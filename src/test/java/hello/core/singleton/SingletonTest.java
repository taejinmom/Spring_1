package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = new AppConfig().memberService();
        //2. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = new AppConfig().memberService();
        //memberService 1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용 순수 자바")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
//        Assertions.assertThat(singletonService2).isSameAs(singletonService1);
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1= ac.getBean("memberService", MemberService.class);
//        MemberService memberService1 = new AppConfig().memberService();
        //2. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
//        MemberService memberService2 = new AppConfig().memberService();
        //memberService 1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
