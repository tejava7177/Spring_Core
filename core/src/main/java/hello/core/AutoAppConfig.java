package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//
@Configuration
@ComponentScan(             //자동으로 spring bean 주입 @Component어노테이션을 찾아서..

        //시작 위치 설정 -> 하지만 권장하지 않음 프로젝트 최상단 경로로 설정하는 것이 권장방법
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,

        //AppConfig 코드(수동으로 Spring Bean 주입)에 @Configuration 이 붙어 있음 -> 충돌 방지를 위해 제외하는 필터
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

//    //수동 vs 자동 의존관계 주입 -> overriding 발생
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
