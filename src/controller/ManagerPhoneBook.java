package controller;

import model.PhoneBook;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerPhoneBook {
    private static ManagerPhoneBook INSTASCE;
    private String name;
    private List<PhoneBook> list = new ArrayList<PhoneBook>();


    private ManagerPhoneBook() {
    }

    private ManagerPhoneBook(String name, List<PhoneBook> list) {
        this.name = name;
        this.list = list;
    }
    public static ManagerPhoneBook getInstance(String name, List<PhoneBook> list){
        if (INSTASCE == null){
            INSTASCE = new ManagerPhoneBook(name,list);
        }return INSTASCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneBook> getList() {
        return list;
    }

    public void setList(List<PhoneBook> list) {
        this.list = list;
    }

    public static void setINSTASCE(ManagerPhoneBook INSTASCE) {
        ManagerPhoneBook.INSTASCE = INSTASCE;
    }

    //    Thêm  mới danh bạ
    public void addPhoneBook(PhoneBook PhoneBook) throws IOException {
        list.add(PhoneBook);
        System.out.println("----> Bạn đã thêm thành công");
        FileManager fileManager = FileManager.getInstance("huynam");
        fileManager.writeFile(list);

    }

    //    Cập nhật danh bạ
    public void editPhoneBook(String phoneNumber, PhoneBook phoneDirectory) throws IOException {
        for(int i = 0; i< list.size();i++){
            if (list.get(i).getPhoneNumber().equals(phoneNumber)){
                list.set(i,phoneDirectory);
                System.out.println(" ----> Bạn đã sửa thành công");
                FileManager fileManager = FileManager.getInstance("huynam");
                fileManager.writeFile(list);
            }
        }
    }

    //    Xoá danh bạ
    public void deletePhoneBook(PhoneBook PhoneBook) throws IOException {
        list.remove(PhoneBook);
        System.out.println(" Bạn đã xoá thành công");
        FileManager fileManager = FileManager.getInstance("huynam");
        fileManager.writeFile(list);
    }

    //    Tìm kiếm   danh bạ theo số điện thoại
    public PhoneBook find(String numberphone){
        PhoneBook PhoneBook = null;
        for (int i =0; i<list.size();i++){
            if (list.get(i).getPhoneNumber().equals(numberphone)){
                return PhoneBook =  list.get(i);
            }
        }return PhoneBook;
    }

    //    Hiển thị danh bạ ra cho xem
    public void showall(){
        for (PhoneBook p:list
        ) {
            System.out.println(p.toString());
        }
    }

}
