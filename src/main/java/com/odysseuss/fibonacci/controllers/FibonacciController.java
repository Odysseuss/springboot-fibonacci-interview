package com.odysseuss.fibonacci.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/fibonacci")
public class FibonacciController {

    @GetMapping("/fibonacci/{starting}/{numberOfFibonacci}")
    public Iterable<Integer> fibonacci(@PathVariable(name = "starting")int starting, @PathVariable(name = "numberOfFibonacci") int numberOfFibonacci) {

        int[] result = new int[numberOfFibonacci];
        int onePrevious = 1;
        int twoPrevious = 0;

        boolean started = false;
        for (int i = 0; (i < numberOfFibonacci) ;) {

            started |= starting >= twoPrevious && starting <= onePrevious;
            if (started){

                if (starting < 1) {
                    result[i] = twoPrevious;
                } else {
                    result[i] = onePrevious;
                }
                
                i++;
            }

            int temp = onePrevious;
            onePrevious += twoPrevious;
            twoPrevious = temp;
        }

        return Arrays.stream(result).boxed().toList();
    }
    
    
}
