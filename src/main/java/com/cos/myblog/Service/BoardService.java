package com.cos.myblog.Service;

import com.cos.myblog.Repository.BoardRepository;
import com.cos.myblog.Repository.UserRepository;
import com.cos.myblog.model.Board;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(Board board,User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public Page<Board> 글목록(Pageable pageable) {
       return boardRepository.findAll(pageable);
    }
}
