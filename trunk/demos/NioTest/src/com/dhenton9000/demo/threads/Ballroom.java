package com.dhenton9000.demo.threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ballroom {
  public static void main(String[] a){
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(200, 300);
    PaintSurface canvas = new PaintSurface();

    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
    executor.scheduleAtFixedRate(canvas, 0L, 100L, TimeUnit.MILLISECONDS);
    
    f.getContentPane().add(canvas);
    f.setVisible(true);
    
  }
}
class PaintSurface extends JComponent implements Runnable{
  int i = 0;
  public void run() {
    repaint();
  }

  public void paint(Graphics g) {

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    Shape ball = new Ellipse2D.Float(i++, i++, 5, 5);
    g2.setColor(Color.RED);
    g2.fill(ball);
  }
}