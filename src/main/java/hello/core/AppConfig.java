package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPoliCy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //memberService 는 memberRepository 를 사용 - memberRepository는 MemoryMemberRepository를 사용
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //orderService는 memberRepository. discountPolicy를 사용 - discountPolicy는 fixDiscountPolicy를 사용
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return  new RateDiscountPolicy();
//        return new FixDiscountPoliCy();
    }
}
