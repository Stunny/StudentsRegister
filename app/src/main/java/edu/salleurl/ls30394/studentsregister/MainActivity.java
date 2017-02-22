package edu.salleurl.ls30394.studentsregister;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setTransitionName(findViewById(R.id.appBarLayout), "Transition");

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        ctl.setTitle("Students Register");
        ctl.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }


    public void onToggleAndroidDeviceCheckbox(View view){
        Log.d("ANDROID DEVICE", "Toggle Checkbox");

        CheckBox cb = (CheckBox) view;

        if(cb.isChecked()){
            Log.d("CHECKBOX", "Checked");
        }
    }

}
