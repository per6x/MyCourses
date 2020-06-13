## Contents
[Why and How](#Why-and-How)\
[Method Related Concepts](#Method-Related-Concepts)\
[Iteration](#Iteration)\
[Exercises](#Exercises)

Disclaimer: I might call methods ``functions`` in this lecture, they are the same thing function is just javascript terminology so don't worry about that

- ## Why and How

    - ## Why

        DRY principle (Don't repeat yourself). Cleaner and most importantly **reusable** code

    - ## How

        ```java
        // Find the greater of 3 numbers

        int a = 2;
        int b = 5;
        int c = 7;
        int res; // Put result here

        // Implementation without a method

        res = a;

        if (res < b)
            res = b;
        if (res < c)
            res = c;

        // Implementation with a method
        public static int getGreaterOf3Numbers(int n1, int n2, int n3) {
            int res = n1;

            if (res < n2)
                res = n2;
            if (res < n3)
                res = n3;

            return res;
        }

        // Method call
        res = getGreaterOf3Numbers(a, b, c);
        ```
        
        Lets break the method declaration down

        - ``public``: Access modifier, more on this in the classes lecture.
        - ``static``: This makes it so the method is callable without an object instance, again more on this in the classes lecture.
        - ``int``: Method Return type. This can be any primitive data type or even object. If the method returns nothing then this should be set to ``void`` (instead of returning the result we could for example print it, you dont need a return statement in this case)
        - ``getGreaterOf3Numbers``: Method name. This can be whatever you want but its good practice to make these self explanatory
        - ``(int n1, int n2, int n3)``: Method arguments/parameters. This forces us to pass in 3 ints during the method call. These ints will be assigned the names ``n1, n2, n3`` **inside** the method.
        - ``return``: You can think of this as what the method evaluates to. In this case it's the bigger number.
        - Method call: ``methodName(require parameters);``. Since this function returns the result we assign it to our own value of ``res``

        Keep in mind that the method declaration does not run on its own until called.

- ## Method-Related-Concepts

    - ## Scoping

        We call the area of a program where a certain variable is accessible it's **scope**

        ```java
        public static void sayHello() {
            int someNumber = 5;

            // Other stuff here
        }

        System.out.println(someNumber); // ERROR someNumber doesnt exist in this scope


        int num = 5;
        int num2 = 5;

        public static void doStuff() {
            int num = 10;

            System.out.println(num); // <10>
            System.out.println(num2); // <5>
        }

        System.out.println(num); // <5>
        ```

        Basically:

        - Any variable declared in an outer scope will be available in an inner scope. Its value can be overriden but will not be communicated back
        - Any variable declared in an inner scope will not be available in an outer scope.

        This is a very important thing to grasp but it becomes very natural over time.

    - ## Method Overloading

        Each method has a unique **method signature** that is comprised of it's name and its parameters. This means that we can have 2 methods with the same name but different parameters, this is called **method overloading**

        ```java
        public static void findBiggerNumber(int a, int b, int c) {
            int res = a;

            if (res < b)
                res = b;

            if (res < c)
                res = c;

            return res;
        }

        public static void findBiggerNumber(int a, int b) {
            if (b > a)
                return a;
            else
                return b;
        }

        int res1 = findBiggerNumber(3, 5, 7);
        int res2 = findBiggerNumber(3, 5);
        ```

        As you can see we are seemingly calling the same method but with different parameters. This becomes very useful when dealing with classes. It is also possible to implement this like this

        ```java
        public static void findBiggerNumber(int a, int b, int c) {
            int res = findBiggerNumber(a, b);

            if (res < c)
                res = c;

            return res;
        }

        public static void findBiggerNumber(int a, int b) {
            if (b > a)
                return a;
            else
                return b;
        }

        int res1 = findBiggerNumber(3, 5, 7);
        int res2 = findBiggerNumber(3, 5);
        ```

        or even like this

        ```java
        public static void findBiggerNumber(int a, int b, int c) {
            return findBiggerNumber(findBiggerNumber(a, b), c);
        }

        public static void findBiggerNumber(int a, int b) {
            if (b > a)
                return a;
            else
                return b;
        }

        int res1 = findBiggerNumber(3, 5, 7);
        int res2 = findBiggerNumber(3, 5);
        ```

        But how does the ``return findBiggerNumber(findBiggerNumber(a, b), c);`` work?

        - First it evaluates ``findBiggerNumber(a, b)`` using the second method, and gets the returned result.
        - Then it evaluates ``findBiggerNumber(findBiggerNumber(a, b), c);``. Since we already evaluated the inner statement you can think of it as ``findBiggerNumber(d, c);`` where d is the bigger number between ``a`` and ``b``
        - Then it evaluates ``findBiggerNumber(d, c);`` and returns the result.

        This is overkill but it just goes to show how powerful methods can be.

        Here we performed overloading by changing the number of parameters our method takes. We could also change the ``type`` of those parameters. For example its possible to have:

        ```java
            public static void findBiggerNumber(int a, int b) { ... }

            public static void findBiggerNumber(double a, double b) { ... }
        ```

    - ## Pass by Value VS Pass by Reference

        ```java
        public static void changeNumber(int x) {
            x = x + 5;
        }

        int x = 0;
        changeNumber(x);
        System.out.println(x); // <0>
        ```

        This is pass by value. Java creates a copy of our passed parameter and uses that inside the function. This means that any change made inside the function to our variable will not apply to anywhere outside of the method scope

        ``What is pass by reference then?`` In the next lecture we will see how by performing the same action on an object will work differently. When as a function parameter we specify an object instead of a primitive java will pass its **memory location** instead of a copy with the same value. This means that any change we perform to it will in fact change the original variable. A good example mentioned in the book is the following:

        ```java
        public static void main(String[] args) {
            int a = 10;
            int b = 12;

            System.out.println(a + ", " + b); // <10, 12>
            swap(a, b);
            System.out.println(a + ", " + b); // <10, 12>
        }

        public static void swap(int x, int y) {
            int temp = x;
            x = y;
            y = temp;
        }
        ```

        We will use an object for this in the next lecture and you'll see how those 2 differ.

- ## Exercises

    Exercise blueprints can be found [here](/OOP/Exercises/Blueprints/Lecture3.java).\
    Exercise solutions can be found [here](/OOP/Exercises/Solutions/Lecture3.java).\

    Since we are now working with methods we can utilize tests to test the implementations. You can easily run the tests through Intellij the same way you would run main(). Solutions are again provided.