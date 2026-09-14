public class Car extends Vehicle{
    @Override
    public void start(){
        super.start();
        System.out.println("Car engine starting...");
    }
    @Override
    public void stop(){
        super.stop();
        System.out.println("Car engine stopping...");
    }
}
