package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    List<Category> categoryList = new Config<Category>().readFormFile(Config.PATH_CATEGORY);
    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId())==null){
            categoryList.add(category);
        }else {
            Category category1 = findById(category.getId());
            category1.setName(category.getName());
//            int index = categoryList.indexOf(findById(category.getId()));
//            categoryList.set(categoryList.indexOf(findById(category.getId())),category);
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId()==id){
                return categoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("Enter id category you want to delete?");
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == id){
                categoryList.remove(i);
            }
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY,categoryList);
    }
}
