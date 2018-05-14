package homework2;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Car {
    public enum CarType{
        载货汽车,越野汽车,自卸汽车,牵引车,专用汽车,客车,轿车,半挂车
    }

    private String carNumber;
    private CarType vehicleType;
    private Driver owner;
    private String Address;
    private String engineNumber;
    private String vehicleIdentificationNumber;
    private Date productionDate;
    private float tankCapacity;
    private float currentOil;
    private float weight;
    private float loadWeight;
    private Image appearancePicture;
    private long totalStrokeKilometerNumber;

    private float speed;
    private String imagePath= "homework2/car.jpg";
    public enum Statement {
        STOP, RUN, DERUN
    }
    private Statement state;
    public ArrayList<journey> journeys=new ArrayList<>();
    private String temp;
    private int i=0;

    public Car(String carNumber, CarType vehicleType, Driver owner, String engineNumber, String vehicleIdentificationNumber, Date productionDate, float tankCapacity, float currentOil, float weight, float loadWeight, Image appearancePicture, long totalStrokeKilometerNumber) {
        this.carNumber = carNumber;
        this.vehicleType = vehicleType;
        this.owner = owner;
        Address = owner.getAddress();
        this.engineNumber = engineNumber;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.productionDate = productionDate;
        this.tankCapacity = tankCapacity;
        this.currentOil = currentOil;
        this.weight = weight;
        this.loadWeight = loadWeight;
        this.appearancePicture = appearancePicture;
        this.totalStrokeKilometerNumber = totalStrokeKilometerNumber;
        this.speed = 0;
    }

    public Car(){
        carNumber="";
        vehicleType=CarType.轿车;
        owner=new Driver();
        Address=owner.getAddress();
        engineNumber="";
        vehicleIdentificationNumber="";
        productionDate=new Date(0);
        tankCapacity=50;
        currentOil=0;
        weight=1560;
        loadWeight=375;
        Toolkit  imagtool=Toolkit.getDefaultToolkit();
        appearancePicture=imagtool.getImage("1.jpg");
        totalStrokeKilometerNumber=0;
        speed=0;

    }


    @Override
    public String toString() {
        return "汽车{" +
                "汽车号牌='" + carNumber + '\'' +
                ", 车辆类型=" + vehicleType +
                ", 所有人=" + owner +
                ", 住址='" + Address + '\'' +
                ", 发动机号码='" + engineNumber + '\'' +
                ", 车辆识别号='" + vehicleIdentificationNumber + '\'' +
                ", 生产日期=" + productionDate +
                ", 油箱容量=" + tankCapacity +
                "L, 当前油量=" + currentOil +
                "L, 重量=" + weight +
                "kg, 载重量=" + loadWeight +
                "kg, 外观图片=" + appearancePicture +
                ", 总行程公里数=" + totalStrokeKilometerNumber +
                "km}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getCarNumber() != null ? !getCarNumber().equals(car.getCarNumber()) : car.getCarNumber() != null)
            return false;
        if (getVehicleType() != car.getVehicleType()) return false;
        if (getOwner() != null ? !getOwner().equals(car.getOwner()) : car.getOwner() != null) return false;
        if (getAddress() != null ? !getAddress().equals(car.getAddress()) : car.getAddress() != null) return false;
        if (getEngineNumber() != null ? !getEngineNumber().equals(car.getEngineNumber()) : car.getEngineNumber() != null)
            return false;
        return (getVehicleIdentificationNumber() != null ? !getVehicleIdentificationNumber().equals(car.getVehicleIdentificationNumber()) : car.getVehicleIdentificationNumber() != null);
    }

    @Override
    public int hashCode() {
        int result = getCarNumber() != null ? getCarNumber().hashCode() : 0;
        result = 31 * result + (getVehicleType() != null ? getVehicleType().hashCode() : 0);
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getEngineNumber() != null ? getEngineNumber().hashCode() : 0);
        result = 31 * result + (getVehicleIdentificationNumber() != null ? getVehicleIdentificationNumber().hashCode() : 0);
        result = 31 * result + (getProductionDate() != null ? getProductionDate().hashCode() : 0);
        return result;
    }

    public static String getDesigner(){
        return "设计者： 【丁志成】 学号：【320170940351】 班级：【计算机基地班】";
    }

    public void accelerate(float speed){
        this.speed+=speed;
        if(this.speed>0){
            state=Statement.RUN;
        }else if (this.speed==0){
            state=Statement.STOP;
        }else
            state=Statement.DERUN;
    }

    public void decelerate(float speed){
        this.speed-=speed;
        if(this.speed>0){
            state=Statement.RUN;
        }else if (this.speed==0){
            state=Statement.STOP;
        }else
            state=Statement.DERUN;
    }
    public void stop(){
        speed = 0;
        state=Statement.STOP;
    }

    public double currentAverageFuelConsumption(){
        return 7+Math.abs(speed-70)/50;
    }

    public void refuel(float addFuel){
        if (addFuel<0){
            System.out.println("请不要加入负容量的油");
            return;
        }
        if(currentOil+addFuel<tankCapacity)
            currentOil+=addFuel;
        else
            currentOil=tankCapacity;
    }

    public double estimatedTravelDistance(){
        return currentOil/this.currentAverageFuelConsumption();
    }

    public boolean travel(float speed,ArrayList<journey> beginJourney){
        if(speed<=0)
            return false;
        if(currentOil-beginJourney.get(i).getDistance()/100*currentAverageFuelConsumption()<=0){
            temp="油量不够！请加油";
            System.out.println(temp);
            return true;}
        this.speed=speed;
        state=Statement.RUN;
        currentOil-=beginJourney.get(i).getDistance()/100*currentAverageFuelConsumption();
        temp="到达"+beginJourney.get(i).getName()+"\n用时"+beginJourney.get(i).getDistance()/speed+"小时";
        System.out.println(temp);
        totalStrokeKilometerNumber+=beginJourney.get(i).getDistance();
        i++;
        if(i>=beginJourney.size())
                return false;
        return true;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public boolean setCarNumber(String carNumber) {
        if (carNumber == null || carNumber.length() != 7) {
            return false;
        } else {
            this.carNumber = carNumber;
            return true;
        }
    }

    public CarType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(CarType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Driver getOwner() {
        return owner;
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public boolean setEngineNumber(String engineNumber) {
        if (engineNumber == null ) {
            return false;
        } else {
            this.engineNumber = engineNumber;
            return true;
        }
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public boolean setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        if (vehicleIdentificationNumber == null || vehicleIdentificationNumber.length() != 17) {
            return false;
        } else {
            this.vehicleIdentificationNumber = vehicleIdentificationNumber;
            return true;
        }
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public float getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(float tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public float getCurrentOil() {
        return currentOil;
    }

    public void setCurrentOil(float currentOil) {
        this.currentOil = currentOil;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(float loadWeight) {
        this.loadWeight = loadWeight;
    }

    public Image getAppearancePicture() {
        return appearancePicture;
    }

    public void setAppearancePicture(Image appearancePicture) {
        this.appearancePicture = appearancePicture;
    }

    public long getTotalStrokeKilometerNumber() {
        return totalStrokeKilometerNumber;
    }

    public void setTotalStrokeKilometerNumber(long totalStrokeKilometerNumber) {
        this.totalStrokeKilometerNumber = totalStrokeKilometerNumber;
    }

    public String getImagePath(){
        return imagePath;
    }

    public boolean setImagePath(String imagePath){
        File file=new File(imagePath);
        if(file.exists()){
            this.imagePath=imagePath;
            return true;
        }else
            return false;
    }

    public String getTemp(){
        return temp;
    }

    public float getSpeed(){
        return speed;
    }
}
