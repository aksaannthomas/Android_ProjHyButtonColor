package calcu.exmp.projhybuttoncolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View mColorRegion;
    Button colorButton;
    private int[] mColorChoices =
            { Color.BLACK, Color.BLUE, Color.CYAN,
                    Color.DKGRAY, Color.GRAY, Color.GREEN,
                    Color.LTGRAY, Color.MAGENTA, Color.RED,
                    Color.WHITE, Color.YELLOW };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorRegion = findViewById(R.id.color_region);
       colorButton =
                (Button)findViewById(R.id.color_button);
        colorButton.setOnClickListener(new ColorRandomizer());
    }

    private void setRegionColor(int color) {
        mColorRegion.setBackgroundColor(color);
        colorButton.setBackgroundColor(color);
    }
    private class ColorRandomizer implements View.OnClickListener {

        /** Calls back to the outer class to set the color of View at
         the bottom. */
        public void onClick(View clickedButton) {
            Random generator = new Random();
            int index = generator.nextInt(mColorChoices.length);
            setRegionColor(mColorChoices[index]);
        }
    }
}