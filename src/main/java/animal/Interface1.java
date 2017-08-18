package animal;

public interface Interface1 {

    default void test(){
        System.out.println("This is a default method.");
    }
}
