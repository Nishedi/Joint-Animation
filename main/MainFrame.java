package main;

import model.FlyWheel;
import model.History;
import view.FlyWheelView;
import view.MyThread;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	History history;
	public MyPanel mp;
	MyThread t;

	public MainFrame(FlyWheel flyWheel, FlyWheelView flyWheelView, History history) {
		this.history=history;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		mp = new MyPanel(flyWheel, flyWheelView);
		contentPane.add(mp, BorderLayout.CENTER);
		t = new MyThread(mp, history);
		t.start();

	}
}
