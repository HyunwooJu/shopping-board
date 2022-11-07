package com.board.shopingboard.service;

import com.board.shopingboard.controller.form.MemberSaveForm;
import com.board.shopingboard.domain.Member;

import com.board.shopingboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public void join(MemberSaveForm form) {

        validateDuplicateMember(form); //중복 회원 검증

        Member member = new Member(form);

        member.setRole("ROLE_USER"); //강제 삽입
        String encPassword = bCryptPasswordEncoder.encode(form.getPassword());
        member.setPassword(encPassword);

        memberRepository.save(member); //DB에 저장된 상태
    }

    private void validateDuplicateMember(MemberSaveForm form) {

        Optional<Member> findUserId = memberRepository.findByUserId(form.getUserId());

        if (!form.getPasswdchk().equals(form.getPassword())) {
            throw new IllegalStateException("페스워드가 동일하지 않습니다.");
        }
        if (!findUserId.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다"); //프론트
        }
    }

}
