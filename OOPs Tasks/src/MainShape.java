public class MainShape {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(6,5);
        System.out.println(r1.calculateArea());
        System.out.println();
        Circle c1 = new Circle(10.0);
        System.out.println(c1.calculateArea());
    }
}
