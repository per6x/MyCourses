package Blueprints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.w3c.dom.ls.LSOutput;

import java.util.Collection;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
Create a class counter that allows all instances of the class to interact with the counter number

Methods:
    Counter(): Creates a Counter object with count = 0
    add()/add(x: int): void
        Increments the counter by 1 or by x. The counter can only go up
    getCount(): int
        Returns the current count
    toString(): String
        Returns "Counter: ${number}"
    reset(): void
        Resets the count to zero
 */
class Counter {
    private static int count;

    public Counter() {}

    public void add() {

    }

    public void add(int x) {

    }

    public int getCount() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public void reset() {

    }
}

/*
Create a new Point class. Takes 2 doubles as parameters.

Methods:
    Point(double, double): Creates a new instance of Point with x, y coordinates
    getX(): double
        Returns x
    getY(): double
        Returns y
    translate(xd: double, yd: double): void
        Increments x by xd and y by yd
    distance(p2: Point): double
        Returns the distance between this point and p2
    toString(): String
        Returns a string representation of Point ("x: $x, y: $y")
    equals(p2: Object): boolean
        Returns true iff p2 is a point and has the same coordinates with this
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return 0;
    }

    public double getY() {
        return 0;
    }

    public void translate(int xd, int yd) {

    }

    public double distance(Point p) {
        return 0.0;
    }

    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}


class CounterTests {
    private Counter c1;

    @BeforeEach
    public void init() {
        c1 = new Counter();
    }

    @Test
    public void addTest0() {
        c1.add();

        assertEquals(1, c1.getCount());

        c1.reset();
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "-1, 0", "0, 0"})
    public void addTest1(int i, int j) {
        c1.add(i);

        assertEquals(j, c1.getCount());

        c1.reset();
    }

    @Test
    public void toStringTest() {
        assertEquals("Counter: 0", c1.toString());
    }

    @Test
    public void resetTest() {
        c1.add();
        assertEquals(1, c1.getCount());
        c1.reset();
        assertEquals(0, c1.getCount());
    }
}

class PointTests {
    private Point p;

    @BeforeEach
    public void init() {
        p = new Point(1, 2);
    }

    @Test
    public void gettersTest() {
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void translateTest() {
        p.translate(1, 2);

        assertEquals(2, p.getX());
        assertEquals(4, p.getY());

        p.translate(-1, -2);

        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void distanceTest() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 2);

        assertEquals(0, p.distance(p1));
        assertEquals(1, p.distance(p2));
    }

    @Test
    public void toStringTest() {
        String res = "x: 1.0, y: 2.0";
        assertEquals(res, p.toString());
    }

    @Test
    public void equalsTest() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        Point p3 = p;
        Point p4 = new Point(2, 2);



        assertEquals(p, p1);

        assertEquals(p, p3);
        assertNotEquals(p, new Object());

        assertNotEquals(p, p4);
        assertNotEquals(p, p2);
    }
}