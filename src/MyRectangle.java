// CS 401 Lab 5
// Fill in the indicated code sections to complete this class.  Then test it
// by compiling and executing Lab5.java.

public class MyRectangle
{
    // Declare instance variables here.  See toString() method below for names.
    private int width;
    private int height;
    private int startX;
    private int startY;

    public MyRectangle()
    {
        // Default constructor -- initialize all instance variables
        // to 0
        width = 0;
        height = 0;
        startX = 0;
        startY =0;
    }

    public MyRectangle(int x, int y, int w, int h)
    {
        // Initialize instance variables based on parameters shown.
        // Be careful to get the order correct!
        width = w;
        height = h;
        startX = x;
        startY = y;
    }

    public int area()
    {
        // Return the area of this Rectangle
        int area;
        area = (width * height);
        return area;
    }

    // I have written this method for you.  Note how a StringBuilder is
    // utilized, since (as we discussed in lecture) it can be modified
    // without having to create a new object each time (unlike a String).
    public String toString()
    {
        StringBuilder S = new StringBuilder();
        S.append("Width: " + width);
        S.append(" Height: " + height);
        S.append(" X: " + startX);
        S.append(" Y: " + startY);
        return S.toString();
    }

    public boolean isInside(int x, int y)
    {
        // This is the trickiest of the methods to write.  This should
        // return true if point (x,y) is anywhere within the borders of the
        // current MyRectangle (including the borders themselves).  Use a
        // pencil and paper to figure out how this can be determined with
        // just a few simple relational operations.
        boolean result = false; //fixme
        if((x > startX && x <= width+startX) && (y >= startY && y <= height+startY))
            result = true;
        return result;
    }

    public void setSize(int w, int h)
    {
        // Update width and height as shown
        width = w;
        height = h;
    }

    public void setPosition(int x, int y)
    {
        // Update startX and startY as shown
        startX = x;
        startY = y;
    }

}