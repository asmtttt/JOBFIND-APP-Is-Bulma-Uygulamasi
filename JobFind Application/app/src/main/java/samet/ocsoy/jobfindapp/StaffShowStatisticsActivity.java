package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StaffShowStatisticsActivity extends AppCompatActivity {

    TextView staff_Statistics_Count_User, staff_statistics_Count_Staff;
    TextView staff_statistics_Count_Job;

    private Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_show_statistics);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // veri tabanını bağladık
        database = new Database(this);

        // kullanilan textviewi bagladik
        staff_Statistics_Count_User = findViewById(R.id.staff_statistics_count_user);
        staff_statistics_Count_Staff = findViewById(R.id.staff_statistics_count_staff);
        staff_statistics_Count_Job = findViewById(R.id.staff_statistics_count_job);


        //  database metodumuzu kullaniyoruz ve sonucu float degiskene atiyoruz
        float count_user_data = database.show_Count_User();
        float count_staff_data = database.show_Count_Staff();
        float count_staff_job = database.show_Count_Job();


        // floati stringe ceviriyoruz text viewe yazabilmek icin
        String result_count_user = Float.toString(count_user_data);
        String result_count_staff = Float.toString(count_staff_data);
        String result_count_job = Float.toString(count_staff_job);

        // stringleri textviewe atiyoruz.
        staff_Statistics_Count_User.setText(result_count_user);
        staff_statistics_Count_Staff.setText(result_count_staff);
        staff_statistics_Count_Job.setText(result_count_job);



    }


    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),Staff_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }
}
