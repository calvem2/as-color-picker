package cse340.colorpicker;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This subclasses AbstractMainActivity and as such is a AbstractMainActivity. It inherits a field
 * `colorPicker` which contains a pre-instantiated and positioned CircleColorPickerView. Do
 * NOT create your own CircleColorPickerView.
 *
 * We encourage you to read and understand AbstractMainActivity as it is fairly simple.
 *
 * Here you will attach a ColorListener callback and add bundle support.
 */
public class MainActivity extends AbstractMainActivity {

    /** The key used to store our bundle information */
    public static final String COLOR_BUNDLE_KEY = "color";

    /** The view that display the color that was selected by the ColorPicker */
    private View mColorView;

    /** The label that displays the string representation of the color selected by the ColorPicker */
    private TextView mLabelView;

    /**
     * Callback that is called when the activity is first created.
     * @param savedInstanceState contains the activity's previously saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mColorView = findViewById(R.id.colorResult);
        mLabelView = findViewById(R.id.colorTextView);

        findViewById(R.id.root_layout).setOnClickListener((view) -> {
            if (mColorPicker.getVisibility() == View.VISIBLE) {
                Toast.makeText(this, R.string.click_outside,
                        Toast.LENGTH_SHORT).show();
                mColorPicker.setVisibility(View.INVISIBLE);
            }
        });

        // Shows the color picker wheel when the color tile is clicked on
        mColorView.setOnTouchListener((view, e) -> {
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                if (mColorPicker.getVisibility() == View.VISIBLE) {
                    Toast.makeText(this,  R.string.click_outside,
                            Toast.LENGTH_SHORT).show();
                    mColorPicker.setVisibility(View.INVISIBLE);
                    view.performClick();
                    return true;
                } else {
                    mColorPicker.setVisibility(View.VISIBLE);
                    return true;
                }
            }
            return false;
        });

        // TODO: register the color change listener for both of your colorPickers
        AbstractColorPickerView picker = findViewById(R.id.circleColorPicker);
        picker.addColorChangeListener(new AbstractColorPickerView.ColorChangeListener() {
            @Override
            public void onColorSelected(int color) {
                updateColor(color);
            }
        });
        picker = findViewById(R.id.myColorPicker);
        picker.addColorChangeListener(new AbstractColorPickerView.ColorChangeListener() {
            @Override
            public void onColorSelected(int color) {
                updateColor(color);
            }
        });

        setStartingColor(savedInstanceState);
    }

    /**
     * Private helper function to update the view after the color in the model has changed
     *
     * @param color The new color
     */
    private void updateColor(int color) {
        mColorView.setBackgroundColor(color);
        mLabelView.setText(colorToString(color));
        mColorModel.setColor(color);
    }

    /**
     * Sets the starting color of this Activity's ColorPicker.
     *
     * @param state Bundled state to extract previous color from or null for default.
     */
    @Override
    protected void setStartingColor(Bundle state) {
        // TODO: Set ColorPicker color from state.
        // HINT: If state == null, then there was no saved state.
        //       In this case, use AbstractColorPickerView.DEFAULT_COLOR
        int color = state == null ? AbstractColorPickerView.DEFAULT_COLOR : state.getInt(COLOR_BUNDLE_KEY);
        mColorPicker.setColor(color);
        updateColor(color);
    }

    /**
     * Invoked when the activity may be temporarily destroyed, save the instance state here.
     * @param outState State to save out through the bundle
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // TODO: get current color and save to bundle.
        outState.putInt(COLOR_BUNDLE_KEY, mColorModel.getColor());
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // TODO: restore the state of the application from the bundle
        // Hint: look for a method to help you.
        setStartingColor(savedInstanceState);
    }
}
