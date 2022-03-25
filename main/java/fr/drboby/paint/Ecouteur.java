package fr.drboby.paint;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class Ecouteur implements View.OnTouchListener{

    public Curve curve;
    public Line line;
    public Rectangle rect;
    private Dessin dessin;
    public int mode;

    public Ecouteur(Dessin dessin){
        this.dessin=dessin;
        this.mode=0;
    }
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(event.getAction()==0){
            if(mode==0){
                curve=new Curve();
                curve.color=Dessin.COLOR;
                curve.addPoint(new Point((int)event.getX(),(int)event.getY()));
            }
            else if(mode==1){
                line=new Line();
                line.color=Dessin.COLOR;
                line.addP1(new Point((int)event.getX(),(int)event.getY()));
            }
            else if(mode==2){
                rect=new Rectangle();
                rect.color=Dessin.COLOR;
                rect.addP1(new Point((int)event.getX(),(int)event.getY()));
            }
        }
        if(event.getAction()==2){
            if(mode==0){
                curve.addPoint(new Point((int)event.getX(),(int)event.getY()));
                dessin.curveTempo=curve;
            }
            else if(mode==1){
                line.addP2(new Point((int)event.getX(),(int)event.getY()));
                dessin.lineTempo=line;
            }
            else if(mode==2){
                rect.addP2(new Point((int)event.getX(),(int)event.getY()));
                dessin.rectTempo=rect;
            }
        }
        if(event.getAction()==1){
            if(mode==0){
                dessin.curves.add(curve);
                dessin.curveTempo=null;
            }
            else if(mode==1){
                line.addP2(new Point((int)event.getX(),(int)event.getY()));
                dessin.lines.add(line);
                dessin.lineTempo=null;
            }
            else if(mode==2){
                rect.addP2(new Point((int)event.getX(),(int)event.getY()));
                dessin.rects.add(rect);
                dessin.rectTempo=null;
            }
        }
        dessin.invalidate();
        return true;
    }
}
