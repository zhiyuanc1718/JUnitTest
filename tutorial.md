## JUnit Testing

### Step 1 : Download Necessary Packages

go to the [downloads folder](./downloads) and download
- `hamcrest-core-1.3.jar`
- `junit-4.13.jar`

Make sure that the two `.jar` files are in the same directory as every other test and code file!

### Step 2 : Prepare test class (the code that you will run the test cases on)

For this example, I will test a static method. Non-static method would require you to instantiate an object (more work, I guess).

Write the class. If our task is to make a sum method in Main class that find the sum of a list of integers:

**Here, I will make the code produce incorrect answer.**

```java

class Main {

  public static int sum(int[] list){
    int total = -1;
    for (int x : list){
      total += x;
    }
    return total;
  }

}
```

Because we started with -1 rather than 0 for `total`, the code will not produce the right answer. However, let's assume we didn't know that (proceed with test file).

compile this java file. `javac Main.java`

### Step 3 : Write test file

- First create a new java file, we will name it `myTest.java` or whatever you prefer that isn't `Test`
- open the file and write the following code

```java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class myTest {

  @Test
  public void test1() {

    assertEquals("expected output here", "the output observed");
  }

}
```

note for each test case, you must use the `@Test` annotation to let the compiler know that we're running a test

`assertEquals(expected, observed)` will throw errors if the observed value differs from the expected.

for example, back to our sum method above, to get the `"output observed"`, you called the method and pass in the parameters for the particular test case. You will manually find the answer for it and replace `"expected output"` with that answer.

```java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class myTest {

  @Test
  public void test1() {
    assertEquals(15, Main.sum(new int[]{1,2,3,4,5}));
  }

}
```

to compile this test file, use command :
`javac -cp .:junit-4.13.jar:hamcrest-core-1.3.jar testFileName.java`

for the case discussed :
`javac -cp .:junit-4.13.jar:hamcrest-core-1.3.jar myTest.java`

After you are done with both files and compiled them,
to run the test

use command :
`java -cp .:junit-4.13.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestFileName`

for our case :
`java -cp .:junit-4.13.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore myTest`

And we will see :

```bash
JUnit version 4.13
.E
Time: 0.071
There was 1 failure:
1) test1(myTest)
java.lang.AssertionError: expected:<15> but was:<14>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:647)
        at org.junit.Assert.assertEquals(Assert.java:633)
        at myTest.test1(myTest.java:8)

FAILURES!!!
Tests run: 1,  Failures: 1
```

Like we expected, our code will produce the wrong answer.
