package rikkei.academy.config;

import rikkei.academy.model.Category;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static final String PATH_CATEGORY = "D:\\Java10f\\module3\\Demo_CRUD_File_Nhi_Phan\\src\\rikkei\\academy\\database\\category.txt";
    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public List<T> readFormFile(String pathFile){
        List<T> tList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (FileNotFoundException f){
            System.out.println("File not found!");
        }catch (IOException i){
            System.out.println("IOE exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found!");
        }
        return tList;
    }
    // Xây dựng phương thức ghi file tha số generic
    public void writeToFile(String pathFile, List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream.writeObject(tList);
            fileOutputStream.close();
            objectInputStream.close();
        }catch (FileNotFoundException f){
            System.out.println("File not found");
        }catch (IOException i){
            System.out.println("IOE Exception");
        }
    }

}
