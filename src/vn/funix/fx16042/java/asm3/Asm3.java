package vn.funix.fx16042.java.asm3;

import vn.funix.fx16042.java.asm2.models.Account;
import vn.funix.fx16042.java.asm2.models.Bank;
import vn.funix.fx16042.java.asm2.models.Customer;
import vn.funix.fx16042.java.asm3.models.*;

import java.util.*;
import java.util.regex.Pattern;

public class Asm3 {
    private static final int EXIT_COMMAND_CODE =0;
    private static final int EXIT_ERROR_CODE =-1;
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID ="001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";
    static Customer khachHang =new DigitalCustomer(CUSTOMER_NAME,CUSTOMER_ID);
    private static Transaction transaction= null;
    private static List<TransactionTow> arrList= new ArrayList<>();




    public static void startDisplay (){
        String verSion= "FX16042@v3.0.0";
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("| NGAN HANG SO |       "+verSion+"             |");
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("| 1. thông tin khách hàng.                        |");
        System.out.println("| 2. thêm tài khoản ATM.                          |");
        System.out.println("| 3. thêm tài khoản tín dụng.                     |");
        System.out.println("| 4. Rút tiền.                                    |");
        System.out.println("| 5. Lịch sử giao dịch.                           |");
        System.out.println("| 0. thoat                                        |");
        System.out.println("+----------+-------------------------+------------+");
        System.out.print("chức năng: ");
    }

    public static void main(String[] args) {
        startDisplay();
        selectFuntion();
    }
    /**
     * hàm lấy in put dạng String đầu váo sử dụng cho toàn bộ chức năng
     * @return trả vế String
     */
    public static String inputSring (){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        return in;
    }
    /**
     * hàm in put dạng number
     * @return một số
     */
    public static int inputNumber (){
        Scanner scanner = new Scanner(System.in);
        int numBer =scanner.nextInt();
        return  numBer;
    }

    /**
     *  hàm chọn các chức năng 0-5 cho ứng dụng
     */
    public static void selectFuntion (){
        // khai báo  báo biến đầu vào và biến báo lỗi
        int inputFun = 0;
        boolean error = false;
        do {
            try {
                error =false;
                inputFun=inputNumber();
                switch (inputFun){
                    case 0:
                        System.out.println("tạm biệt");
                        break;
                    case 1:
                        // hiển thị thông tin khách hàng
                        showCustomer();
                        break;
                    case 2:
                        //thêm tài khoản tiết kiệm
                        addSavingMonney();

                        break;
                    case 3:
                        //thêm tài khoản Loann
                        addLoanAccount();

                        break;
                    case 4:
                        // RÚT TIỀN
                        withdrawMoney();

                        break;
                    case 5:
                        // LỊCH SỬ GIAO DỊCH
                        transactionHistory();


                        break;
                    default:
                        System.out.println("bạn nhập chức năng không đúng, vui lòng chọn các chức năng 0-5");
                }
            }catch (InputMismatchException e){
                System.out.println("vui lòng nhập một số");
                error =true;
            }
        } while (inputFun!=0&&inputFun!=1&&inputFun!=2&&inputFun!=3&&inputFun!=4&&inputFun!=5||error);

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Manu
     */
    public static void manu (){
        System.out.println("+----------+-------------------------+------------+");
        System.out.println("| 1. thông tin khách hàng.                        |");
        System.out.println("| 2. thêm tài khoản ATM.                          |");
        System.out.println("| 3. thêm tài khoản tín dụng.                     |");
        System.out.println("| 4. Rút tiền.                                    |");
        System.out.println("| 5. Lịch sử giao dịch.                           |");
        System.out.println("| 0. thoat                                        |");
        System.out.println("+----------+-------------------------+------------+");
        System.out.print("chức năng: ");
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * CHỨC NĂNG THÔNG TIN KHÁCH HÀNG-CHỨC NĂNG 1
     */
    public static void showCustomer(){
        activeBank.addCustomer(khachHang);
        Customer customer =activeBank.getCustomerById(CUSTOMER_ID);
        if(customer instanceof DigitalCustomer){
            DigitalCustomer digitalCustomer = (DigitalCustomer) customer;
            if(digitalCustomer!=null){
                digitalCustomer.displayInformation();
            }
        }
        manu();
        selectFuntion();


    }
    // -----------------------------------------------------------------------------------------------------------------
    /**
     * CHỨC NĂNG THÊM TÀI KHOẢN TIẾT KIỆM- CHỨC NĂNG 2
     */
     public static void addSavingMonney(){
         System.out.print("nhập số tài khoản gồm 6 sô :");
         // thiết lập định dạng cho số tài khoản
         String soTaiKhoan = setSoTaiKhoan(inputSring());
         //check số tài khoản đã tồn tại- add đối tượng vào digitalBank
         SavingsAccount newSavingAccount =suLySoTaiKhoanDaTonTaiSave(soTaiKhoan);
         for (Customer cus:activeBank.getCustomers()
              ) {
                 if(cus.getCustomerId().equals(CUSTOMER_ID)){
                     cus.getAccounts().add(newSavingAccount);
             }
         }
         manu();
         selectFuntion();
     }
    /**
     * hàm định dạng số tài khoản- bổ trợ chức năng 2 VÀ 3
     */
    public static String setSoTaiKhoan (String soTaiKhoan){
        Pattern a = Pattern.compile("^[0-9]{6}$");
        if(!a.matcher(soTaiKhoan).find()){
            do {
                System.out.println("số tài khoản không đúng định dạng ");
                System.out.print("nhập lại STK:");
                soTaiKhoan=inputSring();

            }while (!a.matcher(soTaiKhoan).find());
            return soTaiKhoan;
        }else {
            return soTaiKhoan;
        }
    }
    /**
     *  hàm kiểm tra số tài khaonr tồn tại - tạo ra dối tượng savingAccount-- bổ trợ chức năng 2
     */
    public static SavingsAccount suLySoTaiKhoanDaTonTaiSave(String soTaiKhoan){
        boolean aLive = activeBank.isAccountExisted(soTaiKhoan);
          String acc =null;
        SavingsAccount newAccount = null;
        if(aLive==true){
            do {
                System.out.println("STK đã tốn tại");
                System.out.print("nhập lại STK:");
                acc= setSoTaiKhoan(inputSring());
                aLive =activeBank.isCustomerExisted(acc);
                if(aLive==false){
                    System.out.print("nhập số dư :");
                    double soDu= Double.parseDouble(inputSring());
                    // step 2 tạo đối tượng SAVING
                    newAccount= new SavingsAccount(acc,soDu);
                }
            } while (aLive==true);
        }else {
            // cho phép nhập số dư
            System.out.print("nhập số dư :");
            double soDu= Double.parseDouble(inputSring());
            // step 2 tạo đối tượng SAVING
            newAccount= new SavingsAccount(soTaiKhoan,soDu);
        }
        return newAccount;
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * CHỨC NĂNG 3 THÊM TÀI KHOẢN LOAN-
     */
    public static void addLoanAccount(){
        System.out.print("nhập số tài khoản :");
        // thiết lập địng dạng cho số tài khoản
        String soTaiKhoanLoan =inputSring();
        //sử lí số tài khoản đã tồn tại tạo đối tượng và add
        LoansAccount newLoanAccount = loansAccountCheck(setSoTaiKhoan(soTaiKhoanLoan));
        for (Customer cus:activeBank.getCustomers()
        ) {
            if(cus.getCustomerId().equals(CUSTOMER_ID)){
                cus.getAccounts().add(newLoanAccount);
            }
        }
        manu();
        selectFuntion();

    }
    /**
     *  hàm kiểm tra số tài khoản tồn tại - tạo ra dối tượng loan-- bổ trợ chức năng 3
     */
    public static LoansAccount loansAccountCheck(String soTaiKhoan){
        boolean aLive = activeBank.isAccountExisted(soTaiKhoan);
        String abb= null;
        LoansAccount newLoanAccount = null;
        if(aLive==true){
            do {
                System.out.println("STK đã tốn tại");
                System.out.print("nhập lại STK:");
                abb= setSoTaiKhoan(inputSring());
                aLive =activeBank.isCustomerExisted(abb);
                if(aLive==false){
                    newLoanAccount =new LoansAccount(abb,100_000_000);
                }
            } while (aLive==true);
        }else {
            // step 2 tạo đối tượng Loan
            newLoanAccount =new LoansAccount(soTaiKhoan,100_000_000);
        }
        return newLoanAccount;
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     *  CHỨC NĂNG 4- RÚT TIÊN
     */
    public static void withdrawMoney() {
        System.out.print("nhập số tài khoản:");
        String soTaiKhoan = setSoTaiKhoan(inputSring());
        // lấy số tài khoản tìm về cái Accunt
        Account account = activeBank.backAccount(soTaiKhoan);
        System.out.print("nhập số tiền:");
        double amountMunber = Double.parseDouble(setAmount(inputSring()));

        // chuyển đối tượng về kiểu loan or saving
        if(account instanceof SavingsAccount==true){
            SavingsAccount typeSaving = (SavingsAccount) account;
            if (typeSaving.isAccepted(amountMunber) ==false) {
                do {
                    amountMunber = Double.parseDouble(setAmount(inputSring()));

                } while (typeSaving.isAccepted(amountMunber) == false);
            }
            typeSaving.withdraw(amountMunber);
            typeSaving.log(amountMunber);
            Customer customerFor =activeBank.getCustomerById(CUSTOMER_ID);
            String time = typeSaving.date();
            TransactionTow transactionTow = new TransactionTow(time,amountMunber,soTaiKhoan);
            arrList.add(transactionTow);
            transaction= new Transaction(customerFor.getName(),customerFor.getCustomerId(),arrList);
            transaction.setAccounts(customerFor.getAccounts());


        } else if (account instanceof LoansAccount==true) {
            LoansAccount typeLoan =(LoansAccount) account;
            if(typeLoan.isAccepted(amountMunber)==false){
                do {
                    amountMunber = Double.parseDouble(setAmount(inputSring()));

                }while (typeLoan.isAccepted(amountMunber)==false);
            }

            typeLoan.withdraw(amountMunber);
            typeLoan.log(amountMunber);
            Customer customerFor =activeBank.getCustomerById(CUSTOMER_ID);
            String time = typeLoan.date();
            TransactionTow transactionTow = new TransactionTow(time,amountMunber,soTaiKhoan);
            arrList.add(transactionTow);
            transaction= new Transaction(customerFor.getName(),customerFor.getCustomerId(),arrList);
            transaction.setAccounts(customerFor.getAccounts());
        }
        manu();
        selectFuntion();
    }
    /**
     * bổ trợ chức năng rút tiền cài đặt số tiền rút
     */
    public static String setAmount(String amount){
        Pattern a = Pattern.compile("^[0-9]+$");
        if(!a.matcher(amount).find()){
            do {
                System.out.println("định dạng số dư không hợp lệ");
                System.out.print("nhập lại số DƯ:");
                amount=inputSring();
            }while (!a.matcher(amount).find());
            return amount;
        }else {
            return amount;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    /**
     *  CHỨC NĂNG LỊCH SỬ GIAO DỊCH
     *
     */
    public  static void transactionHistory(){
        System.out.print("nhập số CCCD:");
        Customer cus =activeBank.getCustomerById(setCanCuocCongDan(inputSring()));
        if(transaction==null){
            System.out.println("chưa có giao dịch nào");
        } else {
            transaction.displayInformation();
        }
        manu();
        selectFuntion();

    }
    /**
     *  SET ĐỊNH  DẠNG SỐ CĂN CƯỚC
     */
    public static String setCanCuocCongDan(String soCanCuoc){
        Pattern a = Pattern.compile("^[0-9]{12}$");
        if(!a.matcher(soCanCuoc).find()){
            do {
                System.out.println("số CCCD không đúng định dạng");
                System.out.print("nhập lại số CCCD:");
                soCanCuoc=inputSring();
            }while (!a.matcher(soCanCuoc).find());
            return soCanCuoc;
        }else {
            return soCanCuoc;
        }
    }

}
