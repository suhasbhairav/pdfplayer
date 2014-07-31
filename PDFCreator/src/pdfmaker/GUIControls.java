package pdfmaker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class GUIControls{
	
	public static JFrame mainWindow = null;
	private static JPanel contentPanel = null;
	private static JMenuBar menuBar = null;
	private static JTabbedPane tabbedPane = null;
	public static JTextArea contentArea = null;
	private static JScrollPane contentScrollPane = null;
	private static MenuItemListener  menuItemListener = new MenuItemListener();
	private static JMenu fileMenu = null;
	private static JMenu helpMenu= null;
	public static String sContent = null;
	public static void prepareGUI(){
	
		CreateMainWindow();
		
	}
	
	public static JFrame CreateMainWindow(){
		mainWindow = new JFrame();
		mainWindow.setTitle("PDF Player");
		mainWindow.setSize(new Dimension(800,600));
		mainWindow.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		mainWindow.setJMenuBar(CreateMenuBar());
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainWindow.setLayout(new FlowLayout());
		mainWindow.setVisible(true);
		return mainWindow;
	}
	
	
	public static void CreateExtractedTextContent(String content){
		sContent = content;
		mainWindow.add(CreateContentPanel());
		contentArea.setText(sContent);		
		mainWindow.setVisible(true);
	}
	
	private static JPanel CreateContentPanel(){
		contentPanel = new JPanel();
		contentPanel.setSize(new Dimension(800,600));
		contentPanel.add(CreateScrollPane());
		contentPanel.setVisible(true);		
		return contentPanel;
	}
	private static JMenuBar CreateMenuBar(){
		menuBar = new JMenuBar();
		menuBar.add(CreateFileMenu());
		menuBar.add(CreateHelpMenu());
		
		return menuBar;
	}
	
	private static JMenu CreateFileMenu(){
		fileMenu = new JMenu("File");
		try{
			JMenuItem openPdf = new JMenuItem("Open PDF");
			openPdf.setActionCommand("ExtractTextFromPdf");
			openPdf.addActionListener(menuItemListener);
			openPdf.setVisible(true);
			
			JMenuItem saveAs = new JMenuItem("Save As");
			saveAs.setActionCommand("SaveAsExtractedText");
			saveAs.addActionListener(menuItemListener);
			saveAs.setVisible(true);
			
			JMenuItem quit = new JMenuItem("Quit");
			quit.setActionCommand("Quit");
			quit.addActionListener(menuItemListener);
			quit.setVisible(true);
			
			fileMenu.add(openPdf);
			fileMenu.add(saveAs);
			fileMenu.add(quit);
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		return fileMenu;
	}
	
	private static	JMenu CreateHelpMenu(){
		helpMenu = new JMenu("Help");
		try{
			JMenuItem about = new JMenuItem("About");
			about.setActionCommand("About");
			about.addActionListener(menuItemListener);
			about.setVisible(true);
			
			helpMenu.add(about);
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return helpMenu;
	}
	
	private static JTextArea CreateContentArea(){
		contentArea = new JTextArea();
		contentArea.setLineWrap(true);
		contentArea.setWrapStyleWord(true);
		
		contentArea.setSize(new Dimension(700,500));
		return contentArea;
	}
	private static JScrollPane CreateScrollPane(){
		contentScrollPane = new JScrollPane(CreateContentArea());
		contentScrollPane.setSize(new Dimension(750,550));
		contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		contentScrollPane.setVisible(true);
		return contentScrollPane;
	}
	
	
	
}

