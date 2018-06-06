package s2u2msdk.spring.service.account.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("s2u2msdk.spring.service.account.dao")
public class MybatisConfig {
}
