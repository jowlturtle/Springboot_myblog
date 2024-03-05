package com.cos.myblog.Repository;

import com.cos.myblog.model.Board;
import com.cos.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DAO와 같다
public interface BoardRepository extends JpaRepository<Board,Integer> {

}

