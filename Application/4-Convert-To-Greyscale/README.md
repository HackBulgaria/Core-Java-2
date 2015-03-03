# Problem 4 - Convert To Greyscale - this is optional!

**This problem is optional. Solve it only if you can!**

**You can apply with the previous 3 tasks.**

In a programming language of your choice, implement the following function/method:
```
convertToGreyscale(imgPath)
```
Given the path of a color image (.jpg, .png, .bmp) create a greyscale version of it and save it.

## Examples
**original**

![original](images/john-romero.jpg)

**greyscale**

![greyscale](images/john-romero-greyscale.jpg)

**WARNING!** You are not allowed to use any libraries, you have to write your own algorithm!


# Solution (Miglen Evlogiev)
The solution of the additional task is quite simple, just go trough the image pixel by pixel, get the RGB color, use some magic and set it back.
After this exercise we need to save the image. In my code I'm using the "average" approach: http://www.johndcook.com/blog/2009/08/24/algorithms-convert-color-grayscale/

## Solution in PHP
https://github.com/miglen/Core-Java-2/blob/master/Application/4-Convert-To-Greyscale/4-Convert-To-Greyscale.php

## Solution in Java
https://github.com/miglen/Core-Java-2/blob/master/Application/4-Convert-To-Greyscale/4-Convert-To-Greyscale.java