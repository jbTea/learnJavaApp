package vn.funix.fx16042.java.asm1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
// hàm main
public class Asm01 {
    public static void main(String[] args) {
        display();
        checkFun();

    }
    // hàm hiển thị ban đầu
    public static void display() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX16042@v1.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. nhap CCCD                                  |");
        System.out.println("| 0. thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("vui long nhap chuc nang: ");
    }
// manu chức năng
    public static void manu(){
        System.out.println("   | 1. kiểm tra nơi sinh");
        System.out.println("   | 2. kiểm tra tuổi, giới tinh");
        System.out.println("   | 3. số ngẫu nhiên");
        System.out.println("   | 0. thoát");
        System.out.print("chuc nang: ");
    }
// kiểm tra có mã tỉnh đúng hay không
     @Contract(pure = true)
     public static boolean Container (String @NotNull [] array, String baSoDau) {
         boolean result = false;
         for (int i = 0; i < array.length; i++) {
             if (array[i].equals(baSoDau)) {
                 result = true;
             }
         }
         return result;
     }
// CHỨC NĂNG 1- KIỂM TRA NƠI SINH
    public static void chucNangOne(String @NotNull [] arr, @NotNull String soCan){
        String [] mangKiemTra = new String[63];
        boolean checkId=true;
        // cắt chuỗi input
        String maTinh =soCan.substring(0,3);
        for (int i = 0; i < arr.length; i++) {
            mangKiemTra[i]=arr[i].substring(0,3);

        }
        checkId=Container(mangKiemTra,maTinh);
        if (checkId==false){
            System.out.println("căn cước của bạn không đúng vui lòng thử lại");
            checkCccd();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].substring(0,3).equals(maTinh)){
                    System.out.println("noi sinh : "+arr[i].substring(4));
                    manu();
                }
            }
        }

    }
//  CHỨC NĂNG 2 KIỂM TRA GIỚI TÍNH NĂM SINH
    public static  void chucNangTow(String soCan){
        // tách lấy số thứ 4 của số căn cước
        String maGioiTinh = soCan.substring(3,4);
        // tách lấy số năm sịnh
        String namSinh =soCan.substring(4,6);
       if (maGioiTinh.equals("0")){
           System.out.println("Gioi Tinh : NAM |" + "19"+namSinh);
           manu();
       } else if (maGioiTinh.equals("1")){
           System.out.println("Gioi Tinh : NU |" + "19"+namSinh);
           manu();
       } else if (maGioiTinh.equals("2")){
           System.out.println("Gioi Tinh : NU |" + "20"+namSinh);
           manu();
       } else if (maGioiTinh.equals("3")){
           System.out.println("Gioi Tinh : NU |" + "20"+namSinh);
           manu();
       } else if (maGioiTinh.equals("4")){
           System.out.println("Gioi Tinh : NAM |" + "21"+namSinh);
           manu();
       } else if (maGioiTinh.equals("5")){
           System.out.println("Gioi Tinh : NU |" + "21"+namSinh);
           manu();
       } else if (maGioiTinh.equals("6")){
           System.out.println("Gioi Tinh : NAM |" + "22"+namSinh);
           manu();
       } else if (maGioiTinh.equals("7")){
           System.out.println("Gioi Tinh : NU |" + "22"+namSinh);
           manu();
       } else if (maGioiTinh.equals("8")){
           System.out.println("Gioi Tinh : NAM |" + "23"+namSinh);
           manu();
       } else if (maGioiTinh.equals("9")){
           System.out.println("Gioi Tinh : Nu |" + "23"+namSinh);
           manu();
       }

    }
// CHỨC NĂNG HIỂN THỊ SỐ NGẪU NHIÊN
     public  static void chucNangThree(String soCan){
        // tách lấy 6 số cuối
         String sauSoCuoi =soCan.substring(6);
         System.out.println("so ngau nhien : " +sauSoCuoi);
         manu();
     }
// TUẦN HOÀN CÁC CHỨC NĂNG QUA LẠI
      public static void tuanHoan (String[] arr , String soCan){
          int so =0;
          do {
                  so =input();
                  switch (so){
                      case 1:
                          chucNangOne(arr,soCan);
                          break;
                      case 2:
                          chucNangTow(soCan);
                          break;
                      case 3:
                          chucNangThree(soCan);
                          break;
                      case 0:
                          display();
                          System.out.println("see you again!");
                      default:
                          System.out.println("vui lòng nhập đúng chức năng");
                          manu();
                          so = input();
                          break;
                  }

          }while (so==0||so==1||so==2||so==3);
      }

// CHECK FUN MANU
public static void checkFunA (String soCanCuoc){
    // set biến
    String number =soCanCuoc;
    int inputFunA=0;
    boolean err = false;
    // mảng mã tỉnh
   String[] mangMatinh = new String[]{"001.Ha Noi","002.Ha Giang","004.Cao Bang","006.Bac Kan","008.Tuyen Quang","010.Lào Cai","011.Điện Biên","012.Lai Châu","014.Sơn La","015.Yên Bái",
   "017.Hòa Bình","019.Thái Nguyên","020.Lạng Sơn","022.Quảng Ninh","024.Bắc Giang","025.Phú Thọ","026.Vĩnh Phúc","027.Bắc Ninh","030.Hải Dương","031.Hải Phòng",
   "033.Hưng Yên","034.Thái Bình","035.Hà Nam","036.Nam Định","037.Ninh Bình","038.Thanh Hóa","040.Nghệ An","042.Hà Tĩnh","044.Quảng Bình","045.Quảng Trị",
   "046.Thừa Thiên Huế","048.Đà Nẵng","049.Quảng Nam","051.Quảng Ngãi","052.Bình Định","054.Phú Yên","056.Khánh Hòa","058.Ninh Thuận","060.Bình Thuận","062.Kon Tum",
   "064.Gia Lai","066.Đắk Lắk","067.Đắk Nông","068.Lâm Đồng","070.Bình Phước","072.Tây Ninh","074.Bình Dương","075.Đồng Nai","077.Bà Rịa - Vũng Tàu","079.Hồ Chí Minh",
   "080.Long An","082.Tiền Giang","083.Bến Tre","084.Trà Vinh","086.Vĩnh Long","087.Đồng Tháp","089.An Giang","091.Kiên Giang","092.Cần Thơ","093.Hậu Giang",
   "094.Sóc Trăng","095.Bạc Liêu","096.Cà Mau"};
    //do-while
    do {
        try{
            err =false;
            inputFunA= input();
            if ((inputFunA!=0&&inputFunA!=1&&inputFunA!=2&&inputFunA!=3)){
                System.out.println("vui lòng nhập đúng chức năng");
                manu();
            } else if (inputFunA==1) {
                // CHỨC NĂNG 1:
                chucNangOne(mangMatinh,number);
                tuanHoan(mangMatinh,number);
            } else if (inputFunA==2) {
                // làm ở đây
                chucNangTow(number);
                tuanHoan(mangMatinh,number);
            } else if (inputFunA==3) {
                 chucNangThree(number);
                tuanHoan(mangMatinh,number);
            } else if (inputFunA==0) {
                display();
            }
        } catch (InputMismatchException e){
            System.out.println("Vui lòng nhập 1 số");
            manu();
            err =true;
        }
    } while ((inputFunA!=0&&inputFunA!=1&&inputFunA!=2&&inputFunA!=3)||err);
}

// hàm lấy input number
    public static int input(){
        Scanner scanner =new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        return  input;
    }
 //hàm lấy input string
    public static String inputString (){
        Scanner scanner =new Scanner(System.in);
        String inputString = scanner.nextLine();
        return inputString;
    }
// hàm check căn cước
     public static void checkCccd(){
        // khởi tạo các biến
         boolean error = false;
         String inputCccd ="0";

         do {
             try {
                  error =false;
                 System.out.print("nhập số căn cước công dân của bạn: ");
                  inputCccd=inputString();
                  // chuyển string sang number nếu không chuyển được báo lỗi khối cath
                 long stringToNumber = Long.parseLong(inputCccd);
                 if(inputCccd.length()!=12){
                     System.out.println("độ dài của số căn cước phải đạt 12");
                 } else {
                     // mở manu chức năng của ứng dụng
                     manu();
                     // check CHỨC NĂNG NGƯỜI DÙNG NHẬP
                     checkFunA (inputCccd);
                 }
             }catch (InputMismatchException e){
                 System.out.println("bạn cần nhập căn cước công dân hợp lệ kí tự 0-9");
                 error =true;
             }
         }while ((inputCccd.length()!=12)||error);


     }
// hàm lấy số ngẫu nhiên tư 100 -999
    public static int maths (){
      Random random = new Random();
      int ranDom = random.nextInt(900)+100;
      return ranDom;
    }
//// hàm check virus
    public static void checkVirus ( int fromRanDom, int fromUser){
        //tạo biến đầu vào
        boolean useAndRanDom =false;
        do {
            try {
                useAndRanDom =false;
                System.out.println("nhập mã xác thực : "+fromRanDom);
                 fromUser = input();
                 if(fromRanDom!=fromUser){
                     System.out.println("mã xác nhận không trùng nhau");
                 } else {
                     //cho phép nhập căn cươc
                     checkCccd();
                 }
            }catch (InputMismatchException e){
                System.out.println("vui lòng nhập số");
                useAndRanDom =false;
            }
        }while ((fromRanDom!=fromUser)||useAndRanDom);
    }
// hàm kiểm tra điều kiện chức năng
    public static void checkFun (){
      // set biến
        int inputFun=0;
        boolean err = false;
      //do-while
        do {
            try{
                err =false;
                inputFun= input();
                if (inputFun!=0&&inputFun!=1){
                    System.out.println("vui lòng nhập đúng chức năng");
                } else if (inputFun==1) {
                    // khi người dùng chọn 1
                    //check virus
                    int fromRanDom =maths();
                    checkVirus(fromRanDom,0);

                } else if (inputFun==0) {
                    display();
                    System.out.println("see you again!");
                }
            } catch (InputMismatchException e){
                System.out.println("Vui lòng nhập 1 số");
                err =true;
            }
        } while ((inputFun!=0&&inputFun!=1)||err);
    }
    }

