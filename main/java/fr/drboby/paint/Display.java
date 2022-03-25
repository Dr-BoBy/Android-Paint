package fr.drboby.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

public class Display extends FrameLayout {

    public static int color;

    public Display(@NonNull Context context) {
        super(context);
        color=0xFF000000;
        setBackgroundColor(color);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    protected void onDraw(Canvas toile) {
        super.onDraw(toile);
    }
}
