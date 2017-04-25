package com.ua.osmachko.configuration;

import com.ua.osmachko.applicationlistener.PostProxyInvokerContextListener;
import com.ua.osmachko.beanpostprocessors.InjectRandomIntAnnotationBeanPostProcessor;
import com.ua.osmachko.beanpostprocessors.ProfilingHandlerBeanPostProcessor;
import com.ua.osmachko.screensaver.ColorFrame;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Valerii_Osmachko on 4/24/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.ua.osmachko")
public class ApplicationConfiguration {

    @Bean(name = "com.ua.osmachko.applicationlistener.PostProxyInvokerContextListener")
    public PostProxyInvokerContextListener getPostProxyInvokerContextListener() {
        return new PostProxyInvokerContextListener();
    }

    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    @Bean(name = "com.ua.osmachko.beanpostprocessors.InjectRandomIntAnnotationBeanPostProcessor")
    public InjectRandomIntAnnotationBeanPostProcessor getInjectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean(name = "com.ua.osmachko.beanpostprocessors.ProfilingHandlerBeanPostProcessor")
    public ProfilingHandlerBeanPostProcessor getProfilingHandlerBeanPostProcessor() throws Exception {
        return new ProfilingHandlerBeanPostProcessor();
    }
}
