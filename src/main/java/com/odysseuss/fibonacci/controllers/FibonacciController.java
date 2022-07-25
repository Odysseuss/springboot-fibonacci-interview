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
        long current = 1;
        long previous = 0;

        boolean started = false;
        for (int i = 0; (i < numberOfFibonacci) ;) {

            started |= starting >= previous && starting <= current;
            if (started){
                
                result[i] = (starting == 0) ? previous : current;
                i++;
            }

            long temp = current;
            current += previous;
            previous = temp;
        }

        return Arrays.stream(result).boxed().toList();
    }
    
    
}
