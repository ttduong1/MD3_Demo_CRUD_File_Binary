package rikkei.academy.view;

import rikkei.academy.config.Config;

public class Navbar {
    public Navbar() {
        System.out.println("********* CATEGORY MANAGE *********");
        System.out.println("1. Show list category: ");
        System.out.println("2. Create category: ");
        System.out.println("3. Update category: ");
        System.out.println("4. Delete category: ");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                new CategoryView().showListCategory();
                break;
            case 2:
                new CategoryView().formCreateCategory();
                break;
            case 3:
                new CategoryView().updateCategory();
                break;
            case 4:
                new CategoryView().deleteCategory();
                break;
        }
    }

    public static void main(String[] args) {
        new Navbar();
    }
}