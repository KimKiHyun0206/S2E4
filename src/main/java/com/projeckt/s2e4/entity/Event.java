package com.projeckt.s2e4.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "event")
@Getter
@Table(name = "event")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "discount_rate")
    private Long discountRate;

    @Column(name = "start_at")
    private LocalDate startAt;

    @Column(name = "end_at")
    private LocalDate endAt;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Event(String eventName, Long discountRate, LocalDate startAt, LocalDate endAt) {
        this.eventName = eventName;
        this.discountRate = discountRate;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public void update(String eventName, Long discountRate, LocalDate startAt, LocalDate endAt){
        this.eventName = eventName;
        this.discountRate = discountRate;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
