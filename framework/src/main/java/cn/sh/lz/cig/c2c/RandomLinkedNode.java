package cn.sh.lz.cig.c2c;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by Link at 11:57 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class RandomLinkedNode {
    @NonNull
    private int data;

    private RandomLinkedNode next;

    private RandomLinkedNode rand;
}
