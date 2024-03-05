package com.cos.myblog.Controller.api;

import com.cos.myblog.Config.auth.PrincipalDetail;
import com.cos.myblog.DTO.ResponseDto;
import com.cos.myblog.Service.BoardService;
import com.cos.myblog.Service.UserService;
import com.cos.myblog.model.Board;
import com.cos.myblog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }



}
