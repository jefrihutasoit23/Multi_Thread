package com.aplikasi.karyawan.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfiguration {
    //    https://rizkimufrizal.github.io/belajar-spring-async/
    /*
    https://stackoverflow.com/questions/17659510/core-pool-size-vs-maximum-pool-size-in-threadpoolexecutor
    https://www.baeldung.com/java-threadpooltaskexecutor-core-vs-max-poolsize
     */

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5000);  // Jumlah minimum thread yang akan tetap ada dalam pool
        executor.setMaxPoolSize(5000);  // Jumlah maksimum thread dalam pool
        executor.setQueueCapacity(1250);  // Kapasitas antrian untuk tugas yang menunggu diproses
        executor.setThreadNamePrefix("custom_task_executor_thread");  // Nama thread
        executor.initialize();
        return executor;
    }

}

