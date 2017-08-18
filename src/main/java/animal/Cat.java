package animal;

public class Cat extends Animal implements Interface1{

    public Cat(int age) {
        super(age);
    }


    public int calcAgeinPersonYears(){
        System.out.println("Cat Years");
        return 10;
    }

    public void purPur(){
        System.out.println("Pur-Pur-puuur");
    }

    @Override
    public void makeASound() {
        System.out.println("Myay");
    }
}
