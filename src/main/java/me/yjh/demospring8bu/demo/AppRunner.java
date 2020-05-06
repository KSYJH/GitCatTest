package me.yjh.demospring8bu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


//스프링 부트 관련 내용
@Component
public class AppRunner implements ApplicationRunner {

    //1,2 둘다 가능!! 1 이 더 높은 super
    //1
//  @Autowired
    //ApplicationContext applicationContext;

    @Autowired
    ApplicationContext resourceLoader;

    //2  -> 가장 구체적인 인터페이스를 받는것이 직관적이다 !!
    @Autowired
    ApplicationEventPublisher publishEvent;

    //12 - ResourceLoader
    //@Autowired
    //ResourceLoader resourceLoader;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //applicationContext.publishEvent(new MyEvent(this, 100 ));
        //publishEvent.publishEvent(new MyEvent(this , 100));
        //13부 Resource 추상화
        //System.out.println(resourceLoader.getClass()); //타입 출력


        //resouce 예제
//        Resource resource = resourceLoader.getResource("classpath:/test.txt");
//
//        System.out.println(resource.getClass());
//
//        System.out.println(resource.exists());
//        System.out.println(resource.getDescription()); //그냥 경로 ?
//        System.out.println(Files.readString(Path.of(resource.getURI())));
        //   Files.readString(Path.of(resource.getURI())) -> 자바 11버전에서만 사용할 수 있다.


        //14부 validation 추상화 예제
        Event event = new Event();
        EventValidator eventValidator = new EventValidator();
        Errors errors = new BeanPropertyBindingResult(event,"event");

        eventValidator.validate(event,errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e ->{
            System.out.println("======error code======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    //git test3 : clone 받고 다시 commit-2



    }
}
