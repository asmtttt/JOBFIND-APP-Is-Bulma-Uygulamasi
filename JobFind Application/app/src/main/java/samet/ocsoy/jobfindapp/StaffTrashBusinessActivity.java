package samet.ocsoy.jobfindapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffTrashBusinessActivity extends AppCompatActivity {

  private Database database;


  EditText name_for_JobDataView_Edittext;
  Button button_for_JobDataView;


  ListView job_Data_List;
  ArrayList<String> ListItem;
  ArrayAdapter<String> adapter;




  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_trash_business);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
        actionBar.setTitle("Menuye Don");

        // bu kisimda geri don tusunu action bara koyuyoruz.
        actionBar.setDisplayHomeAsUpEnabled(true);


        // veri tabanını bağladık
        database = new Database(this);

        // yeni bir liste olusturk
        ListItem = new ArrayList<>();

        // Listview olusturduk
        job_Data_List = findViewById(R.id.job_data_list);


        // yazilan listeleme metodunu calistiriyoruz.
        view_Data();




  }

    // geri dön butonuna basıldığında bir intent açılıyor ve bu bizi login activity ye geri döndürüyor.
    public boolean onOptionsItemSelected(MenuItem item){
      Intent myIntent = new Intent(getApplicationContext(),Staff_MainMenuActivity.class);
      startActivityForResult(myIntent, 0 );
      return true;
  }


    private void view_Data(){

      // veri tabani sinifinda yazdigimiz goruntuleme metodunu cursor ile kullaniyoruz.
      Cursor cursor = database.view_Job_All_Data();

      if (cursor.getCount() == 0){

        Toast.makeText(StaffTrashBusinessActivity.this, "Hata : Veri Tabaninda Kayit Bulunamadi", Toast.LENGTH_SHORT).show();


      } else{

        // bu kisimdayiz
        while (cursor.moveToNext()){

          String baslik;
          baslik = cursor.getString(1);


          String alt_metin;
          alt_metin = "Kategori: "+cursor.getString(0)+ "\n" +
                      "Pozisyon: "+cursor.getString(1)+ "\n" +
                      "Şehir: "+cursor.getString(2)+ "\n" +
                      "İlçe: "+cursor.getString(3)+ "\n" +
                      "Cinsiyet: "+cursor.getString(4)+ "\n" +
                      "Telefon: "+cursor.getString(5)+ "\n" +
                      "E-Posta: "+cursor.getString(6)+ "\n" +
                      "Maaş: "+cursor.getString(7)+ "\n" +
                      "Çalışma Saati: "+cursor.getString(8)+ "\n"
          ;

          baslik = baslik.toUpperCase();

          String data = baslik+"\n\n"+alt_metin;

          ListItem.add(data);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListItem);

        job_Data_List.setAdapter(adapter);

      }
    }


}
