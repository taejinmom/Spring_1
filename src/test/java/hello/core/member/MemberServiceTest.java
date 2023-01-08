package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl(null);
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member = new Member(1L,"member",Grade.VIP);
        
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(member.getId());
        Member member2 = memberService.findMember(member.getId());

        //then
        Assertions.assertThat(member).isEqualTo(member1);
        Assertions.assertThat(member).isEqualTo(member2);
    }
}
