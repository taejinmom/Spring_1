package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "hello.core",// 어디서부터 찾을지 스캔 시작위치를 지정한다.{"",""} <-- 로 여러개를 지정할 수 있다.
        basePackageClasses = AutoAppConfig.class,// <-- 클래스로 시작위치를 지정할 수 있다.
        // basePackageClasses를 지정하지 않으면 ComponentScan()이 붙은 설정정보 클래스의 패키지가 시작위치가 된다.
        // 해당 ComponentScan 클래스를 최상단에 ComponentScan 클래스를 생성하는 것이 좋다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

}
