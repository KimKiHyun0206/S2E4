package com.projekt.s2e4.dto.event.response;

import com.projekt.s2e4.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EventResponse {
    private Long id;
    private String eventName;
    private Long discountRate;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean status;

    public static EventResponse from(Event event){
        return new EventResponse(
                event.getId(),
                event.getEventName(),
                event.getDiscountRate(),
                event.getStartAt(),
                event.getEndAt(),
                event.getCreatedAt(),
                event.getModifiedAt(),
                event.getStatus()
        );
    }
}
