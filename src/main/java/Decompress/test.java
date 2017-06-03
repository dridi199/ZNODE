package Decompress;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.sun.xml.internal.xsom.impl.util.Uri;

public class test {

	public static void main(String[] args) {
		Ahmed a= new Ahmed("dridi", "ahmed");
		System.out.println(a.getNom());
		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("bhc.properties"));
////			String thisLine = "";
////					try {
////						while ((thisLine = br.readLine()) != null) {
////						
////						    System.out.println(thisLine);
////						 }
////					} catch (IOException e) {
////						e.printStackTrace();
////					}   
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			FileInputStream fi = new FileInputStream("bhc.properties");
			Properties properties = new Properties();
			properties.load(fi);
//			System.out.println(properties.getProperty("contactsHdfsRawDir"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fi));
			String thisLine = "";
			while ((thisLine = br.readLine()) != null) {
			
			    System.out.println(thisLine);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Path path = new Paths.get("xmldoc");
//	      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	      this.xmlDocument = dBuilder.parse(fs.open(path));
//	      xmlDocument.getDocumentElement().normalize();
	}
}
