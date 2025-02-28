package com.eipl.customersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eipl.customersupport.models.ComplaintRegistrationAttachments;
import com.eipl.customersupport.repository.ComplaintRegistrationAttachmentsRepository;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

	private static final String UPLOAD_DIR = "/tmp/uploads/";
    //private static final String UPLOAD_DIR = "uploads/";
	
	@Autowired
	private ComplaintRegistrationAttachmentsRepository repository; 

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam("description") String description,
                                        @RequestParam("complaintid") String complaintid){
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty!");
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create directory if it does not exist
            }

            //String filePath = UPLOAD_DIR + file.getOriginalFilename();
            
            String originalFilename = file.getOriginalFilename();
            String fileNameWithoutExtension = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));

            String filePath = UPLOAD_DIR + fileNameWithoutExtension + System.currentTimeMillis() + fileExtension;

            file.transferTo(new File(filePath));

            // Create and save the attachment information to the database
            ComplaintRegistrationAttachments attachment = new ComplaintRegistrationAttachments();
            
            try {
                attachment.setComplaintid(Long.parseLong(complaintid)); // Set complaint ID
            } catch (NumberFormatException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid complaint ID format!");
            }
            attachment.setFileName(filePath); // Save the file path as the file name
            attachment.setFileDescription(description); // Set the description

            repository.save(attachment); // Save to the database
            
            return ResponseEntity.ok("File uploaded successfully: " + description);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed!"+e);
        }
    }
}
