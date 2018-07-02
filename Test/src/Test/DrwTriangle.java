package Test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class DrwTriangle extends JFrame{
    int z=0;
    int x20=0;
    int y20=0;
    Canvas canvas=new Canvas() {
        public void paint(Graphics g) {
            super.paint(g);
            g.drawPolygon(new int[]{100,z+100,x20+100}, new int[]{100,100,y20+100}, 3);
        }
    };
    JLabel sl=new JLabel("side length: ");
    JLabel a=new JLabel("a:");
    JLabel b=new JLabel("b:");
    JLabel c=new JLabel("c:");
    JTextField sl1=new JTextField(5);
    JTextField sl2=new JTextField(5);
    JTextField sl3=new JTextField(5);
    JPanel p1=new JPanel(new FlowLayout());
    JButton locate=new JButton("好的");
    public DrwTriangle() {
        p1.add(sl);
        p1.add(a);
        p1.add(sl1);
        p1.add(b);
        p1.add(sl2);
        p1.add(c);
        p1.add(sl3);
        p1.add(locate);
        canvas.setSize(200,00);
        canvas.setVisible(true);
        locate.addActionListener(new Locate());
        this.setLayout(new BorderLayout());
        this.add(p1,"North");
        this.add(canvas,"Center");
        this.setSize(480,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
class Locate implements ActionListener {
          public void actionPerformed(ActionEvent e){
                double i=Double.parseDouble(sl1.getText());
                double j=Double.parseDouble(sl2.getText());
                double k=Double.parseDouble(sl3.getText());
                boolean x,y;
                x=i>0&&j>0&&k>0;
                y=i+j>k&&i+k>j&&j+k>i;
                if(x&&y) {
                    double x2,y2,m;
                    m=(i*i+j*j-k*k)/(2*i*j);
                    if(m>=0) {
                    	x2=m*j;
                    }
                    else{
                    	x2=m*j+i;
                    }
                    y2=Math.sqrt(k*k-(x2-i)*(x2-i));
                    z=(int)i;
                    x20=(int)x2;
                    y20=(int)y2;
                    canvas.repaint();
                } else JOptionPane.showMessageDialog(DrwTriangle.this, "您输入的三边长不能构成三角形！");
            }
}
    public static void main(String[] args) {
        new DrwTriangle();
    }
}