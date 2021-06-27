package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class StaffAddSurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_add_survey);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);





    }

    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),Staff_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }
}
