package fr.drboby.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

public class Curve {

    private ArrayList<Point> points;
    public int color;

    public Curve(){
        points = new ArrayList<Point>();
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public void drawCurve(Paint pinceau, Canvas toile){
        pinceau.setColor(color);
        for(int i=0; i<(points.toArray().length-1); i++){
            toile.drawLine(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y,pinceau);
        }
    }
}
