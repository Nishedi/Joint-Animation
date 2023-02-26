package model;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

abstract public class GObject {
	 public AffineTransform t;

	 abstract public void drawMe(Graphics g);
	 abstract public void rotate();
}
