package com.example.exceptionlab.dto;

import com.example.exceptionlab.domain.Member;

public class MemberDto {

    private String name;
    private int age;

    public MemberDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Member convertEntity(){
        return new Member(name, age);
    }

}
