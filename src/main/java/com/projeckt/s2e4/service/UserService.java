package com.projeckt.s2e4.service;

import com.projeckt.s2e4.dto.item.request.ItemUpdateRequest;
import com.projeckt.s2e4.dto.item.response.ItemResponse;
import com.projeckt.s2e4.dto.user.request.UserRegisterRequest;
import com.projeckt.s2e4.dto.user.request.UserUpdateRequest;
import com.projeckt.s2e4.dto.user.response.UserResponse;
import com.projeckt.s2e4.entity.Item;
import com.projeckt.s2e4.entity.User;
import com.projeckt.s2e4.exception.S2E4Exception;
import com.projeckt.s2e4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse register(UserRegisterRequest request){
        User user = new User(
                request.getUserName(),
                request.getLoginId(),
                request.getLoginPassword(),
                request.getMoney()
        );

        User savedUser = userRepository.save(user);

        log.info("User 등록했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public UserResponse get(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        log.info("User 조회했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional
    public UserResponse update(Long id, UserUpdateRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        user.update(
                request.getUserName(),
                request.getLoginId(),
                request.getLoginPassword(),
                request.getMoney()
        );

        log.info("User 수정했습니다. {}", user.getId());

        return UserResponse.from(user);
    }

    @Transactional
    public void delete(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            log.info("User 삭제했습니다. {}", id);
        }else {
            log.info("User 정보를 찾을 수 없습니다. {}", id);
        }
    }
}
