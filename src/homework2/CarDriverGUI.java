package homework2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class CarDriverGUI extends Application {
    Driver driver = new Driver();
    Car car = new Car();
    Font font;
    Stage stage=new Stage();
    String s="";

    @Override
    public void start(Stage primaryStage) {
        font = new Font(15);
        stage.setTitle(Car.getDesigner());
        initStageDriver();

    }

    public boolean initStageDriver() {
        try {
            HBox base = new HBox();
            base.setPadding(new Insets(15, 15, 15, 15));
            VBox left = new VBox();
            HBox button = new HBox();
            Label lblcode = new Label("档案编号:" + driver.getFileNumber());
            lblcode.setFont(font);
            Image imgDriver = new Image(driver.getImaginePath());
            ImageView imageViewDriver = new ImageView(imgDriver);
            imageViewDriver.setFitHeight(400);
            imageViewDriver.setFitWidth(550);
            Button btOK = new Button("确认修改");
            btOK.setFont(font);
            Button btCar = new Button("汽车");
            btCar.setOnAction(event -> initCar());
            btCar.setFont(font);
            button.getChildren().addAll(btOK, btCar);
            left.getChildren().addAll(lblcode, imageViewDriver, button);
            GridPane right = new GridPane();
            Label ldlName = new Label("姓名");
            ldlName.setFont(font);
            TextArea taName = new TextArea(driver.getName());
            Label lblNation = new Label("国籍");
            lblNation.setFont(font);
            TextArea taNation = new TextArea(driver.getNationality());
            Label lblAdress = new Label("住址");
            lblAdress.setFont(font);
            TextArea taAddress = new TextArea(driver.getAddress());
            Label lblBirthday = new Label("出生日期");
            lblBirthday.setFont(font);
            TextArea taBirthday = new TextArea(driver.getDateOfBirth().toString());
            taBirthday.setEditable(false);
            Label lblGetLicense = new Label("初次领证日期");
            lblGetLicense.setFont(font);
            TextArea taGetLicense = new TextArea(driver.getDateOfFirstLicense().toString());
            taGetLicense.setEditable(false);
            Label lblCarType = new Label("准驾车型");
            lblCarType.setFont(font);
            String stringcarTypes[] = {"A", "A2", "A3", "B1", "B2", "C1", "C2", "C3", "C4", "D", "E", "F", "M", "N", "P"};
            ComboBox<String> lvCarType = new ComboBox<>(FXCollections.observableArrayList(stringcarTypes));
            int index = driver.getModelForDriving().ordinal();
            lvCarType.getSelectionModel().select(index);
          /*  lvCarType.setOnAction(event -> {
                Driver.carType typecar=Driver.carType.valueOf(lvCarType.getValue());
            });*/
            Label lblPeriodOfValidity = new Label("有效日期");
            lblPeriodOfValidity.setFont(font);
            TextArea taPeriodOfValidity = new TextArea(driver.getPeriodOfValidity().toString());
            taPeriodOfValidity.setEditable(false);
            Label lblEffectiveDate = new Label("有效期限(年）");
            lblEffectiveDate.setFont(font);
            TextArea taEffectiveDate = new TextArea(String.valueOf(driver.getEffectiveDate()));
            right.setHgap(10);
            right.setVgap(10);
            taName.setMaxHeight(16);
            taName.setMaxWidth(300);
            taNation.setMaxHeight(16);
            taNation.setMaxWidth(300);
            taAddress.setMaxHeight(16);
            taAddress.setMaxWidth(300);
            taBirthday.setMaxHeight(16);
            taBirthday.setMaxWidth(300);
            taGetLicense.setMaxHeight(16);
            taGetLicense.setMaxWidth(300);
            taPeriodOfValidity.setMaxHeight(16);
            taPeriodOfValidity.setMaxWidth(300);
            taEffectiveDate.setMaxHeight(16);
            taEffectiveDate.setMaxWidth(300);
            btOK.setOnAction(event -> {
                String dName=taName.getText();
                String dNation=taNation.getText();
                String dAddress=taAddress.getText();
                String dEffective=taEffectiveDate.getText();
                driver.setName(dName);
                driver.setNationality(dNation);
                driver.setAddress(dAddress);
                driver.setEffectiveDate(Long.valueOf(dEffective));
                driver.setModelForDriving(Driver.carType.valueOf(lvCarType.getValue()));
                initStageDriver();
            });

            right.addColumn(0, ldlName, lblNation, lblAdress, lblBirthday, lblGetLicense, lblCarType, lblPeriodOfValidity, lblEffectiveDate);
            right.addColumn(1, taName, taNation, taAddress, taBirthday, taGetLicense, lvCarType, taPeriodOfValidity, taEffectiveDate);
            base.getChildren().addAll(left, right);
            Scene sDriver = new Scene(base);
            stage.setScene(sDriver);
            stage.show();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean initCar() {
        try {
            HBox base = new HBox();
            base.setPadding(new Insets(15, 15, 15, 15));
            VBox left = new VBox();
            HBox button = new HBox();
            Label lblCarIdentify = new Label("车辆识别号" + car.getVehicleIdentificationNumber());
            lblCarIdentify.setFont(font);
            Image imgCarAppearance = new Image(car.getImagePath());
            ImageView ivCarView = new ImageView(imgCarAppearance);
            ivCarView.setFitWidth(550);
            ivCarView.setFitHeight(400);
            HBox hbbutton = new HBox();
            Button btOK = new Button("确定修改");
            btOK.setFont(font);
            Button btDriver = new Button("该车所有人");
            btDriver.setFont(font);
            btDriver.setOnAction(event -> initStageDriver());
            Button brRun = new Button("行驶模拟");
            brRun.setOnAction(event -> initTravel());
            brRun.setFont(font);
            hbbutton.getChildren().addAll(btOK, btDriver, brRun);
            left.getChildren().addAll(lblCarIdentify, ivCarView, hbbutton);
            GridPane right = new GridPane();
            Label lblCarNumber = new Label("汽车号牌");
            lblCarNumber.setFont(font);
            TextArea taCarNumber = new TextArea(car.getCarNumber());
            Label lblCarType = new Label("车辆类型");
            lblCarType.setFont(font);
            String stringCarTypes[] = {"载货汽车", "越野汽车", "自卸汽车", "牵引车", "专用汽车", "客车", "轿车", "半挂车"};
            ComboBox<String> cbCarType = new ComboBox<>(FXCollections.observableArrayList(stringCarTypes));
            int index = car.getVehicleType().ordinal();
            cbCarType.getSelectionModel().select(index);
            Label lblOwner = new Label("所有人");
            lblOwner.setFont(font);
            TextArea taOwner = new TextArea(car.getOwner().getName());
            Label lblAddress = new Label("住址");
            lblAddress.setFont(font);
            TextArea taAddress = new TextArea(car.getOwner().getAddress());
            Label lblEngineNumber = new Label("发动机识别号码");
            lblEngineNumber.setFont(font);
            TextArea taEngineNumber = new TextArea(car.getEngineNumber());
            Label lblProduce = new Label("生产日期");
            lblProduce.setFont(font);
            TextArea taProduce = new TextArea(car.getProductionDate().toString());
            taProduce.setEditable(false);
            Label lblTank = new Label("油箱容量"+"(L)");
            lblTank.setFont(font);
            TextArea taTank = new TextArea(String.valueOf(car.getTankCapacity()));
            Label lblWeight = new Label("重量"+"(kg)");
            lblWeight.setFont(font);
            TextArea taWeight = new TextArea(String.valueOf(car.getWeight()));
            Label lblLoad = new Label("载重量"+"(kg)");
            lblLoad.setFont(font);
            TextArea taLoad = new TextArea(String.valueOf(car.getLoadWeight()));
            btOK.setOnAction(event -> {
                String cNumber=taCarNumber.getText();
                String cOwner=taOwner.getText();
                String cAddress=taAddress.getText();
                String cEngine=taEngineNumber.getText();
                String cTank=taTank.getText();
                String cWeight=taWeight.getText();
                String cLoad=taLoad.getText();

                car.setAddress(cAddress);
                car.setEngineNumber(cEngine);
                car.setLoadWeight(Float.valueOf(cLoad));
                car.setWeight(Float.valueOf(cWeight));
                car.setOwner(new Driver(cOwner));
                car.setTankCapacity(Float.valueOf(cTank));
                car.setCarNumber(cNumber);
                car.setVehicleType(Car.CarType.valueOf(cbCarType.getValue()));
                initCar();
            });
            right.setHgap(10);
            right.setVgap(10);
            taCarNumber.setMaxHeight(16);
            taCarNumber.setMaxWidth(300);
            taOwner.setMaxHeight(16);
            taOwner.setMaxWidth(300);
            taAddress.setMaxHeight(16);
            taAddress.setMaxWidth(300);
            taEngineNumber.setMaxHeight(16);
            taEngineNumber.setMaxWidth(300);
            taProduce.setMaxHeight(16);
            taProduce.setMaxWidth(300);
            taTank.setMaxHeight(16);
            taTank.setMaxWidth(300);
            taWeight.setMaxHeight(16);
            taWeight.setMaxWidth(300);
            taLoad.setMaxHeight(16);
            taLoad.setMaxWidth(300);
            right.addColumn(0, lblCarNumber, lblCarType, lblOwner, lblAddress, lblEngineNumber, lblProduce, lblTank, lblWeight, lblLoad);
            right.addColumn(1, taCarNumber, cbCarType, taOwner, taAddress, taEngineNumber, taProduce, taTank, taWeight, taLoad);
            base.getChildren().addAll(left, right);
            Scene sCar = new Scene(base);
            stage.setScene(sCar);
            stage.show();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean initTravel(){
        try {
            HBox base = new HBox();
            base.setPadding(new Insets(15, 15, 15, 15));
            TextArea left=new TextArea(s);
            left.setMaxWidth(550);
            left.setMaxHeight(600);
            left.setEditable(false);
            GridPane right=new GridPane();
            Label lblSumKilometer=new Label("总行驶里程数km");
            lblSumKilometer.setFont(font);
            TextArea taSumKilometer=new TextArea(String.valueOf(car.getTotalStrokeKilometerNumber()));
            taSumKilometer.setEditable(false);
            Label lblSpeed=new Label("速度km/h");
            lblSpeed.setFont(font);
            TextArea taSpeed=new TextArea(String.valueOf(car.getSpeed()));
            Label lblCurrentOil=new Label("当前油量L");
            TextArea taCurrentOil=new TextArea(String.valueOf(car.getCurrentOil()));
            taCurrentOil.setEditable(false);
            TextArea taAddOil=new TextArea();
            Button btAddOil=new Button("加油 L");
            btAddOil.setFont(font);
            btAddOil.setOnAction(event -> {
                car.refuel(Float.valueOf(taAddOil.getText()));
                taCurrentOil.setText(String.valueOf(car.getCurrentOil()));
            });
            Button btReturn=new Button("汽车");
            btReturn.setFont(font);
            btReturn.setOnAction(event -> initCar());
            Button btTravel=new Button("行驶");
            btTravel.setFont(font);
            ArrayList<journey> journeys=journey.getJourneys();
            btTravel.setOnAction(event -> {
                    car.travel(Float.valueOf(taSpeed.getText()), journeys);
                    taCurrentOil.setText(String.valueOf(car.getCurrentOil()));
                    taSumKilometer.setText(String.valueOf(car.getTotalStrokeKilometerNumber()));
                    s = s + car.getTemp()+"\n";
                    left.setText(s + "\n");

            });
            taSumKilometer.setMaxHeight(16);
            taSumKilometer.setMaxWidth(300);
            taCurrentOil.setMaxHeight(16);
            taCurrentOil.setMaxWidth(300);
            taAddOil.setMaxHeight(16);
            taAddOil.setMaxWidth(50);
            taSpeed.setMaxWidth(300);
            taSpeed.setMaxHeight(16);
            right.addColumn(0,lblSumKilometer,lblSpeed,lblCurrentOil,taAddOil,btReturn);
            right.addColumn(1,taSumKilometer,taSpeed,taCurrentOil,btAddOil,btTravel);
            base.getChildren().addAll(left,right);
            Scene snRun=new Scene(base);
            stage.setScene(snRun);
            stage.show();
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
