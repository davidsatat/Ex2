package GUI;

import javax.swing.JFrame;

import Coords.MyCoords;
import Geom.Point3D;


public class Main 
{
	public static void main(String[] args)
	{
		Point3D g1=new Point3D(32.103506,35.207834);
		Point3D p2=new Point3D(912,388,0);
		Point3D g2=new Point3D(32.103418,35.208723);
		Map m=new Map("C:\\\\Users\\\\����� ���\\\\Desktop\\\\Ariel1.png",g1,g2);
		MainWindow window = new MainWindow(m);
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point3D p1=new Point3D(781,372,0);

		Point3D t2=new Point3D(32.102498,35.207475);
		MyCoords m1=new MyCoords(p1,p2,g1,g2);
		System.out.println(m1.gps2pix(t2));
		//Point3D t2=new Point3D(32.102498,35.207475);
		//Point3D t3=new Point3D(732,540);
//		System.out.println(m.gps2pix(t2));
		//window.Convert(t2);
		//window.Convert(t3);
		//window.Convert3(t2);
		//window.Convert3(t3);
	}
}
