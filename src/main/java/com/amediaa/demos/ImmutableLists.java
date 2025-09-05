package com.amediaa.demos;

import com.amediaa.common.Demo;

import java.util.ArrayList;
import java.util.List;

public class ImmutableLists implements Demo {
    @Override
    public void execute() {

        List<List<Integer>> immutableList = List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9, 10));
        var mutableListOfNums = makeMutable(immutableList);
        System.out.println(mutableListOfNums);

        mutableListOfNums.get(0).set(2, 99);
        mutableListOfNums.set(1, new ArrayList<>(List.of(16, 17, 18, 19, 20)));
        System.out.println(mutableListOfNums);
    }

    public ArrayList<ArrayList<Integer>> makeMutable(List<List<Integer>> immutable_lists_of_nums) {
        ArrayList<ArrayList<Integer>> mutableListsOfNums = new ArrayList<>();

        for(var immutable_list : immutable_lists_of_nums) {
            mutableListsOfNums.add(new ArrayList<>(immutable_list));
        }

        return mutableListsOfNums;
    }
}
