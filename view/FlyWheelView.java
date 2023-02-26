package view;

import model.FlyWheel;
import model.GObject;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class FlyWheelView extends GObject {

	public double alpha, beta;
	int l1=100, l2;
	FlyWheel flyWheel;

	public FlyWheelView(FlyWheel flyWheel) {
		this.flyWheel=flyWheel;
	}

	@Override
	public void drawMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int p0x = g2d.getClipBounds().width / 2;
		int p0y = g2d.getClipBounds().height / 2;
		AffineTransform saveAT = g2d.getTransform();
		t = new AffineTransform();
		t.translate(p0x, p0y);
		t.scale(1, -1);
		t.rotate(alpha);
		g2d.setTransform(t);
		g2d.drawLine(0, 0, flyWheel.l1, 0);
		drawBlackCircle(flyWheel.l1, 0,g2d);
		t.translate(flyWheel.l1, 0);
		beta = flyWheel.computeBeta(alpha);
		t.rotate(-beta);
		g2d.setTransform(t);
		g2d.drawLine(0, 0, flyWheel.l2, 0);
		drawBlackCircle(flyWheel.l2,0,g2d);
		g2d.setTransform(saveAT);
		drawTrianglewithCircle(p0x, p0y, g2d);
		drawTrianglewithCircle(p0x + flyWheel.d, p0y - flyWheel.h, g2d);
	}

	private void drawTrianglewithCircle(int a, int b, Graphics2D g2d){
		int[] xx = new int[3];
		xx[0]=a;
		xx[1]=a+20;
		xx[2]=a-20;

		int[] yy = new int[3];
		yy[0] = b;
		yy[1] = b + 30;
		yy[2] = b + 30;
		Polygon p = new Polygon(xx,yy,3);
		g2d.draw(p);
		g2d.setColor(Color.blue);
		g2d.fill(p);
		drawCircle(a, b, g2d);
	}

	private void drawCircle(int a, int b, Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.fillOval(a-5,b-5, 10, 10);
		g2d.setColor(Color.black);
		g2d.drawOval(a-5,b-5, 10, 10);
	}

	private void drawBlackCircle(int a, int b, Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.fillOval(a-5,b-5, 10, 10);
		g2d.setColor(Color.black);
		g2d.drawOval(a-5,b-5, 10, 10);
	}
	@Override
	public void rotate() {
		alpha += Math.PI / 180.0;
	}

}
