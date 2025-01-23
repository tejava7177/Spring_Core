package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor  //final 이 붙은 값의 생성자를 자동으로 만들어줌
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // 1. 객체 변환 정률할인으로 변경
    // 3. 코드를 변경하여 클라이언트 코드에 영향이 가기 때문에 OCP 위반
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private  final DiscountPolicy discountPolicy = new RateDiscountPolicy();  //2. 하지만 여전히 인터페이스와 구현 클래스에 의존 => DIP 위반
    //해결법
    private final DiscountPolicy discountPolicy;          //추상화에만 의존하고 있음. DIP는 만족


    //생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    //단일체계 원칙을 잘 고수함 => 할인 정책이 변경되더라도 주문 서비스를 고칠필요가 없음
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
