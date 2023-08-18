package com.oit;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFGenerator {
    public static void generatePDFWithQRCode(byte[] qrCodeBytes, String pdfFileName) throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Add QR Code to PDF
            Image qrCodeImage = Image.getInstance(qrCodeBytes);
            document.add(qrCodeImage);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Save the PDF to a file or further processing
        // For simplicity, you can save it to a file directly here
        try (FileOutputStream fileOutputStream = new FileOutputStream(pdfFileName)) {
            fileOutputStream.write(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
