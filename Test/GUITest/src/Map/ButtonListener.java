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
	                	//�޶�����������ͬɫ����
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
		//��ȱ���Ѱ����ͨ��     ��ͨ��ȫ�����
		public void dfs(int r ,int c){
			if(r<0||r>=10||c<0||c>=10) return;
			if(Map1.buttonGroup[r][c].getIcon().toString().equalsIgnoreCase("icons//͸������.png")||!str.equalsIgnoreCase(Map1.buttonGroup[r][c].getIcon().toString()))return;
			count++;
			Map1.removeButton(r,c);	
			for(int dr= -1;dr<=1;dr++)
				for(int dc =-1;dc<=1;dc++){
					if(dr!=dc&&dr+dc!=0)
						dfs(r+dr,c+dc);
				}
			return;
		}
		//��������Ƿ��пհ�����
		public void CheckColumn(){
			for(int c=0;c<10;c++){
	            for(int r=9;r>=0;r--){               
	            	if(Map1.buttonGroup[r][c].getIcon().toString().equalsIgnoreCase("icons//͸������.png")){	       
	            		for(int i=r;i>=0;i--){	            			
	            			 if(!Map1.buttonGroup[i][c].getIcon().toString().equalsIgnoreCase("icons//͸������.png")){
	            				 Map1.buttonGroup[r][c].setIcon((Map1.buttonGroup[i][c].getIcon()));	      
	            				 Map1.removeButton(i,c);
	            				 break;
	            			 }
	            		}
	            	}
	               }
	            }
	       }  
		//�������Ƿ��пհ����򣬴���߿�ʼ��飬���ұ߿�£
		public void CheckRowLeft(){
			for(int c=1;c<10;c++){
				if(Map1.buttonGroup[9][c].getIcon().toString().equalsIgnoreCase("icons//͸������.png")){
				for(int r=0;r<10;r++){
					for(int i=c;i<10;i++){
						if(!Map1.buttonGroup[r][i].getIcon().toString().equalsIgnoreCase("icons//͸������.png"))
						Map1.moveButton(r, i, "left");
						Map1.removeButton(r, i);												
					}
				}
			}
		}
	}
		//�������Ƿ��пհ����򣬴��ұ߿�ʼ��飬����߿�£
		private void CheckRowRight() {
			for(int c=9;c>=0;c--){
				if(Map1.buttonGroup[9][c].getIcon().toString().equalsIgnoreCase("icons//͸������.png")){
				for(int r=0;r<10;r++){
					for(int i=c;i>=0;i--){
						if(!Map1.buttonGroup[r][i].getIcon().toString().equalsIgnoreCase("icons//͸������.png"))
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
            	if((!Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//͸������.png"))
            	   &&(i!=9&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i+1][j].getIcon().toString())
            	   ||(i!=0&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i-1][j].getIcon().toString()))
            	   ||(j!=9&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i][j+1].getIcon().toString()))
            	   ||(j!=0&&Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase(Map1.buttonGroup[i][j-1].getIcon().toString())))){
            		flag=true;
            }
            	//ʹ��ť���ɵ��
            	if(!Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//͸������.png")) {
            		Map1.buttonGroup[i][j].setEnabled(true);
            	}
            	//ʹ�ƶ���ť���Ե��
            	else if(Map1.buttonGroup[i][j].getIcon().toString().equalsIgnoreCase("icons//͸������.png")){
            		Map1.buttonGroup[i][j].setEnabled(false);
            	}
            	
            }
		}
		//�ı����
		if(flag){
			//System.out.print("������\n����Ϊ"+Map1.mark+"\n");
			LevelView.ScoreLabel.setText(Map1.mark+"");
			TimeView.ScoreLabel.setText(Map1.mark+"");
		}
		//�жϳ��޷��棬����
		else{
			//System.out.print("�˽�\n����Ϊ"+Map1.mark+"\n"+"����Ϊ"+Map1.levelmark);
			if(Map1.kind==0) {
				if (Map1.mark>=Map1.levelmark ){
					Map1.level++;				
					Map1.levelmark=Map1.mark+500+500*Map1.level;								
					PassView passframe = new PassView("icons//���ؽ���.png");
					passframe.setSize(562, 318);
					passframe.setLocationRelativeTo(null);
					passframe.setVisible(true);				
				}
				else {
					DefeatedView defeatedframe = new DefeatedView("ͼƬ//����ʧ�ܽ���.png");
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
