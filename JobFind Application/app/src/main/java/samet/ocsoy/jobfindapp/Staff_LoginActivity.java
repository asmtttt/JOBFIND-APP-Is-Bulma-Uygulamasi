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

public class Staff_LoginActivity extends AppCompatActivity {

  EditText email_Login_Edittext, password_login_Edittext;
  Button btn_Login_forStaff, btn_Register_forStaff;
  private Database database;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Personel Giris Ekrani");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);

        // veri tabanını bağladık
        database = new Database(this);

        // kullanilan edittextleri bagladik.
        email_Login_Edittext = (EditText)findViewById(R.id.email_login_for_staff);
        password_login_Edittext = (EditText)findViewById(R.id.password_login_for_staff);

        // kullanilan butonlari tanimladik
        btn_Login_forStaff = (Button)findViewById(R.id.btn_login_forStaff);
        btn_Register_forStaff = (Button)findViewById(R.id.btn_register_forStaff);


        // GIRIS YAP BUTONUNA BASILINCA YAPILACAKLAR
        btn_Login_forStaff.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

            // giris ol tuşuna basınca yapılacak işlem

            // editttextteki verileri string değişkene taşıyoruz.
            String email_login_text = email_Login_Edittext.getText().toString();
            String password_login_text = password_login_Edittext.getText().toString();

            // veri tabanı sınıfında yazdığımız metodu kullanarak sql sorgusunu yapıyoruz.
            Boolean check_login_for_staff = database.check_StaffData(email_login_text,password_login_text);

            if (check_login_for_staff == true)
            {
              Intent intent = new Intent(Staff_LoginActivity.this, Staff_MainMenuActivity.class);
              startActivity(intent);
              finish();

              Toast.makeText(Staff_LoginActivity.this, "Jobfind'a Hoşgeldin", Toast.LENGTH_SHORT).show();

            }else
            {
              Toast.makeText(Staff_LoginActivity.this, "Tekrar Deneyiniz", Toast.LENGTH_SHORT).show();

            }


          }
        });


        // KAYIT OL BUTONUNA BASILINCA YAPILACAKLAR
        btn_Register_forStaff.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

            // kayit ol tuşuna basınca yapılacak işlem

            Intent intent = new Intent(Staff_LoginActivity.this, Staff_RegisterActivity.class);
            startActivity(intent);
            finish();

          }
        });




  }

  // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
  public boolean onOptionsItemSelected(MenuItem item){
    Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
    startActivityForResult(myIntent, 0 );
    return true;
  }
}
