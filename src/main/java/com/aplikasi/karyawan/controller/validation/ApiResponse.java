package com.aplikasi.karyawan.controller.validation;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class ApiResponse {
    private Object data;
    private String message;
//    private boolean error = true;
    private String status ;
    public ApiResponse(Object data, String message){
        this.data = data;
        this.message = message;
    }

    public ApiResponse(Object data, String message, String status ){
        this.data = data;
        this.message = message;
        this.status = status;
    }
}
