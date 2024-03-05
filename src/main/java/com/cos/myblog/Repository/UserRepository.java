package com.cos.myblog.Repository;

import com.cos.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//DAO와 같다
public interface UserRepository extends JpaRepository<User,Integer> {

    //SELECT * FROM user WHERE username =1?
    Optional<User> findByUsername(String username);
}

//JPA Naming 전략
//SELECT * FROM user WHERE username=?1 AND password =?2;
//User findByUsernameAndPassword(String username, String password);

// 위 아래가 같은 거
//@Query(value = "SELECT * FROM user WHERE username=?1 AND password =?2", nativeQuery = true)
//User login(String username, String password);