package samet.ocsoy.jobfindapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


  public static String database_Name = "JobfindDatabase.db";
  public static int version = 1;
  public static String database_Table1 = "user_Data";
  public static String database_Table2 = "staff_Data";
  public static String database_Table3 = "job_Data";
  public static String database_Table4 = "survey_Data";



  // constructor
  // Context:
  // uygulama için genel bilgileri tutan arayüz,
  // uygulamaya özgü kaynaklara erişimi sağlayan c nesnesi.

  public Database(Context context) {
    super(context, database_Name, null, version);

  }


  // veri tabanimizin tablolarini olusturuyor bu bir defa kullanilir.
  @Override
  public void onCreate(SQLiteDatabase db) {

    // kullanici bilgileri icin veri tabani tablosu olusturmak
    String query_User_Data = "CREATE TABLE "+ database_Table1 + "(Eposta Text, Parola Text);";
    db.execSQL(query_User_Data);


    // personel bilgileri icin veri tabani tablosu olusturmak
    String query_Staff_Data = "CREATE TABLE "+ database_Table2 + "(Eposta Text, Parola Text);";
    db.execSQL(query_Staff_Data);


    // is bilgileri icin veri tabani tablosu olusturmak
    String query_Job_Data = "CREATE TABLE "+ database_Table3 + "(Kategori Text," +
      "Ad Text, Sehir Text, Ilce Text, Cinsiyet Text, Telefon Text, Eposta Text," +
      "Maas Integer, Saat_Haftalik Text);";
    db.execSQL(query_Job_Data);


    // kullanici memnuniyet anket bilgileri icin veri tabani tablosu olusturmak
    String query_Surveys_Data = "CREATE TABLE "+ database_Table4 + "(Kategori Text," +
      "Puan Integer, Eksik Text);";
    db.execSQL(query_Surveys_Data);




  }


  // veri tabanimizi her defasinda yeniden olusturmasin die upgrade metodu yaziyoruz.
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    String quer_for_UserData = "DROP TABLE IF EXISTS "+ database_Table1;
    String quer_for_StaffData = "DROP TABLE IF EXISTS "+ database_Table2;
    String quer_for_JobData = "DROP TABLE IF EXISTS "+ database_Table3;
    String quer_for_SurveysData = "DROP TABLE IF EXISTS "+ database_Table4;


    db.execSQL(quer_for_UserData);
    db.execSQL(quer_for_StaffData);
    db.execSQL(quer_for_JobData);
    db.execSQL(quer_for_SurveysData);


  }


  // kullanici verilerinin kullanici bilgileri tablosuna ekleme metodu

  public Boolean insert_UserData (String Eposta, String Parola)
  {

    SQLiteDatabase DB = this.getWritableDatabase();
    ContentValues dataValues = new ContentValues();
    dataValues.put("Eposta",Eposta);
    dataValues.put("Parola",Parola);

    // parametreler long tipinde deger aldigi icin degiskeni long tipi ile tanimladik.
    long result = DB.insert(database_Table1,null, dataValues);

    // bu kısım bir hata olma ihtimali için yapılıyor. sonuç negatif ise false yani hatalı
    if (result == -1){
      return false;
    }

    // hatalı değil ise true değerini döndürüyor.
    else {
      return true;
    }


  }


// Personel verilerinin personel bilgileri tablosuna ekleme metodu

  public Boolean insert_StaffData (String Eposta, String Parola)
  {

    SQLiteDatabase DB = this.getWritableDatabase();
    ContentValues dataValues = new ContentValues();
    dataValues.put("Eposta",Eposta);
    dataValues.put("Parola",Parola);

    // parametreler long tipinde deger aldigi icin degiskeni long tipi ile tanimladik.
    long result = DB.insert(database_Table2,null, dataValues);

    // bu kısım bir hata olma ihtimali için yapılıyor. sonuç negatif ise false yani hatalı
    if (result == -1){
      return false;
    }

    // hatalı değil ise true değerini döndürüyor.
    else {
      return true;
    }


  }




  // is ilani verilerinin tutuldugu tabloya veri ekleme metodu

  public Boolean insert_JobData (String Kategori, String Ad, String Sehir, String Ilce,
                                 String Cinsiyet, String Telefon, String Eposta, int Maas,
                                 String Saat_Haftalik)
  {

    SQLiteDatabase DB = this.getWritableDatabase();
    ContentValues dataValues = new ContentValues();
    dataValues.put("Kategori",Kategori);
    dataValues.put("Ad",Ad);
    dataValues.put("Sehir",Sehir);
    dataValues.put("Ilce",Ilce);
    dataValues.put("Cinsiyet",Cinsiyet);
    dataValues.put("Telefon",Telefon);
    dataValues.put("Eposta",Eposta);
    dataValues.put("Maas",Maas);
    dataValues.put("Saat_Haftalik",Saat_Haftalik);

    // buradan devam

    // parametreler long tipinde deger aldigi icin degiskeni long tipi ile tanimladik.
    long result = DB.insert(database_Table3,null, dataValues);

    // bu kısım bir hata olma ihtimali için yapılıyor. sonuç negatif ise false yani hatalı
    if (result == -1){
      return false;
    }

    // hatalı değil ise true değerini döndürüyor.
    else {
      return true;
    }


  }



  // Anket verilerinin Anket bilgileri tablosuna ekleme metodu

  public Boolean insert_SurveysData (String Kategori, int Puan, String Eksik)
  {

    SQLiteDatabase DB = this.getWritableDatabase();
    ContentValues dataValues = new ContentValues();
    dataValues.put("Kategori",Kategori);
    dataValues.put("Puan",Puan);
    dataValues.put("Eksik",Eksik);

    // parametreler long tipinde deger aldigi icin degiskeni long tipi ile tanimladik.
    long result = DB.insert(database_Table4,null, dataValues);

    // bu kısım bir hata olma ihtimali için yapılıyor. sonuç negatif ise false yani hatalı
    if (result == -1){
      return false;
    }

    // hatalı değil ise true değerini döndürüyor.
    else {
      return true;
    }


  }



  // user icin giris islemi metodu
  public Boolean check_UserData (String Eposta, String Parola)
  {
    // veri tabanını okuma işlemi için kullanacağımızı bildiriyoruz.
    SQLiteDatabase DB = this.getReadableDatabase();

    // Cursor sınıfı ile rawQuery metodu ile sql sorgumuzu yazıyoruz
    Cursor cursor = DB.rawQuery("SELECT * FROM "+ database_Table1 + " WHERE Eposta=? and Parola=?", new String[]{Eposta,Parola});

    // eğer kayıt eşleşiyor ise böyle bir kayıt var ise true döndürüyoruz.
    if (cursor.getCount() > 0)
    {
      return true;
    } else
    {
      return false;
    }


  }



  // personel icin giris islemi metodu
  public Boolean check_StaffData (String Eposta, String Parola)
  {
    // veri tabanını okuma işlemi için kullanacağımızı bildiriyoruz.
    SQLiteDatabase DB = this.getReadableDatabase();

    // Cursor sınıfı ile rawQuery metodu ile sql sorgumuzu yazıyoruz
    Cursor cursor = DB.rawQuery("SELECT * FROM "+ database_Table2 + " WHERE Eposta=? and Parola=?", new String[]{Eposta,Parola});

    // eğer kayıt eşleşiyor ise böyle bir kayıt var ise true döndürüyoruz.
    if (cursor.getCount() > 0)
    {
      return true;
    } else
    {
      return false;
    }


  }


  // is ilanlari tablosundaki tum verileri ekrana bastiran metot

  public Cursor view_Job_All_Data(){

    // veri tabanını okuma işlemi için kullanacağımızı bildiriyoruz.
    SQLiteDatabase DB = this.getReadableDatabase();

    // tum verileri ceken sql sorgumuz
    String query_view_Job_All_Data = "Select * From "+database_Table3;

    // sorgumuzu kullanma
    Cursor cursor = DB.rawQuery(query_view_Job_All_Data,null);

    // verileri ekrana cikti olarak donmek
    return cursor;

  }



  public Boolean delete_User_for_Staff(String eposta, String parola){

    // veri tabanını işlem için kullanacağımızı bildiriyoruz.
    SQLiteDatabase DB = this.getWritableDatabase();

    // sorgumuzu yaziyoruz.
    Cursor cursor = DB.rawQuery("Select * from "+ database_Table1 +" where Eposta =? and Parola=?", new String[]{eposta,parola});


    if (cursor.getCount() > 0){

      long result = DB.delete(database_Table1,"Eposta=? and Parola=?",new String[]{eposta,parola});

      if (result == -1){

        return false;
      } else{

        return true;
      }

    } else {

        return false;

    }


  }


  // kullanici sayisini getiren metot
  public float show_Count_User() {

    SQLiteDatabase DB = this.getReadableDatabase();

    long count = DatabaseUtils.queryNumEntries(DB, database_Table1);

    float floatSayi = (float) count;

    DB.close();

    return floatSayi;
  }


  // personel sayisini getiren metot
  public float show_Count_Staff() {

    SQLiteDatabase DB = this.getReadableDatabase();

    long count = DatabaseUtils.queryNumEntries(DB, database_Table2);

    float floatSayi = (float) count;

    DB.close();

    return floatSayi;
  }


  // ilan sayisini getiren metot
  public float show_Count_Job() {

    SQLiteDatabase DB = this.getReadableDatabase();

    long count = DatabaseUtils.queryNumEntries(DB, database_Table3);

    float floatSayi = (float) count;

    DB.close();

    return floatSayi;
  }















  // ekle sil metotlari yazilacak. sql metotlari



}
