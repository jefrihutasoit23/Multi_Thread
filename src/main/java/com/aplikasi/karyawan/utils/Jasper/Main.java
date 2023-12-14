package com.aplikasi.karyawan.utils.Jasper;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Main {
//    @Test
//    public   void main( ) {
//
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(JasperRerportsSimpleConfig.class);
//        ctx.refresh();
//
//        SimpleReportFiller simpleReportFiller = ctx.getBean(SimpleReportFiller.class);
//        simpleReportFiller.setReportFileName("./report/Supplier2.jrxml");
//        simpleReportFiller.compileReport();
//
////        simpleReportFiller.setReportFileName("employeeReport.jrxml");
////        simpleReportFiller.compileReport();
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("logo", "C:\\Users\\USER\\Downloads\\hard-01.jpg");
//        parameters.put("idSupplier", 1);
//        parameters.put("pathReport", "E:\\binar\\binar synergy batCh 5\\Project\\apps\\report\\");
//
//        simpleReportFiller.setParameters(parameters);
//        simpleReportFiller.fillReport();
//
//        SimpleReportExporter simpleExporter = ctx.getBean(SimpleReportExporter.class);
//        simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
//
//        simpleExporter.exportToPdf("employeeReport.pdf", "baeldung");
//        simpleExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");
//        simpleExporter.exportToCsv("employeeReport.csv");
//        simpleExporter.exportToHtml("employeeReport.html");
//
//    }

    @Autowired
    public  ReportService1 reportService1;

    @Test
    public  void tets() throws SQLException {
        Map<String, Object> parameters33 = new HashMap<>();
//        parameters33.put("logo", "C:\\Users\\USER\\Downloads\\hard-01.jpg");
//        Long inttt = 1L;
//        parameters33.put("idparam", 1);
//        parameters33.put("nameparama", "'%a%'");
//        parameters33.put("pathReport", "E:\\binar\\binar synergy batCh 5\\Project\\apps\\report\\");
//        String pathUrl = "E:\\binar\\binar synergy batCh 5\\Project\\apps\\report\\baranglist.jrxml";
//                String pathUrl = "E:\\binar\\binar synergy batCh 5\\Project\\apps\\report\\Supplier2.jrxml";
        String pathUrl = "E:\\binar\\Binat Batch 6\\MODUL\\karyawan\\src\\main\\resources\\Blank_A4.jrxml";//bisa dengan gambar, namun tidak bisa load sub report
        reportService1.generate_pdf(parameters33,pathUrl);
        reportService1.generate_excel(parameters33,pathUrl);
        reportService1.generateCSV(parameters33,pathUrl);
    }
}

