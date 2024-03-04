package com.cos.myblog.Service;

import com.cos.myblog.UserRepository;
import com.cos.myblog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // Select 할 때 트랜잭션 시작,서비스 종료시에 트랜잭션 종료(정합성)
    public User 로그인(User user) {
      return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
