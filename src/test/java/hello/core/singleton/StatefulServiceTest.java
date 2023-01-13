package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSington() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        int price1 = statefulService1.order("userA",10000);
        //ThreadB : A사용자 20000원 주문
        int price2 = statefulService2.order("userB",20000);



        System.out.println("price1 = " + price1 + " price2 = " + price2);

    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
    @Test
    void getPrice() {
    }
}