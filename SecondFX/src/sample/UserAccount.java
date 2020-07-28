package sample;



public class UserAccount {
    private Double X;
    private String Y;

    public UserAccount(Double X, String Y) {
        this.X=X;
        this.Y=Y;
    }
    public UserAccount(){
    }
    public Double getX() {
        return X;
    }

    public void setX(Double X) {
        this.X = X;
    }

    public String getY() {
        return Y;
    }

    public void setY(String Y) {
        this.Y = Y;
    }
}
