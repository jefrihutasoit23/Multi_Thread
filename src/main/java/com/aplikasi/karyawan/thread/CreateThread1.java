package com.aplikasi.karyawan.thread;

public class CreateThread1 extends Thread{
     @Override
    public  void run(){
         System.out.println("Inside : "+Thread.currentThread().getName());
    }
}
