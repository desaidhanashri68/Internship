package com.oit;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @GetMapping("/generate")
    public void generateDynamicPdf(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=dynamic_example.pdf");

        OutputStream outputStream = response.getOutputStream();
        Document document = new Document();

        PdfWriter.getInstance(document, outputStream);
        document.open();

        List<Person> people = getPeopleData(); // Replace with your data retrieval logic

        for (Person person : people) {
            document.add(new Paragraph("Name: " + person.getName()));
            document.add(new Paragraph("Age: " + person.getAge()));
            document.add(new Paragraph("------------------------------"));
        }

        document.close();
        outputStream.flush();
    }

    // Simulate data retrieval
    private List<Person> getPeopleData() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 28));
        return people;
    }
}
