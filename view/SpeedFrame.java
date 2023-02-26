package view;

import model.FlyWheel;
import model.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpeedFrame extends JFrame {
    SpeedPanel panelspeed;//panel statystyk
    JPanel panel;
    FlyWheel flyWheel;
    History history;
    public JTextArea l1TextArea;
    public JTextArea l2TextArea;
    public JTextArea dTextArea;
    public JTextArea hTextArea;
    public JButton OKButton;
    public JButton Clearbtn;
    public JLabel labell1;
    public JLabel labell2;
    public JLabel labeld;
    public JLabel labelh;


    public SpeedFrame(FlyWheel flyWheel, History history) throws Exception{
        labeld=new JLabel("d");
        labelh=new JLabel("h");
        labell1=new JLabel("l1");
        labell2=new JLabel("l2");
        l1TextArea=new JTextArea("100");
        l1TextArea.setPreferredSize(new Dimension(120,20));
        l2TextArea=new JTextArea("500");
        l2TextArea.setPreferredSize(new Dimension(120,20));
        dTextArea=new JTextArea("200");
        dTextArea.setPreferredSize(new Dimension(120,20));
        hTextArea=new JTextArea("100");
        hTextArea.setPreferredSize(new Dimension(120,20));
        OKButton=new JButton("OK");
        Clearbtn=new JButton("CLEAR");
        panel=new JPanel();
        panel.add(labell1);
        panel.add(l1TextArea);
        panel.add(labell2);
        panel.add(l2TextArea);
        panel.add(labeld);
        panel.add(dTextArea);
        panel.add(labelh);
        panel.add(hTextArea);
        panel.add(OKButton);
        panel.add(Clearbtn);
        panel.setBackground(Color.ORANGE);
        this.add(panel, BorderLayout.NORTH);
        this.history=history;
        this.flyWheel=flyWheel;
        panelspeed=new SpeedPanel(flyWheel, history);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ustawia domyślną akcję zamknięcia okna
        this.add(panelspeed);//dodaje do kontenera okna obiekty typu panelstat
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);//ustawienie widzialnosci okna

    }
    public void ClearbtnListener(ActionListener listenForButton){
        Clearbtn.addActionListener(listenForButton);
    }
    public void OKButtonListener(ActionListener listenForCalcButton){
        OKButton.addActionListener(listenForCalcButton);
    }
}
