

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import junit.framework.Assert;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class ReadXMLFile {

	public static void main(String[] args) 
	
	{
		 
		System.setProperty("ExecutionEnv", "prod");
		String web_url=ReadXMLFile.getTestData("WEB", "application_url");
		//String db_url=ReadXMLFile.getTestData("DB", "DB_Conn_String");
		System.out.println("WEB URL is : " + web_url);

	}
	
	@SuppressWarnings("deprecation")
	public static String getTestData(String SectionName, String NodeName) 
	 {
		 String env= System.getProperty("ExecutionEnv");	
		 String path = "Project/"+SectionName+"/"+ env+ "/" + NodeName;
		
		 //File fXmlFile=new File(System.getProperty("user.dir") + "\\TestData\\" + "Environments" + ".xml"); 
		 File XmlFile = new File("Environments.xml");
		 String foundData = null;

		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
		 DocumentBuilder dBuilder;//Defines the API to obtain DOM Document instances from an XML document. Using this class, an application programmer can obtain a Document from XML.
		 Document doc;//Interface - The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data.The goal for this interface is to scale from very simple needs (a plain text textfield) to complex needs (an HTML or XML document, for example).
		 NodeList nodeList; //Interface - The NodeList interface provides the abstraction of an ordered collection of nodes, without defining or constraining how this collection is implemented. NodeList objects in the DOM are live.
		 Node node;//Interface - The Node interface is the primary datatype for the entire Document Object Model. It represents a single node in the document tree.
		 XPath xPath;// Interface - XPath provides access to the XPath evaluation environment and expressions.
		 
		 try 
		 {
			 dBuilder = dbFactory.newDocumentBuilder();
			 doc = dBuilder.parse(XmlFile);
			 doc.getDocumentElement().normalize();
			 xPath = XPathFactory.newInstance().newXPath();
			 nodeList = (NodeList) xPath.compile(path).evaluate(doc, XPathConstants.NODESET);
		 } 
		 catch (Exception e)
		 {
			 Assert.fail("Exception reading Environments.xml [" + e.getMessage()+ "]");
			 return null;
		 }
		 for (int temp = 0; temp < nodeList.getLength(); temp++)
		 {

			 node = nodeList.item(temp);
			 if (node.getNodeName().equals(NodeName)) 
			 {
				 foundData = node.getTextContent().trim();
			 }
		 }
			 Assert.assertNotNull("Failed to find data in Environments.xml for [" + path + "]", foundData);
			 //System.out.println("Found Data : "   + foundData);
			 return foundData;
		 }

}
