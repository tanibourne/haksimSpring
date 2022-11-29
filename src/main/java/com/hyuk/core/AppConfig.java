package com.hyuk.core;

import com.hyuk.core.Order.OrderService;
import com.hyuk.core.Order.OrderServiceImpl;
import com.hyuk.core.discount.DiscountPolicy;
import com.hyuk.core.discount.FixDiscountPolicy;
import com.hyuk.core.discount.RateDiscountPolicy;
import com.hyuk.core.member.MemberRepository;
import com.hyuk.core.member.MemberService;
import com.hyuk.core.member.MemberServiceImpl;
import com.hyuk.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
