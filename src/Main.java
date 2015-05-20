import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		String startDate = "01/05/2015";
		String endDate = "31/06/2015";
		Integer distance = 548;
		
		String startDateXml = String.format("<start_date>%s</start_date>\n", startDate);
		String endDateXml = String.format("<end_date>%s</end_date>\n", startDate);
		String distanceXml = String.format("<distance>%d</distance>\n", distance);
		String coursesXml = "";
		for(Course course : tab) {
			coursesXml+= ObjectToXml.serializeCourse(course) + "\n";
		}
		String dataXML = "<Courses>\n" + startDateXml + endDateXml + distanceXml + coursesXml + "\n</Courses>";

	    System.out.println(dataXML);
		String inputXSL = "./templates/template.xsl";
		String inputCSS = "./templates/style.css";
	    String outputxHTML = "./output/output.xhtml";
	    String outputPDF = "./output/output.pdf";
	    
		
//		String inputXSL = ".\\templates\\template.xsl";
//		String inputCSS = ".\\templates\\style.css";
//		String outputxHTML = ".\\output\\output.xhtml";
//	    String outputPDF = ".\\output\\output.pdf";
	    
	    File css = new File(inputCSS);
        if (!css.exists())
        {
        	throw new FileNotFoundException();
        }
		
        // XML to xHTML
	    XmlToHtml st = new XmlToHtml();
	    st.transform(dataXML, inputXSL, outputxHTML);
	    
	    FileInputStream outputxHTMLStream = new FileInputStream(outputxHTML);
	    
	    // xHTML to PDF
	    HtmlToPDF.transform(outputxHTMLStream, inputCSS, outputPDF);
	}

}
