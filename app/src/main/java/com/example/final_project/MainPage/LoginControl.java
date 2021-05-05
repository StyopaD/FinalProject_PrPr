package com.example.final_project.MainPage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.final_project.R;
import com.example.final_project.Tab.TabLayoutController;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LoginControl implements TextWatcher {

    private EditText username_email;
    private EditText password;
    private boolean username_emailValid = false;
    private boolean passwordValid = false;

    public LoginControl(Context context, LinearLayout layout){
        initializeCardLogin(context, layout);
    }

    private void initializeCardLogin(Context context, LinearLayout layout){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                context, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(context).
                inflate(R.layout.layout_bottom_sheet_login, layout);

        username_email = bottomSheetView.findViewById(R.id.user_name_log);
        password = bottomSheetView.findViewById(R.id.password_log);
        username_email.addTextChangedListener(this);
        password.addTextChangedListener(this);

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        bottomSheetView.findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username_emailValid && passwordValid){
                    context.startActivity(new Intent(context, TabLayoutController.class));
                    bottomSheetDialog.dismiss();
                    ((Activity)context).finish();
                }
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
