package net.guide.StackAndQueue.sub04_catDogQueue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/9 8:28
 */
public class Pet {
    private String petType;
    private String petName;

    public Pet(String petType, String petName) {
        this.petType = petType;
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petType='" + petType + '\'' +
                ", petName='" + petName + '\'' +
                '}';
    }
}

class Dog extends Pet {

    public Dog(String petType, String petName) {
        super(petType, petName);
    }
}

class Cat extends Pet {

    public Cat(String petType, String petName) {
        super(petType, petName);
    }
}