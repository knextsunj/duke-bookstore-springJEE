package jakarta.tutorial.dukesbookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = { "jakarta.tutorial.dukesbookstore.service" })
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

}
