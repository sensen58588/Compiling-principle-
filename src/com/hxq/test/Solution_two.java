/*
 * ����Դ��mapͼ���keyֵֻ�ܴ�һ�Σ�begin a:=1;b:=2 end#
 * 		  ���map�У�b:=2������
 * 
 * */



package com.hxq.test;

public class Solution_two {
	
    int [] source;//�ʷ��������
	int temp=0;//ָ�룬��ǰ����λ
	int value;//��ȡ��������
	int key=0;//�жϹ����Ƿ����
	public  void program(){ //�����ж�
		value=source[temp];
		if(value==1){
			value=source[++temp];  //ָ�����ƣ���ȡ��һ���ֱ�����Ϣ
			
			//������䴮...
			yucu();
			
			if(value==6){  
				value=source[++temp];
				if(value==0&&key==0){
					System.out.println("success");
				}else{
					if(key==0){
						key=1;
						System.out.println("end  ERROR!!!");}
					 }
						}	
					}else{
						key=1;
						System.out.println("begin  ERROR!!!");
			
						}
		return;
	
	}
	public void yucu(){  //��䴮
		//����statement();
		statement();  //temp=1
		
		while(value==26){
			
			value=source[++temp]; //value=10,temp=5
			
			//����statement()
			
			statement();
		}
		
		return;
	}

	public void statement(){  //���
		if(value==10){
			
			value=source[++temp];//������value=18 temp=2;   value=18 temp=6;
			
			if(value==18){
				value=source[++temp];  //  value=11,temp=3;   value=11 temp=7;
				
				//����experssion��������
				experssion();
			}else{
				key=1;
				
				System.out.println("��ֵ�Ŵ��󣡣�");
				}
		}else{
			key=1;
			System.out.println("������");
			
		}
		return;
	}
	
	public void experssion(){
		//����term����
		term();
		while(value==13||value==14){
			value=source[++temp];
			//����term����
			term();
		}
		return;
	}

	public void term(){
		//����factor()����
		factor();
		while(value==15||value==16){
			value=source[++temp];
			//����factor()����
			factor();
			}
		return;
	}

	public void factor(){
		if(value==10||value==11){
			value=source[++temp]; //value=26,temp=4
		}else if(value==27){
			value=source[++temp];
			experssion(); //����experssion()
			if(value==28){
				value=source[++temp];
			}else{
				key=1;
				System.out.println("')'  ����");
			}
		}else{
			key=1;
			System.out.println("���ʽ���󣡣�");
		}
		return;
	}
	
	public static void main(String args[]){
		Solution_two tool=new Solution_two();
		String test="begin a22:=27;b:=3 end#";
		Solution vt=new Solution();
		vt.judgeInfo(test);
		
		int[]data=vt.results();
		tool.source=data;
		tool.program();
		
		
		
		
		
	}
}
