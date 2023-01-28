package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 롬복 라이브러리 적용 -> final이 붙은 필드값을 생성자로 !!
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy rateDiscountPolicy;


   
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.rateDiscountPolicy = rateDiscountPolicy;
//    }
    @Override
    public  Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = rateDiscountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
