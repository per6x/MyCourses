# Data & Operations

- ## Data

    ### Primitive Data Types

    Integers: ```int``` (-5, 2, 2^31 - 1)\
    Real Numbers: ```float/double``` (-0.42, 0.30000000000000004)\
    Characters: ```char``` ('b', 'r', 'u', 'h')

    ### Declaration and initialisation

    ```java
    // Declaration
    int num;

    // Assignment
    num = 4;

    // Declaration and initialisation (just use this)
    int num2 = 5;

    /*
    Data type: int
    Variable name: num, num2
    Values: 4, 5
    */

    // Similarly
    double ues = 42.0;
    char uw = 'u';
    String ThisIsNotPrimitive = "Notice the double quotes in contrast to the char";
    ```

    ### Operators
    ``+`` Addition\
    ``-`` Subtraction\
    ``*`` Multiplication\
    ``/`` Division\
    ``%`` Remained (might be referenced as modulo)

    These work as expected for numbers but note that you can concatenate Strings with ``+``

    ```java
    String text1 = "br";
    String text2 = "uh";
    String text3 = text1 + text2;
    ```

    Epic useful thing to know. There will be a lot of cases where you will want to increment (increase the value by one) or decrement a number

    ```java
    int hi = 2;

    // The virgin way
    hi = hi + 1;

    // The chad way
    hi++;

    // The I use python lol way
    hi += 1;

    // In all cases hi is incremented by 1

    /* Side Note
    If you increment a value inside of an expression (for example inside a print command) the hi++ statement will be evaluated AFTER the print. This means that while in the end the value will be incremented, that wont be the case in the printed value, you can use ++hi to avoid this, see example later. Keep in mind that both of these change the initial value of hi unlike doing hi + 1 (againt see next snippet for example)
    */
    ```

    ### Printing and Stuff

    Java has a reputation of being really fucking long for no reason literally everywhere so this is the command to print stuff on your console along with some examples, the text inside the ``<>`` represents the values that would be printed where you to run this piece of code

    ```java
    int num = 4;
    String yes = "yes";

    System.out.println("Hello, World"!); // <Hello, World!>
    System.out.println(num + 1); // <5>
    System.out.println(num++); //<4> (unm is now 5)
    System.out.println(++num); //<6> 
    System.out.println(yes + "xdd"); // <yes xdd>
    ```

    ### Your First Java Program

    ```java
    public class idk {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }
    ```

    So basically dont worry about all the weird stuff you can't understand about the next snippet yet it will be made clear in later lectures

    - ``But how tf am I supposed to run this?``
    - Its a good idea to grab an IDE like [Intellij](https://www.jetbrains.com/idea/download/) and just let it do the compiling and executing for you. Here's an [official video](https://www.youtube.com/watch?v=H_XxH66lm3U) that can help you get started, be sure to get a hello world program going before moving on to the next lectures
