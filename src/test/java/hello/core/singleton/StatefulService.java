package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드 , A가 주문한 10000원이 B가 주문한 20000원으로 변경

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
    }

    //이런 식으로 해결할 수 있음 , price 리턴하고 호출하는 부분에서 값을 변수로 담아서 해결
//    public int order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        return price;
//    }

    public int getPrice() {
        return price;
    }
}
