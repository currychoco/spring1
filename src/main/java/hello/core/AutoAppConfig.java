package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,
        classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository") // 수동 빈 등록이 우선권을 지님
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
