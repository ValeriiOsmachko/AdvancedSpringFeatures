package com.ua.osmachko.beanfactorypostprocessors;

import com.ua.osmachko.customannotations.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Valerii_Osmachko on 4/25/2017.
 */
@Component
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                if (beanClassName != null) {
                    Class<?> beanClass = Class.forName(beanClassName);
                    DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                    if (annotation != null) {
                        beanDefinition.setBeanClassName(annotation.newImpl().getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
