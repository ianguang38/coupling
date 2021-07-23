package tian.test;

import javax.swing.*;

public class saved {
}
/*

    JFrame j=new JFrame();
        j.setLayout(new BorderLayout());

                Vector<String> colName=new Vector<>();
        colName.add("id");
        colName.add("name");
        colName.add("image");
        Vector<Vector<Object>> data=new Vector<>();
        DefaultTableModel dtm=new DefaultTableModel();
        dtm.setDataVector(data,colName);
        JTable jt=new JTable(dtm);


        JTextField fi=new JTextField();
        JButton insert=new JButton("导入图片");
        insert.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
        JFileChooser jf=new JFileChooser();
        jf.setMultiSelectionEnabled(true);
        int i=jf.showOpenDialog(null);
        if(i==jf.APPROVE_OPTION){
        fi.setText(jf.getSelectedFiles().toString());
        for(File f:jf.getSelectedFiles()){
        Vector<Object> row=new Vector<>();
        row.add(1);
        row.add(f.toString());
        row.add(f.toString());
        data.add(row);
        }
        jt.updateUI();

        }
        }
        });


        JScrollPane scroll = new JScrollPane(jt);
        j.add(scroll,BorderLayout.WEST);
        j.add(fi,BorderLayout.CENTER);
        j.add(insert,BorderLayout.SOUTH);
        j.setSize(800,400);
        j.setVisible(true);
        }*/
