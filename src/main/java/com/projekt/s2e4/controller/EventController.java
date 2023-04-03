package com.projekt.s2e4.controller;

import com.projekt.s2e4.common.dto.ResponseDto;
import com.projekt.s2e4.dto.event.request.EventRegisterRequest;
import com.projekt.s2e4.dto.event.request.EventUpdateRequest;
import com.projekt.s2e4.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "{EVENT API}")
@RestController
@RequestMapping(value = "/api/v1/events", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @ApiOperation(value = "Event Register")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody EventRegisterRequest request) {
        var response = eventService.register(request);
        return ResponseDto.created(response);
    }

    @ApiOperation(value = "Event Get")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        var response = eventService.get(id);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Event Update")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody EventUpdateRequest request
    ){
        var response = eventService.update(id, request);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Event Delete")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        eventService.delete(id);
        return ResponseDto.noContent();
    }
}