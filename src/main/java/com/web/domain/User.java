package com.web.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.web.domain.enums.SocialType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User {
   
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private LocalDateTime createdDate;
    
    @Column
    private LocalDateTime updatedDate;

    /* 인증 관련 컬럼 */
    @Column
    private String principal; // OAuth2 인증으로 제공받는 키 값

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType; // 어떤 소셜 미디어로 인증받았는지 여부 구분 

    @Builder
    public User(String name, String password, String email, LocalDateTime createdDate,LocalDateTime updatedDate, String principal, SocialType socialType ){
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.principal = principal;
        this.socialType = socialType;
    }
    
}
