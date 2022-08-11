# DECATHLON

In this assignment your task is to write a Java program that would calculate the results of a [Decathlon](http://en.wikipedia.org/wiki/Decathlon)
competition. 

### INPUT

A CSV file containing the raw results of the competition (see ‘results.csv’ file in attachment).

### OUTPUT

- An XML file which contains all the athletes in ascending order of their places. 
- Athletes should have all the result data from the CSV file plus calculated total score and the place in the competition. In case
of equal scores, athletes must share the places, e.g. 3-4 and 3-4 instead of 3 and 4.
- The rules for the point calculation can be found here: http://en.wikipedia.org/wiki/Decathlon (see
formulas at the end of the page).

### TECHNICAL REQUIREMENTS

- JDK 1.8 should be used
- The program should not use any external libraries in addition to the Java standard API
- The tests can use external libraries (Junit, Mockito, etc)
- Your project should be build using Maven 

### Implementation

- DecathlonMainApplication is the main class for this application. You may pass.
- You may permissible input and output file paths as arguments to the above class. 
- By default, results.csv is the input file and decathlon_assignment_result.xml is the output file.