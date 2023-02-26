package view;

import main.MyPanel;
import model.History;

public class MyThread extends Thread {
    MyPanel mp;
    History history;

    public MyThread(MyPanel mp, History history){
        this.mp=mp;
        this.history=history;
    }

    public void run() {
        while (1==1) {
            mp.g.rotate();
            mp.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            history.addAxle(mp.flyWheelView.alpha);
        }
       // System.out.println("Animation stopped");
    }


}
