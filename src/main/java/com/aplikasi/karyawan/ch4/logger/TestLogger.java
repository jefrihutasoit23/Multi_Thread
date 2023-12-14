package com.aplikasi.karyawan.ch4.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class TestLogger {

    @Test
    public  void testLogger(){
        log.trace("trace"+ "ini trace");
        log.debug("debug","ini debug");
        log.info("info","ini info");
        log.warn("warn","ini warn");  // bisa
        log.error("error"+"ini error ");  // Try Catch
    }
}
