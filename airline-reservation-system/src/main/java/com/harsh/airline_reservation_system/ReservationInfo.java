package com.harsh.airline_reservation_system;

import java.time.LocalDate;

public record ReservationInfo(String email, String to, String from, double cost, LocalDate date) {

}
