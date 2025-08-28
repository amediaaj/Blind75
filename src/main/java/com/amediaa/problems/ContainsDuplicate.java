package com.amediaa.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate extends Problem<ContainsDuplicateData>{
    public ContainsDuplicate() {
        super(new ContainsDuplicateData[] {
                new ContainsDuplicateData(new int[] {1,2,3,1}, true)
        });
    }

    @Override
    public void execute() {
        solve();
    }

    private void solve() {
        ContainsDuplicateData data = testData[0];
        int[] input = data.getInput();
        boolean expected = data.getExpected();
        boolean output = containsDuplicate(input);
        System.out.printf("Input: %s Output: %s Expected: %s", Arrays.toString(input), output, expected);
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

class ContainsDuplicateData extends ProblemData<int[], Boolean>{
    public ContainsDuplicateData(int[] nums, boolean expected) {
        super(nums, expected);
    }
}


