package _07_java_abstraction.exercise.task1;

public class AbstractionAndInterfaceTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Chicken();
        animals[1] = new Tiger();

        for (Animal a : animals) {
            System.out.println(a.makeSound());
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();

        for(Fruit f : fruits) {
            System.out.println(f.howToEat());
        }
    }
}
