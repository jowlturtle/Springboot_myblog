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
import java.util.Optional;

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
    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
        });
    }
    @Transactional
    public void 글삭제하기(int id) {
       boardRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다."); // 영속화 완료
        });
        board.setTitle(requestBoard.getTitle());
        board.setTitle(requestBoard.getContent());
        //해당 함수로 종료시에(service가 종료 될때) 트랜잭션이 종료된다. 이때 더티채킹 - 자동 업데이트가 됨 DB flush
    }
}
