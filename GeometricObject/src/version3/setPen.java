package version3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class setPen extends JDialog{
	JFormattedTextField[] sideText = new JFormattedTextField[3];
	MaskFormatter mask = new MaskFormatter();
	JFormattedTextField[] colorText = new JFormattedTextField[3];
	JCheckBox[] side = new JCheckBox[2];
	int[] radius = new int[3];
	Color color;
	JButton ok = new JButton("Ok");
	JButton cancel = new JButton("Cancel");
	JCheckBox filled = new JCheckBox("Fill");
	boolean save = false;
	
	setPen(JFrame f){	
		super(f, "pen", true);
		try {
			
	/***************************TextFeild and CheckBox**************/
			mask = new MaskFormatter("###            ");			
			setLayout(new GridLayout(5,1));
			JPanel panel = new JPanel();

			add(new JLabel("GeometricObject:"));
			panel.add(new JLabel("Side:"));
			
			panel.add(new JLabel("side1:"));
			panel.add(sideText[0] = new JFormattedTextField(mask));

			panel.add(side[0] = new JCheckBox("side2:"));
			panel.add(sideText[1] = new JFormattedTextField(mask));				
			panel.add(side[1] = new JCheckBox("side3:"));
			panel.add(sideText[2] = new JFormattedTextField(mask));				
			add(panel);
			
	/****************CheckBox ״̬�ж�*********************************/		
			sideText[1].setEditable(false);
			sideText[2].setEditable(false);
			side[1].setEnabled(false);
			for(int i = 0; i < 2; i++){
				side[i].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!side[0].isSelected()){
							sideText[1].setEditable(false);
							sideText[2].setEditable(false);
							side[1].setEnabled(false);
							side[1].setSelected(false);
						}
						else if(!side[1].isSelected()){
							sideText[1].setEditable(true);
							sideText[2].setEditable(false);
							side[1].setEnabled(true);
						}
						else {
							sideText[1].setEditable(true);
							sideText[2].setEditable(true);
						}
					}		
				});
			}
	/****************Color����*****************************/		
		
			panel = new JPanel();
			panel.add(new JLabel("Color:  "));
			panel.add(new JLabel("rea:"));
			panel.add(colorText[0] = new JFormattedTextField(mask));
			panel.add(new JLabel("green:"));
			panel.add(colorText[1] = new JFormattedTextField(mask));
			panel.add(new JLabel("blue:"));
			panel.add(colorText[2] = new JFormattedTextField(mask));
			add(panel);			
	/*****************Button OK and cancel**********************************/	

			panel = new JPanel();
			panel.add(ok);
			ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					save = true;
					dispose();		
				}
			});
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					save = false;
					dispose();
				}
			});
			
			/**
			 * ����������	
			 */
			panel.add(cancel);
			add(filled);
			add(panel);
			pack();
			setLocationRelativeTo(null); 
			setVisible(true);			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/*****************************************************/
	public boolean isSave(){
		return save;
	}
	
	private Color getColor(){
		return new Color(Integer.parseInt(colorText[0].getText().substring(0,3)),
				Integer.parseInt(colorText[1].getText().substring(0,3)),
				Integer.parseInt(colorText[2].getText().substring(0,3)));
	}
	
	public void getRadius(){	
		if(!side[0].isSelected()){
			radius[0] = Integer.parseInt(sideText[0].getText().substring(0,3));
		}
		else if(!side[1].isSelected()){
			radius[0] = Integer.parseInt(sideText[0].getText().substring(0,3));
			radius[1] = Integer.parseInt(sideText[1].getText().substring(0,3));
		}
		else {
			radius[0] = Integer.valueOf(sideText[0].getText().substring(0,3));
			radius[1] = Integer.parseInt(sideText[1].getText().substring(0,3));
			radius[2] = Integer.parseInt(sideText[2].getText().substring(0,3));
		}
	}
	
	public GeometricObject getPen() throws 
	NotATriangleException,NotACircleException,NotARectangleException{
			getRadius();
			if(!side[0].isSelected()){				
				return new Circle(radius[0],getColor(),filled.isSelected());
			}
			else if(!side[1].isSelected()){
				return new Rectangle(radius[0],radius[1],getColor(), filled.isSelected());
			}
			else {
				return new Triangle(radius[0],radius[1],radius[2],getColor(), filled.isSelected());
			}
	}
}
