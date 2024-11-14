public class ElonsToyCar 
{

    private int battery;
    private final int meters = 20;
    
    private ElonsToyCar()
    {
        battery = 100;
    } 
    public static ElonsToyCar buy() 
    {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        throw new UnsupportedOperationException("Please implement the ElonsToyCar.distanceDisplay()  method");
    }

    public String batteryDisplay() {
        throw new UnsupportedOperationException("Please implement the ElonsToyCar.batteryDisplay()  method");
    }

    public void drive() {
        throw new UnsupportedOperationException("Please implement the ElonsToyCar.drive()  method");
    }
}
