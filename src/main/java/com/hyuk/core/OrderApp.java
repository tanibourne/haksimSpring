package com.hyuk.core;

import com.hyuk.core.Order.Order;
import com.hyuk.core.Order.OrderService;
import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;
import com.hyuk.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId =1L;

        Member member = new Member(memberId, "nameA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatedPrice() = " + order.calculatedPrice());
    }
}
