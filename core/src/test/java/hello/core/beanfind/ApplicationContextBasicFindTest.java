package hello.core.beanfind;

import com.sun.nio.sctp.Association;
import hello.core.AppConfig;
import member.MemberService;
import member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        //assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memnberService",MemberServiceImpl.class);
        //assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    //실패 테스트
    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX(){
        //MemberService memberServiceXXX = ac.getBean("memnberService",MemberServiceImpl.class);

        //검증 , 예외가 터져야 검증 성공 (Lambda 활용)
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("memberServiceXXX", MemberService.class));

    }



}
