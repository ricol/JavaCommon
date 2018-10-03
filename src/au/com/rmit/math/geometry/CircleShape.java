/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.math.geometry;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author ricolwang
 */
public class CircleShape extends ClosureShape
{

    public Point centre = new Point(0, 0);
    public double radius;

    public CircleShape(double centreX, double centreY, double radius)
    {
        this.centre.x = centreX;
        this.centre.y = centreY;
        this.radius = radius;
    }

    @Override
    public boolean intersect(ClosureShape theTarget)
    {
        return false;
    }

    @Override
    public boolean contain(ClosureShape theTarget)
    {
        return false;
    }

    @Override
    public double getCircumference()
    {
        return Math.PI * this.radius * 2;
    }

    @Override
    public double getArea()
    {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public boolean collideWith(ClosureShape theShape)
    {
        if (theShape instanceof CircleShape)
        {
            return Shape.CircleCollideWithCircle(this, (CircleShape) theShape);
        } else if (theShape instanceof SpecialRectangleShape)
        {
            return Shape.CircleCollideWithRectangle(this, (SpecialRectangleShape) theShape);
        } else
        {
            return false;
        }
    }

    @Override
    public void draw(Graphics2D theGraphicsInTheScene, Color theColor)
    {
        int tmpRadius = (int) radius;
        int tmpX = (int) (centre.x - tmpRadius);
        int tmpY = (int) (centre.y - tmpRadius);
        theGraphicsInTheScene.setColor(theColor);
        theGraphicsInTheScene.drawArc(tmpX, tmpY, 2 * tmpRadius, 2 * tmpRadius, 0, 360);
    }

    @Override
    public void print(String text)
    {
        System.out.println(text + " - CircleShape: Radius: " + radius + " at centre: " + centre.x + " : " + centre.y);
    }

    @Override
    public String toString()
    {
        return "CircleShape: Radius: " + radius + " at centre: " + centre.x + " : " + centre.y;
    }
}
