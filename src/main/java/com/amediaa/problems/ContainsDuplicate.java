package com.amediaa.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicate extends Problem<int[], Boolean>{
    public ContainsDuplicate() {
        super("217. Contains Duplicate", List.of(new int[] {1,2,3,1}), List.of(true));
    }

    @Override
    Boolean solution(int[] input) {
        return containsDuplicate(input);
    }

    // 217.Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for(var num : nums) {
            if(hashSet.contains(num)){
                return true;
            }

            hashSet.add(num);
        }

        return false;
    }
}


