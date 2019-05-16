package org.sber.service.testservice.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class LoggingAnnotationProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class beanClass = bean.getClass();

        do {
            // TODO
            //  Процессор для логов
            //  Положить в конфигурацию
        } while (beanClass != null);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
