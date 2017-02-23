package edu.salleurl.ls30394.studentsregister;

import android.content.DialogInterface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
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
        ctl.setTitle(getString(R.string.app_name));
        ctl.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    /**
     * Either shows or makes disappear the android version Spinner
     * depending on the checkbox's state
     * @param view Android Phone checkbox
     */
    public void onToggleAndroidDeviceCheckbox(View view){

        spAndVersion.setSelection(0);

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

    /**
     * Once the user has completed the registration, all the information will be displayed
     * on a confirmation dialog, which will also clear the form
     * @param u User to be displayed
     */
    private void dialogUserInfo(User u){

        AlertDialog.Builder adBuilder = new AlertDialog.Builder(this);
        adBuilder.setTitle(R.string.user_info);
        adBuilder.setIcon(R.drawable.ic_user);

        adBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        StringBuilder adSb = new StringBuilder(getString(R.string.nameInput_hint));
        adSb.append(getString(R.string.attrname_value_separator));
        adSb.append(u.getUserName());
        adSb.append('\n');

        adSb.append(getString(R.string.email_hint));
        adSb.append(getString(R.string.attrname_value_separator));
        adSb.append(u.getUserEmail());
        adSb.append('\n');

        adSb.append(getString(R.string.password_hint));
        adSb.append(getString(R.string.attrname_value_separator));
        adSb.append(u.getUserPassword());
        adSb.append('\n');

        adSb.append(getString(R.string.ageform_title));
        adSb.append(getString(R.string.attrname_value_separator));
        switch(u.getAgeGroup()){
            case User.YOUNGER_THAN_18:
                adSb.append(getString(R.string.younger_than_18));
                break;
            case User.BETWEEN_18_65:
                adSb.append(getString(R.string.between_18_65));
                break;
            case User.OLDER_THAN_65:
                adSb.append(getString(R.string.older_than_65));
        }
        adSb.append('\n');

        adSb.append(getString(R.string.has_laptop));
        adSb.append(getString(R.string.attrname_value_separator));
        adSb.append(u.hasLaptop()? getString(R.string.yes) : getString(R.string.no));
        adSb.append('\n');

        adSb.append(getString(R.string.has_and_phone));
        adSb.append(getString(R.string.attrname_value_separator));
        adSb.append(u.hasAndPhone()? getString(R.string.yes) : getString(R.string.no));
        adSb.append('\n');

        if(u.hasAndPhone()){
            adSb.append("Android API Level");
            adSb.append(getString(R.string.attrname_value_separator));
            adSb.append(((UserAndroidPhone)u.getCellPhone()).getAndroidVersion());
        }

        adBuilder.setMessage(adSb.toString());

        AlertDialog userAlert = adBuilder.create();

        userAlert.show();
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

        if(isUserDataOK())
            saveUser();
    }

    /**
     * @return True if the user's data has been correctly introduced
     */
    private boolean isUserDataOK(){

        boolean allOK = true;

        String
            userName            = tietNameInput.getText().toString(),
            userEmail           = tietEmailInput.getText().toString(),
            userPass            = tietPasswdInput.getText().toString(),
            confirmationPass    = tietPsswdConfirm.getText().toString();

        if(!isUserNameOK(userName)) allOK = false;
        if(!isUserEmailOK(userEmail)) allOK = false;
        if(!isUserPasswordOK(userPass, confirmationPass)) allOK = false;
        if(cbAndPhone.isChecked() && !(isAndroidVersionSelected())) allOK = false;

        return allOK;
    }

    /**
     * @param name User name typed in TextInputEditText
     * @return True if the user name is valid
     */
    private boolean isUserNameOK(String name){

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
    private boolean isUserEmailOK(String email){

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
    private boolean isUserPasswordOK(String password, String passConfirm){

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
    private boolean isAndroidVersionSelected(){

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

        RadioButton selectedAge = (RadioButton)
                findViewById(rgAgeGroupSelect.getCheckedRadioButtonId());

        switch(selectedAge.getText().toString()){
            case "<18":
                u.setAgeGroup(User.YOUNGER_THAN_18);
                break;
            case "18-65":
                u.setAgeGroup(User.BETWEEN_18_65);
                break;
            case "65":
                u.setAgeGroup(User.OLDER_THAN_65);
                break;
        }

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
        dialogUserInfo(u);
        clearForm();
    }

    /**
     * Resets all Inputs to their original state
     */
    private void clearForm(){

        tietNameInput.getText().clear();
        tietEmailInput.getText().clear();
        tietPasswdInput.getText().clear();
        tietPsswdConfirm.getText().clear();

        if(cbLaptop.isChecked()) cbLaptop.toggle();
        if(cbAndPhone.isChecked()) cbAndPhone.toggle();
        onToggleAndroidDeviceCheckbox(cbAndPhone);

        ((RadioButton)findViewById(R.id.age_younger18)).setChecked(true);
    }

}
