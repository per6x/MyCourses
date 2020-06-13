## Contents
[More Operators](#More-Operators)\
[Selection](#Selection)\
[Iteration](#Iteration)\
[Exercises](#Exercises)


- ## More Operators

    - ## Equality Operators

        ``==`` equal to
        ``!=`` not equal to
        
        ```java
        System.out.println(1 == 1); // <true>
        System.out.println(true != false); // <true>
        ```
        
        This operator compares **the two memory addresses** to determine if the two things we are comparing are equal. This should **only** be used for primitive types (we'll talk about this later when we get into objects), reminder that a String is **not** a primitive data type
        
    - ## Relational Operators
    
        ``<`` less than
        ``>`` greater than
        ``<=`` less or equal to
        ``>=`` greater or equal to
        
        Note that since ``1 < 2`` evaluates to a ``boolean``, it is impossible to perform this operation
        ```java
        boolean myBoolean = 1 < 2 < 3;
        
        /*
        the first half (1 < 2) is evaluated first and returns true. However we now have: true < 3
        which will give us an exception
        */
        ```
       
    - ## Boolean Operators
    
        ``&`` logical AND
        ``|`` logical OR
        ``^`` logical XOR
        ``!`` logical complement (recall !=)
        
        | a     | b     | a & b | a \| b | a ^ b |
        |-------|-------|-------|--------|-------|
        | false | false | false | false  | false |
        | false | true  | false | true   | true  |
        | true  | false | false | true   | true  |
        | true  | true  | true  | true   | false |
        
        | a     | !a    |
        |-------|-------|
        | true  | false |
        | false | true  |
        
    - ## Conditional Operators (lazy)
    
        ``&&`` conditional AND
        ``||`` conditional OR
        
        This is what you'll be using 99% of the time. They are called *lazy* operators because they evaluate the right side only when necessary.
        
        | a     | b          | a && b |
        |-------|------------|--------|
        | false | <anything> | false  |
        | true  | false      | false  |
        | true  | true       | true   |
        
        | a     | b          | a \|\| b |
        |-------|------------|----------|
        | false | false      | false    |
        | fals  | true       | true     |
        | true  | <anything> | true     |
        
    - ## Integer Bitwise Operators
    
        ``&`` bitwise AND
        ``|`` bitwise OR
        ``^`` bitwise XOR
        ``~`` bitwise complement
        
        The expression ``<any number>b`` tells java to interpret the number as binary. You will use this like once in your entire life unless you get into cyber security but here you go.
        
- ## Selection

    - ## If statement
    
        ```java
        if (<condition>)
            <statement>;
        
        if (<other condition>)
            <statement>;
        else if (<other other condition>) {
            <multi line statement which btw require brackets
            You can also use brackets in single line statements if you want>;
        } else
            <No condition was checked, this is the 'default' outcome if the previous 2 ifs are not satisfied>
        ```
        
    - ## Switch statement
    
        A switch statement is just multiple ``if - else if - else`` statements but more readable in case you have a bunch of those. Again you wont see these used very often but they exist
        
        ```java
        String numString = "";
        int num = 5;
        
        // this is ugly asf but yes
        
        switch (num) {
            case 10:
                numString = "Ten";
                break; // This break makes sure to hault execution if the case is satisfied
            case 9:
            case 8:
            case 6:
            case 5:
                numString = "this could be anywhere from nine to five but not 7";
                break;
            default:
                numString = "None of the cases were satisfied :(";
        }
        ```

        Note how if we were to omit the break from lets say case 10 the execution would continue meaning we would also get either case 5 or the default case executed as well
        
- ## Iteration

    - ## For loop
    
        ```java
        for (int i = 0; i < 10; i++) {
            System.out.println(i); // you could also ommit the brackets here
        }
        ```

        Now thats a bunch of new stuff here so lets unpack them.
        
        - ``int i = 0;`` This initializes a counter (sometimes called index) with an initial value of 0.
        This keeps track of how many times we have already performed the statement specified by the for loop. Note 
        that usually you start with the value of ``0`` on this one because of array indices but we'll get into that later
        
        - ``i < 10;`` This is the stopping condition. This is checked before every iteratin and if its not true then
        the for loop stops running. This will not run when ``i == 10`` but remember that we start counting from ``0``
        so this is still 10 iterations.
        
        - ``i++`` This increments our counter after every iteration. If it wasnt for this our counter would always
        have its initial value and our loop would never stop. Of course you can change this to any form of increment
        you want like ``i = i + 2`` for example.
        
        We can also iterate backwards which although useless in this example can be useful when dealing with proper data structures
        
        ```java
        for (int i = 9; i >= 0; i--) {
        System.out.println(i); 
        }
        ```
    
        This prints the same sequence of numbers as the previous one just backwards. Again we want to end at zero because
        of stuff we'll deal with later, just make this a habit.
        
        Your stop condition could also be ``i == 0`` but generally speaking using a relational operator is safer (in case
        you interact with the index inside of the loop you may increment it which may result in you skipping the stopping
        condition so again make it a habit of using relational operators for your stopping condition if possible)
        
        You can add a for loop inside of a for loop which is called a **nested** for loop. By convention most people use
        ``i, j, k, l`` for their nested for loops' counters but you can obviously use whatever you want.
        
        ```java
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                <statement>;
            }
        }
        ```
    
        Be very careful to use the correct indices for each for loop (dont increment ``i`` in the second for loop instead
        of j for example by accident). In case this isn't clear, what this would do is execute the statement 10 times for
        each iteration of the outer for loop. The statement would be executed 100 times in this case.
        
    - ## While loop
    
        While loops are very similar to for loops, in fact they can act exactly the same if you add an increment
        statement inside of them. Usually however you will want to use them when you have a boolean value
        that will change at some point in your execution
        
        ```java
        boolean myBool = true;
        
        while (myBool) { // while this is true, execute the code block
           if (<condition>)
               myBool = false; // this will stop the execution
        }
        ```

- ## Exercises

    - 1. Find the greater of 3 numbers
    - 2. Print this String programmatically 
    ```java
    *   
     *  
      * 
       *
        *
    ```
    For this you need to know that ``System.out.print("text");`` exists and does the exact same with 
    ``System.out.println("text");`` but without a newline ``\n`` character at the end of the String. Hint,
     you should use for loops.
     - 3. Print this sequence ``1.0 1.5 2.0 2.5 3.0`` of floats
     - 4. Find the sum of all numbers in [0, 10)

     Exercise blueprints can be found [here](/OOP/Exercises/Blueprints/Lecture2.java).\
     Exercise solutions can be found [here](/OOP/Exercises/Solutions/Lecture2.java).

     I came up with the solutions in like 5 minutes so there's a good chance that they can be implemented better
     but that's not really my goal right now so idc.

     When we learn about methods (so next lecture) I'll *probably* start writing tests which you will be able to run to check if your method was implemented correctly

     I highly encourage you to take 5-10 minutes to solve each exercise before looking at the solutions
