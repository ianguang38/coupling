package tian.test;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

public class view extends JFrame {
    private final model m;

    private int radius;
    private int Radius;
    private final int[] center={500,300};   //真正的圆心，相对于整个center的位置

    private final JPanel charaPanel;
    private final shapePanel sp;
    private JScrollPane scroll;
    private JTable jt;



    public view(model myModel) {
        m = myModel;
        radius=50;
        Radius=200;

        JLayeredPane jlp=new JLayeredPane();

        charaPanel = new JPanel(null);
            charaPanel.setBounds(0,0,1080,1920);
            charaPanel.setOpaque(false);
        jlp.add(charaPanel,JLayeredPane.MODAL_LAYER);

        sp=new shapePanel();
            sp.setBounds(0,0,800,800);
        jlp.add(sp,JLayeredPane.DEFAULT_LAYER);


        JPanel operatePanel=new JPanel(new FlowLayout());
            operatePanel.setBounds(800,100,400,400);
                JSlider circleSize=new JSlider(100,300);
                circleSize.addChangeListener(new changCircleSize());

                JSlider charaSize=new JSlider(50,150);
                charaSize.addChangeListener(new changeCharaSize());
            operatePanel.add(circleSize);
            operatePanel.add(charaSize);
            operatePanel.setOpaque(false);
        jlp.add(operatePanel,JLayeredPane.PALETTE_LAYER);

        JButton insert = new JButton("导入图片");
        insert.addActionListener(new insertAction());

        initTable();

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.WEST);
        add(insert, BorderLayout.SOUTH);
        add(jlp, BorderLayout.CENTER);


        setSize(1800, 900);
        setVisible(true);
    }


    public void initTable() {
        Vector<String> colName = new Vector<>();
        colName.add("id");
        colName.add("name");
        colName.add("image");
        Vector<Vector<Object>> data = m.getData();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setDataVector(data, colName);
        jt = new JTable(dtm);

        scroll=new JScrollPane(jt);
        scroll.setSize(100,this.getHeight());
    }

    public void resetCharaButton(){
        int i=0;
        int n=m.getData().size();
        for(Component c:charaPanel.getComponents()){
            c.setBounds((int) (center[0]-radius+Radius*Math.cos(i*2*Math.PI/n)),(int) (center[1]-radius+Radius*Math.sin(i*2*Math.PI/n)),2*radius,2*radius);
            i++;
        }
        charaPanel.updateUI();
    }

    public void initCircle() {
        charaPanel.removeAll();
        int n=m.getData().size();
        for(int i=0;i<n;i++){
            JButton charaButton=new JButton();
            charaButton.setIcon(new ImageIcon(m.getFiles()[i]));
            charaButton.setBounds((int) (center[0]-radius+Radius*Math.cos(i*2*Math.PI/n)),(int) (center[1]-radius+Radius*Math.sin(i*2*Math.PI/n)),2*radius,2*radius);
            charaPanel.add(charaButton);
        }
    }

    class insertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jf = new JFileChooser("G:/1.image/邻座");
            jf.setMultiSelectionEnabled(true);
            int i = jf.showOpenDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
                File[] files = jf.getSelectedFiles();
                m.addChara(files);
                initCircle();
                jt.updateUI();
                charaPanel.updateUI();
            }
        }
    }

    class changCircleSize implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            Radius=((JSlider)(e.getSource())).getValue();
            resetCharaButton();
        }
    }
    class changeCharaSize implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            radius=((JSlider)(e.getSource())).getValue();
            resetCharaButton();
        }
    }

    class shapePanel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.drawOval(center[0]-Radius,center[1]-Radius,2*Radius,2*Radius);
        }
    }

}