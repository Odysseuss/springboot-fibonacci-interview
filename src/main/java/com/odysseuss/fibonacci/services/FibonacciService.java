package com.odysseuss.fibonacci.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public Iterable<Long> fibonacci(long starting, int numberOfFibonacci) {
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

        List<Long> resultList = Arrays.stream(result).boxed().toList();

        return resultList;
    }
    
}
