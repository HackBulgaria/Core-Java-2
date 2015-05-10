### 1. Download a file with java
Using only URL and the stream classes, download this photo: http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg to a location of your choosing

##### Now accept files from the command line and label your program the 'java wget'. Woohoo!

### 2. Make a simple website crawler
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

### 3. Get/print all the people that have signed for more than 1 course at Hack Bulgaria.
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

Hint : At present 27/04/2015 the site of hackbulgaria uses TLSv1.2 wih AES_256_CBC with SHA1 for message authentication and EDCHE_RSA for key exchange mechanism. In short this is not supported by default from the java. Here is a [link](http://docs.oracle.com/javase/8/docs/technotes/guides/security/SunProviders.html#SunJCEProvider) for the curious.
This is easy to fix however.  
Step 1: Download [Java Cryptography Extension (JCE)](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)  
Step 2: Locate your jre. Replace 2 jars (local_policy.jar и US_export_policy.jar) in jre\lib\security with the new from JCE.  
Step 3: Run [this code](http://pastebin.com/WsPY7u2M) and see if TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA is in the enabled section of the output.
