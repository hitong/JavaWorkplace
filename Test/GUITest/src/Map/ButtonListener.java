package Map;
import View.LevelView;
import View.DefeatedView;
import View.EndView;
import View.PassView;
import View.StartView;
import View.TimeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ButtonListener implements  ActionListener{
		String str; 
		int count=0;
		public void actionPerformed(ActionEvent e)
	    {
			count=0;
			for(int i=0;i<10;i++){
	            for(int j=0;j<10;j++){               
	                if(e.getSource()==Map1.buttonGroup[i][j]){
	                	str=Map1.buttonGroup[i][j].getIcon().toString();
	                	//限定至少有两块同色相连
	                	if((i!=9&&str.equalsIgnoreCase(Map1.buttonGroup[i+1][j].getIcon().toString()))
	                	   ||(i!=0&&str.equalsIgnoreCase(Map1.buttonGroup[i-1][j].getIcon().toString()))
	                	   ||(j!=9&&str.equalsIgnoreCase(Map1.buttonGroup[i][j+1].getIcon().toString()))
	                	   ||(j!=0&&str.equalsIgnoreCase(Map1.buttonGroup[i][j-1].getIcon().toString()))){	                
	                		dfs(i,j);	               
							CheckColumn();					
							CheckRowLeft();	
							CheckRowRight();	
							Map1.mark+=count*5*count;
							CheckAll();						
							
	                	}
	                }
	            }
	       }
	    }
		//深度遍历寻找连通域     连通域全部清除
		public void dfs(int r ,int c){
			if(r<0||r>=10||c<0||c>=10) return;
			if(Map1.buttonGroup[r][c].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")||!str.equalsIgnoreCase(Map1.buttonGroup[r][c].getIcon().toString()))return;
			count++;
			Map1.removeButton(r,c);	
			for(int dr= -1;dr<=1;dr++)
				for(int dc =-1;dc<=1;dc++){
					if(dr!=dc&&dr+dc!=0)
						dfs(r+dr,c+dc);
				}
			return;
		}
		//检查纵向是否有空白区域
		public void CheckColumn(){
			for(int c=0;c<10;c++){
	            for(int r=9;r>=0;r--){               
	            	if(Map1.buttonGroup[r][c].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")){	       
	            		for(int i=r;i>=0;i--){	            			
	            			 if(!Map1.buttonGroup[i][c].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")){
	            				 Map1.buttonGroup[r][c].setIcon((Map1.buttonGroup[i][c].getIcon()));	      
	            				 Map1.removeButton(i,c);
	            				 break;
	            			 }
	            		}
	            	}
	               }
	            }
	       }  
		//检查横向是否有空白区域，从左边开始检查，向右边靠拢
		public void CheckRowLeft(){
			for(int c=1;c<10;c++){
				if(Map1.buttonGroup[9][c].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")){
				for(int r=0;r<10;r++){
					for(int i=c;i<10;i++){
						if(!Map1.buttonGroup[r][i].getIcon().toString().equalsIgnoreCase("icons//透明背景.png"))
						Map1.moveButton(r, i, "left");
						Map1.removeButton(r, i);												
					}
				}
			}
		}
	}
		//检查横向是否有空白区域，从右边开始检查，向左边靠拢
		private void CheckRowRight() {
			for(int c=9;c>=0;c--){
				if(Map1.buttonGroup[9][c].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")){
				for(int r=0;r<10;r++){
					for(int i=c;i>=0;i--){
						if(!Map1.buttonGroup[r][i].getIcon().toString().equalsIgnoreCase("icons//透明背景.png"))
						Map1.moveButton(r, i, "right");
						Map1.removeButton(r, i);												
					}
				}
			}
		}
			
		}
		
	public void CheckAll(){
		boolean flag=false;
		for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){  
            	if((!Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//透明背景.png"))
            	   &&(i!=9&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i+1][j].getIcon().toString())
            	   ||(i!=0&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i-1][j].getIcon().toString()))
            	   ||(j!=9&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i][j+1].getIcon().toString()))
            	   ||(j!=0&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i][j-1].getIcon().toString())))){
            		flag=true;
            }
            	//使按钮不可点击
            	if(!Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")) {
            		Map1.buttonGroup[i][j].setEnabled(true);
            	}
            	//使移动后按钮可以点击
            	else if(Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//透明背景.png")){
            		Map1.buttonGroup[i][j].setEnabled(false);
            	}
            	
            }
		}
		//改变分数
		if(flag){
			//System.out.print("还能玩\n分数为"+Map1.mark+"\n");
			LevelView.ScoreLabel.setText(Map1.mark+"");
			TimeView.ScoreLabel.setText(Map1.mark+"");
		}
		//判断出无法玩，结束
		else{
			//System.out.print("扑街\n分数为"+Map1.mark+"\n"+"需求为"+Map1.levelmark);
			if(Map1.kind==0) {
				if (Map1.mark>=Map1.levelmark ){
					Map1.level++;				
					Map1.levelmark=Map1.mark+500+500*Map1.level;								
					PassView passframe = new PassView("icons//过关界面.png");
					passframe.setSize(562, 318);
					passframe.setLocationRelativeTo(null);
					passframe.setVisible(true);				
				}
				else {
					DefeatedView defeatedframe = new DefeatedView("图片//闯关失败界面.png");
					defeatedframe.setSize(562, 318);
					defeatedframe.setLocationRelativeTo(null);
					defeatedframe.setVisible(true);
				}
				
			}
		else{						
				Map1.reNew();
		}
	}
	}
}
