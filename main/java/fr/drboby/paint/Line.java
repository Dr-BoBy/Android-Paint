package fr.drboby.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

public class Line {

    private Point p1;
    private Point p2;
    public int color;

    public Line(){
    }

    public void addP1(Point point){
        p1=point;
    }

    public void addP2(Point point){
        p2=point;
    }

    public void drawLine(Paint pinceau, Canvas toile){
        pinceau.setColor(color);
        toile.drawLine(p1.x,p1.y,p2.x,p2.y,pinceau);
    }
}
