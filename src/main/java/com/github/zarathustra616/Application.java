package com.github.zarathustra616;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public DispatcherServlet mvcDispatcherServlet() {
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocation("classpath:/com/github/zarathustra/sample/mvc-dispatcher-servlet.xml");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        return dispatcherServlet;
    }

    @Bean
    public ServletRegistrationBean mvcServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(mvcDispatcherServlet());
        ArrayList<String> list = new ArrayList<>();
        list.add("/");
        bean.setUrlMappings(list);
        return bean;
    }

    @Bean
    public ServletRegistrationBean wsServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(wsdispatcherServlet());
        bean.addUrlMappings("/ws/*");
        return bean;
    }

    public MessageDispatcherServlet wsdispatcherServlet() {
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocation("classpath:/com/github/zarathustra/sample/ws-dispatcher-servlet.xml");
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(ctx);
        return messageDispatcherServlet;
    }

//  disable default dispatherServlet!
    @Bean
    public Void dispatcherServlet() {
        return null;
    }
}
