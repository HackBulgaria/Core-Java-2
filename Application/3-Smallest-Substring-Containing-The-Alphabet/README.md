# Problem 3 - Smallest Substring Containing The Alphabet

In a programming language of your choice, implement the following function/method:
```
smallestSubstringContainingTheAlphabet(str)
```
Given a string return the smallest substring that contains every letter from the English alphabet

## Examples

**The output should be what's in the square brackets in the examples, they are there just for clarity**

```
smallestSubstringContainingTheAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz") 
-> aaaaa[abcdefghijklmnopqrstuvwxyz]
smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn") 
-> abcdefghijklmn124345678!@#$%^&*[opqrstuvwxyz!*abcdefghijklmn]
```


## Details

- The string will contain no whitespaces
- The string may contain characters like `, . ~ ! @ # $ %` etc. But nothing outside of ASCII
- The algorithm should be case insensitive
- The order in which the letters are found is irrelevant


# Solution (Miglen Evlogiev)

For this task I was having most struggle, mostly to understand the proper approach. I have to admit that I was using some ideas from:
http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html

## Solution in PHP
https://github.com/miglen/Core-Java-2/tree/master/Application/3-Smallest-Substring-Containing-The-Alphabet/3-Smallest-Substring-Containing-The-Alphabet.php

## Solution in Java
https://github.com/miglen/Core-Java-2/tree/master/Application/3-Smallest-Substring-Containing-The-Alphabet/3-Smallest-Substring-Containing-The-Alphabet.java