package com.cos.myblog.Repository;

import com.cos.myblog.model.Board;
import com.cos.myblog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReplyRepository extends JpaRepository<Reply,Integer> {

}

