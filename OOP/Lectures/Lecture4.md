## Contents
[Introduction](#Introduction)\
[Making Our Own Class](#Making-Our-Own-Class)\
[Object Equality](#Object-Equality)\
[Strings](#Strings)\
[Static Stuff](#Static-Stuff)\
[Pass by Reference](#Pass-By-Reference)\
[Exercises](#Exercises)

## Introduction

A class is a software module that is composed of attributes and methods.


```java
class Example {
    static int num = 2; // A static attribute

    static int func() { // A static method
        return 1;
    }
}

// Usage
System.out.println(Example.num); // <2>
System.out.println(Example.func()); // <1>

class Example2 {
    int num = 2;

    int func() {
        return 1;
    }
}

// Usage
Example tmp = new Example2(); // We instantiate an object from the Example2 class

System.out.println(tmp.num); // <2>
System.out.println(tmp.func()); // <1>
```

A class acts like a blueprint for objects. The creation of an object using such a blueprint is called **instantiating** the object. That object will then have all the methods as well as attributes specified by the class

## Making Our Own Class

Task: Create a class with 2 attributes ``x, y`` of type ``double`` and 2 methods for returning their values.

```java
public class Point {
    private double x;
    private double y;

    public Point(double passedX, double passedY) {
        this.x = passedX;
        this.y = passedY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
```

Let's break it down

- ``public Point(double passedX, double passedY)``: 
    - ``public``: Access modifier, this class can be accessed from anywhere in your program
    - ``Point``: Class name, start with capital letters by convention
    - ``(double passedX, double passedY)``: Forces the user to pass 2 doubles when instantiating the class (simple parameters)
- ``private double x/y;``: These two are class attributes, values that the object has. Most of the time you want these to be private meaning only this specific class has access to them. This is done so as to prevent the attributes getting edited by random classes by accident or intentionally (security risk), this is called encapsulation
- ``The constructor``: The next 3 lines are a special method called the costructor. What that does is it takes the passed parameters ``passedX, passedY`` and assigns them to the local private variables. More often than not you will see people write constructors like this:
    ```java
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    ```
    In this case I named the two differently to make it less confusing. The ``this`` keyword is used to refer to the current object from inside it's class.
- ``The 2 getter methods``: These are normal methods that we call ``getters``. Since our variables are private we have to access them using our getters from outside the class

This is how we would use such an object
```java
Point point = new Point(1,2);

System.out.println(point.getX()) // <1>
System.out.println(point.getY()) // <2>
```

Just a little note: You could have a class with an attribute that is a different class

## Object Equality

We will keep using our ``Point`` class for the rest of this lecture. Lets compare 2 point objects

```java
Point point1 = new Point(1,2);
Point point2 = new Point(1,2);

System.out.println(point1 == point2);
```

So this is where java just says **no** and returns false. Even though the 2 objects are practically identical the ``==`` operator compares their **memory locations** and of course since the 2 objects are separate entities they can never have the same memory location. This is therefore only really useful in determining if the object is, well, itself, more on this later.

So how *do* you compare objects? Well you are in luck because java has a ``.equal()`` method! So lets use that instead

```java
Point point1 = new Point(1,2);
Point point2 = new Point(1,2);

System.out.println(point1.equals(point2));
```

Of course this wouldnt be java if it had literally any practicality in it so you have to implement the equals method yourself since the default implementation **literally uses the ``==`` operator for the comparison**. So lets do that then

```java
public class Point {

    ...

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point that = (Point) obj;

            return (this.x == that.x) && (this.y == that.y);
        } else
            return false;
    }
}
```

let's once again break this down:

- ``public boolean equals(Object obj)``: This is a public method that returns a boolean and takes in as parameter **an object**
- ``if (obj instanceof Point)``: This returns true if ``obj`` is in fact a ``Point`` object
    - ``Point that = (Point) obj;``: This is called casting, we are basically telling java "Dude trust me, this is a point" to what java replies "cool its not my fault if ur dumb and something breaks from now on aha". And now we have a new Point called ``that``
    - ``return (this.x == that.x) && (this.y == that.y)`` This is the actual comparison, we want both the coordinates from ``this`` and ``that`` to be the same.
- If its not a ``Point`` we can simply return false

If ``this`` and ``other/that`` were not clear:

```java
Point point1 = new Point(1,2);
Point point2 = new Point(1,2);

point1.equals(point2); 
/*
point1 will be this and point2 will be obj and later that. This will of course return true
*/
```

The reason why ``==`` is still useful sometimes inside the ``equals`` method is because, well someone could for some reason be comparing an object to itself. By addying ``this == obj`` if case at the beginning of our equals implementation we improve its efficiency.

## Strings

Remember when in a previous lecture it was mentioned that ``==`` should not be used to compare Strings? Well turns out Strings are not primitives and are in fact arrays of characters. We'll explore arrays in a later lecture for now all you have to know is that they basically are multiple values of a certain type that have the form of a list. So by stacking (if you know what a stack is yes this has nothing to do with it, its just wording) one letter at a time multiple times we get text; a String. 

- ## Interesting char related stuff

    Turns out, chars are just [ascii](https://en.wikipedia.org/wiki/ASCII) values which, turns out, are basically numbers.

    ```java
    char c = 65;

    System.out.println(c); // <A>
    System.out.println(c + 1); // <65>
    System.out.println((char) (c + 1)); // <B>
    ```

    It's also worth mentioning that all primitive data types have corresponding classes with a bunch of useful methods. For example

    ```java
    char c1 = 65;
    char c2 = 'A'; // You must use single quotes for characters

    System.out.println(Character.isUpperCase(c1)); // <true>
    ```

    The String class also has a bunch of useful methods like ``length()`` and ``charAt(i)`` but you should really just look into the method summary of the official [documentation](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html)

## Static Stuff

Static methods technically dont work on objects which is why you can't use ``this`` in them. You also have access to only the static attributes, not the non-static ones.

Let's add a static method to our Point class

```java
public class Point {

    ...

    public static String myMethod() {
        return "Static Method";
    }
}

Point.myMethod(); // A static method is called through the class

Point p = new Point(1,2);
p.getX(); // A non-static method is called though the object
```

If a class has a common attribute then all objects instantiated from it will too. In case one of these objects changes the value of that static attribute, the change will be reflected on all objects. This is why static can be very powerful in some scenarios.

I will re-implement ``equals`` in a static context here

```java
public class Point {

    ...

    public static boolean equals(Object o1, Object o2) {
        if (!(o1 instanceof Point) || !(o2 instanceof Point))
            return false;

        Point p1 = (Point) o1;
        Point p2 = (Point) o2;

        return (p1.x == p2.x) && (p1.y == p2.y);
    }
}

// Usage
Point p1 = new Point(1,2);
Point p2 = new Point(1,2);
System.out.println(Point.equals(p1, p2)); // <true>

```

This is fairly impractical but it hopefully makes the difference between static and non-static more clear.

## Pass by Reference

Remember this? 

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

Lets change it so it works with Points. Since we made our attributes private we want to create ``setters``. 

```java
public class Point {

    ...

    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
```

Setters are used to edit private attributes. I also made a ``toString`` method to display our values (printing an object gives ur its memory location instead of its state)

```java
public static void main(String[] args) {
    Point p = new Point(1,2);

    System.out.println(p.toString()); // <x: 1.0, y: 2.0>
    swap(p);
    System.out.println(p.toString()); // <x: 2.0, y: 1.0>
}

public static void swap(Point p) {
    double temp = p.getX();
    p.setX(p.getY());
    p.setY(temp);
}
```

The reason why this works is because java passes the memory location of the object, not its values (pass by reference)

## Exercises

Exercise blueprints can be found [here](/OOP/Exercises/Blueprints/Lecture4.java).\
Exercise solutions can be found [here](/OOP/Exercises/Solutions/Lecture4.java).