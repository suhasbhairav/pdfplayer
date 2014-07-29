package pdfmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e){
		String sEvent = e.getActionCommand().toUpperCase();
		switch(sEvent){
		case "EXTRACTTEXTFROMPDF":
			break;
			
		default:
			break;
			
		}
		
		
	}

}
