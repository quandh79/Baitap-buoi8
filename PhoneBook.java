package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone{
    ArrayList<String> PhoneList = new ArrayList<>();
    //public ArrayList<PhoneNumber> PhoneList ;

    @Override
    public void insertPhone(String name, String phone) {
        if(PhoneList.isEmpty()){
            PhoneList.add(name + " , " + phone);

        }else {
            String pb = searchPhone(name);
            if(pb != null){
                if (!pb.contains(phone)){
                    PhoneList.set(PhoneList.indexOf(pb), pb + ":" + phone);
                }
            }else {

                PhoneList.add(name + " , " + phone);
            }
        }
    }

    @Override
    public void removePhone(String name) {
        if (PhoneList.isEmpty()){
            System.out.println("Danh ba trong");
        }else {
            String pb = searchPhone(name);

                if (pb!= null){
                    PhoneList.remove(pb);
                    System.out.println("Da xoa nguoi dung" + name + "trong danh ba");
                }else {

                System.out.println("Khong tim thay nguoi dung" + name + "trong danh ba");
            }
        }

    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {
        if (PhoneList.isEmpty()){
            System.out.println("Danh ba trong");
        }else {
            String pb = searchPhone(name);
            if(pb != null){
                if(!pb.contains(newPhone)){
                    PhoneList.set(PhoneList.indexOf(pb), pb.split(",")[0]+","+newPhone);
                }
            }else {
                System.out.println("Khong tim thay nguoi dung" + name + "trong danh ba");

            }
        }
    }

    @Override
    public String searchPhone(String name) {
        for (String pb: PhoneList){
            if(pb.split(",")[0].equals(name)){
                return pb;
            }
        }
        return null;
    }

    @Override
    public void sort() {
        if (PhoneList.isEmpty()){
            System.out.println("Danh ba trong");
        }else {
            // sx tang dan
            Collections.sort(PhoneList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }
    }
}
