package animal;
public abstract class Animal {

    private static int index = 0;
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    public int calcAgeinPersonYears(){
        System.out.println("Animal_Years");
        return age*7;
    }

    public abstract void makeASound();

}
