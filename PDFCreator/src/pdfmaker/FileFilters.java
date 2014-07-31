package pdfmaker;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilters extends FileFilter {

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		String filename = file.getName();
		
		return filename.endsWith(".pdf");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "*.pdf";
	}

}
