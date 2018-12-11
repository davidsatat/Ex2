package Geom;

import GIS.My_Meta_data;

public class Packman  {
	private double Radius;
	private double id;
	private double speed;
	private Point3D point; 

	public Packman(double lat,double lon,double alt,double speed,double id,double Radius) {
		this.point=new Point3D(lat,lon,alt);
		this.id=id;
		this.speed=speed;
		this.Radius=Radius;
	}
	public Packman(double lat,double lon,double id) {
		this.point=new Point3D(lat,lon,0);
		this.id=id;
		this.speed=1;
		this.Radius=1;
	}

	
	public Packman(String line) {
		String[] arr=line.split(",");
		// getting the lat lont alt for the point
		double x= Double.parseDouble(arr[2]);
		double y= Double.parseDouble(arr[3]);
		double z= Double.parseDouble(arr[4]);
		double id=Double.parseDouble(arr[1]);
		double speed=Double.parseDouble(arr[5]);
		double radius=Double.parseDouble(arr[6]);
		this.point=new Point3D(x,y,z);
		this.id=id;
		this.speed=speed;
		this.Radius=radius;
	}
	
	
	public double GetId() {
		return this.id;
	}
	public double GetRadius() {
		return this.Radius;
	}
	public double Getspeed() {
		return this.speed;
	}
	public Point3D Getpoint() {
		return this.point;
	}
	public String toString() {
		return id+","+point.x()+","+point.y()+","+point.z()+","+speed+","+Radius;
	}
}
