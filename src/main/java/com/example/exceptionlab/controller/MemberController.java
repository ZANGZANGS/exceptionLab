package com.example.exceptionlab.controller;

import com.example.exceptionlab.dto.MemberDto;
import com.example.exceptionlab.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Object saveMember(@RequestBody MemberDto memberDto){
        return memberService.saveMember(memberDto);
    }
}
