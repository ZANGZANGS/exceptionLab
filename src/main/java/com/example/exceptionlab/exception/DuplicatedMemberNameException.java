package com.example.exceptionlab.exception;

public class DuplicatedMemberNameException extends RuntimeException{
    public DuplicatedMemberNameException() {
        super("중복된 회원입니다");
    }
}
