package com.web.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.domain.enums.BoardType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키가 자동으로 할당 1. IDENTITY 2. AUTO 
    private Long idx;

    @Column
    private String title;


    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING) // Enum 타입 매핑용 어노테이션. enum 형과 데이터베이스 데이터 변환을 지원한다. 자바 unum 형을 데이터베이스의 String 형으로 변환하여 저장하겠다고 선언 
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    /*
    Board가 필드로 가지고있는 User 도메인을 1:1 관계로 설정. 
    fetch : 
    1.eager - Board 도메인을 조회할 때 즉시 관련 User 도메인을 조회
    2.lazy - 조회하는 시점이 아닌 실제로 사용될 때 조회
    */
    // @OneToOne(fetch = FetchType.LAZY) // 
    // private User user;

}
