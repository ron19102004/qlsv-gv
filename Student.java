package GK;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {
        private float math, physics, chemistry;

        public Student(ArrayList<Person> prs) {
                super(prs,"sinh viên");
                if(super.getStatus())
                {
                        this.math = this.enterScore("toán");
                        this.physics = this.enterScore("lý");
                        this.chemistry = this.enterScore("hóa");
                        super.DrawLine();
                }
        }
        public  float enterScore(String sub) {
                Scanner input = new Scanner(System.in);
                String subjectScore;
                int index = 0;
                while (true) {
                        System.out.print("Nhập điểm môn " + sub + " :");
                        subjectScore = input.nextLine().trim();
                        if (!subjectScore.isBlank() && isNumeric(subjectScore)) {
                                if (Float.parseFloat(subjectScore) >= 0 && Float.parseFloat(subjectScore) <= 10) {
                                        break;
                                } else {
                                        if (index == 2) {
                                                throw new InputMismatchException("Lỗi nhập điểm không hợp lệ !!!");
                                        }
                                        index++;
                                        System.out.println("Số điểm bạn nhập không hợp lệ !!! Thang điểm 10 chạy từ 0 đến 10. Vui lòng thao tác lại.");
                                }
                        } else {
                                if (index == 2) {
                                        throw new InputMismatchException("Oops, Lỗi nhập sai định dạng !!!");
                                }
                                index++;
                                DrawLine();
                                if (index == 2) {
                                        System.out.println("Dữ liệu bạn đưa vào không phải là một con số. Vui lòng nhập lại lần cuối.");

                                } else {
                                        System.out.println("Dữ liệu bạn đưa vào không phải là một con số. Vui lòng nhập lại.");
                                }
                                DrawLine();
                        }
                }
                return Float.parseFloat(subjectScore);
        }
        public void editInfo(Student st){
                Scanner in = new Scanner(System.in);
                while (true){
                        System.out.print("""
                                Bạn muốn thay đổi thông tin nào ?
                                0- Thoát
                                1- Tên
                                2- Tuổi
                                3- Địa chỉ
                                4- Điểm
                                ==>Chọn:\s"""
                        );
                        int select = Integer.parseInt(in.nextLine().trim());
                        if(select == 0) break;
                        switch (select)
                        {
                                case 1: super.editName(st); break;
                                case 2: super.editAge(st); break;
                                case 3: super.editAddress(st); break;
                                case 4:
                                        while (true){
                                                System.out.print("""
                                                Bạn muốn thay đổi điểm môn nào?
                                                0- Thoát
                                                1- Toán
                                                2- Lý
                                                3- Hóa
                                                ==>Chọn:\s"""
                                                );
                                                int selectEditScore = Integer.parseInt(in.nextLine().trim());
                                                if(selectEditScore == 0) break;
                                                switch (selectEditScore){
                                                        case 1:
                                                                st.setMath(editScore("toán",st.getMath()));
                                                                break;
                                                        case 2:
                                                                st.setPhysics(st.editScore("lý", st.getPhysics()));
                                                                break;
                                                        case 3:
                                                                st.setChemistry(st.editScore("hóa",st.getChemistry()));
                                                                break;
                                                        default:
                                                                super.DrawLine();
                                                                System.out.println("Lựa chọn không hợp lệ");
                                                                super.DrawLine();
                                                }

                                        }
                                default:
                                        super.DrawLine();
                                        System.out.println("Lựa chọn không hợp lệ.");
                                        super.DrawLine();
                        }
                }
        }
        public float editScore( String sub, float scoreCurrent){
                Scanner input = new Scanner(System.in);
                String subjectScore;
                int index = 0;
                while (true) {
                        System.out.println("Điểm môn " + sub +" hiện tại là " + scoreCurrent);
                        System.out.print("Nhập điểm môn " + sub + " :");
                        subjectScore = input.nextLine().trim();
                        if (!subjectScore.isBlank() && isNumeric(subjectScore)) {
                                if (Float.parseFloat(subjectScore) >= 0 && Float.parseFloat(subjectScore) <= 10) {
                                        break;
                                } else {
                                        if (index == 2) {
                                                throw new InputMismatchException("Lỗi nhập điểm không hợp lệ !!!");
                                        }
                                        index++;
                                        System.out.println("Số điểm bạn nhập không hợp lệ !!! Thang điểm 10 chạy từ 0 đến 10. Vui lòng thao tác lại.");
                                }
                        } else {
                                if (index == 2) {
                                        throw new InputMismatchException("Oops, Lỗi nhập sai định dạng !!!");
                                }
                                index++;
                                DrawLine();
                                if (index == 2) {
                                        System.out.println("Dữ liệu bạn đưa vào không phải là một con số. Vui lòng nhập lại lần cuối.");

                                } else {
                                        System.out.println("Dữ liệu bạn đưa vào không phải là một con số. Vui lòng nhập lại.");
                                }
                                DrawLine();
                        }
                }
                return Float.parseFloat(subjectScore);
        }
        public void setMath(float math){
                this.math = math;
        }
        public void setPhysics(float physics) {
                this.physics = physics;
        }
        public void setChemistry(float chemistry) {
                this.chemistry = chemistry;
        }

        public float getMath() {
                return math;
        }
        public float getPhysics() {
                return physics;
        }
        public float getChemistry() {
                return chemistry;
        }

        public float getAvgScore(){
                return (this.math + this.physics + this.chemistry) / 3;
        }

        @Override
        public String toString(){
                return super.toString() + "\nĐiểm toán: " + this.math +"\nĐiểm lý: "
                        + this.physics + "\nĐiểm hóa: " + this.chemistry +"\n=>Điểm trung bình: " + this.getAvgScore();
        }

}
