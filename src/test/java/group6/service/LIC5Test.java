package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC5Test {

    @Test
    public void CMV5True(){
        //Act 
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(4, 0),
                new Point(2, 0)
        );
        
        double[] X= {0,4,2}; 
        //Assert
        assertTrue(licService.evaluateLICById(5, points, parameters));
    }

    @Test 
    public void CMV5False(){
        //Act 
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
                new Point(-2, 0),
                new Point(4, 0),
                new Point(5, 0)
        );

        //Assert
        assertFalse(licService.evaluateLICById(5, points, parameters));
    }
}
