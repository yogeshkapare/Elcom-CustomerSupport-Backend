package com.eipl.customersupport.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.eipl.customersupport.models.ComplaintRegistration;
import com.eipl.customersupport.repository.CusotmerregRepository;

import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

@Service
public class ComplaintregReportService {
    
    @Autowired
    private ResourceLoader resourceLoader; // Use ResourceLoader for loading reports

    @Autowired
    private CusotmerregRepository cusotmerregRepository; // Corrected repository name

    @Autowired
    private DataSource dataSource;
    
    public void generateReport(HttpServletResponse response, Long complaintId) throws JRException, IOException, SQLException {

            // Load the compiled Jasper file
            //InputStream mainReportStream = getClass().getResourceAsStream("reports/8dReport.jasper");
            InputStream mainReportStream = null;
			try {
				mainReportStream = resourceLoader.getResource("classpath:reports/8dReport.jasper").getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            if (mainReportStream == null) {
                throw new FileNotFoundException("Jasper report file not found: reports/8dReport.jasper");
            }
            // Create parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("complaintid", complaintId);

            // Get JDBC connection
            Connection connection = null;
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Fill the report
            JasperPrint jasperPrint = null;
			try {
				jasperPrint = JasperFillManager.fillReport(mainReportStream, parameters, connection);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 // Set response headers for PDF download
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=complaint_report.pdf");

	        // Export to output stream
	        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

	        // Close resources
	        connection.close();
	        response.getOutputStream().flush();
	        response.getOutputStream().close();
        }
    }