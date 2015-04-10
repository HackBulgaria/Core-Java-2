All tasks should go into 'Exceptions1' project in your workspace. 

### 1. Unchecked (runtime) exception example usage
Design an unchecked Exception class "DatabaseCorruptedException", which is to be thrown whenever a corrupted database object is detected (e.g. "" for username in table `Users`).
Use good and concise exception message, explaining what is wrong with the object `User` object - for this excercise you can assume that the `username` field is "".

*Database Corruption is not expected to happen. People should not need to 'catch' an eventual database corruption on every interaction/transaction with a database, because this is not an expected situation and it is not OK to be fault-tolerant on such scenarios*

Make a method that throws this exception. Use it and see your message in the stack trace.

### 2. Checked exception example usage
Imagine you are designing an API for using services.  

*In the real world, services break all the time. Network connections go down, firewalls go crazy, routers get re(s)tarted, etc. It is more or less expected of you to be network fault-tolerant, as networks are not perfect and they just can't be.* 

For this task, you need to **first create an Exception class, a checked one (`extends Exception`), give it a good long-ish name, like `ServiceNotAvailableAtTheMoment`, and encapsulate some information about the situation in the exception.** For example, it would be cool if in the exception message you write possible reasons for the service breakdown, what could have gotten wrong, etc.

*Exceptions messages and traces are watched by **developer**. It is a sign of courtesy and respectfullness to write good, descriptive and concise exception messages to help people that investigate when things go wrong.*

After you are done designing your good looking Exception class, you should declare your a method (e.g. `useService`) that is **declared to throw your exception**.
After you are done with that, try and use your method. 
Observe how every time you use it, you are forced to think *what will happen if this service fails?*.


### 3. Make the 'Time' class fool-proof
Remember you wrote a `Time` class, some weeks ago? Go back, copy your class into your project and **make it fool-proof**. Protect the poor public user of your class using exceptions.  Think of some unpleasent (or edge-case) situations that may occur while using your class.

Hint: Check http://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html and
http://stackoverflow.com/questions/15208544/when-should-illegalargumentexception-be-thrown

### 4. Do not allow them to insert null as a key!
You know HashMap in java. They are completely happy with (null, null) key-value pairs.
Let's say we are not happy with this being the default behavior. Especially for **keys**.

Extends `HashMap` and make it optional for your class to accept null **keys**, but by default, set this option to `false`. (Use a flag, make a constructor with the option.) 
Fix the `put`, `get` methods accordingly to allow or not allow null keys. 
What should you do in those methods if your object is set not to allow null keys? Throw your very own, good-named, custom-made exception with a good message, of course.

### 5. Impement your very own immutable and unmodifiable list
Create a class 'ImmutableList', which implements List. It's okay to extend something else.
Your delcaration should be like this:
`public class Immutable<E> extends ArrayList<E>`
 
Unmodifiable collection is collection which oce crated can not accept new ellements and its ellements can not be removed.Its add and remove methods should throw exception. 

immutable collection is when its ellements can not be changed once put in it.

Of course, in order for your class to be immutable, you need good constructors.
Make a constructor that accepts a `Collection<? extends E> collection` in which you add all the elements from `collection` to your list, and forbid anyone to modify it by throwing an exception when anyone tries to do that. 

Implement `Arrays.asList()` factory method functionality - declare a static method `<T> List<T> asList(T... arguments)`. 
Use the `@SafeVarargs` annotation on top of your method declararation to tell the compiler you won't be naughty.

Hint: In the `get` method return a clone of the element, so it can't be modified from the outside. Use Apache Commons for object cloning https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/SerializationUtils.html

##Bonus!##
### Implement a XmlMarkupBuilder class ###
Make an easy to use XmlMarkupBuilder class, which creates a **valid xml** 

We won't worry about namespaces here. By valid, I mean having the `<?xml version="1.0" encoding="UTF-8"?>` declaration, and having only tags, attributes, and text between a tag opening and tag closing.

For instance:
```
<elements>
	<element attr="attributeValue">attr</element>
</elements>

<!-- valid xml! -->

<elements> Hey dude check it out
	<element> why are you out of scope, man? </element>
</elements>
<!-- Because I am an invalid xml declaration, that is why! -->
```

Your class should support these operations:
```java
XmlMarkupBuilder openTag(String tagName); 
XmlMarkupBuilder addAttr(String attrName, String attrValue); // valid only when you have a tag opened!
XmlMarkupBuilder addText(String text); 
XmlMarkupBuilder closeTag(); //close the last opened tag.
XmlMarkupBuilder finish(); //close all tags and finelize your object. Any open,addAttr or other calls to your object, should throw an Exception.
String getResult(); //let's stay close to http://en.wikipedia.org/wiki/Builder_pattern 
```

Example usages of your `XmlMarkupBuilder` class
```java
XmlMarkupBuilder markupBuilder = new XmlMarkupBuilder();

//http://en.wikipedia.org/wiki/Fluent_interface ftw
String validMarkup = markupBuilder.openTag("body").addAttr("background","0xFF0000").addText("Helo HTML!").finalize().getResult(); 
markupBuilder.closeTag() //BOOOM! Object finalized! Exception!
...............
XmlMarkupBuilder markupBuilder = new XmlMarkupBuilder();
markupBuilder.openTag("a").closeTag().openTag("a") //BOOOM! You need to have a root XML object, XML is not a list!
............... 
XmlMarkupBuilder markupBuilder = new XmlMarkupBuilder();
markupBuilder.openTag("a").closeTag().closeTag() //BOOOM! What the hell are we closing?!
...............
XmlMarkupBuilder markupBuilder = new XmlMarkupBuilder();
markupBuilder.openTag("a").closeTag().addAttribute("href","https://www.youtube.com/watch?v=P5ft_7Bcyc4") //BOOOM! What are you adding attribute to?

and so on and so on
```
