package com.hyuk.core;

import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;
import com.hyuk.core.member.MemberService;
import com.hyuk.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "NameA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());

        System.out.println("member = " + member.getName());

        System.out.println("findMember = " + findMember.getName());
    }
}
