package dev.castor.challenges.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureRequests {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future<Node> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(Math.round(1000*Math.random()));
            return new Node(String.valueOf(input), input*input);
        });
    }



    public List<Integer> parallelExecutions(Stack<Integer> nodes, Integer maxParallelExecutions){

        List<Integer> parallelExecutions = new ArrayList<>();
        int executionsNumber = nodes.size() < maxParallelExecutions ? nodes.size() : maxParallelExecutions;
        for(int i = 0; i < executionsNumber ; i++){
            parallelExecutions.add(nodes.pop());
        }

        return parallelExecutions;
    }
}
