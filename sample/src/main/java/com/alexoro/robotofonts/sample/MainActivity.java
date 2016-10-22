package com.alexoro.robotofonts.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.alexoro.robotofonts.RobotoTypeface;

/**
 * Created by uas.sorokin@gmail.com
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv1 = (TextView) findViewById(R.id.text1);
        TextView tv2 = (TextView) findViewById(R.id.text2);
        TextView tv3 = (TextView) findViewById(R.id.text3);

        tv1.setText(R.string.text);
        tv1.setTypeface(RobotoTypeface.getInstance(this, RobotoTypeface.REGULAR, false));
        tv2.setText(R.string.text);
        tv2.setTypeface(RobotoTypeface.getInstance(this, RobotoTypeface.LIGHT, true));
        tv3.setText(R.string.text);
        tv3.setTypeface(RobotoTypeface.getInstance(this, RobotoTypeface.MEDIUM, false));
    }

}