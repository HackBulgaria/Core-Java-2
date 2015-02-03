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
