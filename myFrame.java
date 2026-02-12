/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menubarexample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JFileChooser;

/**
 *
 * @author trujilloartunduaga
 */
public class myFrame extends JFrame implements ActionListener{
        
        
        JMenuBar menuBar;
        JMenu fileMenu, editMenu, helpMenu;
        JMenuItem loadItem, saveItem, saveAsItem, exitItem, aboutItem, cutItem, copyItem, pasteItem;
        JTextArea areaText;
        JScrollPane scroll;
        JFileChooser fileChooser;
        File currentFile;
        
        
        myFrame() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500,500);
            this.setLayout(new BorderLayout());
            this.setTitle("Blog de notas");
                  
            // Menubar
            menuBar = new JMenuBar();
            
            // Text 
            areaText = new JTextArea();
            areaText.setFont(new Font("Consolas", Font.PLAIN, 16));
            areaText.setLineWrap(true);
            areaText.setWrapStyleWord(true);

            // Colores para el text
            areaText.setBackground(new Color(245, 245, 245));
            areaText.setForeground(Color.DARK_GRAY);
            areaText.setCaretColor(Color.BLACK);

            // Margen interno
            areaText.setMargin(new java.awt.Insets(10, 10, 10, 10));
            
            // Scroll
            scroll = new JScrollPane(areaText);

            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
            // Menu
            fileMenu = new JMenu("File");
            editMenu = new JMenu("Edit");
            helpMenu = new JMenu("Help");
            
            // MenuItem
            loadItem = new JMenuItem("Load");
            saveItem = new JMenuItem("Save");
            saveAsItem = new JMenuItem("Save As");
            exitItem = new JMenuItem("Exit");
            aboutItem = new JMenuItem("About");
            cutItem = new JMenuItem("Cut");
            copyItem = new JMenuItem("Copy");
            pasteItem = new JMenuItem("Paste");
       
            
            // Action for the items
            loadItem.addActionListener(this);
            saveItem.addActionListener(this);
            saveAsItem.addActionListener(this);
            exitItem.addActionListener(this);
            aboutItem.addActionListener(this);
            cutItem.addActionListener(e -> areaText.cut());
            copyItem.addActionListener(e -> areaText.copy());
            pasteItem.addActionListener(e -> areaText.paste());
            
            fileMenu.setMnemonic(KeyEvent.VK_F);  
            editMenu.setMnemonic(KeyEvent.VK_E);
            helpMenu.setMnemonic(KeyEvent.VK_H); 
            
            loadItem.setMnemonic(KeyEvent.VK_L); // l for load
            saveItem.setMnemonic(KeyEvent.VK_S); // s for save
            exitItem.setMnemonic(KeyEvent.VK_Q); // q for exit
            
            cutItem.setMnemonic(KeyEvent.VK_X);
            copyItem.setMnemonic(KeyEvent.VK_C);
            pasteItem.setMnemonic(KeyEvent.VK_P);
            
            copyItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)
            );
            
            cutItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)
            );
            
            pasteItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK)
            );
            
            fileMenu.add(loadItem);
            fileMenu.add(saveItem);
            fileMenu.add(saveAsItem);
            fileMenu.add(exitItem);
            helpMenu.add(aboutItem);
            
            editMenu.add(cutItem);
            editMenu.add(copyItem);
            editMenu.add(pasteItem);
            
            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(helpMenu);
            
            
            // Frame
            this.add(scroll, BorderLayout.CENTER);
            this.setJMenuBar(menuBar);
            this.setVisible(true);
            
            
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == loadItem){
             try {
                 loadFile();
             } catch (IOException ex) {
                 System.getLogger(myFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             }
         }
         
        if(e.getSource() == saveAsItem){
             saveAsFile();
        }
        
        if(e.getSource() == saveItem){
             save();
        }
        
        if(e.getSource() == exitItem){
               dispose();
         }
        
        if(e.getSource() == aboutItem){
               JOptionPane.showMessageDialog(
        null,
        "Editor de Texto\n" +
        "Versión 1.0\n\n" +
        "Desarrollado por: Niko\n" +
        "Java + Swing\n" +
        "2026",
        "Acerca de",
        JOptionPane.INFORMATION_MESSAGE
    );
         }
    }
    
    
    // Open the file 
    public void loadFile() throws IOException{
           fileChooser = new JFileChooser();
           fileChooser.setCurrentDirectory(new File("."));
           fileChooser.setFileFilter(
            new javax.swing.filechooser.FileNameExtensionFilter(
                "Archivos de texto (*.txt)", "txt"
            )
        );
           int response = fileChooser.showOpenDialog(null); // Open file
                if(response == JFileChooser.APPROVE_OPTION) {
                    try{
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        FileReader reader = new FileReader(file);
                        areaText.read(reader, file);
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Error file dont't found: " + e);
                    }
        }
    }
    
    
    public void saveAsFile(){
        fileChooser.setFileFilter(
            new javax.swing.filechooser.FileNameExtensionFilter(
                "Archivos de texto (*.txt)", "txt"
            )
        );
        
        int response = fileChooser.showSaveDialog(this); 
                if(response == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                    if (!file.getName().toLowerCase().endsWith(".txt")) {
                        file = new File(file.getAbsolutePath() + ".txt");
                    }
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write(areaText.getText());
                        JOptionPane.showMessageDialog(null, "File saved As successfully");
                        currentFile = file;
                        areaText.setText("");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error saving file");
                    }
                }
    
    
    }
    
    public void save(){

        if(currentFile == null){
            saveAsFile();
        } else{
            try (FileWriter writer = new FileWriter(currentFile)) {
            writer.write(areaText.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file");
        }
            
        }
    }
    


}
