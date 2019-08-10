package demo.spring.demospringmvc1.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import demo.spring.demospringmvc1.model.Product;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
@Component
public class PdfReport {

  public static ByteArrayInputStream productPdfViews(List<Product> products) {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    Document document = new Document();


    try {

      PdfPTable table = new PdfPTable(8);
      table.setWidthPercentage(80);
      table.setWidths(new int[]{1, 3, 3, 3, 3, 3, 3, 3});


      PdfPCell hcell;
      Font font = FontFactory.getFont(FontFactory.HELVETICA);

      hcell = new PdfPCell(new Phrase("Id", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Product Name", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);


      hcell = new PdfPCell(new Phrase("Quantity", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Price", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Description", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Last Updated", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Category Name", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);


      hcell = new PdfPCell(new Phrase("Last Posted", font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);


      for (Product product : products) {
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(product.getId().toString()));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(product.getName())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase(String.valueOf(product.getQuantity())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase(String.valueOf(product.getPrice())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase(String.valueOf(product.getDescription())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(product.getLastUpdated())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(product.getCategory().getName())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase(String.valueOf(product.getPrettyTime())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


      }

      PdfWriter.getInstance(document, out);
      document.open();

      document.add(table);

      document.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ByteArrayInputStream(out.toByteArray());
  }


}
