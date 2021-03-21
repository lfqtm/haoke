package cn.itcast.haoke.dubbo.api;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author lfqtm
 * @date 2021/3/20 下午6:19
 */
@SpringBootApplication
@EnableDubbo
@EnableOpenApi
public class DubboApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboApiApplication.class, args);
    }
}
