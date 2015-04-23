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

Help Ivan maintain his eagle-like vision. Write a program that shows a notification saying 'Get a little rest, will you?' (or a message of your choosing :D) 

Use the incredibly-complex JToaster library. Download it from http://jtoaster.sourceforge.net/
Use the methods `showToaster`, `setToasterWidth`, `setToasterHeight`, `setToasterIcon`, `setToasterColor`, `setBackgroundImage`, `setStep`, etc. to customize and make the coolest toaster you can imagine. Also, set a nice background, something like

*hint*: 
```
Toaster toasterManager = new Toaster();
toasterManager.showToaster( "JToaster Hello World!" );
```

![This dog] (http://www.mnn.com/sites/default/files/editorial/Corgeek.jpg)

### 3. Make a QuickCodeInspector desktop application

Ever needed to really, really quickly inpsect some code?
Here is a one cool syntax highlighter for java https://code.google.com/p/java-syntax-highlighter/  

1) Create a program, that receives a file path as a command-line argument (args[0] in `main(String[] args)`)  
2) For the File given, launch a syntax highlighter windows as the example in the link above.
