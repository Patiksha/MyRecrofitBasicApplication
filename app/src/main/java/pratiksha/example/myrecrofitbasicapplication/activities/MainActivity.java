package pratiksha.example.myrecrofitbasicapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;

        import android.os.Bundle;
        import android.widget.FrameLayout;
        import pratiksha.example.myrecrofitbasicapplication.R;
        import pratiksha.example.myrecrofitbasicapplication.constant.Constant;
        import pratiksha.example.myrecrofitbasicapplication.extras.AppPreference;
        import pratiksha.example.myrecrofitbasicapplication.fragment.LoginFragment;
        import pratiksha.example.myrecrofitbasicapplication.fragment.ProfileFragment;
        import pratiksha.example.myrecrofitbasicapplication.fragment.RegisterFragment;
        import pratiksha.example.myrecrofitbasicapplication.services.MyInterface;
import pratiksha.example.myrecrofitbasicapplication.services.RetrofitClient;
import pratiksha.example.myrecrofitbasicapplication.services.ServicApi;

import static pratiksha.example.myrecrofitbasicapplication.constant.Constant.baseUrl.BASE_URL;

public class MainActivity extends AppCompatActivity implements MyInterface {
    FrameLayout container_fragment;
    public static AppPreference appPreference;
     public static ServicApi servicApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container_fragment=findViewById(R.id.fragment_container);
         appPreference=new AppPreference(this);

         servicApi= RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServicApi.class);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,new LoginFragment())
                .commit();

    }

    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,new RegisterFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void login(String name, String email, String created_at) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,new ProfileFragment())
                .commit();

    }

    @Override
    public void logout() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,new LoginFragment())
                .commit();

    }

}