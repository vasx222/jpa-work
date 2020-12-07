package org.vaskon.jpawork.bootstrap;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Component;
import org.vaskon.jpawork.bean.Storage;
import org.vaskon.jpawork.util.ResBundleUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(2)
public class Starter3 implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager em;
    private final Storage storage;

    public Starter3(EntityManager em, Storage storage) {
        this.em = em;
        this.storage = storage;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Начало генерации отчёта");
        try {
            createReport();
            System.out.println("Генерация отчёта завершена");
        } catch (Exception e) {
            System.out.println("Во время генерации возникла ошибка: " + e);
        }
    }

    String pathForSavingPdf = "D:\\prog\\java\\progs\\work\\jpa-work\\data\\cases.pdf";
    String pathForSavingXls = "D:\\prog\\java\\progs\\work\\jpa-work\\data\\cases.xls";
    String pathForPattern = "D:\\prog\\java\\progs\\work\\jpa-work\\data\\cases.jrxml";
    String pathForSwapFile = "D:\\prog\\java\\progs\\work\\jpa-work\\data";

    public void createReport() throws JRException, SQLException {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CASE_ENTITY", "HPAN");
        parameters.put("REPORT_END_DATE", new Date());
        parameters.put("REPORT_START_DATE", new Date());
        parameters.put("SENSINFO_EXPORT", true);
        parameters.put("REPORT_PRIVATE_SCHEME", Collections.singletonList(1L));
        parameters.put("REPORT_VIRTUALIZER", new JRSwapFileVirtualizer(10, new JRSwapFile(pathForSwapFile, 1024, 1024), true));
        parameters.put("RESOURCE_BUNDLE", ResBundleUtil.getResBundle());
        File reportPattern = new File(pathForPattern);
        JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                ((EntityManagerFactoryInfo)em.getEntityManagerFactory()).getDataSource().getConnection());
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSavingPdf);
        final JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pathForSavingXls));
        exporter.exportReport();
    }
}
