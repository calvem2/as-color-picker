package cse340.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

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
    }

    /**
     * Draw the ColorPicker on the Canvas
     * @param canvas the canvas that is drawn upon
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    /* ********************************************************************************************** *
     *                               <Helper Functions />
     *           TODO add helper functions as needed (i.e. use good coding practice)
     * ********************************************************************************************** */

}
