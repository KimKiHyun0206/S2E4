package com.projeckt.s2e4.dto.event.request;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class EventRegisterRequest {
    private String eventName;
    private Long discountRate;
    private LocalDate startAt;
    private LocalDate endAt;
}
