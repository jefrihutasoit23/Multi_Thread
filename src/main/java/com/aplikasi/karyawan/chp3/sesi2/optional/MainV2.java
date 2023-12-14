package com.aplikasi.karyawan.chp3.sesi2.optional;

import com.aplikasi.karyawan.chp3.sesi1.junit.DtoKaryawan;
import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainV2 {

    public static void main(String[] args) {
        // Contoh 1: Menggunakan Optional.ofNullable
        Employee employee1 = new Employee(1, "Riki Aldi", null, null);

        Optional<String> name1 = employee1.getNameOptional();
        Optional<String> dob1 = employee1.getDobtional();
        Optional<String> address1 = employee1.getAddresstional();

        System.out.println("Contoh 1:");
        System.out.println("Nama: " + name1.orElse("Tidak Ada Nama"));
        System.out.println("Tanggal Lahir: " + dob1.orElse("Tidak Ada Tanggal Lahir"));
        System.out.println("Alamat: " + address1.orElse("Tidak Ada Alamat"));

        // Contoh 2: Menggunakan Optional.ofNullable dengan map
        Employee employee2 = new Employee(2, null, "01-01-1996", "Jl Jakarta");
        Optional<String> name2 = employee2.getNameOptional();
        Optional<String> dob2 = employee2.getDobtional();
        Optional<String> address2 = employee2.getAddresstional();

        System.out.println("\nContoh 2:");
        name2.ifPresent(n -> System.out.println("Nama: " + n));
        dob2.map(d -> d.toString()).ifPresent(d -> System.out.println("Tanggal Lahir: " + d));
        address2.ifPresent(a -> System.out.println("Alamat: " + a));

        // Contoh 3: Menggunakan Optional.orElseGet
        Employee employee3 = new Employee(3, null, null, null);
        Optional<String> name3 = employee3.getNameOptional();
        Optional<String> dob3 = employee3.getDobtional();
        Optional<String> address3 = employee3.getAddresstional();
        Optional<Long> umur = employee3.getUmurOptional();
//        Optional<List<String>> listNama = employee3.getListnama();
//        if(listNama == null){
        //nulis logic berikutnya
            /*
            bisa menuliskan dengan value yang kita ingingakn
             */
        List<String> listNamateman = new ArrayList<>();
        listNamateman.add("Aldi");
        listNamateman.add("RIk");

        //kalian ingin ganti , value dari nama yang sudah ada
        listNamateman.stream().forEach((k -> {
            // loopping ambil nilai dari listNama kalian

        }));

//        List<Integer> konversi = listNamateman.(this::dataKonversi);


//        }

//        List<String> updateListNama = listNama.map(d -> d).orElse((k->{
//            return  null;
//        }));

        System.out.println("\nContoh 3:");
        String nameOrDefault = name3.orElseGet(() -> "Nama Default");
        String dobOrDefault = dob3.map(valueAwal -> valueAwal).orElseGet(() -> "Tanggal Lahir Default");
        Long umurDefault = umur.map(d -> d).orElseGet(() -> 123L);


        Long abc = null;
        if (abc == null) {
            abc = 0L;
        }
        if (dobOrDefault == null) {
            dobOrDefault = "123";
        }

        String addressOrDefault = address3.orElseGet(() -> "Alamat Default");

        System.out.println("Nama: " + nameOrDefault);
        System.out.println("Tanggal Lahir: " + dobOrDefault);
        System.out.println("Alamat: " + addressOrDefault);

        // 1. data awal
        List<Employee> listEmp = listEmp();
        /*
        konversi List<Employee> to
         */
        List<DtoKaryawan> listKonversi = new ArrayList<>();

        //2. looping data awal
        listEmp.stream().forEach((k->{
            DtoKaryawan data = new DtoKaryawan();
            data.setId(k.getId());
            data.setNama(k.getName());
            //3. konversi data awal  ke objek baru
            listKonversi.add(data);
        }));

        // PR mengunakan optional class map : ?
        DtoKaryawan obj = new DtoKaryawan();
//        for(Employee karyObt : listEmp){
//            karyObt
//        }

        List<DtoKaryawan> dtoList = listEmp.stream()
                .map(objectDto -> new DtoKaryawan(objectDto.getId(), objectDto.getName()))
                .collect(Collectors.toList());

        // Cetak hasilnya
        dtoList.forEach(dtoEmployee ->
                System.out.println("ID: " + dtoEmployee.getId() + ", Nama: " + dtoEmployee.getNama()));
    }

    public Integer dataKonversi(String nama) {
        return 1;
    }

    public static List<Employee> listEmp() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Riki Aldi", null, null));
        list.add(new Employee(2, "Riki Aldi", null, null));
        list.add(new Employee(3, "Riki Aldi", null, null));
        list.add(new Employee(4, "Riki Aldi", null, null));

        return list;
    }
}
