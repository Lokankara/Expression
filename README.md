## Req

1. In the environment, create a new project with one main class Main.
2. Create a test class to test the main class of the program.
3. In the main class, describe a method that calculates the values of the function that is specified in the table in the
   test class - test methods for it. Act in the following sequence: first create one test method, generate a method for
   calculating the function. Perform the test and make sure that the test works, that is, testing the generated method
   should result in an "error". Implement the method. Perform the test. After making sure that the test passes, create a
   few more test methods for the function evaluation method. Perform testing.
4. Develop a method that, according to the specified values of the step, start and end of the interval, calculates the
   number of steps for tabulation and test methods for it and perform testing (see the procedure in section H).
5. Create methods that create arrays of values of the function (y) and its argument (x) at all points of the specified
   interval with a given step. (The size of the array is calculated programmatically using the method from step 4).
   Create test methods for them and perform testing (see section 4).
6. Create methods that, after the formation of arrays, find the numbers of the largest and smallest elements of the
   array of function values, and methods that calculate the sum and arithmetic mean of the elements of the array of
   function values. Create methods together with tests and constantly perform testing.
7. Create methods for displaying the largest and smallest elements of an array of function values, specifying their
   numbers and the corresponding argument values.
8. Add the main method to the created class, thus turning it into a standalone program. Compile and execute the
   programm

` mvn clean install -X `

`java -jar ./testing/target/testing-1.0-SNAPSHOT.jar`