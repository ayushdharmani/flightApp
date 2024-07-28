package org.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class FlightApis {

    @Autowired
    private FlightService flightService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping("/flights")
    public void saveFlights(@RequestBody List<Flight> flights) {
        flights.forEach(flight -> {
            String formattedDate = DateTimeUtils.formatDateTime(flight.getScheduled_departure());
        });
        flightService.saveFlights(flights);
    }

    @PatchMapping("/flights/{flightId}/status")
    public void updateFlightStatus(@PathVariable String flightId, @RequestParam String status) {
        flightService.updateFlightStatus(flightId, status);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping("/customers/{flightId}")
    public List<Customer> getCustomersByFlightId(@PathVariable String flightId) {
        return customerService.getCustomersByFlightId(flightId);
    }
}
