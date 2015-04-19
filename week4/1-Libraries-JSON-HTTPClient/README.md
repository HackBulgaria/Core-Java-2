### 1. Send an email

Send an email to someone with subject and some text. Add an attachment to mail.  [here](http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif)

Integrate and use the apache commons-email library from http://commons.apache.org/proper/commons-email/userguide.html

Note: The commons-email library depends on the javax.mail library, which you should download from somewhere. 
If you are using gmail's smtp beware :

https://support.google.com/mail/answer/14257
```
email.setAuthenticator(new DefaultAuthenticator("username", "password"));
email.setSSLOnConnect(true);
email.setDebug(true);
```

### 2. JToaster

Ivan stays a lot on his computer. His mother is afraid it will spoil his vision.
As you know very well, you should take a break of at least 5 minutes (actually, it should be 15, but this *might* be outdated).

Help Ivan maintain his eagle-like vision. Write a program that waits 45 minutes, and the shows a notification saying 'Get a little rest, will you?' (or a message of your choosing :D) 

Use the incredibly-complex JToaster library. Download it from http://jtoaster.sourceforge.net/
Use the methods `showToaster`, `setToasterWidth`, `setToasterHeight`, `setToasterIcon`, `setToasterColor`, `setBackgroundImage`, `setStep`, etc. to customize and make the coolest toaster you can imagine. Also, set a nice background, something like

*hint*: Toaster toasterManager = new Toaster();
toasterManager.showToaster( "JToaster Hello World!" );

![This dog] (http://www.mnn.com/sites/default/files/editorial/Corgeek.jpg)

  
Also, check out the `Thread.sleep` method.


### 3. Make a QuickCodeInspector desktop application

Ever needed to really, really quickly inpsect some code?
Here is a one cool syntax highlighter for java https://code.google.com/p/java-syntax-highlighter/  

1) Create a program, that receives a file path as a command-line argument (args[0] in `main(String[] args)`)  
2) For the File given, launch a syntax highlighter windows as the example in the link above.  

Come back when you are done with 1) and 2).   

Does it work so far? Marvelous.   
3) *Not mandatory*. Now, for the fun, export your program as a *runnable* jar. (See Eclipse->Export). Register your program as one that can handle .java files in your OS (the way to do this will vary among OS and distributions)  
For ubuntu see http://askubuntu.com/questions/289337/how-can-i-change-file-association-globally.  

For windows, create a **.bat** file, containing somthing like:
```
"C:\Program Files\Java\jre7\bin\javaw.exe" -jar "C:\Users\Adriana\Desktop\QuickCodeInspector.jar" %1 %
```
1) C:\Program Files... -> Is the path to your javaw.exe location  
2)-jar C:\Users.....  -> is the path to your QuickCodeInspector.jar  
3) Just append %1 % at the end of the .bat script.
After that, try opening .java files with your application, by using **open with** and pointing to your .bat file. 

Go and check your cool java program that opens .java files for you. (Remove the entry later!).  

4) Set a title on the window that matches the name of the file being viewed!  
5) How cool would it be if we could navigate through all the files of the current directory with the arrows of the keyboard?   
In order to do that, make the jframe **focusable**, add a **KeyEventListener**, and when the user presses the arrow-next on the keyboard (see [key-code table](http://www.foreui.com/articles/Key_Code_Table.htm)), `dispose()` the frame and create a new one with a syntax highlighter configured for the next file.   
6) Make this work recursively for all the files in the folder.  

### 4. Download a file with java
Using only URL and the stream classes, download this photo: http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg to a location of your choosing

##### Now accept files from the command line and label your program the 'java wget'. Woohoo!

### 5. Make a simple website crawler (Pair Programming)
Have you grown tiiiiiiired of looking for stuff on websites that simply seems is not in the navigation menu at all?  
You grow tired of that... and suddenly, baaaam! Someone skypes you the link. It was there, how could I have not seen it.  


Today, we will put an end to that.

Write a simple web crawler, that is receiving a URL as a command line parameter and a "needle" to search for.
Needle is text, usually a sentence.

What your crawler should do is simple
- GET the contents of the URL received
- Check if the contents contain "needle"
- If they do, output the URL and exit
- If they don't, **get all the links** from the URL given and repeat for every link.

Hints/tips:
- **Don't go out of the website's scope** - if a link in `abv.bg` points to google, well, don't follow google, please... 
- **Don't visit the same URL twice** 
- **Use regular expressions** for getting links. If you are unfamiliar with them, use the following method:
```java
	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}
```
- **If you are not comfortable with even using something as ugly as regular expressions, you can do it with regular string matching. It will be harder though :(**
- Use small websites for testing. For example, http://ebusiness.free.bg is one site you can use. It has very, very few links. (Search for the word 'Револвираща'.)

### 6. Get/print all the people that have signed for more than 1 course at Hack Bulgaria.
Some people have signed for Core Java.  
Some people have signed for Front-end Javascript.  
Some people have signed for Angular-JS.   

They are people that have signed for more than one course.  
Using the https://hackbulgaria.com/api/students/ API, the [Jettison library](http://jettison.codehaus.org/) and [Apache HttpClient](http://hc.apache.org/httpclient-3.x/tutorial.html), consume the REST service given and print out all the people, who have signed for more that 1 course. 
 

##### Addendum: Print out the people with the most visits.
See, whenever you visit HackBulgaria and use our WiFi, your MAC addresses get logged. If you have 'filled the forms' when registering at the HackBulgaria website, you can now see  who has been coming and who hasn't been coming to the lectures.  

```
{"date": "2014-06-05", "student_id": 35, "student_courses": [{"group": 1, "name": "Frontend JavaScript"}], "student_name": "Светимир Игнатов"}
```

Using https://hackbulgaria.com/api/checkins/, the [Jettison library](http://jettison.codehaus.org/) and [Apache HttpClient](http://hc.apache.org/httpclient-3.x/tutorial.html), consume the REST service given and print out pairs of String-Integer, where the key (String) is the name of a Person, and the value (Integer) is the number of times he was at HackBulgaria. Sort the pairs when printing - people with more checkins should come before people with less checkins.


 

