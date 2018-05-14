package homework2;

import java.awt.*;
import java.io.File;
import java.util.Date;

public class Driver {

    enum carType {
        A1, A2, A3, B1, B2, C1, C2, C3, C4, D, E, F, M, N, P
    }

    private String name;
    private String nationality;
    private String address;
    private Date dateOfBirth;
    private Date dateOfFirstLicense;
    private long effectiveDate;
    private Date periodOfValidity;
    private Image photos;
    private long fileNumber;
    private carType modelForDriving;

    private String imaginePath= "homework2/driver.jpg";

    public Driver(String name, String nationality, String address, Date dateOfBirth, Date dateOfFirstLicense, long effectiveDate, Date periodOfValidity, Image photos, long fileNumber, carType modelForDriving) {
        this.name = name;
        this.nationality = nationality;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfFirstLicense = dateOfFirstLicense;
        this.effectiveDate = effectiveDate;
        this.periodOfValidity = periodOfValidity;
        this.photos = photos;
        this.fileNumber = fileNumber;
        this.modelForDriving = modelForDriving;
    }

    public  Driver(String name){
        this.name=name;
        nationality="";
        address="";
        dateOfBirth=new Date(0);
        dateOfFirstLicense=new Date(0);
        effectiveDate=0;
        periodOfValidity=dateOfFirstLicense;
        photos=null;
        fileNumber=0;
        modelForDriving=carType.C1;
    }

    public Driver(){
        name="";
        nationality="";
        address="";
        dateOfBirth=new Date(0);
        dateOfFirstLicense=new Date(0);
        effectiveDate=0;
        periodOfValidity=dateOfFirstLicense;
        photos=null;
        fileNumber=0;
        modelForDriving=carType.C1;
    }

    @Override
    public String toString() {
        return "驾驶员{" +
                "姓名='" + name + '\'' +
                ", 国籍='" + nationality + '\'' +
                ", 住址='" + address + '\'' +
                ", 出生日期=" + dateOfBirth +
                ", 初次领证日期=" + dateOfFirstLicense +
                ", 有效日期=" + effectiveDate +
                "年, 有效期限=" + periodOfValidity +
                ", 照片" + photos +
                ", 档案编号=" + fileNumber +
                ", 驾驶车型=" + modelForDriving +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (getEffectiveDate() != driver.getEffectiveDate()) return false;
        if (getFileNumber() != driver.getFileNumber()) return false;
        if (getName() != null ? !getName().equals(driver.getName()) : driver.getName() != null) return false;
        if (getNationality() != null ? !getNationality().equals(driver.getNationality()) : driver.getNationality() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(driver.getAddress()) : driver.getAddress() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(driver.getDateOfBirth()) : driver.getDateOfBirth() != null)
            return false;
        if (getDateOfFirstLicense() != null ? !getDateOfFirstLicense().equals(driver.getDateOfFirstLicense()) : driver.getDateOfFirstLicense() != null)
            return false;
        if (getPeriodOfValidity() != null ? !getPeriodOfValidity().equals(driver.getPeriodOfValidity()) : driver.getPeriodOfValidity() != null)
            return false;
        if (getPhotos() != null ? !getPhotos().equals(driver.getPhotos()) : driver.getPhotos() != null) return false;
        return getModelForDriving() == driver.getModelForDriving();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getNationality() != null ? getNationality().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getDateOfFirstLicense() != null ? getDateOfFirstLicense().hashCode() : 0);
        result = 31 * result + (int) (getEffectiveDate() ^ (getEffectiveDate() >>> 32));
        result = 31 * result + (getPeriodOfValidity() != null ? getPeriodOfValidity().hashCode() : 0);
        result = 31 * result + (getPhotos() != null ? getPhotos().hashCode() : 0);
        result = 31 * result + (int) (getFileNumber() ^ (getFileNumber() >>> 32));
        result = 31 * result + (getModelForDriving() != null ? getModelForDriving().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfFirstLicense() {
        return dateOfFirstLicense;
    }

    public void setDateOfFirstLicense(Date dateOfFirstLicense) {
        this.dateOfFirstLicense = dateOfFirstLicense;
    }

    public long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Date periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public Image getPhotos() {
        Toolkit  imgtool=Toolkit.getDefaultToolkit();
        Image myimg=imgtool.getImage(imaginePath);

        return myimg;
    }

    public void setPhotos(Image photos) {
        this.photos = photos;
    }

    public long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public carType getModelForDriving() {
        return modelForDriving;
    }

    public void setModelForDriving(carType modelForDriving) {
        this.modelForDriving = modelForDriving;
    }

    public String getImaginePath(){
        return imaginePath;
    }

    public boolean setImaginePath(String imaginePath){
        File file=new File(imaginePath);
        if(file.exists()){
            this.imaginePath=imaginePath;
            return true;
        }else
            return false;
    }

}