package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC14Test {
    @Test
    public void cmv14Test1() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(2.0, 0.0),
            new Point(2.0, 0.0),
            new Point(0.0, 3.0),
            new Point(0.0, 3.0),
            new Point(1.0, 0.0),
            new Point(1.0, 0.0),
            new Point(5.0, 1.0),
            new Point(5.0, 1.0),
            new Point(5.0, 1.0),
            new Point(4.0, 4.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(6.0);
        parameters.setArea2(4.0);
        parameters.setEPts(2);
        parameters.setFPts(1);

        assertTrue(licService.evaluateLICById(14, points, parameters));
    }

    @Test
    public void cmv14Test2() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(1.0, 1.0),
            new Point(1.0, 0.0),
            new Point(0.1, 1.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(0.0);
        parameters.setArea2(100.0);
        parameters.setEPts(0);
        parameters.setFPts(0);

        assertFalse(licService.evaluateLICById(14, points, parameters));
    }

    @Test
    public void cmv14Test3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(1.0, 1.0),
            new Point(1.0, 0.0),
            new Point(0.1, 1.0),
            new Point(10.0,10.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(0.0);
        parameters.setArea2(-1.0);
        parameters.setEPts(1);
        parameters.setFPts(1);

        assertFalse(licService.evaluateLICById(14, points, parameters));
    }

    @Test
    public void cmv14Test4() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(100.0, 100.0),
            new Point(-10.0, -10.0),
            new Point(-10.0, -10.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(6.0);
        parameters.setArea2(1.0);
        parameters.setEPts(1);
        parameters.setFPts(1);

        assertFalse(licService.evaluateLICById(14, points, parameters));
    }
}
