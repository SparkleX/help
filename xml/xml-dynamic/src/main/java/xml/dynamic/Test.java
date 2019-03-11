package xml.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Test {

	static public void main(String[] argc) throws Exception {
		XMLOutputFactory xmlFactory = XMLOutputFactory.newInstance();
		
		XMLStreamWriter xmlWriter = xmlFactory.createXMLStreamWriter(System.out, "utf-8");
		xmlWriter.writeStartDocument();
		xmlWriter.writeStartElement("doc");
		List<Map<String, Object>> oList = new ArrayList<>();
		Map<String, Object> oMap = new HashMap<>();
		oMap.put("lineNum", 1);
		oMap.put("itemCode", "i001");
		
		oList.add(oMap);
		oList.add(oMap);

		XmlStreamWriterUtil.convertCollection(xmlWriter, "order",oList);
		xmlWriter.writeEndElement();
		xmlWriter.writeEndDocument();

		xmlWriter.flush();
	}

}
