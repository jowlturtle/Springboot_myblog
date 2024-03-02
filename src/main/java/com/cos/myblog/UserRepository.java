package com.cos.myblog;

import com.cos.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO와 같다
public interface UserRepository extends JpaRepository<User,Integer> {

}
