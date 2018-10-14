/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.math.geometry;

/**
 *
 * @author ricolwang
 */
public class SpecialRectangleShape extends ClosureShape
{

    public double left, top, width, height;

    public SpecialRectangleShape(double left, double top, double width, double height)
    {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean collideWith(ClosureShape theShape)
    {
        if (theShape instanceof CircleShape)
        {
            return Shape.RectangleCollideWithCircle(this, (CircleShape) theShape);
        } else if (theShape instanceof SpecialRectangleShape)
        {
            return Shape.RectangleCollideWithRectangle(this, (SpecialRectangleShape) theShape);
        } else
        {
            return false;
        }
    }

    @Override
    public void print(String text)
    {
        System.out.println(text + " - RectangleShape: " + left + ", " + top + ", " + width + ", " + height);
    }

    @Override
    public String toString()
    {
        return "RectangleShape: " + left + ", " + top + ", " + width + ", " + height;
    }
}
