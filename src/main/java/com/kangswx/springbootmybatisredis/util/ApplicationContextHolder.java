package com.kangswx.springbootmybatisredis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取存储在静态变量中的ApplicationContext
     *      * @return
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 通过bean的名称从ApplicationContext中取得bean，自动转型为所赋值对象的类型
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T)applicationContext.getBean(name);
    }

    /**
     * 通过bean的类型从ApplicationContext中取得bean，自动转型为所赋值对象的类型
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        return (T)applicationContext.getBeansOfType(clazz);
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext(){
        applicationContext = null;
    }

    public static void checkApplicationContext(){
        if(null == applicationContext){
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

}
