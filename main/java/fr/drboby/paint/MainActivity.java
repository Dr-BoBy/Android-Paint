package fr.drboby.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static Ecouteur ecouteur;
    private static Dessin dessin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout scene = findViewById(R.id.scene);
        if(dessin==null){
            dessin = new Dessin(this);
        }
        if(ecouteur==null){
            ecouteur = new Ecouteur(dessin);
        }
        dessin.setOnTouchListener(ecouteur);
        scene.addView(dessin);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FrameLayout scene = findViewById(R.id.scene);
        scene.removeView(dessin);
    }

    public void chooseColor(View vue){
        FrameLayout scene = findViewById(R.id.scene);
        scene.removeView(dessin);
        Intent message = new Intent(this,ColorChoose.class);
        startActivity(message);
    }

    public void delete(View vue){
        dessin.curves = new ArrayList<Curve>();
        dessin.lines = new ArrayList<Line>();
        dessin.rects = new ArrayList<Rectangle>();
        dessin.invalidate();
    }

    public void modeCurve(View vue){ ecouteur.mode=0; }
    public void modeLine(View vue){
        ecouteur.mode=1;
    }
    public void modeRect(View vue){
        ecouteur.mode=2;
    }
}