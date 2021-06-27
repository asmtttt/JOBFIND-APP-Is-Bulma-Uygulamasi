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

public class UserSurveyActivity extends AppCompatActivity {


    EditText edittext_surveypage_for_category,edittext_surveypage_for_points;
    EditText edittext_surveypage_for_complaint;

    Button btn_send_for_surveyPage;

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_survey);


        ActionBar actionBar = getSupportActionBar();
        // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // veri tabanını bağladık
        database = new Database(this);

        // kullanilan edittextleri tanimladik
        edittext_surveypage_for_category = findViewById(R.id.edittext_surveypage_for_category);
        edittext_surveypage_for_points = findViewById(R.id.edittext_surveypage_for_points);
        edittext_surveypage_for_complaint = findViewById(R.id.edittext_surveypage_for_complaint);

        // kullanilan butinu tanimladik
        btn_send_for_surveyPage = findViewById(R.id.btn_send_for_surveyPage);



        btn_send_for_surveyPage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            // string ve int e cevirmek
            String survey_category_text = edittext_surveypage_for_category.getText().toString();
            Integer survey_point_text = Integer.parseInt(edittext_surveypage_for_points.getText().toString());
            String survey_complaint_text = edittext_surveypage_for_complaint.getText().toString();


            // eğer edittextlerden herhangi biri boş ise

            if (
              survey_category_text.equals("") || survey_point_text.equals(null) ||survey_complaint_text.equals("")
            ){

              Intent intent = new Intent(UserSurveyActivity.this, UserSurveyActivity.class);
              startActivity(intent);
              finish();

              Toast.makeText(UserSurveyActivity.this, "Hata : Eksik Bilgi", Toast.LENGTH_SHORT).show();

            } else {

              // ekleme metodu
              // daha önceden yazdığımız metodu kullanıyoruz.
              Boolean insert_survey = database.insert_SurveysData(survey_category_text,
                survey_point_text, survey_complaint_text);


              if (insert_survey == true) {
                // hata yoksa
                Toast.makeText(UserSurveyActivity.this, "Tesekkurler", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UserSurveyActivity.this, UserSurveyActivity.class);
                startActivity(intent);
                finish();

              } else {

                // hata varsa
                Toast.makeText(UserSurveyActivity.this, "Hata : Anket Ekleme İşlemi Yapılamadı", Toast.LENGTH_SHORT).show();


              }

            } // buyuk else

          } // onclick
        });





    }



    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),User_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }
}
