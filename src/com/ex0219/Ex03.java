package com.ex0219;

public class Ex03 {

	public static void main(String[] args) {
		double a =Operation.PLUS.eval(10, 5);
		System.out.println(a);

	}

}

enum Operation {
	PLUS {public double eval(double x, double y) {return x+y;}},
	MIUS {public double eval(double x, double y) {return x-y;}},
	TIMES {public double eval(double x, double y) {return x*y;}},
	DIVIDE {public double eval(double x, double y) {return x/y;}};

	public abstract double eval(double x, double y);
}