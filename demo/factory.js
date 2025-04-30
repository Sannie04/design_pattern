class Animal {
    speak() {
        throw "This method should be overridden!";
    }
}

class Dog extends Animal {
    speak() {
        console.log("Woof!");
    }
}

class Cat extends Animal {
    speak() {
        console.log("Meow!");
    }
}

class AnimalFactory {
    createAnimal(type) {
        switch (type) {
            case 'dog':
                return new Dog();
            case 'cat':
                return new Cat();
            default:
                throw "Unknown animal type!";
        }
    }
}

const factory = new AnimalFactory();
const myDog = factory.createAnimal('dog');
myDog.speak(); // Woof!

const myCat = factory.createAnimal('cat');
myCat.speak(); // Meow!
