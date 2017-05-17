
import java.io.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by xiaoqiang on 2017/5/17.
 */
public class ObjectServer {

    public static void write() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("G:\\objectWrite.obj"));
        Customer customer = new Customer("sensen",24);
        out.writeObject("来自对象序列化：");
        out.writeObject(customer);
        out.writeObject(new Date());
        out.close();
    }

    public static void read() throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("G:\\objectWrite.obj"));
        System.out.println("obej1:"+(String)in.readObject());
        System.out.println("obj2:"+(Customer)in.readObject());
        System.out.println("obj3:"+(Date)in.readObject());
    }
    public static void main(String args[]) throws Exception{
        write();
        read();
    }
}

//实现Serializable接口
class Customer implements Serializable{
    private String name;
    private int age;

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "name="+name+",age="+age;
    }
}
