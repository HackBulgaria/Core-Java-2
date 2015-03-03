# Problem 1 - Primes In An Interval

In a programming language of your choice, implement the following function/method:
```
primesInAnInterval(from, to)
```
The goal is to return a collection of all the prime numbers in the given interval [from, to]

## Examples
```
primesInAnInterval(2, 20) -> [2, 3, 5, 7, 11, 13, 17, 19]
primesInAnInterval(10, 30) -> [11, 13, 17, 19, 23, 29]
primesInAnInterval(20, 10) -> invalid input
primesInAnInterval(-20, 10) -> invalid input
```

## Details
- Make all sorts of checks for the interval - the `from` parameter has to be less than the `to` parameter, they both have to be positive integers etc. etc.
- Design is not important at the moment. You could call the method from the main function, you could export it as a command line tool, you could execute it on a server - your choice



## Solution
For this task I have used the infamous Sieve of Eratosthenes which is one of the most efficient ways to find out prime numbers.
I'm starting from 2 till the required end of the range, then displaying only the numbers from the beggining of the desired range.
First I wrote my solution in PHP and afterwards I have rewriten a solution in Java, following my logic in PHP using Lists as associatie arrays in Java.

# Solution in php
https://github.com/miglen/Core-Java-2/Application/1-Primes-In-An-Interval/1-Primes-In-An-Interval.php

# Solution in java
https://github.com/miglen/Core-Java-2/Application/1-Primes-In-An-Interval/1-Primes-In-An-Interval.java