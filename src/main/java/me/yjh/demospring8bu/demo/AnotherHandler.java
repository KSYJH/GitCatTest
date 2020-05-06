package me.yjh.demospring8bu.demo;


import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE+2)
    public void handle(MyEvent myevent){
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another  " + myevent.getData());

    }
}
