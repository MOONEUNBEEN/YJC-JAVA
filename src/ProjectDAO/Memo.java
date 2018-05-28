package ProjectDAO;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

class Memo {     
    
    public static void main(String[] args) {                  
                
        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setSize(650,550);
                        
        JTextArea t = new JTextArea();      
        f.add(t);
        
        f.setVisible(true);
        
        JMenuBar m = new JMenuBar();
        f.setJMenuBar(m);
         
        JMenu m_file = new JMenu("����");
        m.add(m_file);
        
        JMenuItem i_save = new JMenuItem("����");
        JMenuItem i_load = new JMenuItem("�ε�");     
        m_file.add(i_save);
        m_file.add(i_load);         
        
        // ���� ����
        i_save.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                
                FileDialog dialog = new FileDialog(f, "����", FileDialog.SAVE);           
                dialog.setVisible(true);    
                String path = dialog.getDirectory() + dialog.getFile();
                
                try {
                   
                   FileWriter w = new FileWriter(path);
                   String s = t.getText();
                   s = s.replace("\n","\r\n");
                   w.write(s); 
                   w.close();
            
                } catch (Exception e2) {
                
                    System.out.println("�������" + e2);
                }  
            }            
        }); 
        
        // ���� �ҷ�����
        i_load.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                            
                   FileDialog dialog = new FileDialog(f, "�ε�", FileDialog.LOAD);
                   dialog.setFile("*.txt;");
                   dialog.setVisible(true);        
                   
                   String path = dialog.getDirectory() + dialog.getFile();                 
                   String s ="";
                   
                   if(dialog.getFile() == null) {
                	   return;
                   }
                           
                   try {
                      
                      FileReader r = new FileReader(path);
                      
                      int k;              
                      
                      for( ;  ; ) {
                       
                          k = r.read();
                          if( k == -1) break;
                          s += (char)k;               
                      }           
                      
                      r.close();
               
                   } catch (Exception e2) {
                   
                       System.out.println("����" + e);
                   } 
                   
                   t.setText(s);   
            }            
        }); 
        
    }       
}