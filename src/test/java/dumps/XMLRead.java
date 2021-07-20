package dumps;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

//import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Assert;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XMLRead {

	public static void main(String[] args) throws DocumentException 
	{	
		/*
		 * File file=new File(System.getProperty("user.dir") +
		 * "\\TestData\\" + "Environments" + ".xml"); SAXReader saxReader = new
		 * SAXReader(); Document document = saxReader.read(file); String
		 * dev_application_url =
		 * document.selectSingleNode("//environments/dev/application_url").getText();
		 * String qa_application_url =
		 * document.selectSingleNode("//environments/qa/application_url").getText();
		 * String stg_application_url =
		 * document.selectSingleNode("//environments/stage/application_url").getText();
		 * System.out.println("DEV URL : " + dev_application_url);
		 * System.out.println("QA URL : " + qa_application_url);
		 * System.out.println("STAGE URL : " + stg_application_url);
		 */
        
        
        
        System.setProperty("environment", "qa");
        String env=System.getProperty("environment");
        String path="evironments/app_ui/" + env + "/" + "application_url";
               
        String final_value = null;
        //File xmlpath=new File("E:\\My Projects WorkSpace\\WorkSpace_November_2020\\framework.prerequisites\\Environments.xml");
        File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "Environments" + ".xml"); 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        NodeList nodeList = null;
        Document doc;
        
        try
        {
        	dBuilder=dbFactory.newDocumentBuilder();
        	doc=dBuilder.parse(file);
        	doc.getDocumentElement().normalize();
        	javax.xml.xpath.XPath XPath =XPathFactory.newInstance().newXPath();
        	nodeList=(NodeList) XPath.compile(path).evaluate(doc, XPathConstants.NODESET);
   	
        }
        catch(Exception e)
        {
        	Assert.fail("Exception reading TestData.xml [" +e.getMessage() + "]");
        	final_value=null;
        }
        
        for(int temp=0;temp<nodeList.getLength();temp++)
        {
        	
        	Node nNode=nodeList.item(temp);
        	if(nNode.getNodeName().equals("application_url"))
        	{
        		final_value=nNode.getTextContent().trim();
        		
        	}
        }
        
        Assert.assertNotNull("Failed to Load", final_value);
        System.out.println("Final Value  :" + final_value);
        
        
  
	
	}

}
