package me.yjh.demospring8bu.demo;

//import org.springframework.context.ApplicationEvent;

//public class MyEvent extends ApplicationEvent {
public class MyEvent {  //이렇게 코드에 스프링 프레임워크 코드가 없는것이 유지보수하기에도 좋고 좀더 안정성을 추구하며
                        // 스프링 개발자의 이상향 이다 이것을 포죠?기반의 프로그래밍이라고 한다 (테스트 편함)
    private int data;

    private Object source;

    public MyEvent(Object source) {
        this.source=source;
    }

    public MyEvent(Object source, int data) {
        this.source=source;
        this.data=data;
    }


    public int getData() {
        return data;
    }
}
