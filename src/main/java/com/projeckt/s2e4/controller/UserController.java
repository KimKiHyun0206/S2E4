package com.projeckt.s2e4.controller;

import com.projeckt.s2e4.common.dto.ResponseDto;
import com.projeckt.s2e4.dto.user.request.UserRegisterRequest;
import com.projeckt.s2e4.dto.user.request.UserUpdateRequest;
import com.projeckt.s2e4.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "{USER API}")
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "User Register")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        var response = userService.register(request);
        return ResponseDto.created(request);
    }

    @ApiOperation(value = "User Get")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var response = userService.get(id);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "User Update")
    @PostMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        var response = userService.update(id, request);
        return ResponseDto.ok(response);
    }


    @ApiOperation(value = "User Delete")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseDto.noContent();
    }
}
