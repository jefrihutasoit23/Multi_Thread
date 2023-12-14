package com.aplikasi.karyawan;

import com.aplikasi.karyawan.controller.fileupload.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
@EnableTransactionManagement
public class KaryawanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaryawanApplication.class, args);
	}

}
