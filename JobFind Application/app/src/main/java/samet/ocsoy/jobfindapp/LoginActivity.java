package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {

  EditText email_Login_Edittext, password_login_Edittext;
  Button btn_Login, btn_Register,btn_Staff_Login;
  private Database database;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Jobfind'a Hosgeldiniz");


        // veri tabanını bağladık
        database = new Database(this);

        // kullanilan edittextleri bagladik.
        email_Login_Edittext = (EditText)findViewById(R.id.email_login);
        password_login_Edittext = (EditText)findViewById(R.id.password_login);

        // kullanilan butonlari tanimladik
        btn_Login = (Button)findViewById(R.id.btn_login);
        btn_Register = (Button)findViewById(R.id.btn_register);
        btn_Staff_Login = (Button)findViewById(R.id.btn_staff_login);



          // GIRIS YAP TUSUNA BASINCA YAPILACAK ISLEM
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // giris tuşuna basınca yapılacak işlem

              // editttextteki verileri string değişkene taşıyoruz.
              String email_login_text = email_Login_Edittext.getText().toString();
              String password_login_text = password_login_Edittext.getText().toString();

              // veri tabanı sınıfında yazdığımız metodu kullanarak sql sorgusunu yapıyoruz.
              Boolean check_login_for_user = database.check_UserData(email_login_text,password_login_text);

              if (check_login_for_user == true)
              {
                Intent intent = new Intent(LoginActivity.this, User_MainMenuActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(LoginActivity.this, "Jobfind'a Hoşgeldin", Toast.LENGTH_SHORT).show();

              }else
              {
                Toast.makeText(LoginActivity.this, "Tekrar Deneyiniz", Toast.LENGTH_SHORT).show();

              }



            }
         });



        // KAYIT OL BUTONUNA BASINCA YAPILACAK ISLEM
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // kayit ol tuşuna basınca yapılacak işlem

              Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
              startActivity(intent);
              finish();

            }
        });


        // PERSONEL GIRIS BUTONUNA BASINCA YAPILACAK ISLEM
        btn_Staff_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // personel icin kayit ol tuşuna basınca yapılacak işlem

              Intent intent = new Intent(LoginActivity.this, Staff_LoginActivity.class);
              startActivity(intent);
              finish();

            }
        });


    }
}
