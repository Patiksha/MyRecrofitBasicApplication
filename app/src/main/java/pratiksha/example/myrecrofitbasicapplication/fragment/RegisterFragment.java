package pratiksha.example.myrecrofitbasicapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pratiksha.example.myrecrofitbasicapplication.R;
import pratiksha.example.myrecrofitbasicapplication.activities.MainActivity;
import pratiksha.example.myrecrofitbasicapplication.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterFragment extends Fragment {
    EditText nameInput_reg,emailInput_reg,phoneInput_reg,passInput_reg;
    Button button_reg;
    public RegisterFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register, container, false);

        nameInput_reg=view.findViewById(R.id.nameInput);
        emailInput_reg=view.findViewById(R.id.emailInput);
        phoneInput_reg=view.findViewById(R.id.phoneInput);
        passInput_reg=view.findViewById(R.id.passwordInput);
        button_reg=view.findViewById(R.id.regBtn);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        return view;
    }

    private void registerUser() {
        String name =nameInput_reg.getText().toString().trim();
        String email =emailInput_reg.getText().toString().trim();
        String phone =phoneInput_reg.getText().toString().trim();
        String password =passInput_reg.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            MainActivity.appPreference.showToast("Enter your name");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            MainActivity.appPreference.showToast("Your email is invalid");
        } else if(TextUtils.isEmpty(phone)){
            MainActivity.appPreference.showToast("Enter your phone");
        } else if(TextUtils.isEmpty(password)){
            MainActivity.appPreference.showToast("Enter your password");
        }  else if(password.length()<6)
        {
            MainActivity.appPreference.showToast("your pass length will not match to patern");
        }
          else{
            Call<User> userCall=MainActivity.servicApi.doRegistration(name,email,phone,password);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                   // Log.i("MyWay",response.body().getResponse());
                    System.out.println("MyWay"+response.body().getResponse());
                }

                @Override
                public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                    System.out.println("MyError"+t.getMessage());
                }
            });
        }
    }
}