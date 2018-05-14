package homework1;

import java.util.Date;

public class REvent extends Event {
    private double x;
    private double y;
    private Date time;

    public REvent(double x, double y, Date time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
    public REvent(){
        this(0,0,new Date(0));
    }

    @Override
    public boolean equals(Object event){
        if(event instanceof REvent)
            return Double.parseDouble(String.format(".8f",x))==Double.parseDouble(String.format(".8f",((REvent) event).getX()))&&Double.parseDouble(String.format(".8f",y))==Double.parseDouble(String.format(".8f",((REvent) event).getY()))&&this.time.equals(((REvent)event).getTime());
        if (event instanceof PEvent)
            return this.equals(((PEvent) event).changeIntoREvent());
        else
            return false;
    }

    @Override
    public int hashCode() {
       return this.changeIntoPEvent().hashCode();
    }

    @Override
    public String toString() {
        return "homework1.REvent{" +
                "x=" + x +
                ", y=" + y +
                ", time=" + time +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double distance(Event event){
        if(event instanceof REvent)
            return Math.sqrt((this.x-((REvent) event).getX())*(this.x-((REvent) event).getX())+(this.y-((REvent) event).getY())*(this.y-((REvent) event).getY()));
        if(event instanceof PEvent)
            return distance(((PEvent) event).changeIntoREvent());
        else
            return 0;
    }

    public PEvent changeIntoPEvent(){
        PEvent pEvent;
        if(y>=0)
            pEvent = new PEvent(Math.sqrt(x*x+y*y),Math.atan(y/x),time);
        else
            pEvent = new PEvent(Math.sqrt(x*x+y*y),-Math.atan(y/x),time);
        return pEvent;
    }

}
