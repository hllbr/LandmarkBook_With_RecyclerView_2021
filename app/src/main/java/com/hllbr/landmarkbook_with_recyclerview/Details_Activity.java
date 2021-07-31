package com.hllbr.landmarkbook_with_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hllbr.landmarkbook_with_recyclerview.databinding.ActivityDetailsBinding;
import com.hllbr.landmarkbook_with_recyclerview.databinding.ActivityDetailsBinding;


public class Details_Activity extends AppCompatActivity {
    TextView nameText;
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View Binding = new concept
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //old concept =
        nameText = findViewById(R.id.nameText);
        Intent intent = getIntent();
        //() <- casting concept = verinin hangi yapıdan olduğunu javaya ben biliyorum eminim bu yapı bu konsept içerisinde dediğimiz bir durum
       // com.hllbr.landmarkbook_with_recyclerview.LandMark selectedLandmark =(com.hllbr.landmarkbook_with_recyclerview.LandMark) intent.getSerializableExtra("landmark");
       // LandMark selectedLandmark = chosenLandmark;//hiç güvenli bir yöntem değil
        Singledton singledton = Singledton.getInstance();
        LandMark selectedLandmark = singledton.getSentLandmark();
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);
        //ListView her bir görünüm için MainActivity içersinde tek tek xml oluşturuyor.Kaç adet varsa o kadar oluşturuyor.
        //Bu yapının verimli hali RecyclerView iki Görüntü listesi arasında görsel açıdan hiçbir farklılık yok sadece işlevsellik farklılıkları bulunuyor.
    }
}