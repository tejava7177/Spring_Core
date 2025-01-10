package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);



        //Thread A : A 사용자가 10000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread B : B 사용자가 10000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);


        //int price = statefulService2.getPrice();
        System.out.println("price = " + userAPrice);     //같은 인스턴스를 사용하기 때문에 Service1을 사용했다고 할지라도 20000 결과가 출력 됨.

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}