package DBConnection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){

        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring5fs?characterEncoding=utf8");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;

    }

    @Bean
    public MemberDao memberDao(){
        return new MemberDao(dataSource());
    }
}
