package com.board.shopingboard.repository;

import com.board.shopingboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId);
    public Member findChkByUserId(String userId);

}
