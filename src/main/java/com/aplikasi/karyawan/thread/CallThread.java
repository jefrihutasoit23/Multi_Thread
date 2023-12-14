package com.aplikasi.karyawan.thread;

public class CallThread {

    public static void main(String[] args) {
        Thread call = new CreateThread1();
        call.start();

        Runnable callRunnable = new ThreadRunnable();
        Thread callRunnableThread = new Thread(callRunnable);
        callRunnableThread.start();

        Runnable callRunnableSleep = new ThreadRunnableSleep();
        Thread callRunnableThreadSleep = new Thread(callRunnableSleep);
        callRunnableThreadSleep.start();
    }
}
