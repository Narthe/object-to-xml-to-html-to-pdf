import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.tool.xml.XMLWorkerHelper;


public class HtmlToPDF {

	public static void transform(String htmlFile, String outputPDF) throws IOException, DocumentException
	{
		/**
		 * To add CSS see :
		 * https://github.com/valentin-nasta/itext-html-css-pdf-jsf-template/blob/master/iTextHtmlCssPdfJsf/src/main/java/app/SomeBean.java
		 */
		
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPDF));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlFile)); 
		document.close();
	}
}
