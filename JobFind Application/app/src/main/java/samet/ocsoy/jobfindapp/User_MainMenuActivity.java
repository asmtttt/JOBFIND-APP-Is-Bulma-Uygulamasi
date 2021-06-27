package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class User_MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mainmenu);

      // bu kısımda action bardaki yazı ve rengi degistiriyoruz değiştiriyoruz.

      ActionBar actionBar = getSupportActionBar();
      actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
      actionBar.setTitle("Jobfind'a Hosgeldiniz");


      CircleMenu circleMenu = findViewById(R.id.circle_menu);


      circleMenu.setMainMenu(Color.parseColor("#E91E63"),R.drawable.ic_baseline_album,
        R.drawable.ic_baseline_clear)
        .addSubMenu(Color.parseColor("#E91E63"),R.drawable.ic_baseline_airplay)
        .addSubMenu(Color.parseColor("#E91E63"),R.drawable.ic_baseline_mail)
        .addSubMenu(Color.parseColor("#E91E63"),R.drawable.ic_baseline_insert_comment)
        .addSubMenu(Color.parseColor("#E91E63"),R.drawable.ic_baseline_settings_24)

        .setOnMenuSelectedListener(new OnMenuSelectedListener() {
          @Override
          public void onMenuSelected(int index) {

            switch (index) {

              case 0:

                Intent intent0 = new Intent(User_MainMenuActivity.this, UserShowBusinessActivity.class);
                startActivity(intent0);
                finish();
                break;


              case 1:

                Intent intent1 = new Intent(User_MainMenuActivity.this, UserSendMailActivity.class);
                startActivity(intent1);
                finish();
                break;



              case 2:

                Intent intent2 = new Intent(User_MainMenuActivity.this, UserSurveyActivity.class);
                startActivity(intent2);
                finish();
                break;


              case 3:

                Intent intent3 = new Intent(User_MainMenuActivity.this, User_SettingsActivity.class);
                startActivity(intent3);
                finish();
                break;



            }


          }
        });




    }


    public void onBackPressed(){

      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

      alertDialogBuilder.setTitle("Çıkış Yap");

      alertDialogBuilder.setIcon(R.drawable.ic_baseline_exit_to_app);

      alertDialogBuilder.setMessage("Çıkış yapmak istediğinize emin misiniz ?");


      alertDialogBuilder.setCancelable(false);

      alertDialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          finish();
        }
      });

      alertDialogBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
      });

      AlertDialog alertDialog = alertDialogBuilder.create();
      alertDialog.show();


    }


}
