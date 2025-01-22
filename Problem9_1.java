// driver program
public class Problem9_1 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(10.0, 5.0);
		
		System.out.printf("Area of Rectangle R1 %s\n", r1.getArea());
		System.out.printf("Perimeter of Rectangle R1 %s\n", r1.getPerimeter());
		
		System.out.printf("Area of Rectangle R2 %s\n", r2.getArea());
		System.out.printf("Perimeter of Rectangle R2 %s\n", r2.getPerimeter());
	}
}