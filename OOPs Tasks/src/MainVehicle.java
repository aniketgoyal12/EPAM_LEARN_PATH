public class MainVehicle {
    public static void main(String[] args){
        Car car1 = new Car();
        Bike bike1 = new Bike();
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        car1.start();
        System.out.println();
        car1.stop();
        System.out.println();
        bike1.start();
        System.out.println();
        bike1.stop();
        System.out.println();
        v1.start();
        System.out.println();
        v1.stop();
        System.out.println();
        v2.start();
        System.out.println();
        v2.stop();
    }
}
