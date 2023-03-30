package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showListCategory() {
        System.out.println(categoryList);
        System.out.println("Create successfully!");
        System.out.println("Enter any key to continue or quit to return menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Navbar();
        }
    }

    public void formCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name category: ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategory(category);
            System.out.println("Create successfully!");
            System.out.println("Enter any key to continue or quit to return menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Navbar();
                break;
            }
        }
    }

    public void updateCategory() {
        while (true) {
            System.out.println("Enter the Id to update?");
            int id = Config.scanner().nextInt();
            if (categoryController.detailCategory(id) == null) {
                System.out.println("Id không hợp lệ!");
            } else {
                System.out.println("Enter the name Category:");
                String name = Config.scanner().nextLine();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("Create successfully!");
                System.out.println("Enter any key to continue or quit to return menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("quit")) {
                    new Navbar();
                    break;
                }
            }
        }
    }
    public void deleteCategory(){
        while (true){
            System.out.println("Enter id you want to delete?");
            int targetId = Config.scanner().nextInt();
            if (categoryController.detailCategory(targetId) == null){
                System.err.println("Id does not exist!");
            }else {
                categoryController.deleteCategory(targetId);
                System.out.println("Create successfully!");
                System.out.println("Enter any key to continue or quit to return menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("quit")) {
                    new Navbar();
                    break;
                }
            }
        }
    }
}
