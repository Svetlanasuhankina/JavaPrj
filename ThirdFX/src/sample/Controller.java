package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DecimalFormat;


public class Controller {
    public ObservableList<UserAccount> usersData = FXCollections.observableArrayList();
    int array[][]=new int[5][5];
    int max = 0, min = 0;
    double temp =0;
    @FXML
    private TableView<UserAccount> Table;

    @FXML
    private Button doButton;

    @FXML
    private TableColumn<UserAccount, Integer> Col1;

    @FXML
    private TableColumn<UserAccount, Integer> Col2;

    @FXML
    private TableColumn<UserAccount, Integer> Col3;

    @FXML
    private TableColumn<UserAccount, Integer> Col4;

    @FXML
    private TableColumn<UserAccount, Integer> Col5;

    @FXML
    private Label textMax;

    @FXML
    private Label textMin;

    @FXML
    private Label LableMaxMin;

    @FXML
    private Label textMaxMin;

    @FXML
    private void initialize() {
        initData();
        Col1.setCellValueFactory(new PropertyValueFactory<UserAccount, Integer>("C1"));
        Col2.setCellValueFactory(new PropertyValueFactory<UserAccount, Integer>("C2"));
        Col3.setCellValueFactory(new PropertyValueFactory<UserAccount, Integer>("C3"));
        Col4.setCellValueFactory(new PropertyValueFactory<UserAccount, Integer>("C4"));
        Col5.setCellValueFactory(new PropertyValueFactory<UserAccount, Integer>("C5"));

        Table.setItems(usersData);

    }
    private void initData() {
        usersData.add(new UserAccount(null, null, null, null, null));
    }



    @FXML
    void onClickDo() {
        temp = (double)max/(double)min;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format(temp);
        LableMaxMin.setVisible(true);
        textMaxMin.setText(String.valueOf(result));
        if (min!=0) {
            if (temp == 10) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (array[i][j] < 0) {
                            array[i][j] = Math.abs(array[i][j]);
                        }
                        if (array[i][j] == 0) {
                            array[i][j] = 1;
                        }
                    }
                }
                Table.getItems().clear();
                for (int i = 0; i < 5; i++) {
                    usersData.add(new UserAccount(array[i][0], array[i][1], array[i][2], array[i][3], array[i][4]));
                }
                Table.setItems(usersData);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Решения нет - минимум равен 0");
            alert.showAndWait();
        }
    }

    @FXML
    void onClickGenerate() {
        LableMaxMin.setVisible(false);
        textMaxMin.setText("");
        textMax.setText("");
        textMin.setText("");
        Table.getItems().clear();
        for (int i=0;i< 5;i++) {
            for (int j=0;j< 5;j++) {
                array[i][j]=(int)(Math.random() * 60)-20;
            }
        }
        max = array[0][0];
        min = array[0][0];
        for (int i=0;i< 5;i++) {
            for (int j=0;j< 5;j++) {
                if (array[i][j]>max) {
                    max=array[i][j];
                }
                if (array[i][j]<min) {
                    min=array[i][j];
                }
            }
        }
        for (int i=0;i< 5;i++) {
            usersData.add(new UserAccount(array[i][0], array[i][1],array[i][2],array[i][3],array[i][4]));
        }

        Table.setItems(usersData);
        doButton.setVisible(true);
        textMax.setText(String.valueOf(max));
        textMin.setText(String.valueOf(min));

    }

}
