package com.aplikasi.karyawan.controller;

import com.aplikasi.karyawan.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //untuk write dan read data json
    @Autowired
    private ObjectMapper objectMapper;

//    @Before


    @Test
    void listQuizHeader() throws Exception {
        mockMvc.perform(
                get("/v1/employee/list?page=0&size=10")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andDo(result -> {
            System.out.println("result+"+result.getResponse().getContentAsString());
//            assertNotNull(merchants);
//            assertTrue(merchants.isEmpty());
        });
    }

    @Test
    void listQuizHeaderSpec() {
    }

    @Test
    void defaultJPA() {
    }

    @Test
    void testCreateEmployeeSuccess() throws Exception {
//        CreateMerchantRequest request = new CreateMerchantRequest();
//        request.setMerchantName("Toko ABC");
//        request.setMerchantLocation("Jogja");
//        request.setOpen(true);
        Map map = new HashMap();
        map.put("name","name");
        map.put("address","address");
        map.put("dob","2023-01-01");
        map.put("status","active");

        String token ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImFkbWluQG1haWwuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTcwMDUxNDQwNywiYXV0aG9yaXRpZXMiOlsiUk9MRV9TVVBFUlVTRVIiLCJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6IlhuSlZRd2tpQnBZdkJBX1VsZ2Z3VHJsSUl5USIsImNsaWVudF9pZCI6Im15LWNsaWVudC13ZWIifQ.uUQiDgjip5_jg9-azddPMoTaEcq_rCZ_FOAHvldPZlM";
        mockMvc.perform(
                post("/v1/employee/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(map))
                                .header("Authorization", token)
        ).andExpect(
                status().isOk()
        ).andDo(result -> {
            System.out.println("result+"+result.getResponse().getContentAsString());
//            result.getResponse().getContentAsString().
            // mangil method.
//            method
            callAPIABC(objectMapper.writeValueAsString(result.getResponse().getContentAsString()));
        });
    }

    public  void callAPIABC(Object obj){
        //call emthod
    }
//
//    @Test
//    void testFlagMerchantSuccess() throws Exception {
//        Merchant merchant = new Merchant();
//        merchant.setMerchantName("Toko ABC");
//        merchant.setMerchantLocation("Jogja");
//        merchant.setOpen(true);
//        Merchant savedMerchant = merchantRepository.save(merchant);
//
//        UpdateFlagMerchantRequest request = new UpdateFlagMerchantRequest();
//        request.setFlag(true);
//
//        mockMvc.perform(
//                patch("/api/merchants/flag/{id}", savedMerchant.getId())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<MerchantResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            MerchantResponse flaggedMerchant = response.getData();
//
//            assertNotNull(flaggedMerchant);
//            assertEquals(savedMerchant.getId(), flaggedMerchant.getId());
//            assertTrue(flaggedMerchant.isOpen());
//        });
//    }
//
//    @Test
//    void testGetMerchantsAvailable() throws Exception {
//        // Create merchants
//        merchantService.create(new CreateMerchantRequest("Toko ABC", "Jogja", true));
//        merchantService.create(new CreateMerchantRequest("Toko XYZ", "Surabaya", false));
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            List<MerchantResponse> merchants = response.getData();
//
//            assertNotNull(merchants);
//            assertEquals(2, merchants.size()); // Only one merchant is open
//        });
//    }
//
//    @Test
//    void testFlagMerchantNotFound() throws Exception {
//        UpdateFlagMerchantRequest request = new UpdateFlagMerchantRequest();
//        request.setFlag(false);
//
//        // UUID acak yang tidak ada di database
//        UUID nonExistentMerchantId = UUID.randomUUID();
//
//        mockMvc.perform(
//                patch("/api/merchants/flag/{id}", nonExistentMerchantId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpect(
//                status().isNotFound()
//        );
//    }
//
//    @Test
//    void testUpdateMerchantSuccess() throws Exception{
//
//        Merchant merchant = new Merchant();
//        merchant.setMerchantName("Toko Indra");
//        merchant.setMerchantLocation("Jogja");
//        merchant.setOpen(true);
//        Merchant savedMerchant = merchantRepository.save(merchant);
//
//        UpdateMerchantRequest request = new UpdateMerchantRequest();
//        request.setMerchantName("Toko Baru");
//        request.setMerchantLocation("Jakarta");
//        request.setOpen(false);
//
//        mockMvc.perform(
//                patch("/api/merchants/{id}", savedMerchant.getId())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<MerchantResponse> response = objectMapper.readValue(
//                    result.getResponse().getContentAsString(), new TypeReference<>() {
//                    });
//            assertEquals("Toko Baru", response.getData().getMerchantName());
//            assertEquals("Jakarta", response.getData().getMerchantLocation());
//            assertFalse(response.getData().isOpen());
//        });
//    }
//
//    @Test
//    void testGetMerchantsEmptyList() throws Exception {
//        // Tidak ada merchant yang dibuat
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            List<MerchantResponse> merchants = response.getData();
//
//            assertNotNull(merchants);
//            assertTrue(merchants.isEmpty());
//        });
//    }
//
//    @Test
//    void searchSuccess() throws Exception{
//
//        for (int i = 0; i<50; i++){
//
//            Merchant merchant = new Merchant();
//            merchant.setMerchantName("Toko Indra");
//            merchant.setMerchantLocation("Jogjakarta");
//            merchant.setOpen(true);
//            merchantRepository.save(merchant);
//        }
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("merchantName", "Indra")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("merchantLocation", "Jogja")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("open", "true")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//    }

}