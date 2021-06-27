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

public class RegisterActivity extends AppCompatActivity {

  EditText email_for_userEdittext, password_for_userEdittext, passwordAgain_for_userEdittext;
  Button register_for_userButton;
  private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

      // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

      ActionBar actionBar = getSupportActionBar();
      actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
      actionBar.setTitle("Jobfind'a Hosgeldiniz");

      // bu kisimda geri don tusunu action bara koyuyoruz.
      actionBar.setDisplayHomeAsUpEnabled(true);



      // veri tabanını bağladık
      database = new Database(this);

      // kullanılan edittextleri bağladık.
      email_for_userEdittext = (EditText)findViewById(R.id.email_register);
      password_for_userEdittext = (EditText)findViewById(R.id.password_register);
      passwordAgain_for_userEdittext = (EditText)findViewById(R.id.password_register_again);

      // kullanilan button lari bagladik.
      register_for_userButton = (Button)findViewById(R.id.btn_register_for_user);


      register_for_userButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          // kayit ol butonuna basilinca yapilacak islemler

          // buradan devam

          String email_text = email_for_userEdittext.getText().toString();
          String password_text = password_for_userEdittext.getText().toString();
          String password_text_again = passwordAgain_for_userEdittext.getText().toString();


          // eğer edittextlerden herhangi biri boş ise
          if (email_text.equals("") || password_text.equals("") || password_text_again.equals("")) {
            Toast.makeText(RegisterActivity.this, "Hata : Eksik Bilgi.", Toast.LENGTH_SHORT).show();

          } else {

            if (password_text.equals(password_text_again)) {
              // ekleme metodu
              // daha önceden yazdığımız metodu kullanıyoruz.
              Boolean insert_user_data = database.insert_UserData(email_text, password_text);

              if (insert_user_data == true) {
                // hata yoksa
                Toast.makeText(RegisterActivity.this, "Kayit Yapıldi.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

              } else {
                // hata varsa
                Toast.makeText(RegisterActivity.this, "Hata : Kayit İşlemi Yapılamadı.", Toast.LENGTH_SHORT).show();
              }


            } else {

              Toast.makeText(RegisterActivity.this, "Hata : Parolalar Eslesmiyor.", Toast.LENGTH_SHORT).show();

            }


          } // buyuk else

        } // onclick view


      }); // set on cliker




    } // oncreate


  // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
  public boolean onOptionsItemSelected(MenuItem item){
    Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
    startActivityForResult(myIntent, 0 );
    return true;
  }

}
