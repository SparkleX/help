package xml.dynamic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XmlStreamWriterUtil 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void convertMap(XMLStreamWriter xmlWriter, Map<String,Object> map) throws XMLStreamException
	{
		for(Entry<String, Object> entry:map.entrySet())
		{
			Object value = entry.getValue();
			String key = entry.getKey();
			if(value==null)
			{
				continue;
			}
			if(value instanceof List)
			{
				convertCollection(xmlWriter, key, (List)value);
				continue;
			}
			xmlWriter.writeStartElement(key);
			xmlWriter.writeCharacters(value.toString());
			xmlWriter.writeEndElement();
		}
	}

	public static void convertCollection(XMLStreamWriter xmlWriter, String element, List<Map<String,Object>> list) throws XMLStreamException 
	{
		for(Map<String,Object> o:list)
		{
			xmlWriter.writeStartElement(element);
			convertMap(xmlWriter, o);
			xmlWriter.writeEndElement();
		}
		
	}
}
