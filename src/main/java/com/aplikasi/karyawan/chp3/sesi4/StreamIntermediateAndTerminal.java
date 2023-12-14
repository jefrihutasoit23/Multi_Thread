package com.aplikasi.karyawan.chp3.sesi4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntermediateAndTerminal {
    public static void main(String[] args) {
        // Contoh List data
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        // Intermediate Operations
        List<String> filteredWords = words.stream()
                .filter(word -> word.length() > 4)
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());

        // Terminal Operation
        long count = words.stream()
                .filter(word -> word.startsWith("c"))
                .count();

        // Menampilkan hasil
        System.out.println("Hasil Filter dan Map (Intermediate): " + filteredWords);
        System.out.println("Jumlah kata yang dimulai dengan 'c' (Terminal): " + count);
    }
}