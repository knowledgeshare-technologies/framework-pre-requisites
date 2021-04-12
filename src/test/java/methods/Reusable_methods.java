package methods;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.IIOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class Reusable_methods 
{
		
	public static void captureScreenshot(String screenshotName,WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		
		try {
		File dest=new File(System.getProperty("user.dir") + "\\TestResults\\" +screenshotName + ".jpg");
		FileUtils.copyFile(src, dest);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	public static void saveScreenshotsToWordDocument(String documentName, String[] screenshotNames) throws IOException, XmlException 
	{
		System.out.println("Document Name is : " + documentName);
		System.out.println("Image File name : " +screenshotNames[0] );
		System.out.println("Image File name : " +screenshotNames[1] );
		
		//Create Instance for document, paragraphs, Styles	
		XWPFDocument doc=new XWPFDocument();// document object
		XWPFParagraph p=doc.createParagraph();//paragraph allignments, borders
		XWPFRun r=p.createRun();//Set font styles, colors, next line
		
		//Header and Footer obj
		CTSectPr sectPr=doc.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy policy=new XWPFHeaderFooterPolicy(doc,sectPr);
		
		// Creating Header objects
		CTP ctpHeader=CTP.Factory.newInstance();
		CTR ctrHeader=ctpHeader.addNewR();
		CTText ctHeader=ctrHeader.addNewT();
		
		// Alignments and color, styles of the header in the word doc -- Header
		XWPFParagraph headerParagraph=new XWPFParagraph(ctpHeader,doc);
		XWPFRun headerRun=headerParagraph.createRun();
		
		//Setting Header
		headerParagraph.setAlignment(ParagraphAlignment.LEFT);
		headerRun.setFontSize(10);
		headerRun.setColor("808000");
		headerRun.setText("Knowledge Share - Regression Test Results");
		headerRun.addBreak();
		String curr_date=getCurrentDate("yyyy-MM-dd-hh:mm:ss");
		headerRun.setText(curr_date);
		
		//Parse
		XWPFParagraph[] parsHeader=new XWPFParagraph[1];
		parsHeader[0]= headerParagraph;
		policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT,parsHeader);
		
		//Create Footer Objects
		CTP ctpFooter=CTP.Factory.newInstance();
		CTR ctrFooter=ctpFooter.addNewR();
		CTText ctFooter=ctrFooter.addNewT();
		
		//Setting Footer
		String footerText="© 2021. Confidential - Do not Share this documents.";
		ctFooter.setStringValue(footerText);	
		
		// Alignments and color, styles of the header in the word doc -- Footer
		XWPFParagraph footerparagraph = new XWPFParagraph(ctpFooter,doc);
		footerparagraph.setAlignment(ParagraphAlignment.LEFT);
		
		//Parse
		XWPFParagraph[] parsFooter=new XWPFParagraph[1];
		parsFooter[0]= footerparagraph;
		policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT,parsFooter);//Corrected to Footer
		
		//Title in the center ( Test Scenraio Name )
		p.setAlignment(ParagraphAlignment.CENTER);
		r.setBold(true);
		r.setFontFamily("Verdana");
		r.setText(documentName);
		r.addBreak();
		BufferedImage bimg1;
		
		for (String file : screenshotNames) {
			
			
			try {
				
					File dest = new File(System.getProperty("user.dir") + "\\TestResults\\" + file + ".jpg");
					bimg1 = ImageIO.read(dest);
	
					int width = 500;
					int height = 280;
	
					String imgFile = dest.getName();
					int imgFormat = getImageFormat(imgFile);
	
					r.addBreak();
					r.addBreak();
	
					r.setText(file);
					r.addPicture(new FileInputStream(dest), imgFormat, imgFile, Units.toEMU(width), Units.toEMU(height));
				
				}
			catch(Exception e)
			{
				continue;
			}
			
			
			FileOutputStream out=new FileOutputStream(System.getProperty("user.dir")+ "\\TestResults\\" +  documentName + ".doc");
			doc.write(out);
			out.close();
			
		}
		System.out.println("Word document with screenshots created successfully");
	}
		

	private static int getImageFormat(String imgFileName) 
	{
		int format;
		 if (imgFileName.endsWith(".emf"))
		  format = XWPFDocument.PICTURE_TYPE_EMF;
		 else if (imgFileName.endsWith(".wmf"))
		  format = XWPFDocument.PICTURE_TYPE_WMF;
		 else if (imgFileName.endsWith(".pict"))
		  format = XWPFDocument.PICTURE_TYPE_PICT;
		 else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
		  format = XWPFDocument.PICTURE_TYPE_JPEG;
		 else if (imgFileName.endsWith(".png"))
		  format = XWPFDocument.PICTURE_TYPE_PNG;
		 else if (imgFileName.endsWith(".dib"))
		  format = XWPFDocument.PICTURE_TYPE_DIB;
		 else if (imgFileName.endsWith(".gif"))
		  format = XWPFDocument.PICTURE_TYPE_GIF;
		 else if (imgFileName.endsWith(".tiff"))
		  format = XWPFDocument.PICTURE_TYPE_TIFF;
		 else if (imgFileName.endsWith(".eps"))
		  format = XWPFDocument.PICTURE_TYPE_EPS;
		 else if (imgFileName.endsWith(".bmp"))
		  format = XWPFDocument.PICTURE_TYPE_BMP;
		 else if (imgFileName.endsWith(".wpg"))
		  format = XWPFDocument.PICTURE_TYPE_WPG;
		 else {
		  return 0;
		 }
		 return format;
	}

	private static String getCurrentDate(String format) 
	{
		DateFormat dateformat=new SimpleDateFormat(format);
		Date date=new Date();
		return dateformat.format(date);
		
	}
}
