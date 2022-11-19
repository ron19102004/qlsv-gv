package GK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Person implements IPerson {
    private int ID, age;
    private Boolean status = true;
    private String name, address;

    public boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean stt){
        this.status = stt;
    }
    public Person(ArrayList<Person> prs, String obj) {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.print("Nhập tên " + obj + " :");
            String name = in.nextLine().trim().toUpperCase();
            if(!name.isBlank()&&isNotSpecialSymbols(name)&&!isNumeric(name)){
                this.name = name;
                break;
            } else {
                this.DrawLine();
                System.out.println("Định dạng tên không hợp lệ.");
                this.DrawLine();
            }
        }
        while (true)
        {
            System.out.print("Nhập ID " + obj + " :");
            String ID = in.nextLine().trim();
            if(!ID.isBlank()&&this.isNotSpecialSymbols(ID)){
                 boolean isExist = false;
                 int indexExist = 0;
                 for(int index = 0; index < prs.size(); index++) {
                     if(prs.get(index).getID() == Integer.parseInt(ID)){
                         isExist = true;
                         indexExist = index;
                     }
                 }
                 if(isExist){
                     this.setStatus(false);
                     if(prs.get(indexExist) instanceof Student st){
                         System.out.println("ID đã tồn tại thông tin như sau: ");
                         this.DrawLine();
                         System.out.println(st.toString());
                         this.DrawLine();
                         System.out.print("""
                             Bạn có muốn thay đổi thông tin khách hàng này không ?
                             y: có.
                             n: không.
                             ==>Chọn:\s"""
                         );
                         String selectEdit = in.nextLine().trim().toUpperCase();
                         switch (selectEdit){
                             case "N":
                                 return;
                             case "Y":
                                 ((Student) prs.get(indexExist)).editInfo(st);
                                 return;
                             default:
                                 System.out.println("Không tồn tại yêu cầu như bạn đã nhập.Mặc định không đúng sự lựa chọn nhập vào," +
                                         " chúng tôi sẽ quy ước là không. Cảm ơn !!!");
                                 return;
                         }
                     }
                     else if(prs.get(indexExist) instanceof Teacher tc){
                         System.out.println("ID đã tồn tại thông tin như sau: ");
                         this.DrawLine();
                         System.out.println(tc.toString());
                         this.DrawLine();
                         System.out.print("""
                             Bạn có muốn thay đổi thông tin khách hàng này không ?
                             y: có.
                             n: không.
                             ==>Chọn:\s"""
                         );
                         String selectEdit = in.nextLine().trim().toUpperCase();
                         switch (selectEdit){
                             case "N":
                                 return;
                             case "Y":
                                 ((Teacher) prs.get(indexExist)).editInfo(tc);
                             default:
                                 System.out.println("Không tồn tại yêu cầu như bạn đã nhập.Mặc định không đúng sự lựa chọn nhập vào," +
                                         " chúng tôi sẽ quy ước là không. Cảm ơn !!!");
                         }
                     }
                 } else {
                     this.ID = Integer.parseInt(ID);
                     break;
                 }
            } else {
                this.DrawLine();
                System.out.println("Định dạng ID không hợp lệ.");
                this.DrawLine();
            }
        }
        while (this.status){
            while (true)
            {
                System.out.print("Nhập tuổi của " + this.name + " :");
                String age = in.nextLine().trim();
                if(!age.isBlank()&&isNotSpecialSymbols(age)&&isNumeric(age)){
                    if(Integer.parseInt(age) > 0 && Integer.parseInt(age) < 150){
                        this.age = Integer.parseInt(age);
                        break;
                    } else {
                        this.DrawLine();
                        System.out.println("Số tuổi không hợp lệ.");
                        this.DrawLine();
                    }
                } else {
                    this.DrawLine();
                    System.out.println("Định dạng tuổi không hợp lệ.");
                    this.DrawLine();
                }
            }
            while (true)
            {
                System.out.print("Nhập địa chỉ của " + obj + " " + this.name + " :");
                String address = in.nextLine().trim();
                if(!address.isBlank()){
                    this.address = address;
                    break;
                } else {
                    this.DrawLine();
                    System.out.println("Địa chỉ không được trống.");
                    this.DrawLine();
                }
            }
            break;
        }
    }
    protected void editInfo(Person ps){}
    public void editName(Person ps){
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Tên hiện tại: " + ps.getName());
            System.out.print("Bạn muốn đổi tên thành :");
            String name = in.nextLine().trim().toUpperCase();
            if(!name.isBlank()&&isNotSpecialSymbols(name)&&!isNumeric(name)){
                ps.setName(name);
                break;
            } else {
                this.DrawLine();
                System.out.println("Định dạng tên không hợp lệ.");
                this.DrawLine();
            }
        }
    }
    public void editAge(Person ps){
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Tuổi hiện tại của " + ps.getName() +" : " + ps.getAge());
            System.out.print("Tuổi của  " + ps.getName() + " sẽ được đổi từ " + ps.getAge() + " thành: ");
            String age = in.nextLine().trim();
            if(!age.isBlank()&&isNotSpecialSymbols(age)&&isNumeric(age)){
                if(Integer.parseInt(age) > 0 && Integer.parseInt(age) < 150){
                    ps.setAge(Integer.parseInt(age));
                    break;
                } else {
                    this.DrawLine();
                    System.out.println("Số tuổi không hợp lệ.");
                    this.DrawLine();
                }
            } else {
                this.DrawLine();
                System.out.println("Định dạng tuổi không hợp lệ.");
                this.DrawLine();
            }
        }
    }
    public void editAddress(Person ps){
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Địa chỉ hiện tại: "+ ps.getAddress());
            System.out.print("Nhập địa chỉ mới: " );
            String address = in.nextLine().trim();
            if(!address.isBlank()){
                ps.setAddress(address);
                break;
            } else {
                this.DrawLine();
                System.out.println("Địa chỉ không được trống.");
                this.DrawLine();
            }
        }
    }
    public int getID(){
        return this.ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Tên: " + this.name +"\nID: " + this.ID
                + "\nNăm sinh: " + this.getYearOfBirth()
                + "\nĐịa chỉ: " + this.address;
    }
    @Override
    public int getYearOfBirth() {
        Calendar cld = Calendar.getInstance();
        return cld.get(Calendar.YEAR) - this.age;
    }
    public  void DrawLine() {
        for(int i = 0; i <= 50; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
    public  boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public  boolean isNotSpecialSymbols(String str){
        return !str.matches("\\p{Punct}");
    }
}
