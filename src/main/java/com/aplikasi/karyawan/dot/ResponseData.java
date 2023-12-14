package com.aplikasi.karyawan.dot;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
//    @JsonProperty("createdDate")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private String createdDate;
//    @JsonProperty("updatedDate")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private String updatedDate;
    private Long id;
    private String nama;
    private String jenis;
    private String rekening;
    private Employee employee;

    // Getter and Setter

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Employee {
//        @JsonProperty("createdDate")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private String createdDate;
//        @JsonProperty("updatedDate")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private String updatedDate;
        private Long id;
        private String name;
        private String address;
//        @JsonProperty("dob")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private String dob;
        private String status;
        private DetailEmployee detailEmployee;

        // Getter and Setter

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DetailEmployee {
            private Long id;
            private String nik;
            private String npwp;
//            @JsonProperty("created_date")
//            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            private String created_date;
//            @JsonProperty("updated_date")
//            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            private String updated_date;

            // Getter and Setter
        }
    }
}