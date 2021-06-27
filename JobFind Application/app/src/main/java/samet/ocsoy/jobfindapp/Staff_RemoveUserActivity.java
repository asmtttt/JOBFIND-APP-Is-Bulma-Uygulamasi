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

public class Staff_RemoveUserActivity extends AppCompatActivity {


    Button btn_delete_Staff_for_user;
    EditText email_login_deleteStaffPage_Edittext, password_login_deleteStaffPage_Edittext;

    private Database database;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_remove_user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // veri tabanını bağladık
        database = new Database(this);

        // edittextleri tanimladik
        email_login_deleteStaffPage_Edittext = findViewById(R.id.email_login_deleteStaffPage);
        password_login_deleteStaffPage_Edittext = findViewById(R.id.password_login_deleteStaffPage);


        // butonlari tanimladik
        btn_delete_Staff_for_user = findViewById(R.id.btn_delete_Staff_for_user);



        btn_delete_Staff_for_user.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            // buraya veri tabani sinifindaki delete metodunu cagiracagiz.

            String email_text = email_login_deleteStaffPage_Edittext.getText().toString();
            String password_text = password_login_deleteStaffPage_Edittext.getText().toString();

            // delete metodunu kullandik.
            Boolean delete_user_data = database.delete_User_for_Staff(email_text, password_text);

            if (delete_user_data == true){

              // toast mesaji ile islemin tamamlandigini bildiriyoruz.
              Toast.makeText(Staff_RemoveUserActivity.this, "Kullanici silindi", Toast.LENGTH_SHORT).show();

            } else {

              // toast mesaji ile islemin tamamlandigini bildiriyoruz.
              Toast.makeText(Staff_RemoveUserActivity.this, "Hata: Silinemedi", Toast.LENGTH_SHORT).show();
            }

            // edittextleri temizliyoruz.
            email_login_deleteStaffPage_Edittext.setText("");
            password_login_deleteStaffPage_Edittext.setText("");


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
