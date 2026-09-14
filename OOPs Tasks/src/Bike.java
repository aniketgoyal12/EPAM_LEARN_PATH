public class Bike extends Vehicle {
    @Override
    public void start(){
        super.start();
        System.out.println("Bike engine starting...");
    }
    @Override
    public void stop(){
        super.stop();
        System.out.println("Bike engine stopping...");
    }
}
