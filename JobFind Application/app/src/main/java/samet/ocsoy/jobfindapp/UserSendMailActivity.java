package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserSendMailActivity extends AppCompatActivity {

    EditText adress_mail_Edittext, title_mail_Edittext;
    EditText content_mail_Edittext;

    Button btn_send_mail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_send_mail);


        // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);



        // edittextleri bagliyoruz

        adress_mail_Edittext = findViewById(R.id.adress_mail_Edittext);
        title_mail_Edittext = findViewById(R.id.tittle_mail_Edittext);
        content_mail_Edittext = findViewById(R.id.content_mail_Edittext);


        // butonlari tanimliyoruz
        btn_send_mail = findViewById(R.id.btn_send_mail);



        // butona tiklandiginda olacak islemler
        btn_send_mail.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            sendMail();

          }
        });


    }

    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),User_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
    }


    private void sendMail(){

      // stringe ceviriyoruz.
      String addres_mail_text = adress_mail_Edittext.getText().toString();

      // aliveli@gmail.com, mehmetkasap@gmail.com gibi virgulden ayiriyoruz.
      String[] adress = addres_mail_text.split(",");


      String title_mail_text = title_mail_Edittext.getText().toString();
      String content_mail_text = content_mail_Edittext.getText().toString();

      Intent intent = new Intent(Intent.ACTION_SEND);
      intent.putExtra(Intent.EXTRA_EMAIL, adress);
      intent.putExtra(Intent.EXTRA_SUBJECT, title_mail_text);
      intent.putExtra(Intent.EXTRA_TEXT, content_mail_text);

      intent.setType("message/rfc822");
      startActivity(Intent.createChooser(intent,"Kullan"));







    }




}
