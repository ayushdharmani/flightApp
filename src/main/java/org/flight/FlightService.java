package org.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private CustomerService customerService;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void saveFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            try {
                Query query = new Query(where("flight_id").is(flight.getFlight_id()));
                Flight existingFlight = mongoTemplate.findOne(query, Flight.class);

                if (existingFlight != null) {
                    System.out.println("Duplicate flight_id detected: " + flight.getFlight_id() + ". Skipping insertion.");
                } else {
                    flightRepository.save(flight);
                }
            } catch (DuplicateKeyException e) {
                System.out.println("Duplicate flight_id detected: " + flight.getFlight_id());
            }
        }
    }

    public void updateFlightStatus(String flightId, String status) {
        Query query = new Query(where("flight_id").is(flightId));
        Update update = new Update().set("status", status);
        mongoTemplate.updateFirst(query, update, Flight.class);
        List<Customer> customers = customerService.getCustomersByFlightId(flightId);
        for (Customer customer : customers) {
            emailService.sendStatusUpdateEmail(customer.getEmail(), flightId, status);
            try{
                smsService.sendStatusUpdateSms(customer.getPhone(), flightId, status);
            }catch(Exception e){
                continue;
            }
        }
    }

}
