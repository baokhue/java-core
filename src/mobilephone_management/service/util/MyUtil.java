package mobilephone_management.service.util;

import mobilephone_management.models.AbroadMobilePhone;
import mobilephone_management.models.BrandMobilePhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    public static final String FILE_BRAND = "C:\\Users\\Thu Nguyen\\IdeaProjects\\Exam2\\src\\mobilephone_management\\file\\brand_mobilephone.csv";
    public static final String FILE_ABROAD = "C:\\Users\\Thu Nguyen\\IdeaProjects\\Exam2\\src\\mobilephone_management\\file\\abroad_mobilephone.csv";

    public static void writeBrand(List<BrandMobilePhone> brandMobilePhoneList) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_BRAND);
            BufferedWriter buff = new BufferedWriter(fileWriter);
            for (BrandMobilePhone brandMobilePhone : brandMobilePhoneList) {
                buff.write(brandMobilePhone.getInfo() + "\n");
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BrandMobilePhone> readBrand() {
        List<BrandMobilePhone> brandMobilePhoneList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_BRAND);
            BufferedReader buff = new BufferedReader(fileReader);
            String line = "";
            String[] temp;
            BrandMobilePhone brandMobilePhone;
            while ((line = buff.readLine()) != null) {
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String name = temp[1];
                long cost = Long.parseLong(temp[2]);
                int number = Integer.parseInt(temp[3]);
                String producer = temp[4];
                String date = temp[5];
                String scope = temp[temp.length - 1];
                brandMobilePhone = new BrandMobilePhone(id, name, cost, number, producer, date, scope);
                brandMobilePhoneList.add(brandMobilePhone);
            }
            return brandMobilePhoneList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeAbroad(List<AbroadMobilePhone> abroadMobilePhoneList) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_ABROAD);
            BufferedWriter buff = new BufferedWriter(fileWriter);
            for (AbroadMobilePhone abroadMobilePhone : abroadMobilePhoneList) {
                buff.write(abroadMobilePhone.getInfo() + "\n");
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AbroadMobilePhone> readAbroad() {
        List<AbroadMobilePhone> abroadMobilePhoneList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_ABROAD);
            BufferedReader buff = new BufferedReader(fileReader);
            String line = "";
            String[] temp;
            AbroadMobilePhone abroadMobilePhone;
            while ((line = buff.readLine()) != null) {
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String name = temp[1];
                long cost = Long.parseLong(temp[2]);
                int number = Integer.parseInt(temp[3]);
                String producer = temp[4];
                String country = temp[5];
                String status = temp[temp.length - 1];
                abroadMobilePhone = new AbroadMobilePhone(id, name, cost, number, producer, country, status);
                abroadMobilePhoneList.add(abroadMobilePhone);
            }
            return abroadMobilePhoneList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
