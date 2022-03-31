package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class NetworkClient {

    private String url; // 접속해야할 서버의 url

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

// 빈 생명주기 콜백 방법

    /*
        설정 정보 사용 특징
         @Bean(initMethod = "init",destroyMethod = "close")
        - 메서드 이름을 자유롭게 줄 수 있다.
        - 스프링 빈이 아니라 스프링 코드에 의존하지 않는다
        - 코드가 아니라 설정 정보를 사용하기 떄문에 코드를 고칠수 없는 외부 라이브러리에도 초기화,종료 메서드를 적용할 수 있다.
     */
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
/*
implements InitializingBean, DisposableBean 단점 : 스프링 전용 인터페이스,해당 코드가 스프링 전용 인터페이스에 의존한다
                                                  초기화,소멸 메서드의 이름을 변경할 수 없다.
                                                  내가 코드를 고수 없는 외부 라이브러리에 적용할 수 없다.

 -> 굉장히 초창기에 나온 방법이고 이후 더 좋은 방법이 나와 잘 사용하지 않음
*/

//    //의존관계 주입이 끝나면 호출해주겠다
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    //빈이 종료될때
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }
}
