package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {

    public ObservableList<UserAccount> usersData = FXCollections.observableArrayList();
    double Xi[]=new double[10];
    double Yi[]=new double[10];

    double A=0,B=0;


    @FXML
    private TextField textA;

    @FXML
    private Button doButton;

    @FXML
    private TextField textB;

    @FXML
    private TableView<UserAccount> Table;

    @FXML
    private TableColumn<UserAccount, Double> Col1;

    @FXML
    private TableColumn<UserAccount, String> Col2;

    @FXML
    private void initialize() {
        initData();
        Col1.setCellValueFactory(new PropertyValueFactory<UserAccount, Double>("X"));
        Col2.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Y"));

        Table.setItems(usersData);

    }

    private void initData() {
        usersData.add(new UserAccount(null, null));
    }

    @FXML
    void onClickClear() {
        textA.clear();
        textB.clear();
        Table.getItems().clear();
        doButton.setVisible(false);


    }
    @FXML
    void onClickClose() {
        Stage stage = (Stage) textA.getScene().getWindow();
        stage.close();
    }
    @FXML
    void onClickDo() {
        A = Double.parseDouble(textA.getText());
        B = Double.parseDouble(textB.getText());
        boolean Nul = false;
        for (int i=0;i< 10;i++) {
            if (Xi[i]==0) {
                Nul = true;
            }
        }
            if (A == 0 && B == 0 && Nul) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Пример не имеет решения при данных значениях");
                alert.showAndWait();
            } else{
                if (A == 0 && B == 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Пример не имеет решения при данных значениях");
                    alert.showAndWait();
                }else{
                    Table.getItems().clear();
                    double sum =0;
                    for (int i=0;i< 10;i++) {
                        Yi[i]=(Math.cos(Xi[i])/Math.sqrt((A*A+B*B-Math.sin(Xi[i]))))*sum;
                        sum+=Xi[i];
                    }
                    usersData.add(new UserAccount(Xi[0], "-"));
                    for (int i=1;i< 10;i++) {
                        usersData.add(new UserAccount(Xi[i], String.valueOf(Yi[i])));
                    }
                    Table.setItems(usersData);



                }
        }

    }

    @FXML
    void onClickGenerate() {

        Table.getItems().clear();
        for (int i=0;i< 10;i++) {
            Xi[i] = (Math.random() * 100)-50;
            usersData.add(new UserAccount(Xi[i], null));
        }
        Table.setItems(usersData);

        if (textA.getText().equals("")){
            double A=Math.random() * 10;
            textA.setText(String.valueOf(A));
        }
        if (textB.getText().equals("")){
            double B=Math.random() * 10;
            textB.setText(String.valueOf(B));
        }
        doButton.setVisible(true);
    }

}
