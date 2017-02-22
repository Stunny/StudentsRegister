package edu.salleurl.ls30394.studentsregister;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tietNameInput;
    private TextInputEditText tietEmailInput;
    private TextInputEditText tietPasswdInput;
    private TextInputEditText tietPsswdConfirm;

    private CheckBox cbLaptop;
    private CheckBox cbAndPhone;

    private Spinner spAndVersion;

    private RadioGroup rgAgeGroupSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        ViewCompat.setTransitionName(findViewById(R.id.appBarLayout), "Transition");

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        ctl.setTitle("Students Register");
        ctl.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    private void initWidgets(){

        tietNameInput    = (TextInputEditText) findViewById(R.id.nameInput);
        tietEmailInput   = (TextInputEditText) findViewById(R.id.emailInput);
        tietPasswdInput  = (TextInputEditText) findViewById(R.id.passwordInput);
        tietPsswdConfirm = (TextInputEditText) findViewById(R.id.confirmPasswordInput);

        cbLaptop         = (CheckBox) findViewById(R.id.check_laptop);
        cbAndPhone       = (CheckBox) findViewById(R.id.check_andphone);

        spAndVersion     = (Spinner) findViewById(R.id.andphoneVersionSpinner);

        rgAgeGroupSelect = (RadioGroup) findViewById(R.id.ageForm_select);
    }

    public void onToggleAndroidDeviceCheckbox(View view){

        CheckBox cb = (CheckBox) view;

        if(cb.isChecked()) {
            spAndVersion.setVisibility(View.VISIBLE);
        }else{
            spAndVersion.setVisibility(View.GONE);
        }
    }


    public void onRegisterClicked(View view){

        if(userDataOK()){
            saveUser();
        }

    }

    public boolean userDataOK(){

        boolean allOK = true;



        return allOK;
    }

    public void saveUser(){

    }

}
