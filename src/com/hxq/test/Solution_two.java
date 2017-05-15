/*
 * 错误源：map图里的key值只能存一次，begin a:=1;b:=2 end#
 * 		  结果map中，b:=2不存在
 * 
 * */



package com.hxq.test;

public class Solution_two {
	
    int [] source;//词法分析结果
	int temp=0;//指针，当前数据位
	int value;//读取到的数据
	int key=0;//判断过程是否出错
	public  void program(){ //程序判断
		value=source[temp];
		if(value==1){
			value=source[++temp];  //指针下移，读取下一个种别码信息
			
			//调用语句串...
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
	public void yucu(){  //语句串
		//调用statement();
		statement();  //temp=1
		
		while(value==26){
			
			value=source[++temp]; //value=10,temp=5
			
			//调用statement()
			
			statement();
		}
		
		return;
	}

	public void statement(){  //语句
		if(value==10){
			
			value=source[++temp];//进来后，value=18 temp=2;   value=18 temp=6;
			
			if(value==18){
				value=source[++temp];  //  value=11,temp=3;   value=11 temp=7;
				
				//调用experssion（）函数
				experssion();
			}else{
				key=1;
				
				System.out.println("赋值号错误！！");
				}
		}else{
			key=1;
			System.out.println("语句错误！");
			
		}
		return;
	}
	
	public void experssion(){
		//调用term函数
		term();
		while(value==13||value==14){
			value=source[++temp];
			//调用term函数
			term();
		}
		return;
	}

	public void term(){
		//调用factor()函数
		factor();
		while(value==15||value==16){
			value=source[++temp];
			//调用factor()函数
			factor();
			}
		return;
	}

	public void factor(){
		if(value==10||value==11){
			value=source[++temp]; //value=26,temp=4
		}else if(value==27){
			value=source[++temp];
			experssion(); //调用experssion()
			if(value==28){
				value=source[++temp];
			}else{
				key=1;
				System.out.println("')'  错误");
			}
		}else{
			key=1;
			System.out.println("表达式错误！！");
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
