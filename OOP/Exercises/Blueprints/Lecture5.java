package Blueprints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PointList {
    private final LinkedList<Point> points;

    public PointList(LinkedList<Point> points) {
        this.points = new LinkedList<>();
    }

    /*
    Adds a point to the list
     */
    public void add(Point p) {

    }

    /*
    Returns the list size
     */
    public int size() {
        return 0;
    }

    /*
    Returns the point that has the longest distance from 0 (if there are 2 points return the first one)
     */
    public Point furthestDistanceFromZero() {
        return null;
    }

    /*
    Returns a list of Points whose x coordinates are even numbers
     */
    public LinkedList<Point> getEvenX() {
        return null;
    }

    /*
    Return the first point whose x coordinate matches the argument
     */
    public Point findFirstByX(double x) {
        return null;
    }

    /*
    Returns points
     */
    public LinkedList<Point> getPoints() {
        return null;
    }

    /*
    Removes the last point from the list
    */
    public void remove() {

    }
}

class PointListTests {
    private Point p3;
    private PointList pl;

    @BeforeEach
    public void init() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 4);
        p3 = new Point(3, 6);

        pl = new PointList(new LinkedList<>());
        pl.add(p1);
        pl.add(p2);
    }

    @Test
    public void sizeTest() {
        assertEquals(2, pl.size());
        pl.add(p3);
        assertEquals(3, pl.size());
        pl.remove();
        assertEquals(2, pl.size());
    }

    @Test
    public void furthestDistanceFromZeroTest() {
        Point tmp = pl.furthestDistanceFromZero();

        assertEquals(2, tmp.getX());
        assertEquals(4, tmp.getY());

        pl.add(p3);

        tmp = pl.furthestDistanceFromZero();

        assertEquals(3, tmp.getX());
        assertEquals(6, tmp.getY());

        while (!pl.getPoints().isEmpty())
            pl.remove();

        assertNull(pl.furthestDistanceFromZero());
    }

    @Test
    public void getEvenXTest() {
        LinkedList<Point> evenPoints = pl.getEvenX();

        for (Point p : evenPoints)
            assertEquals(0, p.getX() % 2);

        while (!pl.getPoints().isEmpty())
            pl.remove();

        assertNull(pl.getEvenX());
    }

    @Test
    public void findFirstByXTest() {
        Point tmp = pl.findFirstByX(3.0);

        assertNull(tmp);

        pl.add(p3);
        tmp = pl.findFirstByX(3.0);

        assertEquals(p3, tmp);

        pl.add(new Point(3.0, 6.5));
        tmp = pl.findFirstByX(3.0);

        assertEquals(p3, tmp);

        while (!pl.getPoints().isEmpty())
            pl.remove();

        assertNull(pl.findFirstByX(3.0));
    }
}