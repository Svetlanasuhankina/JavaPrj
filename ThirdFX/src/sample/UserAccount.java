package sample;



public class UserAccount {
    private Integer C1,C2,C3,C4,C5;


    public UserAccount(Integer C1, Integer C2,Integer C3,Integer C4,Integer C5) {
        this.C1=C1;
        this.C2=C2;
        this.C3=C3;
        this.C4=C4;
        this.C5=C5;

    }
    public UserAccount(){
    }
    public Integer getC1() { return C1; }

    public void setC1(Integer C1) {
        this.C1 = C1;
    }

    public Integer getC2() {
        return C2;
    }

    public void setC2(Integer C2) { this.C2 = C2; }

    public Integer getC3() {
        return C3;
    }

    public void setC3(Integer C3) { this.C3 = C3; }

    public Integer getC4() { return C4; }

    public void setC4(Integer C4) { this.C4 = C4; }

    public Integer getC5() {
        return C5;
    }

    public void setC5(Integer C5) { this.C5 = C5; }

}
