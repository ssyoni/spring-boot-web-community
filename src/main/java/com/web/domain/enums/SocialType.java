package com.web.domain.enums;
/*
소셜 미디어의 타입 정보를 나타내는 enum 객체 
*/
public enum SocialType {
    FACEBOOK("facebook"),
    GOOGLE("google"),
    KAKAO("kakao");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name){
        this.name = name ;
    }
    /* 'ROLE_*' 형식으로 소셜 미디어의 권한명을 생성한다. enum을 사용해 권한 생성 로직을 공통코드로 처리하여 중복 코드를 줄일 수 있다. */
    public String getRoleType() { return ROLE_PREFIX + name.toUpperCase(); }
    
    public String getValue(){ return name; }

    public boolean isEquals(String authority){
        return this.getRoleType().equals(authority);
    }
}
