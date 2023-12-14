package com.aplikasi.karyawan.testing;

import com.aplikasi.karyawan.dot.ResponseData;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.service.impl.EmployeeV10;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    @Qualifier("employeeImplke2") // Specify the bean name
    public EmployeeService employeeService10 ;

    @Test
    public void  test1(){
     Map map =     employeeService10.save(null);
        System.out.println("ekpektasi response ="+map);
    }

    @Test
    public void listSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/api/v1/rekening/list?size=10&page=0", HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody()); //JACKSON Parsing
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void getIdSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        Integer id = 12;
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/api/v1/rekening/"+id, HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void  saveSukses() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"nama\": \"Riki Aldi Pari\",\n" +
                "    \"jenis\": \"BCA\",\n" +
                "    \"rekening\": \"12345678\", \n" +
                "    \"employee\": {\n" +
                "        \"id\": 29\n" +
                "    }\n" +
                "}";

        /*
        cara : Map
         */
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        System.out.println("bodyTesting  =" + bodyTesting);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/api/v1/rekening/save", HttpMethod.POST, entity, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());

        String jsonResponse = exchange.getBody();
        //Step 1
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        //Step 2 : apa objek akan kita ambil
        String message = jsonNode.get("message").asText();
        int status = jsonNode.get("status").asInt();
        JsonNode data = jsonNode.get("data");
        JsonNode employee = data.get("employee");
        JsonNode detailEmployee = employee.get("detailEmployee");



        // how to parsing  data ; ke class DTORespnonse
        //Step 3 : cetak
        System.out.println("data dto ="+message);
        System.out.println("data dto ="+status);
        System.out.println("data dto ="+data);

        ResponseData abc = new ResponseData();
        abc.setId(Long.valueOf(data.get("id").toString()));
        abc.setRekening(data.get("rekening").toString());
        abc.setNama(data.get("nama").toString());
//        abc.setCreatedDate(data.get("createdDate").toString());

//        ResponseData responseDto = objectMapper.readValue(data, ResponseData.class);
        Map responseDto = objectMapper.convertValue(data, Map.class);
        System.out.println("json node="+abc);
        System.out.println("json node="+responseDto);


    }

    @Test
    public void  updateSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"id\":\"8\",\n" +
                "    \"nama\":\"pulpen update\",\n" +
                "    \"stok\":\"1\",\n" +
                "    \"satuan\":\"pcs\",\n" +
                "    \"harga\":\"123\"\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/sp/barang/update", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response  =" + exchange.getBody());
    }

    @Test
    public void getidSuccessListKaryawan() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        Integer id = 35;
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/api/v1/karyawan/"+id, HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        http://localhost:8081/api/v1/employee/list?page=0&size=10
    }
}
