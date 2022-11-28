package com.hyuk.core.Order;

import com.hyuk.core.discount.DiscountPolicy;
import com.hyuk.core.discount.FixDiscountPolicy;
import com.hyuk.core.member.Member;
import com.hyuk.core.member.MemberRepository;
import com.hyuk.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
