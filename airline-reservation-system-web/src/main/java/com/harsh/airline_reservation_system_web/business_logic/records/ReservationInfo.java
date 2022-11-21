package com.harsh.airline_reservation_system_web.business_logic.records;

import java.time.LocalDate;

public record ReservationInfo(String email, String to, String from,int people, LocalDate date) {

}
