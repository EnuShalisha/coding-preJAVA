package com.ex0219;

public class Ex01 {

	public static void main(String[] args) {
		Test1 ob=new Test1();
		
		ob.setColor(Color.GREEN);
		Color color=ob.getColor();
		switch(color) {
		case RED: System.out.println("red"); break;
		case GREEN: System.out.println("green"); break;
		case BLUE: System.out.println("blue"); break;
		}

	}

}

enum Color{
	RED, GREEN, BLUE
}

class Test1{
	private Color color=Color.RED;
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	
}