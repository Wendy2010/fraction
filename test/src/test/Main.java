package test;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}
class Fraction{
	public int up;
	public int down; 
	public Fraction(int a, int b) {
		this.up = a;
		this.down = b;
	}
	public double toDouble() {
		return (double)(this.up/this.down);
	}
	public Fraction plus(Fraction r) {
		
		return new Fraction(this.up*r.down + r.up * this.down, this.down * r.down);
	}
	public Fraction multiply(Fraction r) {
		return new Fraction(this.up*r.up, this.down*r.down);
	}
	void print() {
		// 做简化输出
		this.simple();
		if (this.down == 1) {
			System.out.println(this.up);
		}
		System.out.println(this.up + "/" + this.down);
		
	}
	public void simple() {
		int up = this.up;
		int down = this.down;
		int min = Math.min(up, down);
		for (int i = 2; i <= min; i++ ) {
			if (up % i == 0 && down % i ==0) {
				up = up/i;
				down = down/i;
			}
		}

		this.up = up;
		this.down = down;
	}
}