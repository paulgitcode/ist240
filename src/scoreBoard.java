
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
 * @author Paul, Jasmeet
 */
public class scoreBoard {

    private Vector scores;

    XML_240 readScore; // XML reader for score

    String mainScoreFile = "scoresheet.xml";

    public scoreBoard() {
        readScore = new XML_240();
        readScore.openReaderXML(mainScoreFile);
        Object v = readScore.ReadObject();
        scores = new Vector();
        if (Vector.class.isInstance(v)) {
            scores = (Vector) v;
        }

        readScore.closeReaderXML();
    }

    /**
     * @return the score
     */
    public Vector getScores() {
        return scores;
    }

    public void addScore(options o) {
        scores.add(o);
    }

    public JScrollPane displayXML() {
        DefaultTableModel model = new DefaultTableModel(0, 0);
        String[] cols = {"Name", "Difficulty", "Score"};
        model.setColumnIdentifiers(cols);
        JTable jt = new JTable();
        jt.setModel(model);
        jt.setAutoCreateRowSorter(true);
        jt.enable(false);

        for (int idx = 1; idx <= 10; idx++) {
            Vector<Object> data = new Vector<Object>();
            data.add("Name " + String.format("%03d", idx));
            data.add("Difficulty " + String.format("%03d", idx));
            data.add(String.format("%05d", (int) (Math.random() * 100 * idx)));
            model.addRow(data);
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Score Board [Click on Header to Sort]"));
        return scrollPane;
    }

}
