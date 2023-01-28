package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);


        org.assertj.core.api.Assertions.assertThat(beanA).isNotNull();
        
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("beanB",BeanB.class));

    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyIncludeCoponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyExcludeCoponent.class))
    static class ComponentFilterAppConfig {

    }

}
