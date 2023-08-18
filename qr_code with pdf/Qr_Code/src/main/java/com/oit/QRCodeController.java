package com.oit;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;

@RestController
public class QRCodeController {

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePDFWithQRCode() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // Generate QR Code
            String qrText = "https://google.com"; // Replace with your URL
            int qrWidth = 200;
            int qrHeight = 200;
            QRCodeGenerator.generateQRCode(outputStream, qrText, qrWidth, qrHeight);

            // Generate PDF with QR Code
            String pdfFileName = "qrcode_with_pdf.pdf";
            PDFGenerator.generatePDFWithQRCode(outputStream.toByteArray(), pdfFileName);

            // Return PDF as response
            byte[] pdfBytes = outputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(pdfFileName, pdfFileName);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
