package vn.funix.fx16042.java.asm3.models;

import vn.funix.fx16042.java.asm2.models.Account;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoansAccount extends Account implements IWithdraw,IReportService{
    private final double LOAN_ACCOUNT_WITHDRAW_FEE =0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE =0.01;
    private final int LOAN_ACCOUNT_MAX_BALANCE =100000000;
    public LoansAccount() {
    }

    public LoansAccount (String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public int getLOAN_ACCOUNT_MAX_BALANCE() {
        return LOAN_ACCOUNT_MAX_BALANCE;
    }


    @Override
    public boolean withdraw(double amount) {
        double newBlance =0.0;
        double vat =0.0;
        if(isAccepted(amount)==true&&isPremium()==true){
            newBlance=newBlance+amount;
            vat =newBlance*0.01;
            setBalance(getBalance()-(newBlance+vat));
            return true;
        } else if (isPremium()==false&&isAccepted(amount)==true) {
            newBlance=newBlance+amount;
            vat =newBlance*0.05;
            setBalance(getBalance()-(newBlance+vat));
            return true;
        }else return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        boolean check =false;
        if(amount<=getLOAN_ACCOUNT_MAX_BALANCE()&&this.getBalance()-amount>=50000){
           check=true;
        } else {
            System.out.println("số tiền trong tài khoản không đủ hoặc");
            System.out.println("số tiền rút không quá 100.000.000đ");
            System.out.print("nhâp lại số tiền :");
            check=false;
        };
        return check;
    }
    public static String date(){
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    @Override
    public void log(double amount) {
        String time =date();
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("         BIEN LAI GIAO DICH LOAN                   ");
        System.out.println("NGAY G/D :   "+time);
        System.out.println("ATM ID         DIGITAL-BANK-2022");
        System.out.println("STK :                      "+this.getAccountNumber());
        System.out.println("SO TIEN:                   "+amount);
        System.out.println("SO DU:                     "+this.getBalance());
        System.out.println("PHI+VAT:                   "+(this.LOAN_ACCOUNT_MAX_BALANCE-this.getBalance()));
        System.out.println("+----------+-------------------------+------------+");

    }
}
