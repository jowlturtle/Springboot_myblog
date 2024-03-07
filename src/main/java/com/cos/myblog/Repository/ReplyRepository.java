package com.cos.myblog.Repository;

import com.cos.myblog.DTO.ReplySaveRequestDto;
import com.cos.myblog.model.Board;
import com.cos.myblog.model.Reply;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface ReplyRepository extends JpaRepository<Reply,Integer> {
    @Modifying
    @Query(value="INSERT INTO reply(userId,boardId,content,createDate) VALUES(?1,?2,?3,now())", nativeQuery = true)
    int mSave(int userId, int boardId, String content); // 기본적으로 업데이트된 행의 개수를 리턴해줌

}

