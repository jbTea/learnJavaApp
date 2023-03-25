package vn.funix.fx16042.java.asm3.models;

public class TransactionTow {
    private String time;
    private double amount;
    private String soTai;

    public TransactionTow(String time, double amount, String soTai) {
        this.time = time;
        this.amount = amount;
        this.soTai = soTai;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSoTai() {
        return soTai;
    }

    public void setSoTai(String soTai) {
        this.soTai = soTai;
    }
}
