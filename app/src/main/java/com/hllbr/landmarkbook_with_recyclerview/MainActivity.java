package com.hllbr.landmarkbook_with_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hllbr.landmarkbook_with_recyclerview.databinding.ActivityMainBinding;
import com.hllbr.landmarkbook_with_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    private ActivityMainBinding binding;
   // static  LandMark chosenLandmark ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //ArrayList initialize operatin area :)

        landMarkArrayList =new ArrayList<>();

        //DATA

        LandMark pisa = new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark eiffel = new LandMark("Eiffel","France",R.drawable.effiel);
        LandMark colosseum = new LandMark("Colosseum","Italy",R.drawable.colosseum);
        LandMark london_Bridge = new LandMark("London Bridge","England",R.drawable.london_bridge);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);
        landMarkArrayList.add(london_Bridge);

        //Singleton verimli değil / Not Efficient / Bitmap Veri yollamanın birden fazla yolu var sadece intent ile göndermiyoruz.İntenlerin bir kapasitesi var ve resimler Bitmapler bu durumu aşıyor.Singleton sadece veri yolamak için değil Tek objeli bir sınıf ihtiyacımı olduğunda kullanabileceğimiz bir yapı.Sadece Java değil tüm dillerde kullanılabiliyor.

        //Tek bir arrayList ile tek bir model içerisinde 12 değişkeni tutabiliyor pozisyona gelmiş oldum

        //Adapter = Bizim veri kaynağımız ile xml'i ve listView'i birbirine bağlayan yapımız.

        //RecyclerView = tek bir zorluğu var adaptor yazımı
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landMarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
    }
}
/*
RecyclerView ListView gibi bir Jetpack üyesidir.
Görünüm olarak ListView dan farkı olmasada işlevsellik açısından daha verimli bir duruma sahibiz.
ListView içinde bin adet elemanımızda olsa tek tek xml'i gösteriyor ama recyclerView 1000 adet xml oluşturmuyor.Kullanıcının göreceği kadar oluşturuyor.
Biz scroll yaptıkça aşağı doğru indikçe tekrar kullanılıyor.Recycler terimi buradan geliyor.
Recycler terimi anlam olarak geri dönüştürmek anlamına geldiği için Önceki görünümleri geri dönüştürüyor tekrar tekrar yeni bir görünüm oluşturmak yerine mevcut görünüm içerisindeki verileri update ediyoruz gibi düşünülenilir.
RecyclerView eleman sayısının artmasından bağımsız bir verime sahip 50000 adet veri içinde 1000 adet veri içinde yüksek performans alabiliriz.Emülator yada Telefon hafızasından işletim sisteminden harcama minimalize ediliyor bu bakımdan ListView yerine tercih etmemiz mantıklıdır.
Profesyonel uygulamalarda herzaman RecyclerView tercih edilmelidir.

 */