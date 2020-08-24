package pratiksha.example.myrecrofitbasicapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pratiksha.example.myrecrofitbasicapplication.R;
import pratiksha.example.myrecrofitbasicapplication.services.MyInterface;

public class LoginFragment extends Fragment {
    MyInterface myInterface_login;
    Button loginBtn_op;
    EditText emailInput_op,passwordInput_op;
    TextView registerTV;
    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
         emailInput_op=view.findViewById(R.id.emailInput);
         passwordInput_op=view.findViewById(R.id.passwordInput);
         loginBtn_op=view.findViewById(R.id.loginBtn);
        loginBtn_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Login", Toast.LENGTH_SHORT).show();
            }
        });

        //Register

        registerTV=view.findViewById(R.id.registerTV);
        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Register", Toast.LENGTH_SHORT).show();
                 myInterface_login.register();
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;
        myInterface_login=(MyInterface) activity;
    }
}