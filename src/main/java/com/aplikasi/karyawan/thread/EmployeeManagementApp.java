package com.aplikasi.karyawan.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeManagementApp {

    @Autowired
    private TestRestTemplate restTemplateBuilder;

//    public  final int THREAD_POOL_SIZE = 10; // Jumlah thread dalam thread pool
    public  String API_BASE_URL = "http://localhost:8081/api/v1/employee";

    @Qualifier("taskExecutor")
    @Autowired
    private TaskExecutor taskExecutor;

    @Test
    public  void abc() {
        // Membuat thread pool dengan ukuran tertentu
//        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // Simulasi beberapa operasi manajemen karyawan
        String[] employeeIds = {"31", "32", "33", "34", "35","26", "27", "28", "29", "30","31", "32", "33", "34", "35","26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35","26", "27", "28", "29", "30","31", "32", "33", "34", "35","26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35","26", "27", "28", "29", "30","31", "32", "33", "34", "35","26", "27", "28", "29", "30"};

        // Mengajukan tugas ke thread pool untuk mendapatkan data karyawan
        for (String employeeId : employeeIds) {
//            threadPool.execute(() -> getEmployeeDetails(employeeId));
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    getEmployeeDetails(employeeId);
                }
            });
//            System.out.println("hasil="+employeeId);
        }

        // Menunggu semua tugas selesai sebelum menutup thread pool
//        threadPool.shutdown();
    }

    private  void getEmployeeDetails(String employeeId) {
        // Logika untuk mendapatkan detail karyawan dari API
        String apiUrl = API_BASE_URL + "/" + employeeId;

        // Simulasi panggilan API

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dateString=sdf.format(new Date());
        System.out.println(dateString +" = Calling API to get employee details for ID " + apiUrl);

//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create(apiUrl))
//                .build();

        try {
//            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            processApiResponse(employeeId, response.body());
//            ResponseEntity<Map> response123 = restTemplateBuilder.exchange(apiUrl, HttpMethod.GET, null, new
//                    ParameterizedTypeReference<Map>() {
//                    });
//            System.out.println("response123="+dateString);

        } catch (Exception e) {
            System.err.println("Error calling API for employee ID " + employeeId + ": " + e.getMessage());
        }


    }
    private static void processApiResponse(String employeeId, String apiResponse) {
        System.out.println("Received API response for employee ID " + employeeId + ": " + apiResponse);
        // Implementasi logika pemrosesan respons API, misalnya menyimpan data ke database.
    }
}