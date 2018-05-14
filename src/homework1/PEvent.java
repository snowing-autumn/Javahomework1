package homework1;

import java.util.Date;
import java.util.Objects;

public class PEvent extends Event {
    private double polarAngle;
    private double polarAxis;
    private Date time;

    public PEvent(){
        this(0,0,new Date(0));

    }

    public PEvent(double polarAngle,double polarAxis,Date time){
        if(polarAxis>=0) {
            if(polarAngle>=0)
                this.polarAngle = polarAngle % (2*Math.PI);
            else
                this.polarAngle=polarAngle % (2*Math.PI)+2*Math.PI;
            this.polarAxis = polarAxis;
        }
        else {
            if(polarAngle<=0)
                this.polarAngle = polarAngle % (2*Math.PI)+3*Math.PI;
            else
                this.polarAngle=polarAngle % (2*Math.PI)+Math.PI;
            if(this.polarAngle>=2*Math.PI) this.polarAngle-=2*Math.PI;
            this.polarAxis = Math.abs(polarAxis);
        }
        this.time=time;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PEvent)
            return Double.parseDouble(String.format(".8f",polarAngle))==Double.parseDouble(String.format(".8f",((PEvent) o).getPolarAngle()))&&Double.parseDouble(String.format(".8f",polarAxis))==Double.parseDouble(String.format(".8f",((PEvent) o).getPolarAxis()))&&this.time.equals(((PEvent) o).getTime());
        if(o instanceof REvent)
            return this.equals(((REvent) o).changeIntoPEvent());
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Double.parseDouble(String.format(".8f",polarAngle)),Double.parseDouble(String.format(".8f",polarAxis)),time);
    }

    @Override
    public String toString() {
        return "homework1.PEvent{" +
                "polarAngle=" + polarAngle +
                ", polarAxis=" + polarAxis +
                ", time=" + time +
                '}';
    }

    public double getPolarAngle() {
        return polarAngle;
    }

    public void setPolarAngle(double polarAngle) {
        if(polarAngle>=0)
            this.polarAngle = polarAngle % (2*Math.PI);
        else
            this.polarAngle=polarAngle % (2*Math.PI)+2*Math.PI;
    }

    public double getPolarAxis() {
        return polarAxis;
    }

    public void setPolarAxis(double polarAxis) {
        if(polarAxis>=0) {
            if(polarAngle>=0)
                this.polarAngle = polarAngle % (2*Math.PI);
            else
                this.polarAngle=polarAngle % (2*Math.PI)+2*Math.PI;
            this.polarAxis = polarAxis;
        }
        else {
            if(polarAngle<=0)
                this.polarAngle = polarAngle % (2*Math.PI)+3*Math.PI;
            else
                this.polarAngle=polarAngle % (2*Math.PI)+Math.PI;
            if(this.polarAngle>=2*Math.PI) this.polarAngle-=2*Math.PI;
            this.polarAxis = Math.abs(polarAxis);
        }
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double distance(Event event){
        if(event instanceof PEvent){
            return Math.sqrt(this.polarAxis*this.polarAxis+((PEvent) event).getPolarAxis()*((PEvent) event).getPolarAxis()-2*this.polarAxis*((PEvent) event).getPolarAxis()*Math.cos(this.polarAngle-((PEvent) event).getPolarAngle()));
        }
        if(event instanceof REvent){
            return this.distance(((REvent) event).changeIntoPEvent());
        }
        else return 0;
    }
    public REvent changeIntoREvent(){
        REvent rEvent=new REvent(this.polarAxis*Math.cos(this.polarAngle),this.polarAxis*Math.sin(this.polarAngle),this.time);
        return rEvent;
    }


}
