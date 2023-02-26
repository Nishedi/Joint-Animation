package view;

import model.FlyWheel;
import model.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedPanel extends JPanel implements ActionListener {

    Timer timer;
    final int Panel_width = 1000;
    final int Panel_height = 400;
    FlyWheel flyWheel;
    History history;
    SpeedPanel(FlyWheel flyWheel, History history) {
        this.history=history;
        this.flyWheel = flyWheel;
        this.setPreferredSize(new Dimension(Panel_width, Panel_height));
        this.setBackground(Color.gray);
        timer = new Timer(1000, this);
        timer.start();
    }

    public void paint (Graphics G){
        Graphics2D G2D = (Graphics2D) G;
        Double[] x = flyWheel.possition(1);
        int ofsx=50;
        int ofsy=50;
        G2D.drawLine(ofsx, getHeight()-ofsy, 5000+ofsx,getHeight()-ofsy);
        G2D.drawLine(ofsx, getHeight()-(ofsy), ofsx,getHeight()-(ofsy+1000));

        for(int i = 1; i<=history.axlelist.size()-1;i++){
            Double[] actualtab = new Double[2];
            Double[] previoustab = new Double[2];
            double xdiffrence;
            double ydiffrence;
            actualtab = flyWheel.possition(history.axlelist.get(i));
            previoustab = flyWheel.possition(history.axlelist.get(i-1));
            xdiffrence=actualtab[0]-previoustab[0];
            ydiffrence=actualtab[1]-previoustab[1];
            if(xdiffrence<0){
                xdiffrence=-xdiffrence;
            }
            if(ydiffrence<0){
                ydiffrence=-ydiffrence;
            }
            double v = Math.sqrt((xdiffrence * xdiffrence) + (ydiffrence * ydiffrence));
            G2D.setColor(Color.GREEN);
            G2D.drawLine(i+ofsx,getHeight() - (int) (xdiffrence*100)-ofsy-3,i+ofsx,getHeight() - (int) (xdiffrence*100)-ofsy);
            G2D.setColor(Color.CYAN);
            G2D.drawLine(i+ofsx,getHeight() - (int) (ydiffrence*100)-ofsy-3,i+ofsx,getHeight() - (int) (ydiffrence*100)-ofsy);

            G2D.setColor(Color.MAGENTA);
          //  G2D.drawLine(i+ofsx,getHeight() - (int) (v*100)-ofsy-3,i+ofsx,getHeight() - (int) (v*100)-ofsy);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
