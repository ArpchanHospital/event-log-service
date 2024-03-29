package org.bahmni.module.eventlogservice;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJpaRepositories
@EnableTransactionManagement
@Configuration
@ComponentScan({"org.bahmni.module.eventlogservice"})
@EntityScan(basePackages = {"org.bahmni.module.eventlogservice"})
@EnableAutoConfiguration
public class EventLogService extends SpringBootServletInitializer {
    @RequestMapping("/")
    String home() {
        return "Event log service is up and running.";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EventLogService.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new TomcatEmbeddedServletContainerFactory();
    }

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }

}
