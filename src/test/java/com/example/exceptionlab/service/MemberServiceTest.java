package com.example.exceptionlab.service;

import com.example.exceptionlab.domain.Member;
import com.example.exceptionlab.dto.MemberDto;
import com.example.exceptionlab.exception.DuplicatedMemberNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원 가입 테스트")
    @Transactional
    void saveMemberTest(){
        // given
        String name = "홍길동";
        int age = 15;
        MemberDto memberDto = new MemberDto(name, age);
        // when
        Long saveId = memberService.saveMember(memberDto);
        Optional<Member> findMember = memberService.findMemberByName(memberDto.getName());

        // then
        Long findId = findMember.orElseThrow(DuplicatedMemberNameException::new).getId();
        System.out.println("회원 아이디 = " + saveId);
        System.out.println("조회 아이디 = " + findId);
        assertThat(saveId).isEqualTo(findId);
    }

    @Test
    @DisplayName("회원_중복_테스트")
    @Transactional
    void duplicatedUserTest(){
        // given
        String name = "홍길동";
        int age = 15;
        MemberDto memberDto = new MemberDto(name, age);

        // when
        memberService.saveMember(memberDto);

        // then - 홍킬동 중복 가입 시도
        DuplicatedMemberNameException e = assertThrows(DuplicatedMemberNameException.class,
                () -> memberService.saveMember(memberDto));

        System.out.println("회원 중복 테스트" + e.getMessage());
    }
}