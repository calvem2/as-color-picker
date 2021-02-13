package cse340.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.ColorInt;

/**
 * TODO: Implement your ColorPickerView. You will be expected to use appropriate helper methods and add comments
 */
public class MyColorPickerView extends ColorPickerView {

    /**
     * Update the local model (color) for this colorpicker view
     *
     * @param x The x location that the user selected
     * @param y The y location that the user selected
     */
    protected void updateModel(float x, float y) {
        // TODO implement this
        setColor(getColorFromTouch(x));
    }

    /* ********************************************************************************************** *
     *                               <End of model declarations />
     * ********************************************************************************************** */

    /* ********************************************************************************************** *
     * TODO Create variables you might need
     * You may create any constants you wish here.                                                     *
     * You may also create any fields you want, that are not necessary for the state but allow         *
     * for better optimized or cleaner code                                                             *
     * ********************************************************************************************** */
    private final Paint paint;
    /** The colors for the picker */
    private final int[] colorChoices;

    /* ********************************************************************************************** *
     *                               <End of other fields and constants declarations />
     * ********************************************************************************************** */

    /**
     *
     * Constructor of the ColorPicker View
     * @param context The Context the view is running in, through which it can access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view. This value may be null.
     */
    public MyColorPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mState = State.START;
        paint = new Paint();
        colorChoices = getResources().getIntArray(R.array.rainbow);
    }

    /**
     * Draw the ColorPicker on the Canvas
     * @param canvas the canvas that is drawn upon
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mState = State.START;
        paint.setStrokeWidth(getHeight());
        int colorWidth = getWidth() / colorChoices.length;
        for (int i = 0; i < colorChoices.length; i++) {
            paint.setColor(colorChoices[i]);
            canvas.drawLine(i * colorWidth, getHeight() / 2f, i * colorWidth + colorWidth,getHeight() / 2f, paint);
        }
    }

    /**
     * Calculate the essential geometry given an event.
     *
     * @param event Motion event to compute geometry for, most likely a touch.
     * @return EssentialGeometry value.
     */
    @Override
    protected EssentialGeometry essentialGeometry(MotionEvent event) {
        return event.getX() <= getX() + getWidth() && event.getY() <= getY() + getHeight() ? EssentialGeometry.INSIDE : EssentialGeometry.OUTSIDE;
    }

    /* ********************************************************************************************** *
     *                               <Helper Functions />
     *           TODO add helper functions as needed (i.e. use good coding practice)
     * ********************************************************************************************** */
    /**
     * Converts from an angle to a color on the wheel.
     *
     * @param angle position on the wheel in radians
     * @return color at this position of this color on the wheel.
     */
    /***
     * Calculate the color of the selection on color picker given a touch.
     *
     * @param touchX Horizontal position of the touch event.
     * @return color at this position on the picker.
     */
    protected @ColorInt int getColorFromTouch(float touchX) {
        System.out.println(touchX);
        return colorChoices[(int) (touchX) / (getWidth() / colorChoices.length)];
    }

}
