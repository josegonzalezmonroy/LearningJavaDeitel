public enum TrafficLight 
{
    RED(30),
    GREEN(70),
    YELLOW(5);
    
    private final int duration;

    TrafficLight(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }
}
