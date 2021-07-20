package dumps;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLWrite {

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
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElementNS("https://www.journaldev.com/employee", "Employees");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getEmployee((Document) doc, "1", "Pankaj", "29", "Java Developer", "Male"));

            //append second child
            rootElement.appendChild(getEmployee((Document) doc, "2", "Lisa", "35", "Manager", "Female"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("E:\\XMLTest\\Environments.xml"));
            //File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "Environments" + ".xml");

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	 private static Node getEmployee(Document doc, String id, String name, String age, String role,
	            String gender) {
	        Element employee = ((org.w3c.dom.Document) doc).createElement("Employee");

	        //set id attribute
	        employee.setAttribute("id", id);

	        //create name element
	        employee.appendChild(getEmployeeElements(doc, employee, "name", name));

	        //create age element
	        employee.appendChild(getEmployeeElements(doc, employee, "age", age));

	        //create role element
	        employee.appendChild(getEmployeeElements(doc, employee, "role", role));

	        //create gender element
	        employee.appendChild(getEmployeeElements(doc, employee, "gender", gender));

	        return employee;
	}
	//utility method to create text node
	    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
	        Element node = ((org.w3c.dom.Document) doc).createElement(name);
	        node.appendChild(((org.w3c.dom.Document) doc).createTextNode(value));
	        return node;
	    }
}
