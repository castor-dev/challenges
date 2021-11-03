package dev.castor.challenges.misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class FutureRequestsTest {

    private FutureRequests futureRequests = new FutureRequests();


    @Test
    public void futureTest() throws ExecutionException, InterruptedException {

        List<Integer> numbers = IntStream.rangeClosed(1, 40).boxed().collect(Collectors.toList());
        Stack<Integer> numbersStack = new Stack<>();
        numbersStack.addAll(numbers);
        int maxParallelExecutions = 5;
        List<Integer> parallelExecutions = futureRequests.parallelExecutions(numbersStack, maxParallelExecutions);
        List<Future<Node>> collect = parallelExecutions.stream().map(n -> futureRequests.calculate(n)).collect(Collectors.toList());
        int parallelExecutionsCount = collect.size();
        List<Node> executed = new ArrayList<>();

        for (int i = 0; i < parallelExecutionsCount; i++) {
            Future<Node> nodeFuture = collect.get(i);

            if (nodeFuture.isDone()) {
                Node node = nodeFuture.get();
                executed.add(node);
                System.out.println(node);
                collect.remove(i);
                if (!numbersStack.isEmpty()) {
                    collect.add(i, futureRequests.calculate(numbersStack.pop()));
                }
            }

            if (i == parallelExecutionsCount - 1) {
                i = 0;
            }

        }

    }


}