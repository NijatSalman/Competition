package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {

	public static void writeObjectToFile(Object object,String name){

		FileOutputStream fout=null;
		ObjectOutputStream oos=null;
		
		try {
			fout=new FileOutputStream(name);
			oos=new ObjectOutputStream(fout);
			oos.writeObject(object);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fout !=null){
				try {
					fout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(oos !=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}

public static Object readObjectFromFile(String name) throws Exception{
	Object obj=null;
	ObjectInputStream in=new ObjectInputStream(new FileInputStream(name));
	obj=in.readObject();
	return obj;
}
}
