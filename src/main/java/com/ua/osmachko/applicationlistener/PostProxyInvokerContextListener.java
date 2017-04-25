package com.ua.osmachko.applicationlistener;


import com.ua.osmachko.configuration.ApplicationConfiguration;
import com.ua.osmachko.customannotations.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


import java.lang.reflect.Method;

/**
 * Created by Valerii_Osmachko on 4/24/2017.
 */
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String element : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(element);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                if (originalClassName != null) {
                    Class<?> originalClass = Class.forName(originalClassName);
                    Method[] methods = originalClass.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(PostProxy.class)) {
                            System.out.println("DONE!!!!!!");
                            Object bean = context.getBean(element);
                            try {
                                Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                                currentMethod.invoke(bean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }


}
