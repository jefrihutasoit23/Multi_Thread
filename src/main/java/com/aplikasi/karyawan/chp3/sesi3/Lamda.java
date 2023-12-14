package com.aplikasi.karyawan.chp3.sesi3;

import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Lamda {
  static   InterfaceEx objInterface = new InterfaceEx() {
        @Override
        public String getNama(String namasSaya) {
            return namasSaya;
        }

//      @Override
//      public List<Employee> listKaryawan(Employee kary) {
//          List<Employee> obj= new ArrayList<>();
//          obj.add(kary);
//          return obj;
//      }
  };
//    Consumer: Consumer adalah antarmuka fungsional yang menerima satu argumen dan tidak menghasilkan nilai. Contoh penggunaan lambda expression pada Consumer:
    public static void main(String[] args) {
        InterfaceEx testInterface = ((param-> "Riki aldi pari"));
        testInterface.getNama("abc");

        System.out.println(testInterface.getNama("abc"));


        List<String> names = new ArrayList<>();
        names.add("RIKI");
        names.add("ALDI");
        names.add("PARI");

        List<String> namesTampungan = new ArrayList<>();
        for(String nama : names){
            namesTampungan.add("value="+nama);
        }
        //step 1 : update date : dapat di implemetasi Objek karyawan -> PR Student
//        names.stream().forEach((p ->{
//            p = "update nama saya";
//            names.add(p);
//        }));

        //2. looping data
        // Menggunakan lambda expression untuk mencetak setiap nama
        names.forEach(name -> System.out.println("Hello, " + name));

        // Foreach : hanya melooping data saaja
        // stream. foreach -> looping : memanipulasi data yang ada pada objek ararray tersebut.

        // butuh action dari baris ->
//        names.forEach(name->{
//            //
//            System.out.println("print="+name);
//        });

        // sorting, asc desc, filter by : seracing by id

//        ConsumerExample();
//        umur(20);
//        biConsumer();
    }


    public static  void ConsumerExample(){
        // cara 1
        Consumer<Integer>  umur = u -> System.out.println("Umur="+ u); // kelemahan hanya satu action
        umur.accept(23);

        // cara 2 : kurung tutup : banyak action
        Consumer<Integer>  umur1 = u -> {
            System.out.println("Umur="+ u);
            System.out.println("acition ="+ u);
        };
        umur1.accept(24);

        // cara 3
        Consumer<Integer>  umur2 = (u -> {
            System.out.println("Umur="+ u);
        });
        umur1.accept(24);
    }
    public static  void biConsumer(){
        BiConsumer<Integer, String > umur = (u,n) ->{
            System.out.println("nama ="+n + " dan umur"+u);
        }; // kelemahan hanya satu action
        umur.accept(20,"riki");
    }

    public  static  void umur(int umur){
        System.out.println("umur saya="+umur);
    }

}
