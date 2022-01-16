package application.nthenergy.core;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GeneratePdf {

    public static final String FILE_NAME = null;

    /**
     * This method is used to generate invoice pdf from the received data of invoice.
     *
     * @param customerData
     * @param gasData
     * @param elecData
     * @param fileName
     */
    public static void generateInvoicePdf(String[] customerData, String[] gasData, String[] elecData, String fileName) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));
            document.open();
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(18);
            Paragraph p = new Paragraph("Invoice Details - Northampton Energy Supplier", f);
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);
            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths = {2f, 2};
            table.setWidths(columnWidths);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Customer Details"));
            cell1.setPaddingLeft(10);
            cell1.setPaddingBottom(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell cell2 = new PdfPCell(new Paragraph("Gas & Electricity Charges"));
            cell2.setPaddingLeft(10);
            cell2.setPaddingBottom(20);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            //Add un-ordered list
            List customerDataList = new List(List.UNORDERED);
            for (int i = 0; i < customerData.length; i++) {
                customerDataList.add(new ListItem(customerData[i]+""));
            }
            List gasDataList = new List(List.UNORDERED);
            for (int i = 0; i < gasData.length; i++) {
                gasDataList.add(new ListItem(gasData[i]+""));
            }
            List elecDataList = new List(List.UNORDERED);
            for (int i = 0; i < elecData.length; i++) {
                elecDataList.add(new ListItem(elecData[i]+""));
            }
            cell1.addElement(customerDataList);
            cell2.addElement(gasDataList);
            cell2.addElement(elecDataList);
            table.addCell(cell1);
            table.addCell(cell2);
            document.add(table);
            document.close();
            writer.close();
            System.out.println("Done");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
