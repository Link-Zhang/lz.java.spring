package cn.sh.lz.cig.c1p8;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by Link at 16:54 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class TreeNode {
    @NonNull
    private int data;

    private TreeNode left;

    private TreeNode right;
}
