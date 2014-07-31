package pdfmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

@SuppressWarnings("unused")
public class MenuItemListener implements ActionListener {
	
	private static JFileChooser openFile = new JFileChooser(new File("."));
	private static JFileChooser saveAsFile = new JFileChooser(new File("."));
	
	public void actionPerformed(ActionEvent e){
		String sEvent = e.getActionCommand().toUpperCase();
		switch(sEvent){
		case "EXTRACTTEXTFROMPDF":
			openFile.addChoosableFileFilter(new FileFilters());
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
				saveAsFile.setDialogTitle("Save As");
				int userSave = saveAsFile.showSaveDialog(GUIControls.mainWindow);
				if(userSave==JFileChooser.APPROVE_OPTION)
				{
					File fileSave = saveAsFile.getSelectedFile();
					PrintWriter writer=null;
					try {
						writer = new PrintWriter(fileSave.getAbsolutePath(),"UTF-8");
					} catch (FileNotFoundException
							| UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					writer.println(GUIControls.GetExtractedText());
					writer.close();
				}
			break;
		case "QUIT":
			break;
		default:
			break;
			
		}		
	}
}
