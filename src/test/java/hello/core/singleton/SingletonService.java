package hello.core.singleton;

public class SingletonService {









    // DIP , OCP 원칙 X 안티패턴으로도 불림
    private static SingletonService instance;

    private SingletonService(){}

    public static SingletonService getInstance(){
        if(instance == null){
            return instance = new SingletonService();
        }else{
            return instance;
        }
    }
    public void logic(){
        System.out.println("singleton 생성!");
    }

}
