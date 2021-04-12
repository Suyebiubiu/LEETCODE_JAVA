package net.guide.StackAndQueue.sub04_catDogQueue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/9 8:31
 */
public class PetPlus {
    private Pet pet;
    private long count;

    public PetPlus(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getPetPlusType() {
        return this.pet.getPetType();
    }
}
