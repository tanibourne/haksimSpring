package com.hyuk.core.discount;

import com.hyuk.core.member.Grade;
import com.hyuk.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        else{
            return 0;

        }
    }
}
