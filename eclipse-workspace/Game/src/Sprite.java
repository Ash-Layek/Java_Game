import java.awt.Rectangle;

public class Sprite {
	
	protected int x, y;
	
	protected int height, width;
	
	protected String image;
	
	protected Rectangle r;
	
	
	
	
	
	public int getX() {
		
		return x;
		
	}
	
	public void setX(int x) {
		
		this.x = x;
		
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public void setY(int y) {
		
		
		this.y = y;
	}
	
	public int getHeight() {
		
		return height;
		
		
	}
	
	public void setHeight(int H) {
		
		
		this.height = H;
		
	}
	
	
	public int getWidth() {
		
		return width;
		
	}
	
	public void setWidth(int W) {
		
		this.width = W;
	}
	
	
	
	public String getImage() {
		
		return image;
		
	}
	
	
	public void setImage(String Img) {
		
		this.image = Img;
		
	}
	
	
	
	public Sprite() {	
	super();
	
	this.x = -1;
	
	this.y = -1;
	
	this.height = -1;
	
	this.width  = -1;
	
	this.image = "";
	
	this.r = new Rectangle(0,0,0,0);
	
		
	}
	
	
	public Sprite(int x, int y, int height, int width, String img) {
		
		
		this.x = x;
		
		this.y = y;
		
		this.height = height;
		
		this.width = width;
		
		this.image = img;
		
		
		this.r = new Rectangle(x,y,height,width);
		
		
	}
	
	
	public void Display() {
		
		System.out.println("x + y are :" + this.x + this.y );
		
		
		System.out.println("width + height are :" + this.width + this.height );
		
		
		System.out.println("image is  :" + this.image);
		
		
		
	}
	
	
	public void updateRectanglePosition() {
		
		this.r.x = x;
		
		this.r.y = y;
		
		
		
	}
	
	public void updateRectangleSize() {
		
		this.r.height = height;
		
		this.r.width = width;
		
	}
	
	
	
	public Rectangle getRectangle() {
		
		
		return this.r;
	}
	
	
	
	
	
	

}
