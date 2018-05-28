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
         
        JMenu m_file = new JMenu("파일");
        m.add(m_file);
        
        JMenuItem i_save = new JMenuItem("저장");
        JMenuItem i_load = new JMenuItem("로드");     
        m_file.add(i_save);
        m_file.add(i_load);         
        
        // 파일 저장
        i_save.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                
                FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);           
                dialog.setVisible(true);    
                String path = dialog.getDirectory() + dialog.getFile();
                
                try {
                   
                   FileWriter w = new FileWriter(path);
                   String s = t.getText();
                   s = s.replace("\n","\r\n");
                   w.write(s); 
                   w.close();
            
                } catch (Exception e2) {
                
                    System.out.println("저장오류" + e2);
                }  
            }            
        }); 
        
        // 파일 불러오기
        i_load.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                            
                   FileDialog dialog = new FileDialog(f, "로드", FileDialog.LOAD);
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
                   
                       System.out.println("오류" + e);
                   } 
                   
                   t.setText(s);   
            }            
        }); 
        
    }       
}