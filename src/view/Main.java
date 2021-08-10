package view;

import controller.ManagerPhoneBook;
import model.PhoneBook;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PhoneBook> list = new ArrayList<>();
        ManagerPhoneBook manager = ManagerPhoneBook.getInstance("huynam",list);
        FileManager fileManager = FileManager.getInstance("huynam");
        try {
            list = fileManager.readFile("namPhone.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        menu(manager);

    }
    public static void menu(ManagerPhoneBook manager){

        int choice = 0;
        while (choice!=6){
            System.out.println("_____ Chương Trình Quản Lý Danh bạ Điện Thoại ______");
            System.out.println("Nhấn 1: Xem Danh Sách: ");
            System.out.println("Nhấn 2: Thêm mới: ");
            System.out.println("Nhấn 3: Cập nhật: ");
            System.out.println("Nhấn 4: Xoá: ");
            System.out.println("Nhấn 5: Tìm Kiếm: ");
            System.out.println("Nhấn 6: Thoát ");
            Scanner scanner = new Scanner(System.in);
            System.out.println(" MỜi bạn nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                {
                    List<PhoneBook> list = manager.getList();
                    if (list.size()>0){
                        manager.showall();
                    }else {
                        System.out.println("Danh bạ trống");
                    }

                    break;
                }
                case 2:
                {
                    PhoneBook phoneBook = createNewPhoneBook();
                    try {
                        manager.addPhoneBook(phoneBook);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case 3:
                {
                    System.out.println("Nhập số điện thoai bạn muốn sửa");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneBook phoneBook= manager.find(numberPhone);
                    if (phoneBook!=null){
                        PhoneBook phoneBook1 = createNewPhoneBook();
                        try {
                            manager.editPhoneBook(numberPhone,phoneBook);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    break;
                }
                case 4:
                {
                    System.out.println(" Mời bạn nhập số điện thoại muốn xoá:");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneBook phoneBook = manager.find(numberPhone);
                    if (phoneBook!=null){
                        try {
                            manager.deletePhoneBook(phoneBook);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Không có  số điện thoại đó trong danh bạ");
                    }

                    break;
                }
                case 5:
                {
                    System.out.println("Nhập vào số điện thoại bạn cần tìm kiếm: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneBook phoneBook = manager.find(numberPhone);
                    if (phoneBook!=null){
                        System.out.println(phoneBook.toString());
                    }else {
                        System.out.println("KHông tìm thấy thôngn tin về số điện thoại này trong danh bạ");
                    }
                    break;
                }
                case 6:
                {
                    break;
                }
            }

        }
    }

      public static PhoneBook createNewPhoneBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên nào: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập số điện thoại nào: ");
        String phoneNumber = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập địa chỉ nào: ");
        String address = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập Email nào: ");
        String email = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập FaceBook nào: ");
        String faceBook = scanner4.nextLine();

        PhoneBook phoneBook = new PhoneBook(name,phoneNumber,address,email,faceBook);
        return phoneBook;
    }
}

