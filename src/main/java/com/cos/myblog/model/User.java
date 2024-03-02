package com.cos.myblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@DynamicInsert // insert 시에 null인 필드는 제외시킨다.
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'")
    @Enumerated(EnumType.STRING) // DB에는 RoleType이 없기 때문에
    private RoleType role;

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}
