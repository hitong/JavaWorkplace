package version3;

import java.awt.*;
import javax.swing.JPanel;

/**
 * 给类用于添加图片
 * @author Sun
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel{   
	 private Image image  =  null;     
     public MyPanel(Image image){   
         this.image = image;   
     }   
    
     protected void paintComponent(Graphics g) {   
    	 g.drawImage(image,0,0, this.getWidth(), this.getHeight(), this);   
     }   
}