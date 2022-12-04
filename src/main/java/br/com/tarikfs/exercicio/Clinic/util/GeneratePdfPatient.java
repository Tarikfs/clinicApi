package br.com.tarikfs.exercicio.Clinic.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.tarikfs.exercicio.Clinic.model.Patient;

public class GeneratePdfPatient {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfPatient.class);

    public static ByteArrayInputStream patientReport(List<Patient> patients) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(80);
            table.setWidths(new int[] { 6, 5, 3, 1, 4 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new com.itextpdf.text.Phrase("Patient ID", headFont));
            hcell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new com.itextpdf.text.Phrase("Name", headFont));
            hcell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new com.itextpdf.text.Phrase("Birthdate", headFont));
            hcell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new com.itextpdf.text.Phrase("Sex", headFont));
            hcell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new com.itextpdf.text.Phrase("Cpf", headFont));
            hcell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Patient patient : patients) {

                PdfPCell cell;

                cell = new PdfPCell(new com.itextpdf.text.Phrase(patient.getId().toString()));
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new com.itextpdf.text.Phrase(patient.getName()));
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new com.itextpdf.text.Phrase(patient.getBirthDate().toString()));
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(new com.itextpdf.text.Phrase(patient.getSex().toString()));
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(new com.itextpdf.text.Phrase(patient.getCpf()));
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                table.addCell(cell);

            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (Exception ex) {
            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
