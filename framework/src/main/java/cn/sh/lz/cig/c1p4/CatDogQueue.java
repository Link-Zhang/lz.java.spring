package cn.sh.lz.cig.c1p4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Link at 09:45 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class CatDogQueue {
    private Queue<PetEnterQueue> catQ;
    private Queue<PetEnterQueue> dogQ;
    private String CAT = "cat";
    private String DOG = "dog";

    private long timestamp = 0;

    public CatDogQueue() {
        // 频繁插入删除，使用LinkedList
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.timestamp = 0;
    }

    public void offer(Pet pet) {
        if (CAT.equals(pet.getPetType())) {
            this.catQ.offer(new PetEnterQueue(pet, this.timestamp++));
        } else if (DOG.equals(pet.getPetType())) {
            this.dogQ.offer(new PetEnterQueue(pet, this.timestamp++));
        } else {
            throw new IllegalStateException();
        }
    }

    public Cat pollCat() {
        if (!this.catQ.isEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        }
        return null;
    }

    public Dog pollDog() {
        if (!this.dogQ.isEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        }
        return null;
    }

    public Pet pollPet() {
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
            if (this.catQ.peek().getTimestamp() < this.dogQ.peek().getTimestamp()) {
                return this.catQ.poll().getPet();
            }
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }
}
