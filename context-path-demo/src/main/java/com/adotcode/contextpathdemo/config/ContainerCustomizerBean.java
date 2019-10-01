package com.adotcode.contextpathdemo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author risfeng
 * @date 2019/09/26
 */
@Configuration
@EnableWebMvc
public class ContainerCustomizerBean {

  private final Environment environment;

  public ContainerCustomizerBean(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public ServletRegistrationBean restServlet() {
    //注解扫描上下文
    AnnotationConfigWebApplicationContext applicationContext
        = new AnnotationConfigWebApplicationContext();
    //通过构造函数指定dispatcherServlet的上下文
    DispatcherServlet restDispatcherServlet = new DispatcherServlet(applicationContext);
    //用ServletRegistrationBean包装servlet
    ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<>(
        restDispatcherServlet);
    registrationBean.setLoadOnStartup(1);
    //指定url mapping
    String contextPath = environment.getProperty("server.servlet.context-path.native");
    if (contextPath != null) {
      registrationBean.addUrlMappings(String.format("%s/*", contextPath));
    }
    //指定name，如果不指定默认为dispatcherServlet
    registrationBean.setName("contentPathServlet");
    return registrationBean;
  }
}
