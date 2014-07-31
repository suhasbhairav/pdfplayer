package pdfmaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class PDFExtractor {
	private  PDFParser pdfParse= null;
	private  PDDocument pdDoc= null;
	private  COSDocument cosDoc = null;
	private  PDFTextStripper pdfStripper = null;
	private static File file = null;
	private static String sExtractedContent = null;
	@SuppressWarnings("unused")
	public static String TextExtract(String fileName){	
		PDFExtractor pdOb = new PDFExtractor();
		try {
			file = new File(fileName);
			pdOb.pdfParse = new PDFParser(new FileInputStream(file));
			pdOb.pdfParse.parse();
			pdOb.cosDoc = pdOb.pdfParse.getDocument();
			pdOb.pdfStripper = new PDFTextStripper();
			pdOb.pdDoc = new PDDocument(pdOb.cosDoc);
			sExtractedContent =pdOb.pdfStripper.getText(pdOb.pdDoc);
			pdOb.cosDoc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sExtractedContent;
	}

	

}
