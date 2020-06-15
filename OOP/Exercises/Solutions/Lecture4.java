package Solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

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
 */
class Counter {
    private static int count;

    public Counter() {}

    public void add() {
        count++;
    }

    public void add(int x) {
        if (x > 0)
            count += x;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return "Counter: " + count;
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
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int xd, int yd) {
        x = x + xd;
        y = y + yd;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Point))
            return false;

        Point point = (Point) o;

        return x == point.x && y == point.y;
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
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "2, 4", "-1, 4", "0, 4"})
    public void addTest1(int i, int j) {
        System.out.println(c1.toString());
        c1.add(i);
        System.out.println(c1.toString());

        assertEquals(j, c1.getCount());
    }

    @Test
    public void toStringTest() {
        assertEquals("Counter: 4", c1.toString());
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
        String res = "x: " + 1 + ", y: " + 2;
        assertEquals(res, p.toString());
    }

    @Test
    public void equalsTest() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 2);
        Point p3 = p;

        assertEquals(p, p1);
        assertNotEquals(p, p2);
        assertEquals(p, p3);
    }
}