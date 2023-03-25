package vn.funix.fx16042.java.asm3.models;

import vn.funix.fx16042.java.asm2.models.Account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends Account implements IWithdraw,IReportService {
    private final int SAVINGS_ACCOUNT_MAX_WITHDRAW =5000000;
    public SavingsAccount() {
    }

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public int getSAVINGS_ACCOUNT_MAX_WITHDRAW() {
        return SAVINGS_ACCOUNT_MAX_WITHDRAW;
    }
    @Override
    public boolean withdraw(double amount) {
        double newBlance =0.0;
        if(isAccepted(amount)){
            newBlance=newBlance+amount;
            setBalance(getBalance()-newBlance);
            return true;
        } else return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        boolean check= false;
        if(isPremium()==true){
            if(amount>=50000&&amount%10000==0&&this.getBalance()-amount>=50000){
                check=true;
            }else {
                System.out.println("số tiền trong tài khoản không đủ hoặc");
                System.out.println("số tiền rút phải lớn hơn 50000đ và là bội số của 10000đ");
                System.out.print("nhập lại số tiền :");
                check=false;
            }
        } else {
            if(amount>=50000&&amount%10000==0&&this.getBalance()-amount>=50000&&amount<=getSAVINGS_ACCOUNT_MAX_WITHDRAW()){
                check=true;
            } else {
                System.out.println("số tiền trong tài khoản không đủ hoặc");
                System.out.println("số tiền rút phải lớn hơn 50000đ và nhỏ hơn 5.000.000đ và là bội số của 10000đ");
                System.out.print("nhập lại số tiền :");
                check=false;
            };
        }
        return check;
    }
    public  String date(){
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }


    @Override
    public void log(double amount) {
        String time =date();
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("         BIEN LAI GIAO DICH SAVING                  ");
        System.out.println("NGAY G/D :   "+time);
        System.out.println("ATM ID         DIGITAL-BANK-2022");
        System.out.println("STK :                                    "+this.getAccountNumber());
        System.out.println("SO TIEN:                                 "+amount);
        System.out.println("SO DU:                                   "+this.getBalance());
        System.out.println("PHI+VAT:                               0đ");
        System.out.println("+----------+-------------------------+------------+");
    }
}
