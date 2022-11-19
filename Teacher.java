package GK;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Person {
    private int experience;
    public Teacher(ArrayList<Person> prs){
        super(prs,"giáo viên");
        if (super.getStatus())
        {
            Scanner in = new Scanner(System.in);
            while (true)
            {
                System.out.print("Nhập số năm kinh nghiệm của " + super.getName() + " :");
                String ex = in.nextLine().trim();
                if(!ex.isBlank()&&isNotSpecialSymbols(ex)&&isNumeric(ex)){
                    this.experience = Integer.parseInt(ex);
                    DrawLine();
                    break;
                } else {
                    this.DrawLine();
                    System.out.println("Định dạng không hợp lệ.");
                    this.DrawLine();
                }
            }
        }
    }
    @Override
    public String toString(){
        return super.toString() + "\nSố năm kinh nghiệm: " + this.experience;
    }
    public void editInfo(Teacher tc){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("""
                                Bạn muốn thay đổi thông tin nào ?
                                0- Thoát
                                1- Tên
                                2- Tuổi
                                3- Địa chỉ
                                4- Số năm kinh nghiệm
                                ==>Chọn:\s"""
            );
            int select = Integer.parseInt(in.nextLine().trim());
            if(select == 0) break;
            switch (select)
            {
                case 1: super.editName(tc); break;
                case 2: super.editAge(tc); break;
                case 3: super.editAddress(tc); break;
                case 4: this.editExperience(tc); break;
                default:
                    super.DrawLine();
                    System.out.println("Lựa chọn không hợp lệ.");
                    super.DrawLine();
            }
        }
    }
    public void editExperience(Teacher tc){
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Số năm kinh nghiệm hiện tại của " + tc.getName() + " là " + tc.getExperience());
            System.out.print("Nhập số năm kinh nghiệm sẽ được thay bằng : ");
            String ex = in.nextLine().trim();
            if(!ex.isBlank()&&isNotSpecialSymbols(ex)&&isNumeric(ex)){
                tc.setExperience(Integer.parseInt(ex));
                break;
            } else {
                this.DrawLine();
                System.out.println("Định dạng không hợp lệ.");
                this.DrawLine();
            }
        }
    }
    public void setExperience(int ex){
        this.experience = ex;
    }
    public int getExperience(){
        return this.experience;
    }

}
