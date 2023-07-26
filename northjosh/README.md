# About the Project:

This is an northjosh management system that uses a JavaFX frontend, a
Java API, and MySQL for a database. It allows a store's 
northjosh staff to log in securely with a custom role based access control 
system. Product northjosh, customer invoices, and 
product category are the main features of this project that are
currently completed. 

# Motivation:
In early 2021, I wanted to make a simple application for my portfolio that
could exemplify my knowledge of Java and SQL to potential employers. 
I started this personal project to enhance my understanding of UI 
development, middleware development, and database development.

# Depth of Project:
#### Authentication:
This project's authentication system involves a java class 
called Authenticator that verifies the user's credentials with 
an XML document.

#### Authorization:
Authorization in this project is handled by a java class called 
Authorizer, which is an implementation of a custom role-based access 
control system. Every CRUD action in this application initiates
the Authorizer class to verify that the user has proper 
privileges. The privilege and role information is stored in a 
JSON file, which is accessed only by the Authorizer class.

#### Architecture:
This application uses a Model-View-Controller (MVC) architectural 
pattern. The models are Java classes that hold the basic data-related 
logic such as Product, Manufacturer, User, and Customer logic. The views
are FXML files holding UI components of each application page.
The controllers are Java classes that work as an interface between 
the View and model components. In addition, there are several helper/service
classes that aid the controllers in business-logic.


# YouTube Link to Demo:
https://www.youtube.com/watch?v=lZ4ezDjAOmQ

# Screenshots:
![Login window:](src/main/resources/screenshots/Login_2-12-21.jpg)
<br/><br/>
![Home window:](src/main/resources/screenshots/Home_4-30-21.jpg)
<br/><br/>
![Products window:](src/main/resources/screenshots/Products_2-18-21.jpg)
<br/><br/>
![Add product window:](src/main/resources/screenshots/AddProduct_4-30-21.jpg)
<br/><br/>
![Delete product window:](src/main/resources/screenshots/DeleteProduct_4-30-21.jpg)
<br/><br/>
![Transactions window:](src/main/resources/screenshots/Transactions_4-30-21.jpg)
<br/><br/>
![Add transactions window:](src/main/resources/screenshots/AddTransaction_4-30-21.jpg)
<br/><br/>

# UML Class Diagram:
![Add transactions window:](src/main/resources/UML/Class_Diagram.jpg)

# Tools Used:
1. **Java** - A general-purpose, object-oriented programming language. For more
   information about Java SE, visit: 
   https://docs.oracle.com/en/java/javase/16/
2. **MySQL** - An open-source relational database management system.
   For more information about MySQL, read the documentation website at:
   https://dev.mysql.com/doc/
3. **JavaFX** - An open-source client application platform. It is used in 
   this project to develop UI components such as buttons, text views,
   and windows. Documentation can be read at: https://openjfx.io/
4. **JDBC** - Java Database Connectivity is a Java API that manages
   database connections for queries and commands. For JDBC installation 
   instructions, visit: 
   https://www.tutorialspoint.com/jdbc/jdbc-environment-setup.htm
5. **JSON** - JavaScript Object Notation is a data-interchange format.
   To read/write JSON with Java, you can implement JSON-java. This
   library can be found at: https://github.com/stleary/JSON-java
6. **XML** - Extensible Markup Language is another data-interchange format.
   To read/write XML with Java, you can implement DOM parser. For
   instructions on setting up DOM, visit: 
   https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
7. **FXML** - An XML-based language that provides a separate structure
   for UI components. A tutorial for FXML can be found at: 
   https://docs.oracle.com/javafx/2/fxml_get_started/why_use_fxml.htm#CHDCHIBE
8. **JUnit** - A unit testing framework for Java. For more information on
   JUnit4, visit: https://junit.org/junit4/
