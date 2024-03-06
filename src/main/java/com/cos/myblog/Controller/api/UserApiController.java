package com.cos.myblog.Controller.api;

import com.cos.myblog.Config.auth.PrincipalDetail;
import com.cos.myblog.DTO.ResponseDto;
import com.cos.myblog.Service.UserService;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiContorller : save 호출됨");
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user){
        userService.회원수정(user);

        //세션등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
    /*

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        System.out.println("UserApiController : login호출됨");
        User principal = userService.로그인(user);
        if (principal != null){
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

 */
}
