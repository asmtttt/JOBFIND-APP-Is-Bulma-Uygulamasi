package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StaffAddBusinessActivity extends AppCompatActivity {

  EditText category_entry_Edittext, position_entry_Edittext, city_entry_Edittext;
  EditText district_entry_Edittext, gender_entry_Edittext, phone_entry_Edittext;
  EditText email_entry_Edittext, salary_entry_Edittext, weeklyhour_entry_Edittext;

  Button add_Job_Button;

  private Database database;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_add_business);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // veri tabanını bağladık
        database = new Database(this);


        // kullanılan edittextleri bağladık.
        category_entry_Edittext = (EditText)findViewById(R.id.category_entry);
        position_entry_Edittext = (EditText)findViewById(R.id.position_entry);
        city_entry_Edittext = (EditText)findViewById(R.id.city_entry);
        district_entry_Edittext = (EditText)findViewById(R.id.district_entry);
        gender_entry_Edittext = (EditText)findViewById(R.id.gender_entry);
        phone_entry_Edittext = (EditText)findViewById(R.id.phone_entry);
        email_entry_Edittext = (EditText)findViewById(R.id.email_entry);
        salary_entry_Edittext = (EditText)findViewById(R.id.salary_entry);
        weeklyhour_entry_Edittext = (EditText)findViewById(R.id.weeklyhour_entry);


        // kullanilan button lari bagladik.
        add_Job_Button = (Button)findViewById(R.id.btn_add_Job);



        // Ekle Butonuna basinca yapilacak islemler

        add_Job_Button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


            // edittextleri string ve integer veri tiplerine ceviriyoruz.

            String category_text = category_entry_Edittext.getText().toString();
            String position_text = position_entry_Edittext.getText().toString();
            String city_text = city_entry_Edittext.getText().toString();
            String district_text = district_entry_Edittext.getText().toString();
            String gender_text = gender_entry_Edittext.getText().toString();
            String phone_text = phone_entry_Edittext.getText().toString();
            String email_text = email_entry_Edittext.getText().toString();

            // integer yapman lazim
            Integer salary_text = Integer.parseInt(salary_entry_Edittext.getText().toString());

            String weeklyhour_text = weeklyhour_entry_Edittext.getText().toString();


            // eğer edittextlerden herhangi biri boş ise
            if (category_text.equals("") || position_text.equals("") || city_text.equals("") ||
            district_text.equals("") || gender_text.equals("") || phone_text.equals("") ||
              email_text.equals("") || salary_text.equals(null) ||weeklyhour_text.equals("")
            ) {
              Toast.makeText(StaffAddBusinessActivity.this, "Hata : Eksik Bilgi", Toast.LENGTH_SHORT).show();

            } else{

                // ekleme metodu
                // daha önceden yazdığımız metodu kullanıyoruz.
                Boolean insert_job_data = database.insert_JobData(category_text, position_text, city_text,
                  district_text, gender_text, phone_text, email_text, salary_text, weeklyhour_text);

                if (insert_job_data == true) {
                  // hata yoksa
                  Toast.makeText(StaffAddBusinessActivity.this, "İlan Eklendi", Toast.LENGTH_SHORT).show();

                  Intent intent = new Intent(StaffAddBusinessActivity.this, StaffAddBusinessActivity.class);
                  startActivity(intent);
                  finish();

                } else {
                  // hata varsa
                  Toast.makeText(StaffAddBusinessActivity.this, "Hata : Kayit İşlemi Yapılamadı", Toast.LENGTH_SHORT).show();
                }


            }  // buyuk else

          } // on click
        });



  }

    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),Staff_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }
}
