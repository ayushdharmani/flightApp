package org.flight;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@Document(collection = "flights")
public class Flight {
    @Id
    private String id;

    @Indexed(unique = true)
    private String flight_id;
    private String airline;
    private String status;
    private String departure_gate;
    private String arrival_gate;

    private Instant scheduled_departure;
    private Instant scheduled_arrival;

    private Instant actual_departure;
    private Instant actual_arrival;

    public Flight(String flight_id, String airline, String status, String departure_gate, String arrival_gate, Instant scheduled_departure, Instant scheduled_arrival, Instant actual_departure, Instant actual_arrival) {
        this.flight_id = flight_id;
        this.airline = airline;
        this.status = status;
        this.departure_gate = departure_gate;
        this.arrival_gate = arrival_gate;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_arrival = scheduled_arrival;
        this.actual_departure = actual_departure;
        this.actual_arrival = actual_arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeparture_gate() {
        return departure_gate;
    }

    public void setDeparture_gate(String departure_gate) {
        this.departure_gate = departure_gate;
    }

    public String getArrival_gate() {
        return arrival_gate;
    }

    public void setArrival_gate(String arrival_gate) {
        this.arrival_gate = arrival_gate;
    }

    public Instant getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(Instant scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public Instant getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(Instant scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public Instant getActual_departure() {
        return actual_departure;
    }

    public void setActual_departure(Instant actual_departure) {
        this.actual_departure = actual_departure;
    }

    public Instant getActual_arrival() {
        return actual_arrival;
    }

    public void setActual_arrival(Instant actual_arrival) {
        this.actual_arrival = actual_arrival;
    }
}
