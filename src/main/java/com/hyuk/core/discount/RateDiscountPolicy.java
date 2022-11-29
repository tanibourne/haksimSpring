package com.hyuk.core.discount;

import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return itemPrice * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
