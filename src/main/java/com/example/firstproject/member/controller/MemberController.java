package com.example.firstproject.member.controller;

import com.example.firstproject.member.dto.MemberForm;
import com.example.firstproject.member.entity.Member;
import com.example.firstproject.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "member/new";
    }

    @PostMapping("/join")
    public String signupMember(MemberForm form){
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id= "+id);

        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member",memberEntity);

        return "member/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        List<Member> memberEntityList = memberRepository.findAll();

        model.addAttribute("memberList",memberEntityList);

        return "member/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member",memberEntity);

        return "member/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        log.info(form.toString());

        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());

        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if(target != null){
            memberRepository.save(memberEntity);
        }

        return "redirect:/members/"+memberEntity.getId();
    }
}
