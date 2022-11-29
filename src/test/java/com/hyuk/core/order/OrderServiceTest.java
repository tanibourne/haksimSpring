package com.hyuk.core.order;


import com.hyuk.core.AppConfig;
import com.hyuk.core.Order.Order;
import com.hyuk.core.Order.OrderService;
import com.hyuk.core.Order.OrderServiceImpl;
import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;
import com.hyuk.core.member.MemberService;
import com.hyuk.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        long memberId = 1L;

        Member member = new Member(memberId, "nameA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.calculatedPrice()).isEqualTo(9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
