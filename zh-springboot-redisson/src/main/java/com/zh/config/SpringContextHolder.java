package com.zh.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author he.zhang
 * @since 2020/6/23 17:44
 */

@Configuration
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     * @param applicationContext 上下文
     * @throws BeansException /
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中获得Bean，自动转型为所赋值对象的类型
     * @param name 类名称
     * @param <T>  泛型
     * @return T
     */
    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }


    /**
     * 从静态变量ApplicationContext中获得Bean，自动转型为所赋值对象的类型
     * 如果有多个Bean符合Class，只取第一个
     * @param clazz  类型
     * @param <T>    泛型
     * @return T
     */
    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        Map beanMaps = applicationContext.getBeansOfType(clazz);
        if(beanMaps != null && !beanMaps.isEmpty()){
            return (T) beanMaps.values().iterator().next();
        } else {
            return null;
        }
    }

    private static void checkApplicationContext(){
        if(applicationContext == null){
            throw new IllegalStateException("applicationContext未注入，请在application.xml中定义");
        }
    }
}
