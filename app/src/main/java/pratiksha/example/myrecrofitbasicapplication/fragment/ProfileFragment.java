package pratiksha.example.myrecrofitbasicapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pratiksha.example.myrecrofitbasicapplication.R;
import pratiksha.example.myrecrofitbasicapplication.activities.MainActivity;
import pratiksha.example.myrecrofitbasicapplication.extras.AppPreference;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
                                               