package ru.inno.educ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class CorporateSettlementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorporateSettlementServiceApplication.class, args);
    }

}
