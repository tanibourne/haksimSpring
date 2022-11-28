package com.hyuk.core;

import com.hyuk.core.Order.Order;
import com.hyuk.core.Order.OrderService;
import com.hyuk.core.Order.OrderServiceImpl;
import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;
import com.hyuk.core.member.MemberService;
import com.hyuk.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        MemberService memberService = new MemberServiceImpl();
        
        long memberId =1L;

        Member member = new Member(memberId, "nameA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatedPrice() = " + order.calculatedPrice());
    }
}
