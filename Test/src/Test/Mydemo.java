package Test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Mydemo{
    public static void run(final JFrame f, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //设置标题
                f.setTitle(f.getClass().getSimpleName());
                //设置图标
                f.setIconImage(new ImageIcon("图片路径").getImage());
                //设置默认关闭方式
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //设置大小
                f.setSize(width, height);
                //设置窗口可见
                f.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args){
    	Mydemo.run(new JFrame(), 100, 100);
    }
}
