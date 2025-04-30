abstract class Animal {
    abstract void speak();
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Cat();
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new DogFactory();
        Animal dog = factory.createAnimal();
        dog.speak(); // Woof!

        factory = new CatFactory();
        Animal cat = factory.createAnimal();
        cat.speak(); // Meow!
    }
}
