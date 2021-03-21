package cn.itacst.haoke.dubbo.house.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lfqtm
 * @date 2021/3/20 下午2:07
 */
@MapperScan("cn.itacst.haoke.dubbo.house.mapper")
@Configuration
public class MybatisConfig {
}
