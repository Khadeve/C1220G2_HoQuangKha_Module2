package _07_java_abstraction.exercise.task1;

public class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "could be fried";
    }

    @Override
    public String makeSound() {
        return "chicken: cluck-cluck";
    }
}
