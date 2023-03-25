package vn.funix.fx16042.java.asm3.models;

import vn.funix.fx16042.java.asm2.models.Account;
import vn.funix.fx16042.java.asm2.models.Bank;
import vn.funix.fx16042.java.asm2.models.Customer;

import java.util.List;

public class DigitalBank extends Bank {
    public DigitalBank() {
    }
    public Customer getCustomerByStk(String soTaiKhoan){
        Customer cuss = null;
        for (int i = 0; i < this.getCustomers().get(i).getAccounts().size(); i++) {
            for (int j = 0; j <this.getCustomers().size() ; j++) {
                if(this.getCustomers().get(j).getAccounts().get(i).getAccountNumber().equals(soTaiKhoan)){
                    cuss= this.getCustomers().get(j);
                } else cuss = null;
            }
        }
        return cuss;
    }
    public Customer getCustomerById (String customerId){
        Customer cus = null;
        for (Customer cuss: this.getCustomers()
             ) {
            if(cuss.getCustomerId().equals(customerId)){
                cus=cuss;
            }else cus=null;
        }
        return cus;
    }
    public Account backAccount (String soTaiKhoan ){
          Account acc =null;
        for (int i = 0; i <this.getCustomers().size() ; i++) {
            for (int j = 0; j < this.getCustomers().get(i).getAccounts().size(); j++) {
                if(this.getCustomers().get(i).getAccounts().get(j).getAccountNumber().equals(soTaiKhoan)){
                    acc=this.getCustomers().get(i).getAccounts().get(j);
                    break;
                } else acc=null;
            }
        }
        return acc;
        }


}
