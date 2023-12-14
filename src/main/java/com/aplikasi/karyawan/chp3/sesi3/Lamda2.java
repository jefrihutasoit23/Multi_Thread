package com.aplikasi.karyawan.chp3.sesi3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Lamda2 {
    public static void main(String[] args) {
//        BiConsumer: BiConsumer adalah antarmuka fungsional yang menerima dua argumen dan tidak menghasilkan nilai. Contoh penggunaan lambda expression pada BiConsumer:
        Map<String, Integer> scores = new HashMap<>();
        scores.put("RIKI", 85);
        scores.put("ALDI", 92);
        scores.put("PARI", 78);

        // Menggunakan lambda expression untuk mencetak nama dan skor
        BiConsumer<String, Integer> printScore = (name, score) ->
                System.out.println(name + "'s score is " + score);

        scores.forEach(printScore);
    }
}
