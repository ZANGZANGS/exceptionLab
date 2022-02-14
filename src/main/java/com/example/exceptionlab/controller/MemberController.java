package com.example.exceptionlab.controller;

import com.example.exceptionlab.dto.MemberDto;
import com.example.exceptionlab.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object saveMember(@RequestBody MemberDto memberDto){
        return memberService.saveMember(memberDto);
    }
}
