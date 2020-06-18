## Contents
[Arrays](#Arrays)\
[Understanding main again](#Understanding-main-again)\
[Exercises](#Exercises)

## Arrays

```java
// Declaration
int [] arr;

// Memory allocation
new int[4]

// Binding
int[] arr = new int[4];

// Retrieving a cell
arr[number]
```

Arrays in Java have a fixed length (static) and when declared will be filled with the default value for the specified type (for int thats 0, boolean false etc). How can you fill the array with the values you want though?

```java
int[] arr1 = new int[3];
arr1[0] = 1;
arr1[1] = 2;
arr1[2] = 3;

int[] arr2 = { 1, 2, 3 };

int[] arr3 = new int[3];
for (int i = 0; i < arr3.length; i++) // Notice how its array.length not .length()
    arr3[i] = i;

// All arrays have the same values
```

## Understanding main again

```java
public static void main(String[] args)
```

- ``public``: Accessible from anywhere within the program
- ``static``: Works at class level, not object level
- ``void``: No return value
- ``main``: Entry point of the program
- ``String[] args``: An array of Strings. This can be entered when the program starts (console parameters)

## Exercises

Exercise blueprints can be found [here](/OOP/Exercises/Blueprints/Lecture5.java).\
Exercise solutions can be found [here](/OOP/Exercises/Solutions/Lecture5.java).
