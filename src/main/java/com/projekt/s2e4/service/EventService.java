package com.projekt.s2e4.service;

import com.projekt.s2e4.dto.event.request.EventRegisterRequest;
import com.projekt.s2e4.dto.event.request.EventUpdateRequest;
import com.projekt.s2e4.dto.event.response.EventResponse;
import com.projekt.s2e4.entity.Event;
import com.projekt.s2e4.exception.S2E4Exception;
import com.projekt.s2e4.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    @Transactional
    public EventResponse register(EventRegisterRequest request){
        Event event = new Event(
                request.getEventName(),
                request.getDiscountRate(),
                request.getStartAt(),
                request.getEndAt()
        );

        Event savedEvent =  eventRepository.save(event);

        log.info("Event 등록했습니다. {}", event.getId());

        return EventResponse.from(event);
    }

    @Transactional(readOnly = true)
    public EventResponse get(Long id){
        Event event = eventRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        log.info("Event 조회했습니다. {}", event.getId());

        return EventResponse.from(event);
    }

    @Transactional(readOnly = true)
    public Page<EventResponse> getAll(Pageable pageable){
        return eventRepository.findAll(pageable)
                .map(EventResponse::from);
    }

    @Transactional
    public EventResponse update(Long id, EventUpdateRequest request){
        Event event = eventRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        event.update(
                request.getEventName(),
                request.getDiscountRate(),
                request.getStartAt(),
                request.getEndAt()
        );

        log.info("Event 수정했습니다. {}", event.getId());

        return EventResponse.from(event);
    }

    @Transactional
    public void delete(Long id){
        if(eventRepository.existsById(id)){
            eventRepository.deleteById(id);
            log.info("Event 삭제했습니다. {}", id);
        }else {
            log.info("Event 정보를 찾을 수 없습니다. {}", id);
        }
    }
}
