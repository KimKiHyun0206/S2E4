package com.projeckt.s2e4.dto.event.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventUpdateRequest {
    private String eventName;
    private Long discountRate;
    private LocalDate startAt;
    private LocalDate endAt;
}
