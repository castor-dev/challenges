package dev.castor.challenges.hackerank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayElementsSumTest {

    private final ArrayElementsSum arrayElementsSum = new ArrayElementsSum();



    @Test
    public void testSimpleArraySum(){

        List<Integer> numbers = Arrays.asList(2,8,13,59);

        Integer simpleArraySum = arrayElementsSum.simpleArraySum(numbers);

        Assertions.assertEquals(simpleArraySum, 82);
    }

    @Test
    public void testReduceArraySum(){

        List<Integer> numbers = Arrays.asList(2,8,13,59);

        Integer simpleArraySum = arrayElementsSum.mapReduceArraySum(numbers);

        Assertions.assertEquals(simpleArraySum, 82);
    }

    @Test
    public void testPerformance(){
        List<Integer> numbers = IntStream.rangeClosed(1, 500_000).boxed().collect(Collectors.toList());

        Instant startSimple = Instant.now();
        Integer simpleArraySum = arrayElementsSum.simpleArraySum(numbers);
        Instant endSimple = Instant.now();

        Instant startReduce = Instant.now();
        Integer mapReduceArraySum = arrayElementsSum.mapReduceArraySum(numbers);
        Instant endMapReduce = Instant.now();

        Assertions.assertEquals(simpleArraySum, mapReduceArraySum);

        System.out.println(Duration.between(startSimple, endSimple));
        System.out.println(Duration.between(startReduce, endMapReduce));


    }

}