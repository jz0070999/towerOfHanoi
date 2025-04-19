package edu.georgiasouthern.finalprojecttowerofhanoi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

// My custom view where we override the onDraw method to draw the three rods and animate disk
// movements

public class HanoiGameDrawing extends View {

    // create an array for the x coordinates
    private float[] rodsXCoordinates = new float[3];

    // Y coordinates to define the height of the rods
    private float topYCoordinate;
    private float bottomYCoordinate;

    // set the thickness of the rod
    private float rodThickness = 8f;

    // remember that we get user input for the number of discs
    // via the EditText so we need to store the number of discs in the
    // HanoiGameDrawing
    private int numOfDiscs = 0;
    private int[] discLocation;
    private float discHeight = 20f;



    public HanoiGameDrawing(Context context) {
        super(context);
    }

    public HanoiGameDrawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HanoiGameDrawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HanoiGameDrawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        // helper method with a more easily understood name
        updateRodPositions(w, h);
    }

    private void updateRodPositions(int width, int height){
        rodsXCoordinates[0] = width * 0.25f;
        rodsXCoordinates[1] = width * 0.50f;
        rodsXCoordinates[2] = width * 0.75f;

        // set the vertical boundaries for the rods
        topYCoordinate = 200;
        bottomYCoordinate = height - 300;
    }

    // called from the main activity class to update
    // with the user input how many discs to draw
    public void setNumberOfDiscs(int n){
        this.numOfDiscs = n;
        // initialize the array and place all on the starting rod
        discLocation = new int[n];
        for(int i = 0; i < n; i++){
            discLocation[i] = 0; // 0 means the first rod
        }

        // remember that the purpose of invalidate is to
        // indicate that a view's visual appearance has
        // changed and needs to be redrawn
        // it triggers the onDraw() method
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        // create a paint color for the three rods
        Paint rodColor = new Paint();
        rodColor.setColor(Color.BLACK);
        rodColor.setStrokeWidth(rodThickness);

        // drawing the three rods as vertical
        for(int i = 0; i < rodsXCoordinates.length; i++){
            canvas.drawLine(rodsXCoordinates[i], bottomYCoordinate, rodsXCoordinates[i], topYCoordinate, rodColor);
        }

        // now we need to draw the discs
        if(numOfDiscs > 0 && discLocation != null){
            int[] rodDiscCount = new int[3];

            // the largest disc is index = numOfDisc - 1
            for(int discIndex = numOfDiscs - 1; discIndex >= 0; discIndex--){
                int rodIndex = discLocation[discIndex];

                // the bigger the disc index == the bigger the disc
                float discWidth = 60 + discIndex * 20;

                // y position is the bottom of the rod
                // minus how many discs are on that rod * discHeight
                float discBottomY = bottomYCoordinate - (rodDiscCount[rodIndex] * discHeight);
                rodDiscCount[rodIndex]++;

                // define the top and bottom
                float discTopY = discBottomY - discHeight;
                float centerX = rodsXCoordinates[rodIndex];
                float leftX = centerX - discWidth/2;
                float rightX = centerX + discWidth/2;

                // pick a color for each disc
                Paint discColor = new Paint();
                discColor.setColor(Color.rgb(50 + discIndex*25, 100, 200));

                // draw the outline
                canvas.drawRect(leftX, discTopY, rightX, discBottomY, discColor);
            }
        }


        

    }
}
