package com.aplikasi.karyawan.chp3.sesi3;

import java.util.Random;
import java.util.function.Supplier;

public class LamdaSupplier {
    public static void main(String[] args) {
        // Supplier: Supplier adalah antarmuka fungsional yang tidak menerima argumen dan menghasilkan nilai.
        // Contoh penggunaan lambda expression pada Supplier:
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        int randomValue = randomNumberSupplier.get();
        System.out.println("Random number: " + randomValue);
    }
}