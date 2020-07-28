package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller{
    @FXML
    private TextField textX;
    @FXML
    private TextField textA;
    @FXML
    private TextField textB;
    @FXML
    private TextField textResult;
    @FXML
    private Button CloseButtton;

    @FXML
    public void onClickClear(){
        textX.clear();
        textA.clear();
        textB.clear();
        textResult.clear();

    }
    @FXML
    public void onClickStart(){
        double Y = 0;

    if (textX.getText().equals("") | textB.getText().equals("") | textA.getText().equals("")){
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Вы не ввели значения");
        alert2.showAndWait();
    }else{
        double X = Double.parseDouble(textX.getText());
        double A = Double.parseDouble(textA.getText());
        double B = Double.parseDouble(textB.getText());
        if (X<=7){
            if (A!=0&&B!=0){
                Y = (X+4)/(A*A+B*B);
                textResult.setText(String.valueOf(Y));
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Деление на ноль запрещено!");
                alert.showAndWait();
            }
        }else {
            Y = X*Math.pow(A+B,2);
            textResult.setText(String.valueOf(Y));
        }

    }

    }
   public void onClickClose(){
       Stage stage = (Stage) CloseButtton.getScene().getWindow();
       stage.close();
    }
}