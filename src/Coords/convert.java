package Coords;

import Geom.Fruit;
import Geom.Packman;
import Geom.PathPoint;
import Geom.myLine;
import javafx.scene.shape.Line;

public class convert {
	private int mapWidth;
	private int mapHeight;
	private double mapLongitudeStart;
	private double mapLatitudeStart;
	private double mapLongitude;
	private double mapLatitude;
	
	/**
	 * this class dose convert between pixels and lat lon coordinate
	 * note you have to give this class the point of the edges of the map in lat lon and the size
	 * of your map in pixels
	 *  its not going to work
	 * @author ����� ���
	 *
	 */
	// according to https://stackoverflow.com/questions/38748832/convert-longitude-and-latitude-coordinates-to-image-of-a-map-pixels-x-and-y-coor
	
	
	public convert(int mapWidth,int mapHeight,double mapLongitudeStart,double mapLatitudeStart,double mapLongitudeEnd,double mapLatitudeEnd) {
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
		this.mapLongitudeStart=mapLongitudeStart;
		this.mapLatitudeStart=mapLatitudeStart;
		this.mapLongitude=mapLongitudeEnd-mapLongitudeStart;
		
		this.mapLatitude=mapLatitudeStart-mapLatitudeEnd;
		
	}
	 
	/**
	 * convert pacmans from pixels to gps
	 */
	public Packman PacPix2Gps(Packman p) {
		double xPIX=p.Getpoint().x();
		double yPIX=p.Getpoint().y();
		   double x=xPIX*mapLongitude ;//;
		   //System.out.println(z);
		   x=x/(mapWidth);
		  // System.out.println(z);
		   x=x +mapLongitudeStart;
	       //System.out.println(x);
	       double y=yPIX*mapLatitude;
	       y=y/mapHeight;
	       y=y-mapLatitudeStart;
	       y=y*(-1);
	       //System.out.println(x+","+y);
	       Packman p1=new Packman(y,x,p.Getpoint().z(),p.Getspeed(),p.GetId(),p.GetRadius());
	       return p1;
	}
	/**
	 * convert pacmans from  gps to pixels 
	 */
	public Packman PacGps2Pix(Packman p) {
	    double x,y;
	    x=p.Getpoint().y() - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    y = mapLatitudeStart-p.Getpoint().x();
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(x/mapLongitude));
	    int y1 = (int) (mapHeight*(y/mapLatitude));
       // System.out.println((int)x1+","+ (int)y1);
        Packman p1=new Packman(x1,y1,p.Getpoint().z(),p.Getspeed(),p.GetId(),p.GetRadius());
       // System.out.println(p1);
        return p1;
	}
	/**
	 * convert PathPoint from gps to pixels
	 */
	public PathPoint PathPointGps2Pix(PathPoint p) {
	    double x,y;
	    x=p.y() - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    y = mapLatitudeStart-p.x();
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(x/mapLongitude));
	    int y1 = (int) (mapHeight*(y/mapLatitude));
       // System.out.println((int)x1+","+ (int)y1);
        Packman p1=new Packman(x1,y1,p.z(),0,0,0);
        PathPoint p2=new PathPoint(p1.Getpoint(),p.getTime());
       // System.out.println(p1);
        return p2;
	}
	
	/**
	 * convert Line from gps to pixels
	 */
	public Line LineGps2Pix(Line l) {
	    double sx,sy,ex,ey;
	    
	    sx=l.getStartY() - mapLongitudeStart;
	    ex=l.getEndY() - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    sy = mapLatitudeStart-l.getStartX();
	    ey=  mapLatitudeStart-l.getEndX();
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(sx/mapLongitude));
	    int y1 = (int) (mapHeight*(sy/mapLatitude));
	    int x2 = (int) (mapWidth*(ex/mapLongitude));
	    int y2 = (int) (mapHeight*(ey/mapLatitude));
	    Line l1= new Line(x1,y1,x2,y2);
        return l1;
	}

	/**
	 *if the size of the frame is change
	 */
	public void setFrame(int mapWidth,int mapHeight) {
		this.mapHeight=mapHeight;
		this.mapWidth=mapWidth;
	}
	
	/**
	 * convert Fruit from pixels to gps
	 */
	public Fruit FruPix2Gps(Fruit f) {
				double xPIX=f.Getpoint().x();
	double yPIX=f.Getpoint().y();
	   double x=xPIX*mapLongitude ;//;
	   //System.out.println(z);
	   x=x/(mapWidth);
	  // System.out.println(z);
	   x=x +mapLongitudeStart;
    //System.out.println(x);
    double y=yPIX*mapLatitude;
    y=y/mapHeight;
    y=y-mapLatitudeStart;
    y=y*(-1);
    //System.out.println(x+","+y);
    Fruit p1=new Fruit(y,x,f.Getpoint().z(),f.GetWeight(),f.GetId());
    return p1;
	}
	
	
	/**
	 * convert Fruit from gps to pixels  
	 */
	public Fruit FruGps2Pix(Fruit f) {
			    double x,y;
    x=f.Getpoint().y() - mapLongitudeStart;
   // System.out.println(x);
    // do inverse because the latitude increases as we go up but the y decreases as we go up.
    // if we didn't do the inverse then all the y values would be negative.
    y = mapLatitudeStart-f.Getpoint().x();
    //System.out.println(y);
    // set x & y using conversion
    int x1 = (int) (mapWidth*(x/mapLongitude));
    int y1 = (int) (mapHeight*(y/mapLatitude));
   // System.out.println((int)x1+","+ (int)y1);
    Fruit p1=new Fruit(x1,y1,f.Getpoint().z(),f.GetWeight(),f.GetId());
   // System.out.println(p1);
    return p1;
	}
	public int getMapWidth() {
		return mapWidth;
	}

	

	public int getMapHeight() {
		return mapHeight;
	}

	

	public double getMapLongitudeStart() {
		return mapLongitudeStart;
	}

	

	public double getMapLatitudeStart() {
		return mapLatitudeStart;
	}

	

	public double getMapLongitude() {
		return mapLongitude;
	}

	

	public double getMapLatitude() {
		return mapLatitude;
	}

	
	

}
