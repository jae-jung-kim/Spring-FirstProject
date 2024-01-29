package com.example.firstproject.member.repository;

import com.example.firstproject.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository <Member, Long> {
    @Override
    ArrayList<Member> findAll();
}
