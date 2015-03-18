###OOP fun!###

###1###
Make a class Car. 
Make several(at least 4) subtypes of Car, representing the different brands of cars - Audi, BMW, Wolkswagen (of course!), etc. 

Implement the toString method, to match the type of the class. For example, an object of type Audi should return "Audi@1f52ac3";

Later, for the Audi type you need to return its mileage, because all the German brand manufacturers require it - how you will do it?

###2###

Make a class `Time` to hold information about the current time and *the current date* .

Make an *easy-to-use* constructor (from client perspective), that would represent the time and date the client wants to hold in your class.

Implement the toString() method, returning the time and date in format : "hh:mm:ss dd.MM.YY". 

Check out String.format method

*Bonus*
Make a factory method `now()` for your class, returning the Time at the present moment :)

See http://en.wikipedia.org/wiki/Factory_method_pattern

###3###

Make a class `Pair`, representing a pair of *Objects* (later we will revisit this with Generics)

Create getter methods for the first and second member of the pair.
http://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work

Implement the toString method, giving a meaningful representation of the class.
Override the equals method from Object => two pairs are equal if both their members are equal.

Make the class *immutable*.
###4###

Create and implement a class `StackImpl`, representing a... well, stack. 

Think about all the required (public) operations needed, so that one can use a stack class. You know, stuff like actually pushing an element, popping an element, length, clear, isEmpty, stuff like that. Think about the return types of those operations (see task 5, you may get a hint about one). *Extract them all to an interface  `Stack`, which your class should implement*. 

###5###

Create an implementation of your `Stack` interface, which has the added invariant:
-It does not allow an element to be duplicated. If there is an element 'a' in the stack, and some smart guy pushes 'a' again, his operation should fail, and the smart guy should have a way to know this.


###6###

Implement a (doubly-linked) list (using ints only). Just as before, extract all of its required public operations in an interface. Some of those operations are add, *remove*, size, get(int elementIndex), getHead (getFirst), getTail(getLast), etc. 
Think good and hard about your implementation, and whether you will need another class for a List Node.

###7###
Implement your own `Stack` with your own (doubly) `LinkedList` class : )

*Bonus* implement a unique stack just as before, but using your `LinkedList` and an *anonymous implementation*, combined with a factory method. 
See http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/

Return your anonymous implementation from a factory method!

###8###
Make a mutable class 'Matrix' represeting a NxM (int[][]) matrix. Think good about your constructors, your data. Your goal is to make this class as convenient as possible for the person using it.

Your class `Matrix` should have another cool thing about it => it would allow operations with every pixel.
In order for this to work, your class should declare a public method `operate(MatrixOperation op)`

Where `MatrixOperation` is an interface, containing a method 'int withPixel(int x, int y, int[][] matrix)'.
*Think - why are we getting x, y, and the matrix instead of just passing the pixel value?*

Implement the toString(), converting the whole matrix into a String in a way that it would be visible on the console.

The method should `operate(MatrixOperation op)`  should call the `withPixel` method for every x and y in the matrix and assign the result of `withPixel` to the matrix.

Now that you have this, implement:
-a naive binarization filter, using a simple threshold, for instance 127.
-a naive gaussian blur filter, which just averages the color of this pixel by using the colors of its neighbour pixels!

*Bonuses* - Use a *local class* to fetch information about the matrix using the MatrixOperation interface.

Make an implementation of MatrixOperation, that you can use to:
- get average of pixels
- get most used color in the matrix
- get an image histogram of the matrix 

See http://docstore.mik.ua/orelly/java-ent/jnut/ch03_11.htm

Idea -- implement gausian filter?


###9###
Create a friendly interactive calculator in java
Bundle, execute and test your program as a jar file.

Example usage of your program:
```
java -jar yourJar.jar  
Hello!

Enter expression:> 5  
Output:> 5.0  
Enter expression:> 3 + (5 + 9*7 + 9)  
Output:> 78  
Enter expression:>  4*(4 + 5)  
Output:> 36  
Enter expression:> exit  
  
Bye!  
```


Supported operations: 
- addition  
- multiplication  
- division (this is not integer division! 2/3 = 0.666666667, not 0!)  
- brackets   
- Negative numbers.  

Multiplication and addition take precedence and have higher priority than addition.  
Priority list: () before * before / before + before -  

Your program should support a *variable* ammount of spaces in the expression, as shown in the output below.

*Hints*
- Use this class if you have trouble reading from system.in:  https://gist.github.com/GeorgiPachov/bcc51f1fc3b3a1de1bce  
- Write this program in a TDD way, but *iteratively*. Start from the easiest 'features', add tests for them,and build up on them after you are sure they are rock-solid.   
- Do not worry about invalid input:  
`123/213/123/1/2/23/3 //order of divisions is undefined here, do what is easier for you.`  
`(12 + 5) + 65) //brackets mashup => this is invalid input`  
`(12++-*3) //operators mashup => this is invalid input`  
- There is no need to use any collections here.
- There is no need to use any generics here.
- There is no need to use any regular expressions here. You will probably just need to escape some stuff when calling `String.replace`, e.g. to replace a '+', you will need to call `someString.replace("\\+","my replaced output)` (because + is from regex syntax. And because `replace` accepts a regex input as a String, not as a Pattern, which is actually not the smartest decision in the world).

But if you think regexes will help you here and will make your life easier, you are free to use them. 
Use http://docs.oracle.com/javase/tutorial/essential/regex/ for reference
and http://www.tutorialspoint.com/java/java_regular_expressions.htm for example usage. 


*Bonus challenge objectives*
- Use less than 120 lines of code in total for all classes. (not counting bonuses implementations and unit tests, you can test as much as you like there!)
- Add factorial operation support. It should precede multiplication and division, but bracket rules should apply. 
Examples:
```
java -jar your Jar.jar:
Hello!

Output:> 5.0
Enter expression:> (5+3)!
Output:> 40320.0
Enter expression:> (2*3 + 1*3)!
Output:> 362880.0
Enter expression:> 9!
```
- Add 'power' support: 2^3 = 8, 3^2 = 9, etc. It has the same priority as multiplication!
Examples:
```
java -jar your Jar.jar:
Hello!

Enter expression:> 3^2 + 2^3
Output:> 17.0
Enter expression:> 2^3 + (5+3)^2
Output:> 72.0
Enter expression:> 2^3! + 5*((3+2!)^2)
Output:> 189.0
```
-Add support for mashed up user input: E.g. 2+3\ should be parsed as 2+3. Discourage any symbols different from the ones you are interested in. //regexes will probably help you here, although the difference with/without is ~2 lines of code.
