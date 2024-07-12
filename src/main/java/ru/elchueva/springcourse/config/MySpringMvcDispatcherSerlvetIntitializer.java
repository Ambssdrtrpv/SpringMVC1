package ru.elchueva.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //в эти методы передаем конфигурацию
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override //здесь подставляем конфигурационный класс SpringConfig равноценно из web.xml проставление пути: <param-value>/WEB-INF/applicationContextMVC.xml</param-value>
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override //как в web.xml мы посылали все запросы на dispatcher servlet добавляя /
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
