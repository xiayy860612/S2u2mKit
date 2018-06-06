package s2u2msdk.spring.service.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s2u2msdk.spring.core.uid.SnowFlakeUidGenerator;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * class UidGeneratorConfig
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Configuration
public class UidGeneratorConfig {

    @Bean
    SnowFlakeUidGenerator generator() throws Exception {
        Instant start = ZonedDateTime.of(
                2018, 5, 1,
                0, 0, 0, 0,
                ZoneId.of(TimeConfig.DefaultZone)).toInstant();
        return new SnowFlakeUidGenerator(start, 1);
    }
}
