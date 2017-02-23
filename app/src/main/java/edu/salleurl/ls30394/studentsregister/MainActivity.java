package edu.salleurl.ls30394.studentsregister;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import edu.salleurl.ls30394.studentsregister.Model.Phone;
import edu.salleurl.ls30394.studentsregister.Model.User;
import edu.salleurl.ls30394.studentsregister.Model.UserAndroidPhone;

public class MainActivity extends AppCompatActivity {


    //-------------------------------------FORM WIDGETS-------------------------------------------//
    private TextInputLayout tilNameInput;
    private TextInputLayout tilEmailInput;
    private TextInputLayout tilPasswdInput;
    private TextInputLayout tilPsswdConfirm;

    private TextInputEditText tietNameInput;
    private TextInputEditText tietEmailInput;
    private TextInputEditText tietPasswdInput;
    private TextInputEditText tietPsswdConfirm;

    private CheckBox cbLaptop;
    private CheckBox cbAndPhone;

    private Spinner spAndVersion;

    private RadioGroup rgAgeGroupSelect;

    //------------------------------------INITIALIZATION OF ACTIVITY------------------------------//

    @Override
    /**
     * Creation of the main view oif the app
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWidgets();
        initToolBar();

    }

    /**
     * Initializes every widget attribute that shall be required
     * in order to process user data
     */
    private void getWidgets(){

        tilNameInput     = (TextInputLayout) findViewById(R.id.nameInputWrapper);
        tilEmailInput    = (TextInputLayout) findViewById(R.id.emailInputWrapper);
        tilPasswdInput   = (TextInputLayout) findViewById(R.id.passwordInputWrapper);
        tilPsswdConfirm  = (TextInputLayout) findViewById(R.id.confirmPasswordInputWrapper);

        tietNameInput    = (TextInputEditText) findViewById(R.id.nameInput);
        tietEmailInput   = (TextInputEditText) findViewById(R.id.emailInput);
        tietPasswdInput  = (TextInputEditText) findViewById(R.id.passwordInput);
        tietPsswdConfirm = (TextInputEditText) findViewById(R.id.confirmPasswordInput);

        cbLaptop         = (CheckBox) findViewById(R.id.check_laptop);
        cbAndPhone       = (CheckBox) findViewById(R.id.check_andphone);

        spAndVersion     = (Spinner) findViewById(R.id.andphoneVersionSpinner);

        rgAgeGroupSelect = (RadioGroup) findViewById(R.id.ageForm_select);

    }

    //----------------------------------ALL THE ACTIVITY'S GRAPHIC FUNCTIONALITIES----------------//

    /**
     * Initializes the activvity ToolBar
     */
    private void initToolBar(){
        ViewCompat.setTransitionName(findViewById(R.id.appBarLayout), "Transition");
        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        ctl.setTitle("Students Register");
        ctl.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    /**
     * Either shows or makes disappear the android version Spinner
     * depending on the checkbox's state
     * @param view Android Phone checkbox
     */
    public void onToggleAndroidDeviceCheckbox(View view){

        if(cbAndPhone.isChecked()) {
            spAndVersion.setVisibility(View.VISIBLE);
        }else{
            spAndVersion.setVisibility(View.GONE);
        }
    }

    /**
     * Sets a new error on the user name input
     * @param message Error message to be shown
     */
    private void setUserNameInputError(String message){
        tilNameInput.setErrorEnabled(true);
        tietNameInput.setError(message);
    }

    /**
     * Sets a new error on the user email input
     * @param message Error message to be shown
     */
    private void setUserEmailInputError(String message){

        tilEmailInput.setErrorEnabled(true);
        tietEmailInput.setError(message);

    }

    /**
     * Sets a new error on the user password input
     * @param message Error message to be shown
     */
    private void setUserPasswordInputError(String message){
        tilPasswdInput.setErrorEnabled(true);
        tilPsswdConfirm.setErrorEnabled(true);
        tietPasswdInput.setError(message);
        tietPsswdConfirm.setError(message);
    }


    //------------------------------------USER FORM LOGIC FUNCTIONALITIES-------------------------//
    /**
     *
     * @param view clicked TextInputEditText
     */
    public void onTypeDisableError(View view){

        Log.d("ID", view.getClass().toString()+"--"+view.getId());
        switch(view.getId()){
            case R.id.nameInput:
                tietNameInput.setError(null);
                tilNameInput.setErrorEnabled(false);
                break;
            case R.id.emailInput:
                tietEmailInput.setError(null);
                tilEmailInput.setErrorEnabled(false);
                break;
            case R.id.passwordInput:
                tietPasswdInput.setError(null);
                tilPasswdInput.setErrorEnabled(false);
                break;
            case R.id.confirmPasswordInput:
                tietPsswdConfirm.setError(null);
                tilPsswdConfirm.setErrorEnabled(false);
                break;
            default:
        }

    }

    /**
     * Action to perform when the "Register" button is clicked
     * @param view Clicked button
     */
    public void onRegisterClicked(View view){

        if(userDataOK())
            saveUser();

    }

    /**
     * @return True if the user's data has been correctly introduced
     */
    private boolean userDataOK(){

        boolean allOK = true;

        String
            userName            = tietNameInput.getText().toString(),
            userEmail           = tietEmailInput.getText().toString(),
            userPass            = tietPasswdInput.getText().toString(),
            confirmationPass    = tietPsswdConfirm.getText().toString();

        if(!userNameOK(userName)) allOK = false;
        if(!userEmailOK(userEmail)) allOK = false;
        if(!userPasswordOK(userPass, confirmationPass)) allOK = false;
        if(cbAndPhone.isChecked() && !(andVersionSelected())) allOK = false;

        return allOK;
    }

    /**
     * @param name User name typed in TextInputEditText
     * @return True if the user name is valid
     */
    private boolean userNameOK(String name){

        boolean nameOK = true;

        if(!name.contains(" ") || name.equalsIgnoreCase("")){
            nameOK = false;
            setUserNameInputError(getString(R.string.username_error_msg));
        }

        return nameOK;
    }

    /**
     * @param email User email typed in TextInputEditText
     * @return True if has a valid format
     */
    private boolean userEmailOK(String email){

        boolean emailOK = true;
        int qAts = email.split("@", -1).length -1;

        if(!email.contains("@")
                || (qAts == 0)
                || (qAts > 1)
                ||  email.equalsIgnoreCase(""))
        {
            emailOK = false;
            setUserEmailInputError(getString(R.string.email_input_error_msg));
        }

        return emailOK;
    }

    /**
     * @param password Chosen user password
     * @param passConfirm Confirmation of the chosen password
     * @return True if both password fields match
     */
    private boolean userPasswordOK(String password, String passConfirm){

        boolean passwdOK = true;
        String errorMsg = "";

        if(!password.equals(passConfirm)){
            passwdOK = false;
            errorMsg = getString(R.string.passwds_dont_match);
        }

        else if(password.equals("") || passConfirm.equals("")){
            passwdOK = false;
            errorMsg = getString(R.string.incomplete_psswd_msg);
        }

        if(!passwdOK) setUserPasswordInputError(errorMsg);
        return passwdOK;
    }

    /**
     * @return True if Android version of spinner has been selected
     */
    private boolean andVersionSelected(){

        boolean versionOK = true;

        if(spAndVersion.getSelectedItem().toString()
                .equals(getString(R.string.and_select))) {

            versionOK = false;
            Toast.makeText(this, R.string.ask_and_version_toast, Toast.LENGTH_SHORT).show();
        }

        return versionOK;
    }

    /**
     * Saves the new user in the system and shows its data on screen
     */
    private void saveUser(){

        User u = new User(tietNameInput.getText().toString());

        u.setUserEmail(tietEmailInput.getText().toString());
        u.setUserPassword(tietPasswdInput.getText().toString());
        u.setHasLaptop(cbLaptop.isChecked());
        u.setHasAndPhone(cbAndPhone.isChecked());

        Phone userPhone;

        if(u.hasAndPhone()){
            userPhone = new UserAndroidPhone();
            switch(spAndVersion.getSelectedItem().toString()){
                case "Jelly Bean":
                    ((UserAndroidPhone)userPhone)
                            .setAndroidVersion(UserAndroidPhone.JELLY_BEAN);
                    break;
                case "KitKat":
                    ((UserAndroidPhone)userPhone)
                            .setAndroidVersion(UserAndroidPhone.KITKAT);
                    break;
                case "Lollipop":
                    ((UserAndroidPhone)userPhone)
                            .setAndroidVersion(UserAndroidPhone.LOLLIPOP);
                    break;
                case "Marshmallow":
                    ((UserAndroidPhone)userPhone)
                            .setAndroidVersion(UserAndroidPhone.MARSHMALLOW);
                    break;
                case "Nougat":
                    ((UserAndroidPhone)userPhone)
                            .setAndroidVersion(UserAndroidPhone.NOUGAT);
                    break;
            }
        }else{
            userPhone = new Phone();
        }

        u.setCellPhone(userPhone);

        u.logInfo();
    }

}
