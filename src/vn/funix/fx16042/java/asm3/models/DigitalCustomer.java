package vn.funix.fx16042.java.asm3.models;

import vn.funix.fx16042.java.asm2.models.Account;
import vn.funix.fx16042.java.asm2.models.Customer;

public class DigitalCustomer extends Customer {

    public DigitalCustomer(String name, String customerId) {
        super(name, customerId);
    }
    public String type(Account account){
        String typeAcc = null;
        if(account instanceof LoansAccount){
            typeAcc="loan";
        } else if(account instanceof SavingsAccount){
            typeAcc ="save";
        }
        return typeAcc;
    }
    @Override
    public boolean displayInformation() {
        System.out.println(this.getCustomerId()+"|       "+this.getName()+"|       "+hehe(this.isPremium())+"|      "+this.getBalance());
        for (int i = 0; i <this.getAccounts().size() ; i++) {
            System.out.println(i+1 +"      " +this.getAccounts().get(i).getAccountNumber()+"      "+type(this.getAccounts().get(i))+"|                       "+this.getAccounts().get(i).getBalance());
        }
       return false;
    }


}
