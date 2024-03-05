package com.cos.myblog.Config.auth;

import com.cos.myblog.Repository.UserRepository;
import com.cos.myblog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    //스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
    //password 부분은 알아서 해줌
    //username이 DB에 있는지 확인만 해주면 됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username).orElseThrow(()->{
                                        return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다" + username);
                                        });
        return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보가 저장이 됨
    }
}
