package animal;

public class Dog extends Animal {

    public Dog(int age) {
        super(age);
    }

    @Override
    public int calcAgeinPersonYears() {
        return age*10;
    }

    @Override
    public void makeASound() {
        System.out.println("Woof-Woof");
    }
}
