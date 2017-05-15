package com.hxq.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class Node{
	String key;
	int value;
	Node next;
	public Node(String key,int value){
		this.key=key;
		this.value=value;
		this.next=null;
	}
}
public class Solution {
	
	 HashMap<String, Integer> map=new HashMap<String, Integer>();
	// static LinkedHashMap<String, Integer> get_map=new LinkedHashMap<>();
	  Node frist;
	  Node last;
	  int size=0;
	 public boolean isEmpty(){
		 return frist==null;
	 }
	 
	 public void print(){
		 Node current=frist;
		 while(current!=null){
			 System.out.print("("+current.value+","+current.key+")"+" ");
			 current=current.next;
			 
		 }
		 
	 }
	 public void insert(String keys,int values){
		 Node newNode=new Node(keys,values);
		 if(this.isEmpty()){
			 frist=newNode;
			 last=newNode;
			 size++;
		 }else{
			 last.next=newNode;
			 last=newNode;
			 size++;
		 }
		 
		 return;
	 }
	 
	 public Solution(){   //种别码表信息
			map.put("=",25);
			map.put(":",17);
			map.put("begin",1);
			map.put("if",2);
			map.put("then",3);
			map.put("while",4);
			map.put("do",5);
			map.put("end",6);
			map.put("+",13);
			map.put("-",14);
			map.put("*",15);
			map.put("/",16);
			map.put(":",17);
			map.put(":=",18);
			map.put("<",20);
			map.put("<>",21);
			map.put("<=",22);
			map.put(">",23);
			map.put(">=",24);
			map.put("=",25);
			map.put(";",26);
			map.put("(",27);
			map.put(")",28);
			map.put("#",0);
		}
	 
	 public void saveInfo(String key){
		 int value=11;  //假定为数字的种别码
		 char[] data=key.toCharArray();
		 if(map.containsKey(key)){  //如果是关键词或者符号
			 value=map.get(key);
		 }else{
			 for(int j=0;j<data.length;j++){  
				 if(IsLetter(data,j)){  //如果单词含有字母，如a1,a22之类
					 value=10;
				 }
			 }
			}
		 insert(key, value);  //存信息
	 }
	 
	 public void judgeInfo(String n){
		 char[] get=n.toCharArray();
		 int count =0;
		 int size=0;
		 for(int i=0;i<get.length;i++){
			 if(get[i]=='#'){
				 char []kk=new char[1];
				 kk[0]='#';
				 String key=new String(kk);
				 saveInfo(key);
				 break;
			 }
			 else if(get[i]==' '){
				 count=i+1;
			 }
			 
			 else if(get[i]=='/'&&get[i+1]=='*'){
				   // i++;
				 	while((get[i]=='*'&&get[i+1]=='/')!=true){
						 i++;
					 }
				 	i=i+1;
					}
			 
			 
			 
			 //遇到符号
			 else if(IsSymbol(get,i)&&IsDescription(get, i)==false){  
				 if(IsSymbol(get,i+1)&&IsDescription(get, i)==false){
					 
					 char[] key=new char[2];
					 key[0]=get[i];
					 key[1]=get[i+1];
					 String keyInfo=new String(key);
					 //System.out.println("符号："+keyInfo);
					 count=i+2;
					 i++;
					
					 saveInfo(keyInfo);
				 }else{
					 char[]key2=new char[1];
					 key2[0]=get[i];
					 String keyInfo=new String(key2);
					 //System.out.println("符号："+keyInfo);
					 count=i+1;
					
					 saveInfo(keyInfo);
				 }
			 }
			 //字母
			 else if(IsLetter(get,i)&&IsDescription(get, i)==false){
				 
					 if(IsSymbol(get,i+1)||get[i+1]==' '||get[i+1]=='#'){
						 size=i+1-count;
						 char[] key=new char[size];
						 
							 for(int j=0;j<size;j++){
							 
								 key[j]=get[count];
								 count++;
						 }
						 //System.out.println(count);
						 String keyInfo=new String(key);
						 //System.out.println("单词："+keyInfo);
						 saveInfo(keyInfo);
						
					 }
				 
				 
			 }
			 
			 //数字
			 else if(IsNumber(get,i)&&IsDescription(get, i)==false){
				 
					 if(IsSymbol(get,i+1)||get[i+1]==' '||get[i+1]=='#'){
						 size=i+1-count;
						 char[] key=new char[size];
						 for(int j=0;j<size;j++){
							 
							 key[j]=get[count];
							 count++;
						 }
						 
						 String keyInfo=new String(key);
						
						 //System.out.println("数字："+keyInfo);
						 saveInfo(keyInfo);
					 }
				 
			 }
			 
		 }
	 }
	 
	 public boolean IsSymbol(char[] get,int i){
		 return (get[i]==':'||get[i]=='='||get[i]=='('||get[i]==')'||get[i]=='+'||
		   get[i]=='-'||get[i]=='*'||get[i]=='/'||get[i]=='>'||get[i]=='<'||get[i]==';');
	 }
	 
	 public boolean IsDescription(char[] get,int i){
		 return ((get[i]=='/'&&get[i+1]=='*')||get[i]=='*'&&get[i+1]=='/');
	 }
	 
	 public boolean IsLetter(char[] get,int i){
		 return (get[i]>='a'&&get[i]<='z'||get[i]>='A'&&get[i]<='Z');
	 }
	 
	 public boolean IsNumber(char[] get,int i){
		 return (get[i]>='0'&&get[i]<='9');
	 }
  	
	public int[] results(){
		int[] result=new int[size];
		 Node current=frist;
		 int temp=0;
		 while(current!=null){
			 result[temp]=current.value;
			 current=current.next;
			 temp++;
		 }
		return result;
	}
	 
	 public static void main(String[] args) {
		
 		String test="begin a22:=27; /*asdjsaojdoa*/ xxx=333  end#";
 		/*Scanner sacn=new Scanner(System.in);
 		String source=sacn.nextLine();*/
 		
 		Solution vt=new Solution();
 		vt.judgeInfo(test);
 		//vt.judgeInfo(test);
 		//vt.showInfo(get_map);
 		
 		vt.print();
 		System.out.println();
 		int[]data=vt.results();
 		
	}


 	

}

