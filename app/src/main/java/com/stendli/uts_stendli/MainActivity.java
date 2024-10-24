package com.stendli.uts_stendli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Deklarasi Variable Pendukung
    private TextView Hasil;
    private EditText Masukan;
    private Button Eksekusi;
    // Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;
    // Digunakan Untuk Konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Masukan = findViewById(R.id.input);
        Hasil = findViewById(R.id.output);
        Eksekusi = findViewById(R.id.save);

        // Membuat File Baru Beserta Modifiernya
        preferences = getSharedPreferences("Belajar_SharedPreferences", Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getSharedPreferences(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }

            private Context getSharedPreferences() {
                return null;
            }
        });
    }

    private SharedPreferences getSharedPreferences(String belajar_sharedPreferences, int modePrivate) {
        return null;
    }

    private void getData() {
        // Mendapatkan Input dari user
        String getKonten = Masukan.getText().toString();
        // Digunakan Untuk Pengaturan Konfigurasi SharedPreferences
        editor = preferences.edit();
        // Memasukan Data Pada Editor SharedPreferences dengan key (data_saya)
        editor.putString("data_saya", getKonten);
        // Menjalankan Operasi
        editor.apply();
        // Menampilkan Output
        Hasil.setText("Output Data : " + preferences.getString("data_saya", null));
    }
}