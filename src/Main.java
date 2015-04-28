import java.util.ArrayList;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;


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
	    String inputXSL = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/FileTwo.xsl";
	    String outputHTML = "/home/local/users/jbrasseur/DEV/perso/object-to-xml-to-html-to-pdf/xml/output.html";
		
		//String inputXSL = ".\\xml\\FileTwo.xsl";
		//String outputHTML = ".\\xml\\output.html";
		
	    XmlToHtml st = new XmlToHtml();
	    
	    st.transform(dataXML, inputXSL, outputHTML);
	}
}
