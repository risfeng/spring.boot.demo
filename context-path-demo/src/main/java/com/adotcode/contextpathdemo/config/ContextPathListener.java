package com.adotcode.contextpathdemo.config;

import java.util.Properties;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

/**
 * @author risfeng
 * @date 2019/09/27
 */
public class ContextPathListener implements
    ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  /**
   * Handle an application event.
   *
   * @param event the event to respond to
   */
  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    ConfigurableEnvironment environment = event.getEnvironment();
    String oldValue = environment.getProperty("server.servlet.context-path");
    Properties props = new Properties();
    props.put("server.servlet.context-path", "/");
    props.put("server.servlet.context-path.native", oldValue);
    environment.getPropertySources()
        .addFirst(new PropertiesPropertySource("applicationConfig", props));
  }
}
