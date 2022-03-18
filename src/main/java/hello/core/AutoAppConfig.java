package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 어노테이션이 붙은 클래스를 찾아서 모두 스프링 빈으로 등록해줌
        //basePackages = "hello.core.member", //ComponentScan 대상을 정해줄 수 있음 , member에서만 검색하기 떄문에 discount나 order는 검색대상에서 제외
        //basePackageClasses = AutoAppConfig.class, //AutoAppConfig의 클래스인 hello.core부터 시작
        // basePackages를 정해주지 않은 디폴트 값은 ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //AppConfig,TestConfig 에 Configuration 안에 까보면 Component가 있어서 충돌나기 떄문제 제외시켜줌 , 기존 코드를 유지하기 위해
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
