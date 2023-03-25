package vn.funix.fx16042.java.asm2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private  List<Customer> customers;
    private  String id;

    public Bank() {
        this.id = String.valueOf(UUID.randomUUID());
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getId() {
        return id;
    }

    /**
     * thêm custommer
     * @param newCustomer
     */
    public void addCustomer(Customer newCustomer){
        if(newCustomer==null){
            return;
        }
        boolean isAcceptAddCustomer = false;
        if(customers==null || customers.isEmpty()){
            isAcceptAddCustomer = true;
        }else {//check neu da ton tai thi khong add nua
            for (Customer cus : customers) {
                if (cus.getCustomerId().equals(newCustomer.getCustomerId())){
                    isAcceptAddCustomer = false;
                    break;
                }
            }
        }
        if(isAcceptAddCustomer){

        }customers.add(newCustomer);
        }


    /**
     * kiểm tra id có tồn tại hay chưa
     * @param customerId
     * @return
     */
    public boolean isCustomerExisted(String customerId){
        boolean stillAlive =false;
        for (Customer customer :customers){
            if(customer.getCustomerId().equals(customerId)){
                stillAlive=true;
            } else {
                stillAlive=false;
            }
        }
        return stillAlive;
    }
    /**
     *  kiểm tra số tài khoản đã tồn tại hay chưa
     */
    public  boolean isAccountExisted (String accountNumber){
        boolean stillAlive =false;
        for (int i = 0; i < this.customers.size(); i++) {
            for (int j = 0; j <this.customers.get(i).getAccounts().size() ; j++) {
                if(this.customers.get(i).getAccounts().get(j).getAccountNumber().equals(accountNumber)){
                    stillAlive=true;
                    break;
                }else stillAlive= false;
            }
        }
        return stillAlive;
    }
    public void seachId (String seach){
        for (Customer cus: customers
             ) {
            if (cus.getCustomerId().equals(seach)){
                cus.displayInformation();
            }
        }
    }
    public void seachName(String key){
        String p = ".*"+key+".*";

        if(customers.isEmpty()){
            System.out.println("danh sách khách hàng trống");
            return;
        }
        for (Customer cus: customers
             ) {
            if(cus.getName().toLowerCase().matches(p)){
                cus.displayInformation();
            } else {
                System.out.println("không tìm thấy ");
            }
        }
    }

}
