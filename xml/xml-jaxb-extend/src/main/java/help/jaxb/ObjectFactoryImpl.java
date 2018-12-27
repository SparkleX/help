package help.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import help.jaxb.Column;
import help.jaxb.ObjectFactory;
import help.jaxb.Table;

@XmlRegistry
public class ObjectFactoryImpl extends ObjectFactory
{
	public TableImpl createTable() 
    {
		System.out.println("createTable");
        return new TableImpl();
    }

	public ColumnImpl createColumn() 
	{
		System.out.println("createColumn");
        return new ColumnImpl();
    }
	
 /*   @XmlElementDecl(namespace = "urn:test:test", name = "column")
    public JAXBElement<ColumnImpl> createColumn(ColumnImpl value) 
    {
    	System.out.println("JAXBElement:createColumn");
        return new JAXBElement<ColumnImpl>(new QName("urn:test:test","column"), ColumnImpl.class, null, value);
    }
    
    @XmlElementDecl(namespace = "urn:test:test", name = "table")
    public JAXBElement<TableImpl> createTable(TableImpl value) 
    {
    	System.out.println("JAXBElement:createTable");
        return new JAXBElement<TableImpl>(new QName("urn:test:test","table"), TableImpl.class, null, value);
    }*/
}
