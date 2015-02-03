# Problem 2 - List Duplicating Files

## Description

In a programming language of your choice, implement the following function/method:

```
listDuplicatingFiles(dir)
```

Return a collection of all the files in a given directory `dir`. 

When we say "all the files" we mean all the files...recursively. Meaning that the files contained in the subfolders all the way down should also be included. From those files, exclude the ones who are equal to previously discovered files. 

**By equal we mean files with equal contents**. We don't care about the timestamp or the file name.

## Examples
Let's say that your current directory looks like this:
```
/root
|__readme.md
|__/examples
  |__test1.java
  |__test2.java
  |__/images
    |__walter_white.png
    |__witcher_3_wallpaper.png
  |__/assets
    |__witcher.png
```

In the above structure our root folder contains only one file - `readme.md`. 
We wish to traverse it to the bottom of the heirarchy, thus the list of all files our program should select is - `readme.md`, `test1.java`, `test2.java`, `walter_white.png`, `witcher_3_wallpaper.png`, `witcher.png`.
And now for the filtering part. `witcher_3_wallpaper.png` and `witcher.png` reside in different directories and have different names, but their contents are the same. The result of the program should be:
```
[`readme.md`, `test1.java`, `test2.java`, `walter_white.png`, `witcher_3_wallpaper.png`]
```
or
```
[`readme.md`, `test1.java`, `test2.java`, `walter_white.png`, `witcher.png`]
```
It doesn't matter which file you choose to keep, as long as there are no duplicating ones in the final result

## Details
- Check if the directory exists
- And don't forget - locate the files in every level of the root directory and exclude the duplicating ones!
