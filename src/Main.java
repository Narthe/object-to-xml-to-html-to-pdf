import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.tidy.Tidy;


public class Main {

	public static void main(String[] args)
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
		//System.out.println(dataXML);
		//System.exit(1);
	    String inputXSL = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/template.xsl";
	    String outputHTML = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.html";
	    String outputPDF = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.pdf";
		//String inputXSL = ".\\xml\\template.xsl";
		//String outputHTML = ".\\xml\\output.html";
	    //String outputPDF = ".\\xml\\output.pdf";
		
	    XmlToHtml st = new XmlToHtml();
	    
	    st.transform(dataXML, inputXSL, outputHTML);
	    
	    InputStream inputStream = new StringBufferInputStream(outputHTML);
	    String htmlString = IOUtils.toString(outputHTML);
	    
	    try {
			HtmlToPDF.transform(outputHTML, outputPDF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String convertHtmlToXhtml(String html) {
        Tidy tidy = new Tidy(); 
        tidy.setXHTML(true); 
        tidy.setDocType("omit");
        InputStream inputStream = new StringBufferInputStream(html);
        OutputStream outputStream = new ByteArrayOutputStream();
        tidy.parse(inputStream, outputStream); 
        return outputStream.toString();
    }
}
