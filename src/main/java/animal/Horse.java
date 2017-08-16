package animal;

public class Horse extends Animal {

    public Horse(int age) {
        super(age);
    }

    @Override
    public void makeASound() {
        System.out.println("PFFFFF.....");
    }
}
