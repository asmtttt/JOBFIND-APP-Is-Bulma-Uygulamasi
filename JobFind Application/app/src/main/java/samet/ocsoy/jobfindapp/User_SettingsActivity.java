package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class User_SettingsActivity extends AppCompatActivity {

    public Switch backgroundColor_Switch_User_Settings;

    LinearLayout view_Settings_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // switch ve linear layotulari tanimladk
        backgroundColor_Switch_User_Settings = (Switch)findViewById(R.id.backgroundColor_Switch_UserSettings);

        view_Settings_User = findViewById(R.id.view_Settings_User);

      backgroundColor_Switch_User_Settings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

          if (isChecked){

            //

            view_Settings_User.setBackgroundResource(R.color.pink);

          } else {
            //

            view_Settings_User.setBackgroundResource(R.color.darkblue);

          }

        }
      });

    }

    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),User_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }

}
