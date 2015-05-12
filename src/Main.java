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
	    /*if (args.length != 3)
	    {
	        System.err.println("give command as follows : ");
	        System.err.println("XSLTTest data.xml converted.xsl converted.html");
	        return;
	    }*/
	    //String dataXML = "/home/local/users/jbrasseur/DEV/perso/PDF_export/data/FileOne.xml";
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

	    String inputXSL = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/template.xsl";
	    String outputHTML = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.html";
	    String outputxHTML = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.xhtml";
	    String outputPDF = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.pdf";
		/*
		String inputXSL = ".\\xml\\template.xsl";
		String outputHTML = ".\\xml\\output.html";
		String outputxHTML = ".\\xml\\output.xhtml";
	    String outputPDF = ".\\xml\\output.pdf";
	    */
		
	    XmlToHtml st = new XmlToHtml();
	    
	    st.transform(dataXML, inputXSL, outputxHTML);
	    
	    //String htmlString = readFile(outputHTML, StandardCharsets.UTF_8);
	    //String xhtmlString = convertHtmlToXhtml(htmlString);
	    
	    //writeFile(xhtmlString, outputxHTML);
	    //System.out.println(htmlString);
	    
	    HtmlToPDF.transform(outputxHTML, outputPDF);
	}
	/*
	public static String convertHtmlToXhtml(String html) {
        Tidy tidy = new Tidy(); 
        tidy.setXHTML(true); 
        tidy.setDocType("omit");
        InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(html.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        OutputStream outputStream = new ByteArrayOutputStream();
        tidy.parse(inputStream, outputStream); 
        return outputStream.toString();
    }*/
	
	public static String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
	public static void writeFile(String data, String outputFile)
	{
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
		    fWriter = new FileWriter(outputFile);
		    writer = new BufferedWriter(fWriter);
		    writer.write(data);
		    writer.close(); //make sure you close the writer object 
		} catch (Exception e) {
		  //catch any exceptions here
		}
	}
}
