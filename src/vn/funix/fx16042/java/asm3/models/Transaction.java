package vn.funix.fx16042.java.asm3.models;

import vn.funix.fx16042.java.asm2.models.Account;

import java.util.List;
import java.util.UUID;

public class Transaction extends DigitalCustomer{
    private  List<TransactionTow> arr;
    private  String id;

    public Transaction(String name, String customerId, List<TransactionTow> arr) {
        super(name, customerId);
        this.arr = arr;
    }

    @Override
    public boolean displayInformation() {
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("               LỊCH SỬ GIAO DỊCH");
        System.out.println(this.getCustomerId()+"|       "+this.getName()+"|       "+hehe(this.isPremium())+"|      "+this.getBalance());
        for (int i = 0; i <this.getAccounts().size() ; i++) {
            System.out.println(i+1 +"      " +this.getAccounts().get(i).getAccountNumber()+"      "+type(this.getAccounts().get(i))+"|                       "+this.getAccounts().get(i).getBalance());
        }
        System.out.println("----------------------------------------------------");
        for (int i = 0; i <this.arr.size(); i++) {
            System.out.println(this.arr.get(i).getSoTai()+"|         "+"-"+this.arr.get(i).getAmount()+"|         "+this.arr.get(i).getTime());
        }
        System.out.println("+----------+-------------------------+------------+");
        return false;
    }


}
