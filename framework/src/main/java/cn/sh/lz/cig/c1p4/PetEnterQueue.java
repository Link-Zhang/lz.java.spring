package cn.sh.lz.cig.c1p4;

/**
 * Created by Link at 09:44 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class PetEnterQueue {
    private Pet pet;
    private long timestamp;

    public PetEnterQueue(Pet pet, long timestamp) {
        this.pet = pet;
        this.timestamp = timestamp;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }
}
