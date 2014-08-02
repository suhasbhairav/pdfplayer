package pdfmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.*;

@SuppressWarnings("unused")
public class MenuItemListener implements ActionListener {
	
	private static JFileChooser openFile = new JFileChooser(new File("."));
	private static JFileChooser saveAsFile = new JFileChooser(new File("."));
	
	public static void InitializeFileFilters(){
		openFile.addChoosableFileFilter(new FileFilters());
	}
	
	public void actionPerformed(ActionEvent e){
		String sEvent = e.getActionCommand().toUpperCase();
		switch(sEvent){
		case "EXTRACTTEXTFROMPDF":			
			openFile.showOpenDialog(null);
			if(openFile.getSelectedFile()!=null){				
				if(GUIControls.CheckExistenceOfContentPanel()==false){
				GUIControls.CreateExtractedTextContent(PDFExtractor.TextExtract(openFile.getSelectedFile().getAbsolutePath().toString()));			
				
				}
				else{
					
					GUIControls.SetContentArea(PDFExtractor.TextExtract(openFile.getSelectedFile().getAbsolutePath().toString()));
				}
			}
			break;
		case "SAVEASEXTRACTEDTEXT":
				if(GUIControls.CheckContentAreaExistence()!=false){
				saveAsFile.setDialogTitle("Save As");
				int userSave = saveAsFile.showSaveDialog(GUIControls.mainWindow);
				if(userSave==JFileChooser.APPROVE_OPTION)
				{
					File fileSave = saveAsFile.getSelectedFile();
					PrintWriter writer=null;
					try {
						if(fileSave.getAbsolutePath()==null)
						{
							CreateNewFile(fileSave.getAbsolutePath());
						}
						writer = new PrintWriter(fileSave.getAbsolutePath(),"UTF-8");
					
						} catch (FileNotFoundException
							| UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					writer.println(GUIControls.GetExtractedText());
					writer.close();
				}
				}else{
					GUIControls.CreateAlertBox("Open a pdf file before trying to save...");
					
				}
			break;
		case "VIEWPDF":			
			break;
		case "QUIT":			
			GUIControls.mainWindow.dispose();
			break;
		case "ABOUT":
			GUIControls.CreateAlertBox("PDF Player v0.1");
		default:
			break;
			
		}		
	}	
	private static File CreateNewFile(String fName){
		File fNew = new File(fName);
		return fNew;
	}
}
