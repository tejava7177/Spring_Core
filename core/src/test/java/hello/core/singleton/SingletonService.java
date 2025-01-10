package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    //유일한 조회
    public static SingletonService getInstance() {
        return instance;
    }

    //외부에서 생성을 막기 위해 Private 생성자 사용
    private  SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
