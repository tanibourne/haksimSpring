package com.hyuk.core.discount;

import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용")
    void vip_o() {
        Member member = new Member(1L, "memeberV", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용 안됨")
    void vip_x() {
        Member member = new Member(2L, "memeberV", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(0);
    }


}