/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmeet
 */

import java.io.*;
public class persistObject {
        Object obj;
        String fileName="persistObject.ser";
        
        persistObject()
        {
            this.obj=null;
        }

        public void Serialize(Object obj){
            try {
               FileOutputStream file = new FileOutputStream(fileName);
               ObjectOutputStream out = new ObjectOutputStream(file);
               out.writeObject(obj);
               out.close();
               file.close();
               System.out.printf("Serialized data in " +fileName);
            }catch(IOException e) {
               e.printStackTrace();
            }
        }
        
        public Object DeSerialize(){
            try {
               FileInputStream file = new FileInputStream(fileName);
               ObjectInputStream in = new ObjectInputStream(file);
               obj = in.readObject();
               in.close();
               file.close();
               return obj;
            }catch(IOException e) {
               e.printStackTrace();
               return null;
            }catch(ClassNotFoundException c) {
               System.out.println("Object not found");
               c.printStackTrace();
               return null;
            }
        }
}

