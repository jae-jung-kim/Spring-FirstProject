package com.example.firstproject.member.dto;

import com.example.firstproject.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public Member toEntity(){
        return new Member(id, email, password);
    }
}
