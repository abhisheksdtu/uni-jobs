package com.project.unijobs;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = "com.project.unijobs")
public class UniJobsApplication {
    private final Environment env;

    public UniJobsApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniJobsApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            String port = env.getProperty("server.port");
            String contextPath = env.getProperty("server.servlet.context-path");
            String appName = env.getProperty("spring.application.name");
            if (contextPath == null) {
                contextPath = "";
            }

            String appUrl = appName + " is running at http://localhost:" + port + contextPath;
            String swaggerUrl = "Swagger UI is available at http://localhost:" + port + contextPath + "/swagger-ui/";

            int maxLength = Math.max(appUrl.length(), swaggerUrl.length());
            String border = new String(new char[maxLength]).replace("\0", "-");

            System.out.println(border);
            System.out.println(appUrl);
            System.out.println(swaggerUrl);
            System.out.println(border);
        };
    }
}
