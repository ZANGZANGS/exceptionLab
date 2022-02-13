package com.example.exceptionlab.service;

import com.example.exceptionlab.domain.Member;
import com.example.exceptionlab.dto.MemberDto;
import com.example.exceptionlab.exception.DuplicatedMemberNameException;
import com.example.exceptionlab.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long saveMember(MemberDto memberDto){
        duplicatedMemberByName(memberDto.getName());
        return memberRepository.save(memberDto.convertEntity());
    }

    public Optional<Member> findMemberByName(String name){
        return memberRepository.findByName(name);
    }

    private void duplicatedMemberByName(String name){
        if(findMemberByName(name).isPresent()){
            throw new DuplicatedMemberNameException();
        }
    }
}
