package pratiksha.example.myrecrofitbasicapplication.extras;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import pratiksha.example.myrecrofitbasicapplication.R;

//AppPreference
public class AppPreference {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public AppPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.s_pref_file), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //login status
    public void setLoginStatus(boolean status) {
        editor.putBoolean(String.valueOf(R.string.s_pref_login_status), status);
        editor.commit();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean(String.valueOf(R.string.s_pref_login_status), false);
    }

    //Name
    public void setDisplayName(String name) {
        editor.putString(String.valueOf(R.string.s_pref_login_name), "Name");
        editor.commit();
    }

    public String getDisplayName() {
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_login_name), "Name");
    }

    //Email
    public void setDisplayEmail(String Email) {
        editor.putString(String.valueOf(R.string.s_pref_login_email), "Email");
        editor.commit();
    }

    public String getDisplayEmail() {
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_login_email), "Email");
    }

    //Data
    public void setDisplayData(String Data) {
        editor.putString(String.valueOf(R.string.s_pref_login_data), "Data");
        editor.commit();
    }

    public String getDisplayData() {
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_login_data), "Data");
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
