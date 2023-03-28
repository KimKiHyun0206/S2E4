package com.projeckt.s2e4.controller;

import com.projeckt.s2e4.common.dto.ResponseDto;
import com.projeckt.s2e4.dto.item.request.ItemRegisterRequest;
import com.projeckt.s2e4.dto.item.request.ItemUpdateRequest;
import com.projeckt.s2e4.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@Api(tags = "{ITEM API}")
@RestController
@RequestMapping(value = "/api/v1/items", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @ApiOperation(value = "Item Register")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody ItemRegisterRequest request) {
        var response = itemService.register(request);
        return ResponseDto.created(response);
    }

    @ApiOperation(value = "Item Get")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var response = itemService.get(id);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Item Update")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody ItemUpdateRequest request
    ) {
        var response = itemService.update(id, request);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Item Delete")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        itemService.delete(id);
        return ResponseDto.noContent();
    }
}
