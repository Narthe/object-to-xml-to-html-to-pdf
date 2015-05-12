import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;


public class Main {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, DocumentException
	{
		Course course1 = new Course(0, 0, 26);
		Course course2 = new Course(1, 26, 36);
		Course course3 = new Course(2, 36, 59);
		Course course4 = new Course(3, 59, 154);
		Course course5 = new Course(4, 154, 176);
		
		ArrayList<Course> tab = new ArrayList<Course>();
		tab.add(course1);
		tab.add(course2);
		tab.add(course3);
		tab.add(course4);
		tab.add(course5);
		
		String coursesXml = "";
		for(Course course : tab) {
			coursesXml+= ObjectToXml.serializeCourse(course) + "\n";
		}
		String dataXML = "<Courses>\n" + coursesXml + "\n</Courses>";

	    /*
		String inputXSL = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/template.xsl";
	    String outputxHTML = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.xhtml";
	    String outputPDF = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.pdf";
	    */
		
		String inputXSL = ".\\xml\\template.xsl";
		String outputxHTML = ".\\xml\\output.xhtml";
	    String outputPDF = ".\\xml\\output.pdf";
	    
		
	    XmlToHtml st = new XmlToHtml();
	    
	    st.transform(dataXML, inputXSL, outputxHTML);
	    
	    //String htmlString = readFile(outputHTML, StandardCharsets.UTF_8);
	    //String xhtmlString = convertHtmlToXhtml(htmlString);
	    
	    //writeFile(xhtmlString, outputxHTML);
	    //System.out.println(htmlString);
	    
	    //HtmlToPDF.transform(outputxHTML, outputPDF);
	}

}
