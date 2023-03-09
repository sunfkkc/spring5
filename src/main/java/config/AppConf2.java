package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class AppConf2 {

    /**
     * 필드 인젝션을 사용하지 마라는 인텔리제이 에러 발생
     * 단위테스트시 의존관계를 가지는 객체를 생성해서 주입할 수가 없다고 함
     */
    @Autowired
    private MemberDao memberDao;

    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao);
    }
}
