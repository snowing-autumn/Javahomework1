package homework1;

public abstract class Event {
    public static String getDesigner(){
        return ("设计者：【丁志成】 学号：【320170940351】 班级：【计算机基地班】");
    }

    abstract double distance(Event event);
}
