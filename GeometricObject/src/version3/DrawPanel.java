package version3;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel{	
	ArrayList<GeometricObject> geometric = null;
	GeometricObject pen;
	
	DrawPanel(GeometricObject pen){	
		this.pen = pen;
		geometric = new ArrayList<GeometricObject>();
		setLayout(null);
		this.addMouseListener(new Mouse());
	}	
	
	public void paint(Graphics g){
		super.paint(g);
		Iterator<GeometricObject> it = geometric.iterator(); 
		g.drawImage(new ImageIcon("F:\\JavaWorkplace\\GeometricObject\\src\\3.jpg").getImage(),0,0, this.getWidth(), this.getHeight(), this); 
		
		GeometricObject temp;
		/**
		 * 遍历图形信息列表，绘制出不同图形
		 */
		while(it.hasNext()){
			temp = (GeometricObject)it.next();		
			if(temp.isFilled()){
				g.setColor(temp.getColor());
				/**
				 * 根据图形id信息，选择对应分支，绘制出对应图形
				 */
				if(temp.getID() == 1)
					g.fillArc(temp.getX(), temp.getY(), temp.getSide1(),temp.getSide1(), 0 , 360);			
				else if(temp.getID() == 2)
					g.fillRect(temp.getX(), temp.getY(), temp.getSide1() , temp.getSide2());		
				else{
					g.setColor(temp.getColor());
					if(temp.getID() == 1)
						g.drawArc(temp.getX(), temp.getY(), temp.getSide1(),temp.getSide1(), 0 , 360);			
					else if(temp.getID() == 2)
						g.drawRect(temp.getX(), temp.getY(), temp.getSide1() , temp.getSide2());		
					else{
						double i= temp.getSide1();
		                double j= temp.getSide2();
		                double k= temp.getSide3();
		                double x2,y2,m;
	                    m=(i*i+j*j-k*k)/(2*i*j);
	                    if(m>=0) {
	                    	x2=m*j;
	                    }
	                    else{
	                    	x2=m*j+i;
	                    }
	                    y2=Math.sqrt(k*k-(x2-i)*(x2-i));
	                    int z=(int)i;
	                    int x20=(int)x2;
	                    int y20=(int)y2;
	                    int trueX = temp.getX();
	                    int trueY = temp.getY();
	                    g.fillPolygon(new int[]{trueX, z + trueX, x20 + trueX}, new int[]{trueY,trueY ,y20 + trueY}, 3);      
					}		
				}				
			}
			else{
				g.setColor(temp.getColor());
				if(temp.getID() == 1)
					g.drawArc(temp.getX(), temp.getY(), temp.getSide1(),temp.getSide1(), 0 , 360);			
				else if(temp.getID() == 2)
					g.drawRect(temp.getX(), temp.getY(), temp.getSide1() , temp.getSide2());		
				else{
					g.setColor(temp.getColor());
					if(temp.getID() == 1)
						g.drawArc(temp.getX(), temp.getY(), temp.getSide1(),temp.getSide1(), 0 , 360);			
					else if(temp.getID() == 2)
						g.drawRect(temp.getX(), temp.getY(), temp.getSide1() , temp.getSide2());		
					else{
						double i= temp.getSide1();
		                double j= temp.getSide2();
		                double k= temp.getSide3();
		                double x2,y2,m;
	                    m=(i*i+j*j-k*k)/(2*i*j);
	                    if(m>=0) {
	                    	x2=m*j;
	                    }
	                    else{
	                    	x2=m*j+i;
	                    }
	                    y2=Math.sqrt(k*k-(x2-i)*(x2-i));
	                    int z=(int)i;
	                    int x20=(int)x2;
	                    int y20=(int)y2;
	                    int trueX = temp.getX();
	                    int trueY = temp.getY();
	                    g.drawPolygon(new int[]{trueX, z + trueX, x20 + trueX}, new int[]{trueY,trueY ,y20 + trueY}, 3);      
					}		
				}				
			}
		}
	}

	/**
	 * 更改当前需要绘制的图形
	 * @param pen
	 */
	public void setPen(GeometricObject pen){
		this.pen = pen;
	}
	
	/**
	 * 添加图形到图形列表
	 * @param p
	 */
	public void addPaint(Point p){
		GeometricObject m;
		if(pen.getID() == 1)
			m = (Circle)pen.clone();
		else if(pen.getID() == 2)
			m = (Rectangle)pen.clone();
		else
			m = (Triangle)pen.clone();
				
		m.setPoint(p);
		geometric.add(m);
		
	}
	
	/**
	 * 传入图形列表
	 * @param geometric
	 */
	public void setGeometric(ArrayList<GeometricObject> geometric){
		this.geometric = geometric;
	}
	
	/**
	 * 返回图形列表
	 * @return
	 */
	public ArrayList<GeometricObject> getGeometric() {
		return geometric;
	}

	/**
	 * 删除列表中所有图形
	 */
	public void reStart(){
		while(!geometric.isEmpty()){
			revoke();
		}		
	}
		
	/**
	 * 删除一个图形
	 */
	public void revoke(){
		if(!geometric.isEmpty()){
			geometric.remove(geometric.size() - 1);	
			repaint();
		}
	}
	
	/**
	 * 删除指定图形信息
	 * @param del
	 */
	public void delete(GeometricObject del){
		for(int i = 0; i < geometric.size(); i++){
			if(	del.getID() == geometric.get(i).getID() &&
				del.getSide1() == geometric.get(i).getSide1() &&
        		del.getSide2() == geometric.get(i).getSide2() && 
        		del.getSide3() == geometric.get(i).getSide3() && 
        		del.getColor().equals(geometric.get(i).getColor())){
				geometric.remove(i);
				i--;
			}
		}
		repaint();		
	}
	
	/**
	 * 获取点击信息，添加相应图形进入图形列表
	 * @author Sun
	 *
	 */
	class Mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			addPaint(new Point(e.getX(), e.getY()));
			repaint();
		}
	}
}


