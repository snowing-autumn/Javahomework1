package homework1;

import java.util.Date;

public class EventTest {
    public static void main(String args[]){
        Event.getDesigner();
        PEvent P=new PEvent(Math.PI/6,4,new Date(1));
        PEvent P2=new PEvent(Math.PI/4,4,new Date(1));
        System.out.println(P.distance(P2));
        REvent R2=P.changeIntoREvent();
        REvent R=new REvent(Math.sqrt(3)*2,2,new Date(1));
        System.out.println(P);
        System.out.println(R);
        System.out.println(R2);
        System.out.println(P.equals(R)+"   "+R2.equals(R));
    }
}
