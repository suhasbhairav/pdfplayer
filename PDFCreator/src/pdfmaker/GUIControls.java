package pdfmaker;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIControls {
	
	private static JFrame mainWindow=null;
	private static JPanel mainPanel=null;
	private static JMenuBar menuBar = null;
	private static JMenu fileMenu = null;
	private static JMenu helpMenu = null;
	private static MenuItemListener menuItemListener = new MenuItemListener();
	public static void prepareGUI(){
		mainWindow = new JFrame();
		mainWindow.setTitle("PDF Player");
		mainWindow.setSize(400, 400);
		mainWindow.setVisible(true);
		mainWindow.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);				
			}
			
		});
		mainWindow.add(menuBar);
	}
	
	private static JMenu CreateFileMenu(){
		fileMenu = new JMenu("File");
		try{
			JMenuItem newExtractText = new JMenuItem("Extract Text From PDF");
			newExtractText.setActionCommand("ExtractTextFromPdf");
			newExtractText.addActionListener(menuItemListener);
			
			JMenuItem quit = new JMenuItem("Quit");
			quit.setActionCommand("Quit");
			quit.addActionListener(menuItemListener);
			
			fileMenu.add(newExtractText);
			fileMenu.add(quit);
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return fileMenu;
	}
	
	private static JMenu CreateHelpMenu(){
		helpMenu = new JMenu("Help");
		try{
			JMenuItem about = new JMenuItem("About");
			about.setActionCommand("About");
			about.addActionListener(menuItemListener);			
			
			helpMenu.add(about);
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		return helpMenu;
	}
	
	private static JMenuBar menuBar(){
		menuBar = new JMenuBar();		
		menuBar.add(CreateFileMenu());
		menuBar.add(CreateHelpMenu());
		menuBar.setVisible(true);
		return menuBar;
	}

}
