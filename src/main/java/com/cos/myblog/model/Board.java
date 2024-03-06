package com.cos.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content;

    //@ColumnDefault("0")
    private int count; //조회수

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board") //mappedby가 있으면 연관관계의 주인이 아니다, DB에 컬럼을 만들지 마세요, 객체명 기입
    @JsonIgnoreProperties({"board"})
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}
