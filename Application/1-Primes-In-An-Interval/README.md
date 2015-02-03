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
