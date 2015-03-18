###Some debugging fun###
1) Get latest changes from HackBulgaria repo
`git pull` 
or
`git clone https://github.com/HackBulgaria/Core-Java-1.git`

2) Import the DebuggingFun project in Eclipse
- if you use 'import existing projects Eclipse it will not copy it in your workspace
- if you use 'import from file system' 


//The ProjectName for all of the three problems below should be 'TDDIntro'

###JUnit Hello world###
Implement a method 'getNumberOfDigits(int)' which just counts the number of digits.

1) Write the signature of the method  
2) Write the test, make sure it fails beautifully. Think of some edge cases.  
 3) Implement the method  
4) Pass your own test! Woohoo!  


###Implement a join method### 
Java does not have a String join method. Apache StringUtils does have, but, well, that's not an excuse.

Make a method that joins strings, with a **glue** given from the caller of your method.

Can you think of a way for it to work with every object, not just string? Even primitives?

//Glue is the first argument => " "
`stichMeUp(" ", "Днес", "видях", 5, "ходещи", "медузи") => "Днес видях 5 ходещи медузи"` 

1) Think of a good name for this method
2) Make a test class
3) Make several test cases, see that your tests fail mightily : )
4) Implement! 

###Reduce file path! In Java. In a test-driven way. ###
See Problem 27 @ https://github.com/HackBulgaria/Programming101/blob/master/week0/simple_problems2.md
