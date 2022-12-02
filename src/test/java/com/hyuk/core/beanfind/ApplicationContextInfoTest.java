package com.hyuk.core.beanfind;

import com.hyuk.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name = "+ beanDefinitionName +" object = " + bean);

        }
    }@Test
    @DisplayName("app 빈 조회")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role Role_Application : 직접 등록한 어플리케이션 빈 (일반적으로 사용자가 정의한 빈)
            // Role Role_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);

                System.out.println("name = "+ beanDefinitionName +" object = " + bean);
            }

        }
    }
}
