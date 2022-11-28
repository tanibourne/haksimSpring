package com.hyuk.core.discount;

import com.hyuk.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int itemPrice);
}
