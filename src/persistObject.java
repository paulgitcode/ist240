
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmeet
 * 
 */

public class persistObject {
    Object obj;
    String xmlFileName="persistObject.xml";
           
    persistObject(){
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
        
/*    public JScrollPane displayXML(){
        DefaultTableModel model = new DefaultTableModel(0, 0);
        String[] cols = {"Name", "Difficulty", "Score", "Date"};
        model.setColumnIdentifiers(cols);
        JTable jt = new JTable();
        jt.setModel(model);
        jt.setAutoCreateRowSorter(true);
        jt.enable(false);

        for (int idx = 1; idx <= 10; idx++) {
            Vector<Object> data = new Vector<Object>();
            data.add("Name "+ String.format("%03d",idx));
            data.add("Difficulty " + String.format("%03d",idx));
            data.add(String.format("%05d",(int)(Math.random()*100*idx)));
            data.add(new Date());
            model.addRow(data);
        }
           
            //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setBorder(BorderFactory.createTitledBorder ("Score Board [Click on Header to Sort]"));
        return scrollPane;
    }
*/
}
