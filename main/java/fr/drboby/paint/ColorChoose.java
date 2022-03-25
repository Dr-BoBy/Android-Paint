package fr.drboby.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;

public class ColorChoose extends AppCompatActivity {

    private static Display display;
    private SeekBar redsb;
    private SeekBar greensb;
    private SeekBar bluesb;

    private static int redValue= 0;
    private static int greenValue=0;
    private static int blueValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_choose);
        FrameLayout scene = findViewById(R.id.scene);
        if(display==null){
            display = new Display(this);
        }
        scene.addView(display);
        SeekBar redsb = findViewById(R.id.redbar);
        redsb.setProgress(redValue);
        SeekBar greensb = findViewById(R.id.greenbar);
        greensb.setProgress(greenValue);
        SeekBar bluesb = findViewById(R.id.bluebar);
        bluesb.setProgress(blueValue);
        redsb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                redValue=progressValue;
                display.setBackgroundColor(android.graphics.Color.argb(255,redValue,greenValue,blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        greensb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                greenValue=progressValue;
                display.setBackgroundColor(android.graphics.Color.argb(255,redValue,greenValue,blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bluesb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                blueValue=progressValue;
                display.setBackgroundColor(android.graphics.Color.argb(255,redValue,greenValue,blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FrameLayout scene = findViewById(R.id.scene);
        scene.removeView(display);
    }


    public void valider(View vue){
        FrameLayout scene = findViewById(R.id.scene);
        scene.removeView(display);
        Intent message = new Intent(this,MainActivity.class);
        Dessin.COLOR=android.graphics.Color.argb(255,redValue,greenValue,blueValue);
        startActivity(message);
    }
}