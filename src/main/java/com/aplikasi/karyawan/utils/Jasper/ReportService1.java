package com.aplikasi.karyawan.utils.Jasper;


import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Service
public class ReportService1 {
    @Autowired
    ApplicationContext context;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    RestTemplate restTemplate;

    public byte[] generate_pdf(Map<String, Object> parameters, String reportName) {
        try {
            JasperReport report = JasperCompileManager.compileReport(reportName);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,jdbcTemplate.getDataSource().getConnection());

            byte[] result = JasperExportManager.exportReportToPdf(jasperPrint) ;
            OutputStream out = new FileOutputStream("./cdn/out.pdf");
            out.write(result);
            out.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity generate_excel(Map<String, Object> parameters, String reportName) throws SQLException {
        Connection connection = null;
        byte[] data = new byte[0];
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            connection = dataSource.getConnection();
            httpHeaders.set( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + reportName + ".xlsx" );

            JasperReport report = JasperCompileManager.compileReport(reportName);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,jdbcTemplate.getDataSource().getConnection());

            JRXlsxExporter exporter = new JRXlsxExporter();

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.exportReport();
            data = byteArrayOutputStream.toByteArray();
            OutputStream out = new FileOutputStream("./cdn/out.xlsx");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.close();
                connection = null;
            }
        }
        return new ResponseEntity(data, httpHeaders, HttpStatus.OK );
    }

    public ResponseEntity generateCSV(Map<String, Object> parameters, String reportName) throws SQLException {
        Connection connection = null;
        byte[] data = new byte[0];
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            connection = dataSource.getConnection();
            httpHeaders.set( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + reportName + ".csv" );

            JasperReport report = JasperCompileManager.compileReport(reportName);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,jdbcTemplate.getDataSource().getConnection());

            JRXlsxExporter exporter = new JRXlsxExporter();

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.exportReport();
            data = byteArrayOutputStream.toByteArray();
            OutputStream out = new FileOutputStream("./cdn/out.csv");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.close();
                connection = null;
            }
        }
        return new ResponseEntity(data, httpHeaders, HttpStatus.OK );
    }
}
