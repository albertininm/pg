import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Points extends JPanel implements MouseListener{
	public static ArrayList<Point> points = new ArrayList();
	
	public Points() {
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.red);
		
		if (points.size() > 1) {
			for (int i = 0; i < points.size() - 1; i++) {
				g2d.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
			}
		} else if (!points.isEmpty()) {
			g2d.drawLine(points.get(0).x, points.get(0).y, points.get(0).x, points.get(0).y);
		}
		/*
		 * for (int i = 0; i <= 100000; i++) { Dimension size = getSize(); int w =
		 * size.width ; int h = size.height;
		 * 
		 * Random r = new Random(); int x = Math.abs(r.nextInt()) % w; int y =
		 * Math.abs(r.nextInt()) % h; g2d.drawLine(x, y, x, y); }
		 */
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point p1 = new Point();
		p1.setLocation(x, y);
		points.add(p1);
		
		repaint();
		System.out.println(points.size());
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public static void main(String[] args) {
		Points points = new Points();
		JFrame frame = new JFrame("Points");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(points);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.addMouseListener(points);
		//frame.addMouseListener();
		// listener(frame);
	}
}