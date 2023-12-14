package com.aplikasi.karyawan.chp3.sesi4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Contoh List data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("RIKI", "ALDI", "PARI");

        for(Integer data : numbers){
            if(data % 2 == 0){  // > 343
                System.out.println("bilangan genap="+data);
            }else {
                System.out.println("bilangan ganjil="+data);
            }
        }

        // 1. Filter Data
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Bilangan Genap: " + evenNumbers);

        // 2. Map Data
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Panjang Nama: " + nameLengths);

        // 3. Sorting Data
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Nama yang Diurutkan: " + sortedNames);

        // 4. Menghitung Jumlah
        long count = numbers.stream()
                .count();
        System.out.println("Jumlah Elemen: " + count);

        // 5. Operasi Reduce
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // Identity : value start nya
        System.out.println("Jumlah Semua Elemen: " + sum);

        // 6. Parallel Streams
        long parallelCount = numbers.parallelStream()
                .count();
        System.out.println("Jumlah Elemen (Parallel): " + parallelCount);
    }
}