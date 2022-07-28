package com.odysseuss.fibonacci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odysseuss.fibonacci.services.FibonacciService;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/{starting}/{numberOfFibonacci}")
    public ResponseEntity<Iterable<Long>> fibonacci(@PathVariable(name = "starting")int starting, @PathVariable(name = "numberOfFibonacci") int numberOfFibonacci) {

        Iterable<Long> result = fibonacciService.fibonacci(starting, numberOfFibonacci);
        return new ResponseEntity<Iterable<Long>>(result, HttpStatus.OK);
    }
    
    
}
