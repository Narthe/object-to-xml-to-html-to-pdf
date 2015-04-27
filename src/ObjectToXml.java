import com.thoughtworks.xstream.XStream;

public class ObjectToXml {

	public static String serializeCourse(Course course){
		XStream xstream = new XStream();
		String xml = xstream.toXML(course);
		return xml;
	}
}
