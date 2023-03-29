package com.projekt.s2e4.service;

import com.projekt.s2e4.dto.user.request.UserRegisterRequest;
import com.projekt.s2e4.dto.user.request.UserUpdateRequest;
import com.projekt.s2e4.dto.user.response.UserResponse;
import com.projekt.s2e4.entity.User;
import com.projekt.s2e4.exception.S2E4Exception;
import com.projekt.s2e4.model.Grade;
import com.projekt.s2e4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse register(UserRegisterRequest request) {
        User user = new User(
                request.getUserName(),
                request.getLoginId(),
                request.getLoginPassword(),
                request.getMoney(),
                request.getGrade()
        );

        User savedUser = userRepository.save(user);

        log.info("User 등록했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        log.info("User 조회했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserResponse::from);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getNotAdmin(Pageable pageable){
        Page<UserResponse> users = userRepository.findAll(pageable).map(UserResponse::from);

        List<UserResponse> filtered = users.filter(u -> !u.getGrade().equals(Grade.Admin))
                .stream()
                .collect(Collectors.toList());

        return makePage(filtered);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getByGrade(Pageable pageable, Grade grade) {
        Page<UserResponse> users = userRepository.findAll(pageable).map(UserResponse::from);

        List<UserResponse> filtered = users.filter(u -> u.getGrade().equals(grade))
                .stream()
                .collect(Collectors.toList());

        return makePage(filtered);
    }

    @Transactional
    public UserResponse update(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        user.update(
                request.getUserName(),
                request.getLoginId(),
                request.getLoginPassword(),
                request.getMoney(),
                request.getGrade()
        );

        log.info("User 수정했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            log.info("User 삭제했습니다. {}", id);
        } else {
            log.info("User 정보를 찾을 수 없습니다. {}", id);
        }
    }

    private PageImpl<UserResponse> makePage(List<UserResponse> process) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), process.size());
        return new PageImpl<>(process.subList(start, end), pageRequest, process.size());
    }
}
