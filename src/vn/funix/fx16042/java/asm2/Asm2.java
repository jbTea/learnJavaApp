package vn.funix.fx16042.java.asm2;

import vn.funix.fx16042.java.asm2.models.Account;
import vn.funix.fx16042.java.asm2.models.Bank;
import vn.funix.fx16042.java.asm2.models.Customer;
import vn.funix.fx16042.java.asm2.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Asm2 {
    String verSion= "FX16042@v2.0.0";
    private static final Bank bank = new Bank();
    public static void main(String[] args) {
        displays();
        selectFuntion();
    }
    public static void displays(){
        String verSion= "FX16042@v2.0.0";
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO |       "+verSion+"           |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. them khach hang                            |");
        System.out.println("| 2. them tai khoan cho khach hang              |");
        System.out.println("| 3. hien thi danh sach khach hang              |");
        System.out.println("| 4. tin theo CCCD                              |");
        System.out.println("| 5. tim theo ten khach hang                    |");
        System.out.println("| 0. thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("vui long nhap chuc nang: ");
    }
    /**
     * hàm hiển thị chức nưng ban đầu
     */
    public static void manu (){
        System.out.println("++---------------------------------------------");
        System.out.println(" |1. them khach hang                           |");
        System.out.println(" |2. them tai khoan cho khach hang             |");
        System.out.println(" |3. hien thi danh sach khach hang             |");
        System.out.println(" |4. tin theo CCCD                             |");
        System.out.println(" |5. tim theo ten khach hang                   |");
        System.out.println(" |0. thoat                                     |");
        System.out.println("++---------------------------------------------");
        System.out.print("vui long nhap chuc nang: ");
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
                       // thêm khách hàng
                       chucNangOne();
                       break;
                   case 2:
                       //thêm tài khoản cho khách hàng
                       chucNangTow();
                       break;
                   case 3:
                       //hiển thị danh sách khách hàng
                       chucNangThree();
                       break;
                   case 4:
                       // tìm theo số căn cớc công dân
                       chucNangFor();
                       break;
                   case 5:
                       // tìm theo tên khách hàng
                       chucNangFine();
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
    /**
     * chức năng thêm khách hàng
     */
    public static String suLySoDu(String soDu){
           long soDuNunber = Long.parseLong(soDu);
           long namChuc =50000;
           if(soDuNunber<namChuc){
               do {
                   System.out.println("số dư tài khoản phải lớn hơn 50000đ");
                   System.out.print("nhập lại số dư: ");
                   soDu=inputSring();
                   soDuNunber=Long.parseLong(soDu);
                   suLySoDu(setSoDu(soDu));
               }while (soDuNunber<namChuc);
               return soDu;
           } else {return soDu;}

    }


    /**
     * set định dạng cho số dư tài khoản
     * @param soDu
     * @return số dư có định dạng số dài tùy ý
     */
     public static String setSoDu(String soDu){
         Pattern a = Pattern.compile("^[0-9]+$");
         if(!a.matcher(soDu).find()){
             do {
                 System.out.println("định dạng số dư không hợp lệ");
                 System.out.print("nhập lại số DƯ:");
                 soDu=inputSring();
             }while (!a.matcher(soDu).find());
             return soDu;
         }else {
             return soDu;
         }
     }
    /**
     * hàm sử lí số tài khoản đã tồn tại
     * @param soTaiKhoan
     */

    public static Account
    suLySoTaiKhoanDaTonTai(String soTaiKhoan){
        boolean aLive = bank.isAccountExisted(soTaiKhoan);
        Account newAccount = new Account();
        if(aLive==true){
            System.out.println("STK đã tốn tại");
            System.out.print("nhập lái STK:");
            soTaiKhoan=inputSring();
            suLySoTaiKhoanDaTonTai(setSoTaiKhoan(soTaiKhoan));
        }else {
            // cho phép nhập số dư
            System.out.print("nhập số dư :");
            String soDu = inputSring();
            setSoDu(soDu);
            double soDuTieuChuan= Double.parseDouble(suLySoDu(setSoDu(soDu)));
            // step 2 tạo đối tượng acc
             newAccount= new Account(soTaiKhoan,soDuTieuChuan);
        }
        return newAccount;
    }

    /**
     * hàm chuẩn định dạng số tài khoản
     * @return trả về số tài khoản đúng định dạng 6 số
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
     *  hàm sử lí số căn cước đã tồn tại
     * @param soCanCuoc
     *
     */
     public static void suLySoCanCuocDaTonTai(String soCanCuoc){
         boolean aLive = bank.isCustomerExisted(soCanCuoc);

         if(aLive==true){
             // cho phép nhập số tài khoản
             System.out.print("nhập STK:");
             String soTaiKhoan=inputSring();
             Account acc= suLySoTaiKhoanDaTonTai(setSoTaiKhoan(soTaiKhoan));
             for (Customer cus: bank.getCustomers()
                  ) {
                 if (cus.getCustomerId().equals(soCanCuoc)) {
                     cus.addAccount(acc);
                     break;
                 }
             }
         } else {
             do {
                 System.out.println("số CCCD không tồn tại");
                 System.out.print("nhập lại Số CCCD:");
                 soCanCuoc=inputSring();
                 setCanCuoc(soCanCuoc);
                 aLive= bank.isCustomerExisted(setCanCuoc(soCanCuoc));
                 suLySoCanCuocDaTonTai(setCanCuoc(soCanCuoc));

             }while (aLive==false);
         }
     }
    /**
     *
     * @param soCanCuoc
     * @return trả về số căn cước chuẩn định dạng
     */
    public static String setCanCuoc(String soCanCuoc){
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

    /**
     * CHỨC NĂNG 1:
     * chức năng thêm khách hàng
     */

    public static void   chucNangOne() {
        Pattern a = Pattern.compile("^[0-9]{12}$");
        Pattern b = Pattern.compile("^[a-zA-Z]+$");

        System.out.print("nhập tên khách hàng :");
        // biến lưu tên khách hàng
        String nameUser = inputSring();
        // kiểm tra xem đã nhập tên chưa rồi mới cho phép nhập
        // vì vòng lặp do -while sẽ thực hiện câu lệnh ít nhất 1 lần nên phải có câu lệnh điều kiện ở đây kiểm soát

        if(nameUser.length()==0||!b.matcher(nameUser).find()){
            do {
                System.out.println("bạn chưa nhập tên , tên của bạn chứa kí tự không hợp lệ");
                System.out.print("vui lòng nhập lại tên :");
                nameUser=inputSring();
            }while (nameUser.length()==0||!b.matcher(nameUser).find());
        }
        System.out.print("nhập CCCD :");
        String soCanCuoc =inputSring();
        // kiểm tra id thỏa mãn 12 kí tự
        if (nameUser.length()!=0){
            // vì vòng lặp do -while sẽ thực hiện câu lệnh ít nhất 1 lần nên phải có câu lệnh điều kiện ở đây kiểm soát
            if(!a.matcher(soCanCuoc).find()){
                do {
                    System.out.println("CCCD của bạn phải có kí tự 0-9, gồm 12 chữ sô");
                    System.out.print("nhạp lại CCCD :");
                    soCanCuoc=inputSring();
                } while (!a.matcher(soCanCuoc).find());

            }
        }
        // tạo đối tượng custommer
        Customer khachHang = new Customer(nameUser,soCanCuoc);
        bank.addCustomer(khachHang);
        manu();
        selectFuntion();
    }

    /**
     * CHỨC NĂNG 2 : THÊM SỐ TÀI KHOẢN
     * chức năng thêm tài khoản cho khách hàng
     */
    public static void chucNangTow (){
        System.out.print("nhập số CCCD :");
        String soCan =inputSring();
        // kiểm tra số căn cước
        soCan=setCanCuoc(soCan);
         suLySoCanCuocDaTonTai(soCan);
         manu();
         selectFuntion();
    }

    /**
     * CHỨC NĂNG 3- HIỂN THỊ
     * chức năng hiển thì danh sách khách hàng
     */
    public static void chucNangThree(){
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            System.out.print(bank.getCustomers().get(i).displayInformation());
        }
        manu();
        selectFuntion();
    }

    /**
     * CHỨC NĂNG 4
     * chức nang tìm theo số CCCD
     */
    public static void chucNangFor(){
        System.out.print("nhâp CCCD :");
        bank.seachId(setCanCuoc(inputSring()));
        manu();
        selectFuntion();
    }

    /**
     * CHỨC NĂNG 5
     * tìm kiếm theo tên
     */
    public static void chucNangFine (){
          System.out.print("nhập cụm từ cần tìm kiếm:");
          bank.seachName(inputSring().toLowerCase());
          manu();
          selectFuntion();
    }

}
