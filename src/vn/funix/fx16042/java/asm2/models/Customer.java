package vn.funix.fx16042.java.asm2.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String customerId) {
        super(name, customerId);
        this.accounts=new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public boolean isPremium() {
        boolean ac =false;
        for (Account acc:accounts
             ) {
            if(acc.isPremium()==true){
               return true;
            } else {
                return false;
            }
        }
        return ac;

    }
    public void addAccount(Account newAccount){
        if(newAccount==null){
            return;
        }
        boolean isAcceptAdd = false;
        if(accounts==null||accounts.isEmpty()){
            isAcceptAdd=true;
        } else {
            for (Account acc:accounts
                 ) {
                if(acc.getAccountNumber().equals(newAccount.getAccountNumber())){
                    isAcceptAdd=false;
                    break;
                }
            }
        }
        if(isAcceptAdd){
            accounts.add(newAccount);
        }
    }
    public double getBalance(){
        double sum=0;
        for (Account acc :accounts
             ) {
            sum=sum+acc.getBalance();
        }
        return sum;
    }
    public String hehe (boolean abc){
        String vip ="Premium";
        String nomal ="Nomal";
        if(abc==true){
            return vip;
        } else return nomal;
    }
    public boolean displayInformation(){

        System.out.println(getCustomerId()+"   |"+getName()+"     |"+hehe(isPremium())+"          "+getBalance());
        for (int i = 0; i <accounts.size() ; i++) {
            System.out.println(i+1 +"    "+ accounts.get(i).getAccountNumber() +"                               "+accounts.get(i).getBalance());
        }
        return false;
    }
}
