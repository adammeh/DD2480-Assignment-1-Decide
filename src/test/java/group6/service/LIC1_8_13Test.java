package group6.service;

import group6.model.LIC;
import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC1_8_13Test{

    @Test
    public void testCorrectDistance(){
        LIC lic = new LIC(); 
        
        assertEquals(0.0, lic.distance(0.0, 0.0, 0.0, 0.0));
        assertEquals(5.0, lic.distance(3.0, 4.0, 0.0, 0.0));
        assertEquals(5.0, lic.distance(-3.0, -4.0, 0.0, 0.0));
  
    }  

    @Test
    public void testLIC1True(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        Parameters parameters2 = new Parameters();
        List<Point> points1 = Arrays.asList(
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        ); 
        List<Point> points2 = Arrays.asList(
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 3),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)

        );
        parameters.setRadius1(1);
        parameters2.setRadius1(2);
        
        //Assert
        assertTrue(licService.evaluateLICById(1, points1, parameters));
        assertTrue(licService.evaluateLICById(1, points2, parameters));


    }


    @Test
    public void testLIC1False(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points1 = Arrays.asList(
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        ); 
        List<Point> points2 = Arrays.asList(
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 3),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)

        );
        parameters.setRadius1(0.5);
        
        //Assert
        assertFalse(licService.evaluateLICById(1, points1, parameters));
        assertFalse(licService.evaluateLICById(1, points2, parameters));

    }


    @Test
    public void testLIC8True(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(0, 2),
            new Point(2, 0),
            new Point(3, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(-2, -1)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(2);
 
        
        //Assert
        assertTrue(licService.evaluateLICById(8, points, parameters));

    }


    @Test
    public void testLIC8False(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(0, 4),
            new Point(0, 0),
            new Point(-5, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(3, 3)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertFalse(licService.evaluateLICById(8, points, parameters));
    }


    @Test
    public void notEnoughPointsLIC8(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(3, 0),
            new Point(-2, -1)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(1);
        
        //Assert
        assertFalse(licService.evaluateLICById(8, points, parameters));

    }

    @Test
    public void testLIC13True(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1),
            new Point(0.5, 0.5),
            new Point(Double.NaN, Double.NaN),
            new Point(0.2, -1),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-1, 0)

        );
        parameters.setRadius1(3);
        parameters.setRadius2(1);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertTrue(licService.evaluateLICById(13, points, parameters));

    }


    @Test
    public void testLIC13FalseOneRadius(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1),
            new Point(0.5, 0.5),
            new Point(Double.NaN, Double.NaN),
            new Point(0.2, -1),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-1, 0)

        );
        parameters.setRadius1(0.5);
        parameters.setRadius2(1);
        parameters.setAPts(1);
        parameters.setBPts(2);
        //Assert
        assertFalse(licService.evaluateLICById(13, points, parameters));

    }

    @Test
    public void testLIC13FalseNoRadius(){

        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1),
            new Point(0.5, 0.5),
            new Point(Double.NaN, Double.NaN),
            new Point(0.2, -1),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, 0)

        );
        parameters.setRadius1(0.5);
        parameters.setRadius2(1);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertFalse(licService.evaluateLICById(13, points, parameters));


    }


}
