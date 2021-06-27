package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Staff_SettingsActivity extends AppCompatActivity {

  public Switch backgroundColor_Switch;

  LinearLayout view_Settings_Staff;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_settings);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);



        backgroundColor_Switch = (Switch)findViewById(R.id.backgroundColor_Switch);

        view_Settings_Staff = findViewById(R.id.view_Settings_Staff);

        backgroundColor_Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if (isChecked){

              //


              view_Settings_Staff.setBackgroundResource(R.color.pink);

            } else {
              //

              view_Settings_Staff.setBackgroundResource(R.color.darkblue);

            }

          }
        });

  }


    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),Staff_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }
}
