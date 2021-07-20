package xml_Read_Write;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSystemColorImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	public static void main(String[] args) 
	{
		System.setProperty("ExecutionEnv", "stage");
		String web_url=ReadXML.getTestData("WEB","application_url");
		
		System.out.println("Recieved Web URL is : " + web_url);

		System.setProperty("ExecutionEnv", "stage");
		String db_url=ReadXML.getTestData("DB", "DB_Conn_String");
		
		System.out.println("Recieved DB URL is : " + db_url );
		
		/*
		 * WebDriver driver = null; driver.get(db_url);
		 */
		
	}

	private static String getTestData(String SectionName, String NodeName) 
	{
	
		String env=System.getProperty("ExecutionEnv");
		//System.out.println("Environment is :" + env );
		String path ="Project/"+SectionName+"/"+env+"/"+NodeName;
		//System.out.println("Path is : " +path );
		
		File XmlFile=new File("Environments.xml");
		String final_value = null;
		
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc;
		NodeList nodeList;
		Node node;
		XPath xPath;
		
		try
		{
				dBuilder=dbFactory.newDocumentBuilder();
				doc=dBuilder.parse(XmlFile);
				doc.getDocumentElement().normalize();
				xPath=XPathFactory.newInstance().newXPath();
				nodeList=(NodeList) xPath.compile(path).evaluate(doc, XPathConstants.NODESET);
		}
		catch(Exception e)
		{
			return null;
		}
		
		for(int temp=0;temp<nodeList.getLength();temp++)
		{
			node=nodeList.item(temp);
			if(node.getNodeName().equals(NodeName))
			{
				final_value=node.getTextContent().trim();
			}
		}
		
		
		
		return final_value;
	}

}
