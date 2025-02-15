package hello.core.autowired;

import jakarta.annotation.Nullable;
import member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ //스프링 컨테이너와 관련이 없음.
            System.out.println("noBean1 = " + noBean1);

        }


        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }


        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
