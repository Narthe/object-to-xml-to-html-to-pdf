
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
public class XmlToHtml {

    public void transform(String dataXML, String inputXSL, String outputHTML)
    //throws TransformerConfigurationException,
    //TransformerException
    {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(inputXSL);
        Transformer transformer = null;
		try {
			transformer = factory.newTransformer(xslStream);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File fOut = new File(outputHTML);
        if(fOut.exists() && !fOut.isDirectory())
        {
        	//StreamSource in = new StreamSource(dataXML);
        	Document coursesNode = null;
			try {
				coursesNode = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				        .parse(new InputSource(new StringReader(dataXML)));
			} catch (SAXException | IOException | ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	DOMSource sourcexml = new DOMSource(coursesNode);
            StreamResult out = new StreamResult(fOut);
        	System.out.printf("The file %s exists", outputHTML);
	        try {
				transformer.transform(sourcexml, out);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else
        {
        	System.out.printf("The file %s does not exist", outputHTML);
        }
        //System.out.println("The generated HTML file is:" + outputHTML);
    }
}