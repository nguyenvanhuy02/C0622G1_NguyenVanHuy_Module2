package ss7_abstract_class_interface.practice.animal_interface_edible.model;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "chickken : cục tác cục tác";
    }

    @Override
    public String howToEat() {
        return "Gà quay đều quay đều";
    }
}
