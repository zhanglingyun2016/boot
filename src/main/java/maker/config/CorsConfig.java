package maker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsConfig(CorsRegistry registry){
        registry.addMapping("/")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");

    }

}
