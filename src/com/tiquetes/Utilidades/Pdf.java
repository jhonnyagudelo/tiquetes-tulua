package com.tiquetes.Utilidades;

import com.tiquetes.Dao.QrDao;
import com.tiquetes.Modelos.Sesion;
import com.tiquetes.Modelos.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.printing.PDFPageable;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Pdf {
    private QrDao qrDao;
    private Sesion sesion;


    public Pdf(QrDao qrDao, Sesion sesion) {
        this.qrDao = qrDao;
        this.sesion = sesion;
    }

    public void printTicket() throws IOException, PrinterException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);
            java.util.Date date = new java.util.Date();
            DateFormat timeDate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setLeading(14.5f);
            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() + -5);

            String separator = "=================================";
            String title = "                  Tiquete de viaje ";
            String footer = "Gracias por tu preferencia";

            //agregar a la tirilla
            contentStream.showText(separator);
            contentStream.newLine();
            contentStream.showText(title);
            contentStream.newLine();
            contentStream.showText(separator);
            contentStream.newLine();
            contentStream.showText("Compañia: " + qrDao.datostiquete().getEstablecimiento());
            contentStream.newLine();
            contentStream.showText("Destino: " + qrDao.datostiquete().getDestino());
            contentStream.newLine();
            contentStream.showText("Taquilla: " + sesion.getNombre() + " " + sesion.getApellido());
            contentStream.newLine();
            contentStream.showText(footer);
            contentStream.newLine();
            contentStream.showText("                           " + timeDate.format(date));
            contentStream.newLine();

            contentStream.endText();

            // Image
            PDImageXObject image = PDImageXObject.createFromFile("Qr.png", document);
            contentStream.drawImage(image, 80, page.getMediaBox().getHeight() - 180, image.getWidth() / 9, image.getHeight() / 9);

            contentStream.close();
            document.save("document.pdf");
        }
        PDDocument document = PDDocument.load(new File("document.pdf"));
        PrinterJob job = PrinterJob.getPrinterJob();
        LOGGER.log(Level.INFO, "Mostrando el dialogo de impresion");
        if (job.printDialog() == true) {
            job.setPageable(new PDFPageable(document));
            LOGGER.log(Level.INFO, "Imprimiendo documento");
            job.print();
        }

    }

}
