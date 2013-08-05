/**
 Provided in 2013 TechLab Education

 The MIT License (MIT)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

@SuppressWarnings("serial")
/**
 * A simple text editor view.
 * @author (your name) 
 */
public class TextEditor extends JApplet implements ActionListener {
	private TextEditorModel model;

	// add components here
	private JTextField field;
	private JTextArea area;

	// Remember whether or not we have saved our work.
	private boolean saved = false;
	private String saveFile;

	/**
	 * Called by the browser or applet viewer to inform this JApplet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the start method is called.
	 */
	public void init() {
		// Create a model and view object.
		model = new TextEditorModel();
		// Set the size of this applet to the size that the view wants.
		this.setSize(new Dimension(500, 500));
		// Make a new content pane to organize what we put into the applet - since we only have
		// a JTextArea, we make a 1 x 1 grid to ensure the text area resizes to the entire window.
		this.setLayout(new GridLayout(1, 1));

		initializeComponents();
	}

	/**
	 * Initializes the components of this applet.
	 */
	public void initializeComponents() {
		// Initialize the buttons.
		JMenuBar bar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenuItem openitem = new JMenuItem("Open"); 
		openitem.setActionCommand("Open");
		openitem.addActionListener(this); 
		JMenuItem newitem = new JMenuItem("New");
		newitem.setActionCommand("New");
		newitem.addActionListener(this);
		JMenuItem quititem = new JMenuItem("Quit");
		quititem.setActionCommand("Quit");
		quititem.addActionListener(this);
		JMenuItem saveitem = new JMenuItem("Save");
		saveitem.setActionCommand("Save");
		saveitem.addActionListener(this);
		JMenuItem saveasitem = new JMenuItem("Save As");
		saveasitem.setActionCommand("Save As");
		saveasitem.addActionListener(this);
		JMenuItem clearitem = new JMenuItem("Clear");
		clearitem.setActionCommand("Clear");
		clearitem.addActionListener(this);
		bar.add(filemenu);
		filemenu.add(saveitem);
		filemenu.add(newitem);
		filemenu.add(quititem);
		filemenu.add(saveasitem);
		filemenu.add(openitem);
		filemenu.add(clearitem);
		setJMenuBar(bar);
		JMenu replaceMenu = new JMenu("Replace");
		JMenu removeMenu = new JMenu("Remove");
		removeMenu.add(createItem("Remove Profanity"));
		removeMenu.add(createItem("Remove Insults"));
		replaceMenu.add(removeMenu);
		replaceMenu.add(createItem("Shakespearean"));
		replaceMenu.add(createItem("Funny Names"));
		replaceMenu.add(createItem("Filter"));
		
		replaceMenu.add(createItem("Troll"));
		bar.add(replaceMenu);

		// Initializing a text area.
		area = new JTextArea(30, 30);
		JScrollPane pane = new JScrollPane(area);
		add(pane);
	}

	public JMenuItem createItem(String name){
		JMenuItem item = new JMenuItem(name);
		item.setActionCommand(name);
		item.addActionListener(this);
		return item;

	}

	/**
	 * This method is called whenever a component with an action value is
	 * activated.
	 */
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == field) {
			// Then our text field is sending us data.
		}
		else {
			// Otherwise, some other component is sending us data.
			String action = a.getActionCommand();
			if (action.equals("New")) {
				if(!saved){
					int result = JOptionPane.showConfirmDialog(this, "Would you like to save?");
					if(result == JOptionPane.YES_OPTION ){
						JFileChooser chooser = new JFileChooser();
						chooser.showSaveDialog(this);
						String fileName = chooser.getSelectedFile().getAbsolutePath();
						model.saveFile(fileName, area.getText());
						saved  = true;
						saveFile = fileName;

					}
					if(result == JOptionPane.NO_OPTION){
						area.setText("");

					}
					if(result == JOptionPane.CANCEL_OPTION){


					}
					else{
						saved = false;
						area.setText("");
					}

				}
			}
			// Get the file name to open, then set the text area to the contents.
			if (action.equals("Open")) {
				JFileChooser filechooser = new JFileChooser();
				filechooser.showOpenDialog(this);
				String fileName = filechooser.getSelectedFile().getAbsolutePath();
				String contents = model.openFile(fileName);
				area.setText(contents);
			}
			// Save the contents of the text area to a file, making a new file if necessary.
			if (action.equals("Save")) {
				// Your code here.
				if(saved == false){
					if(saved == false){
						JFileChooser chooser = new JFileChooser();
						chooser.showSaveDialog(this);
						String fileName = chooser.getSelectedFile().getAbsolutePath();
						model.saveFile(fileName, area.getText());
						saved  = true;
						saveFile = fileName;

					}
					else{
						model.saveFile(saveFile, area.getText());
					}
				}
			}
			// Saves the contents of the text area to a new file, even if it has already been saved.
			if (action.equals("Save As")) {
				JFileChooser chooser = new JFileChooser();
				if(chooser.getSelectedFile() != null){
					chooser.showSaveDialog(this);
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					model.saveFile(fileName, area.getText());
					saved  = true;
					saveFile = fileName;
				}
			}
			// Clears the text editor.
			if (action.equals("Clear")) {
				// Your code here.
			}
			if (action.equals("Quit")){
				destroy();
				stop();



			}

			if(action.equals("Remove Profanity")){
				String text = area.getText();
				text = text.replaceAll("\\bheck\\b", "balls");
				text = text.replaceAll("\\bdarn\\b", "hoo ha");

				area.setText(text);
			
				
				
			}
			if(action.equals("Filter")){
				String text = area.getText();
				text = text.replaceAll("tr(ol)+", "troll");
				text = text.replaceAll("a+h+", "ah");
				area.setText(text);
			}
			if(action.equals("Shakespearean")){
				String text = area.getText();
				text = text.replaceAll("\\b(\\w+)\\b", "$1eth");
				text = text.replaceAll("\\bareeth\\b", "art");
				text = text.replaceAll("\\byoueth\\b", "thou");
				text = text.replaceAll("\\byoureth\\b", "thine");
				area.setText(text);


			}
			
			if(action.equals("Remove Insults")){
				String text = area.getText();
				text = text.replaceAll("(?i)you are (stupid|dumb|stupid and dumb)", "you are quite intelligent and not $1");
				text = text.replaceAll("(?i)you are (bad|terrible|sucky) at (\\w+)", "you are not $1 at $2");
				area.setText(text);
				
				
				
			}
			if(action.equals("Troll")){
				String text = area.getText();
				text = text.replaceAll("\\b\\w+\\b", "TROLL" +
						"");
				area.setText(text);
								
				
			}
			
		}

	}

}
