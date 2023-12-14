package com.aplikasi.karyawan.chp3.sesi3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ContohLamda {
    public static void main(String[] args) {
// Contoh 1: Lambda dengan satu parameter
        Consumer<Integer> printNumber = (x) -> System.out.println(x);
        printNumber.accept(42);

// Contoh 2: Lambda tanpa parameter
        Supplier<String> getMessage = () -> "Hello, World!";
        String message = getMessage.get();

// Contoh 3: Lambda dengan multiple parameters dan blok kode
        BinaryOperator<Integer> add = (x, y) -> {
            int result = x + y;
            return result;
        };
        int sum = add.apply(10, 20);

        //contoh 4
        BinaryOperator<String> ad = (x,y)->{
            return x +y;
        };
        String nama = ad.apply("nama saya ", "riki");
        System.out.println("nama ="+ nama);


    }
}
