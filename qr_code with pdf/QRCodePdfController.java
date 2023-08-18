package com.oit;

/*
 * package com.oit;
 * 
 * import org.springframework.http.MediaType; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController; import
 * com.google.zxing.BarcodeFormat; import com.google.zxing.EncodeHintType;
 * import com.google.zxing.WriterException; import
 * com.google.zxing.client.j2se.MatrixToImageWriter; import
 * com.google.zxing.common.BitMatrix; import
 * com.google.zxing.qrcode.QRCodeWriter; import
 * com.google.zxing.qrcode.decoder.ErrorCorrectionLevel; import
 * com.itextpdf.text.Document; import com.itextpdf.text.DocumentException;
 * import com.itextpdf.text.Image; import com.itextpdf.text.PageSize; import
 * com.itextpdf.text.pdf.PdfWriter; import java.io.ByteArrayOutputStream; import
 * java.io.IOException; import java.util.HashMap; import java.util.Map;
 * 
 * @RestController public class QRCodePdfController {
 * 
 * @PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
 * public byte[] generateQRCodeAndPdf(@RequestBody UserData userData) throws
 * IOException, WriterException, DocumentException { ByteArrayOutputStream
 * pdfOutputStream = new ByteArrayOutputStream();
 * 
 * try { // Generate QR Code image int width = 200; int height = 200; String
 * qrCodeData = "Name: " + userData.getName() + "\nEmail: " +
 * userData.getEmail() + "\nSalary: " + userData.getSalary();
 * Map<EncodeHintType, Object> hints = new HashMap<>();
 * hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
 * QRCodeWriter qrCodeWriter = new QRCodeWriter(); BitMatrix bitMatrix =
 * qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, width, height, hints);
 * ByteArrayOutputStream qrCodeOutputStream = new ByteArrayOutputStream();
 * MatrixToImageWriter.writeToStream(bitMatrix, "PNG", qrCodeOutputStream);
 * 
 * // Generate PDF with QR Code image Document document = new
 * Document(PageSize.A4); PdfWriter.getInstance(document, pdfOutputStream);
 * document.open(); Image qrCodeImage =
 * Image.getInstance(qrCodeOutputStream.toByteArray());
 * qrCodeImage.scaleToFit(150, 150);
 * qrCodeImage.setAlignment(Image.ALIGN_CENTER); document.add(qrCodeImage);
 * document.close(); } catch (Exception e) { e.printStackTrace(); }
 * 
 * return pdfOutputStream.toByteArray(); } }
 */


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QRCodePdfController {

    @PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateQRCodeAndPdf(@RequestBody UserData userData) {
        try {
            // Generate PDF with QR Code image
            byte[] pdfBytes = generatePdfWithQRCode(userData);

            // Save PDF to a file
            String filePath ="C:\\Users\\LENOVO\\Desktop\\PDF_Saver\\generated_pdf.pdf";
            Files.write(Paths.get(filePath), pdfBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "generated_pdf.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private byte[] generatePdfWithQRCode(UserData userData) throws DocumentException, IOException, WriterException {
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
try {
            // Generate QR Code image
            int width = 400;
            int height = 400;
            String qrCodeData = "Name: " + userData.getName() + "\nEmail: " + userData.getEmail() + "\nSalary: " + userData.getSalary();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, width, height, hints);
            ByteArrayOutputStream qrCodeOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", qrCodeOutputStream);

            // Generate PDF with QR Code image
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, pdfOutputStream);
            document.open();
            Image qrCodeImage = Image.getInstance(qrCodeOutputStream.toByteArray());
            qrCodeImage.scaleToFit(150, 150);
            qrCodeImage.setAlignment(Image.ALIGN_CENTER);
            document.add(qrCodeImage);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfOutputStream.toByteArray();
    }
}
