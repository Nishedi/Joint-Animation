package main;

import controller.AppController;
import model.FlyWheel;
import model.History;
import view.FlyWheelView;
import view.SpeedFrame;

import javax.swing.*;

public class Simulator {
    public static void  main(String[] args) throws Exception {
        FlyWheel flyWheel = new FlyWheel(200,100,100,500);
        FlyWheelView flyWheelView = new FlyWheelView(flyWheel);
        History history = new History();
        MainFrame mainFrame = new MainFrame(flyWheel, flyWheelView, history);
        SpeedFrame speedFrame = new SpeedFrame(flyWheel, history);
        mainFrame.setTitle("Fly Wheel");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AppController appController=new AppController(flyWheel, mainFrame, speedFrame, history);
        mainFrame.setVisible(true);
    }
}
