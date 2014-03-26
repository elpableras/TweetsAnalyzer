TweetsAnalyzer
===============


I had developed a RESTful web service, using NetBeans 7.3 for it, and as server GlassFish v3.1, I used the features of Java EE6.

The GET method is used to make the request and obtain information through a parameter which return a String that all information, then with successive split, I create arrays with the information that after I will show.
The class that contain these methods is as an EJB Facade class of a Java EE application, but also could have been used Jersey.

To display the Web Service, I has created a simple HTML, which contains JavaScript, I use it with AJAX for consume the JavaScript, using jQuery.

To the URL I will pass the parameter ("base") of Tweet, written in HTML, which will be analyzer for the application and return a String data.

Once the data is in the HTML, I split it in pieces and I will be used for:

- Show the Tweet lowercase sentence with punctuation removed
- The value of each of the words analyzed
- The average of all
- The language is the Tweet

After with the data word values I create a chart table with the utility gives the API Google Chart, for show, a happy face, if the Tweet data is positive, a normal face if the Tweet data is normal or a sad face if the Tweet data is negative.

