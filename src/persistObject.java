/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmeet
 */

public class persistObject 
{
        Object obj;
        String xmlFileName="persistObject.xml";
           
        persistObject()
        {
            this.obj=null;
        }
        
        public Object readObject(){
            XML_240 xml = new XML_240();
            xml.openReaderXML(xmlFileName);
            obj = xml.ReadObject();
            xml.closeReaderXML();
            return obj;
        }
        
        public void writeObject(Object o){
            XML_240 xml = new XML_240();
            xml.openWriterXML(xmlFileName);
            xml.writeObject(o);
            xml.closeWriterXML();
        }
}