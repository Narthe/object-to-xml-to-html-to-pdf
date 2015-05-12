import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;


public class HtmlToPDF {

	public static void transform(String htmlFile, String cssFile, String outputPDF) throws IOException, DocumentException
	{
		/**
		 * To add CSS see :
		 * https://github.com/valentin-nasta/itext-html-css-pdf-jsf-template/blob/master/iTextHtmlCssPdfJsf/src/main/java/app/SomeBean.java
		 */
		
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPDF));
		XMLWorkerHelper helper = XMLWorkerHelper.getInstance();
		
		// CSS
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        CssFile css = XMLWorkerHelper.getCSS(new FileInputStream(cssFile));
        cssResolver.addCss(css);
		
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlFile)); 
		document.close();
	}
}
