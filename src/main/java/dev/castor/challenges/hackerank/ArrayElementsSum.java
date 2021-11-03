package dev.castor.challenges.hackerank;

import java.util.List;

public class ArrayElementsSum {

    public Integer simpleArraySum(List<Integer> numbers){
        Integer sum = 0;
        for(Integer n : numbers){
            sum += n;
        }
        return sum;
    }

    public Integer mapReduceArraySum(List<Integer> numbers){
        return numbers.stream().reduce(Integer::sum).orElse(0);
    }
}
