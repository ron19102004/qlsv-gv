package GK;

import GK.Sort.*;
import java.util.*;

public class Main {
    public static void DrawLine() {
        for(int i = 0; i <= 50; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
    public static void menuTab(int numSt, int numTc){
        if(numSt == 0 && numTc == 0)
        {
            System.out.println("Hiện tại hệ thống chưa quản lí sinh viên hoặc giáo viên nào." +
                    "\nBạn nên thêm sinh viên hoặc giáo viên trước khi sử dụng các chức năng 1/4/5/6/7/8/9.");
        } else if (numSt > 0 || numTc > 0)
        {
            System.out.println("Hiện tại hệ thống đang quản lí " + numSt + " sinh viên và " + numTc + " giáo viên.");
        }
        System.out.print("""
                Hệ thống có các chức năng sau
                1- Xem tất cả thông tin
                2- Nhập vào một Student
                3- Nhập vào một Teacher
                4- Sắp xếp các Persons
                5- Tìm kiếm và in ra các Person dựa vào
                6- In thông tin của tất cả:
                7- Xóa thông tin theo ID
                8- Sửa thông tin theo ID
                9- Xóa tất cả dữ liệu.
                10- Thoát chương trình.
                ==>Chọn:\s"""
        );
    }
    public static void menuCase4Main(){
        System.out.print("""
                Hệ thống có các chức năng xắp xếp như sau
                1- Tăng theo ID
                2- Giảm theo ID
                3- Tăng theo tên
                4- Giảm theo tên
                5- Tăng theo tuổi
                6- Giảm theo tuổi
                7- Các giáo viên ở trước sinh viên, các giáo viên sắp xếp tăng theo kinh nghiệm
                   ,các sinh viên sắp xếp tăng theo điểm trung bình của 3 môn toán, lý, hóa.
                0- Thoát chức năng.
                ==>Chọn:\s"""
        );
    }
    public static void menuCase5Main(){
        System.out.print("""
                Hệ thống có các chức năng tìm kiếm như sau
                 1- ID
                 2- Tên
                 3- Tuổi
                 4- Năm sinh
                 0- Thoát chức năng.
                ==>Chọn:\s"""
        );
    }
    public static int LocateByID(ArrayList<Person> ps , int id){
        int index = -1;
        for (int i = 0; i < ps.size(); i++){
            if(ps.get(i).getID() == id){
                index = i;
            }
        }
        return index;
    }
    public static void LocateByName(ArrayList<Person> ps , String name){
        HashSet<Integer> listIndex = new HashSet<Integer>();
        for (int i = 0; i < ps.size(); i++){
            String[] nameStr = ps.get(i).getName().split("\\s");
            if(Objects.equals(name.toUpperCase().trim(),nameStr[nameStr.length-1])){
                listIndex.add(i);
            }
        }
        if(listIndex.size() != 0){
            for(Integer index : listIndex){
                System.out.println(ps.get(index).toString());
                DrawLine();
            }
        } else System.out.println("Tên không tồn tại.");
    }
    public static void LocateByAge(ArrayList<Person> ps, int age){
        HashSet<Integer> listIndex = new HashSet<Integer>();
        for(int i = 0; i < ps.size(); i++){
            if(ps.get(i).getAge() == age){
                listIndex.add(i);
            }
        }
        if(listIndex.size() != 0){
            for(Integer index : listIndex){
                System.out.println(ps.get(index).toString());
                DrawLine();
            }
        } else System.out.println("Tuổi không tồn tại trong hệ thống.");
    }
    public static void LocateByYearOfBirth(ArrayList<Person> ps, int year){
        HashSet<Integer> listIndex = new HashSet<Integer>();
        for(int i = 0; i < ps.size(); i++){
            if(ps.get(i).getYearOfBirth() == year){
                listIndex.add(i);
            }
        }
        if(listIndex.size() != 0){
            for(Integer index : listIndex){
                System.out.println(ps.get(index).toString());
                DrawLine();
            }
        } else System.out.println("Năm sinh không tồn tại trong hệ thống.");
    }
    public static void main(String[] args) {
        ArrayList<Person> listManage = new ArrayList<Person>();
        try(Scanner input = new Scanner(System.in)){
            int numSt = 0, numTc = 0;
            while (true){
                menuTab(numSt,numTc);
                int selectMain = Integer.parseInt(input.nextLine().trim());
                DrawLine();
                if(selectMain == 0) break;
                switch (selectMain){
                    case 1:
                        if( listManage.size() != 0){
                            for(Person prs : listManage){
                                System.out.println(prs.toString());
                                DrawLine();
                            }
                        } else {
                            System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                            DrawLine();
                        }
                        break;
                    case 2:
                        Person aSt = new Student(listManage);
                        if(aSt.getStatus()){
                            listManage.add(aSt);
                            numSt++;
                        }
                        break;
                    case 3:
                        Person aTc = new Teacher(listManage);
                        if(aTc.getStatus()){
                            listManage.add(aTc);
                            numTc++;
                        }
                        break;
                    case 4:
                        if( listManage.size() != 0){
                             while (true){
                                menuCase4Main();
                                int selectMainCase4 = Integer.parseInt(input.nextLine().trim());
                                DrawLine();
                                if(selectMainCase4 == 10) break;
                                switch (selectMainCase4){
                                    case 1:
                                        Collections.sort(listManage, new SortByIDIncreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 2:
                                        Collections.sort(listManage, new SortByIDDecreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 3:
                                        Collections.sort(listManage, new SortByNameIncreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 4:
                                        Collections.sort(listManage, new SortByNameDecreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 5:
                                        Collections.sort(listManage, new SortByAgeIncreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 6:
                                        Collections.sort(listManage, new SortByAgeDecreate());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 7:
                                        Collections.sort(listManage, new SortByObj());
                                        for(Person pr : listManage){
                                            System.out.println(pr.toString());
                                            DrawLine();
                                        }
                                        break;
                                    default:
                                        System.out.println("Sự lựa chọn không hợp lệ. !!!");
                                        DrawLine();
                            }
                        }
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        DrawLine();
                        break;
                    case 5:
                        if( listManage.size() != 0){
                            while (true){
                                menuCase5Main();
                                int selectMainCase5 = Integer.parseInt(input.nextLine().trim());
                                DrawLine();
                                if(selectMainCase5 == 0) break;
                                switch (selectMainCase5){
                                    case 1:
                                        System.out.print("Nhập ID cần tìm: ");
                                        int id = Integer.parseInt(input.nextLine().trim());
                                        int indexCS1 = LocateByID(listManage,id);
                                        if(indexCS1 == -1) System.out.println("ID không tồn tại.");
                                        else {
                                            System.out.println(listManage.get(indexCS1).toString());
                                            DrawLine();
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Nhập tên cần tìm: ");
                                        String name = input.nextLine();
                                        LocateByName(listManage,name);
                                        break;
                                    case 3:
                                        System.out.print("Nhập tuổi cần tìm: ");
                                        int age = Integer.parseInt(input.nextLine().trim());
                                        LocateByAge(listManage,age);
                                        break;
                                    case 4:
                                        System.out.print("Nhập số năm cần tìm: ");
                                        int year = Integer.parseInt(input.nextLine().trim());
                                        LocateByYearOfBirth(listManage,year);
                                        break;
                                    default:
                                        System.out.println("Sự chọn lựa không hợp lệ.");
                                        DrawLine();
                                }
                            }
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        DrawLine();
                        break;
                    case 6:
                        if(listManage.size() != 0){
                            System.out.print("""
                                    Hệ thống có các chức năng hiển thị như sau
                                    1- Tất cả sinh viên
                                    2- Tất cả giáo viên
                                    ==>Chọn:\s""");
                            int selectMainCase6 = Integer.parseInt(input.nextLine().trim());
                            DrawLine();
                            switch (selectMainCase6){
                                case 1:
                                    for(Person ps : listManage){
                                        if(ps instanceof Student){
                                            System.out.println(ps.toString());
                                            DrawLine();
                                        }
                                    }
                                    break;
                                case 2:
                                    for(Person ps : listManage){
                                        if(ps instanceof Teacher){
                                            System.out.println(ps.toString());
                                            DrawLine();
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Sự lựa chọn không hợp lệ.");
                            }
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        DrawLine();
                        break;
                    case 7:
                        if(listManage.size() != 0){
                            System.out.print("Nhập ID cần xóa: ");
                            int id = Integer.parseInt(input.nextLine().trim());
                            int index = LocateByID(listManage,id);
                            if(index == -1) System.out.println("ID không tồn tại trong hệ thống");
                            else {
                                System.out.println("Thông tin của ID: " + id);
                                System.out.println(listManage.get(index).toString());
                                if(listManage.get(index) instanceof Student) numSt--;
                                else if (listManage.get(index) instanceof Teacher) numTc--;
                                listManage.remove(index);
                                System.out.println("ID : " + id + " đã được xóa khỏi hệ thống");
                            }
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        DrawLine();
                        break;
                    case 8:
                        if(listManage.size() != 0){
                            System.out.print("Nhập ID cần sửa: ");
                            int id = Integer.parseInt(input.nextLine().trim());
                            int index = LocateByID(listManage,id);
                            if(index == -1) System.out.println("ID không tồn tại trong hệ thống");
                            else {
                                System.out.print("Thông tin ID:" + id);
                                System.out.println(listManage.get(index).toString());
                                DrawLine();
                                if(listManage.get(index) instanceof Student st){
                                    ((Student)listManage.get(index)).editInfo(st);
                                } else if (listManage.get(index) instanceof Teacher tc) {
                                    ((Teacher) listManage.get(index)).editInfo(tc);
                                }
                            }
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        DrawLine();
                        break;
                    case 9:
                        if(listManage.size() != 0){
                            listManage.clear();
                            numTc = 0;
                            numSt = 0;
                        } else System.out.println("Hệ thống chưa quản lí đối tượng nào. Vui lòng thêm thông tin !!!");
                        break;
                    default:
                        System.out.println("Sự lựa chọn không hợp lệ.");
                        DrawLine();
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
