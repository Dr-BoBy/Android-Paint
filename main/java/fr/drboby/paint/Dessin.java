package fr.drboby.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import java.math.BigInteger;
import java.util.ArrayList;

public class Dessin extends FrameLayout {


    public Curve curveTempo;
    public ArrayList<Curve> curves;
    public Line lineTempo;
    public ArrayList<Line> lines;
    public Rectangle rectTempo;
    public ArrayList<Rectangle> rects;
    public static Paint pinceau;
    public static int COLOR = 0xFF000000;

    public Dessin(@NonNull Context context) {
        super(context);
        setBackgroundColor(0xFFEEEEEE);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        pinceau = new Paint();
        curves = new ArrayList<Curve>();
        lines = new ArrayList<Line>();
        rects = new ArrayList<Rectangle>();
    }

    public static void setPinceauColor(int color) {
        pinceau.setColor(color);
        pinceau.setStyle(Paint.Style.FILL);
    }

    protected void onDraw(Canvas toile) {
        super.onDraw(toile);
        // Tracé du dessin
        pinceau.setStrokeWidth(4);

        //DRAW FINAL
        for(Curve curve : curves){
            curve.drawCurve(pinceau,toile);
        }
        for(Line line : lines){
            line.drawLine(pinceau,toile);
        }
        for(Rectangle rect : rects){
            rect.drawRect(pinceau,toile);
        }
        //DRAW TEMPO
        if(curveTempo!=null){
            curveTempo.drawCurve(pinceau,toile);
        }
        if(lineTempo!=null){
            lineTempo.drawLine(pinceau,toile);
        }
        if(rectTempo!=null){
            rectTempo.drawRect(pinceau,toile);
        }
    }
}
