package com.cos.myblog.Service;

import com.cos.myblog.Repository.UserRepository;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public void 회원가입(User user)
    {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);

    }

    @Transactional
    public void 회원수정(User user) {
        //수정시에는 Jpa 영속성 컨텍스트 User 오브젝트를 영속화 시키고 영속화된 User 오브젝트를 수정
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
                    return new IllegalArgumentException("회원 찾기 실패");
        });
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());
        //회원수정 함수 종료 시 = 서비스 종료 = 트랜잭션 종료 = commit이 자동으로 된다.
        //영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문 발생


    }
}
