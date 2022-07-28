# springboot-fibonacci-interview
An interview question I encountered on creating a rest interface for fibonacci sequence


# Problem Statement
Expose a rest services which take a number as input parameters . Print the next 5 numbers from the Fibonacci sequence .start 
With the input digit if eligible or next eligible number in the fibonacci sequence.


# Example Test Cases
Input: If I pass 5 in the input. 5 is an eligible digit in Fibonacci sequence so print starting from 5
Expected Response :  5, 8, 13, 21, 34,

Input: If I pass 2 in the input.2 is an eligible digit in Fibonacci sequence so print starting from 2
Expected Response :  2, 3, 5, 8, 13,

Input :
Input : If I pass 4 in the input.4 is not an eligible digit in Fibonacci sequence so print starting from 5
Expected Response :  5, 8, 13, 21, 34


# Fibonacci Primer

The fibonacci sequence has two base cases where:
fib(0) = 0 and fib(1) = 1

After this, the general sequence is as follows:
fib(n) = fib(n-1) + fib(n-2)

Therefore the following are the first seven entries of the sequence:
```
fib(0) = 0
fib(1) = 1
fib(2) = 1
fib(3) = 2
fib(4) = 3
fib(5) = 5
fib(6) = 8
```

# The Solution

For the solution, I wanted to stay away from using the naive recursive approach
to the fibonacci calculation from CompSci 101. This is because that solution has
a Time Complexity of O(2^n) and a Space Complexity of O(n)
Obviously, this was paramont, in my view, to avoid.

Instead, I took a dynamic programming approach which reduced the Time Complexity to 
O(n), where `n = (starting + numberOfFibonacci)`, and the Space Complexity to O(1).

As for the REST controller, I took the liberty of adding the number of digits
to report from the Fibonacci sequence as a path variable. However, this was
not required and perhaps could be viewed as a problem in an interview setting.
I liked the ability to remove the magic number, 5, in this way and give a more robust
interface.