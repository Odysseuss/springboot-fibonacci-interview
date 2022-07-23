package com.odysseuss.fibonacci.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    @GetMapping("/{starting}/{numberOfFibonacci}")
    public Iterable<Long> fibonacci(@PathVariable(name = "starting")int starting, @PathVariable(name = "numberOfFibonacci") int numberOfFibonacci) {

        long[] result = new long[numberOfFibonacci];
        long onePrevious = 1;
        long twoPrevious = 0;

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

            long temp = onePrevious;
            onePrevious += twoPrevious;
            twoPrevious = temp;
        }

        return Arrays.stream(result).boxed().toList();
    }
    
    
}
