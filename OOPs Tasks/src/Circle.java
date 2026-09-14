public class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double calculateArea(){
        double area = 3.14 * radius * radius;
        return area;
    }
}
