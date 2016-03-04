package net.fktan5.hoge001;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static String KEY = "key";

    @OnClick(R.id.button) void nextActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button2) void thirdActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fab1) void onClickFab(){
        Snackbar.make(findViewById(R.id.relativeLayout), R.string.text1, Snackbar.LENGTH_LONG)
                .show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //SharedPreferenceの実験
        float value = 1455500647.680438f;
        double value2 = 1455500647.680438;
        Log.d(KEY, "value : " + value);
        Log.d(KEY, "value2 : " + value2);

        SharedPreferences sharedPreferences = getSharedPreferences("DemoApp", MODE_PRIVATE);
        sharedPreferences.edit().putFloat(KEY, value).apply();
    }
}
