package com.aplikasi.karyawan.thread;

public class ThreadRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println("Inside Runnabel: "+Thread.currentThread().getName());
    }
}
