package controller;

import exception.IncorectDataexception;
import main.MainFrame;
import model.FlyWheel;
import model.History;
import view.SpeedFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class AppController {
    private static FlyWheel flyWheel;
    MainFrame mainFrame;
    SpeedFrame speedFrame;
    Timer timer;
    History history;


    public AppController(FlyWheel flyWheel,  MainFrame mainFrame, SpeedFrame speedFrame, History history) {

        this.flyWheel = flyWheel;
        this.mainFrame = mainFrame;
        this.speedFrame=speedFrame;
        this.speedFrame.OKButtonListener(new OKButtonListeners());
        this.speedFrame.ClearbtnListener(new ClearbtnListener());
        this.history = history;
        timer = new Timer(100, new TimerListener());
        timer.start();//uruchomienie timera

    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            speedFrame.repaint();
        }
    }

    class OKButtonListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                parsedatafromedit();
            } catch (IncorectDataexception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }

    public void parsedatafromedit() throws IncorectDataexception {
        String l1;
        Integer l1parsed;
        try {
         l1 = speedFrame.l1TextArea.getText();
        l1parsed = parseInt(l1);
        }catch (NumberFormatException er ){
            throw new IncorectDataexception("Wrong format of l1");
        }


        String l2;
        Integer l2parsed;
        try{
        l2 = speedFrame.l2TextArea.getText();
        l2parsed = parseInt(l2);
        }catch (NumberFormatException er ){
            throw new IncorectDataexception("Wrong format of l2");
        }


        String d;
        Integer dparsed;
        try{
        d = speedFrame.dTextArea.getText();
        dparsed = parseInt(d);
        }catch (NumberFormatException er ){
            throw new IncorectDataexception("Wrong format of d");
        }


        String h;
        Integer hparsed;
        try{
        h = speedFrame.hTextArea.getText();
        hparsed = parseInt(h);
        }catch (NumberFormatException er ){
            throw new IncorectDataexception("Wrong format of h");
        }

        Integer heightofpanel=mainFrame.mp.getSize().height/2;
        Integer widthofpanel = mainFrame.mp.getSize().width/2;
        System.out.println(heightofpanel);
        System.out.println(widthofpanel);

        if(l2parsed-l1parsed<Math.sqrt(dparsed*dparsed+hparsed*hparsed)){
            JOptionPane.showMessageDialog(null, "Invalid data. Compared to distance from triangles l2 or l1 is too short. Try to correct data.");
            return;
        }

        if((l2parsed+l1parsed)>heightofpanel+300){
            JOptionPane.showMessageDialog(null, "Invalid data. Risk of showing animation out of window. Try to correct data by increasing height of panel or reduce l1 or l2.");
            return;
        }
        if((l2parsed+l1parsed)>widthofpanel+300){
            JOptionPane.showMessageDialog(null, "Invalid data. Risk of showing animation out of window. Try to correct data by increasing width of panel or reduce l1 or l2.");
            return;
        }
        if(dparsed>widthofpanel){
            JOptionPane.showMessageDialog(null, "Invalid data. Risk of showing triangle out of window. Try to correct data by increasing width of panel or d.");
            return;
        }
        if(hparsed>heightofpanel){
            JOptionPane.showMessageDialog(null, "Invalid data. Risk of showing animation out of window. Try to correct data by increasing height of panel or h");
            return;
        }

        mainFrame.mp.flyWheel.l1=l1parsed;
        mainFrame.mp.flyWheel.l2=l2parsed;
        mainFrame.mp.flyWheel.d=dparsed;
        mainFrame.mp.flyWheel.h=hparsed;

    }
}


    class ClearbtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            history.axlelist.clear();
        }
    }
}
