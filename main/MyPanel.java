package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.FlyWheel;
import model.GObject;
import view.FlyWheelView;

public class MyPanel extends JPanel {

	public GObject g;
	private static final long serialVersionUID = 1L;
	public FlyWheel flyWheel = null;
	public FlyWheelView flyWheelView = null;

	public MyPanel(FlyWheel flyWheel, FlyWheelView flyWheelView) {
		this.flyWheel=flyWheel;
		this.setPreferredSize(new Dimension(1800,1800));
		this.setLayout(new GridBagLayout());
		g = flyWheelView;
		this.flyWheelView=flyWheelView;

	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		if (g != null) {
			g.drawMe(arg0);
		}
	}
}
