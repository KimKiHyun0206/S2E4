package com.projekt.s2e4.dto.event.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventRegisterRequest {
    private String eventName;
    private Long discountRate;
    private LocalDate startAt;
    private LocalDate endAt;
    private Boolean status;
}
