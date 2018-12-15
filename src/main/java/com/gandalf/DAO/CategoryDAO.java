package com.gandalf.DAO;

import com.gandalf.DTO.CategoryDTO;
import com.gandalf.models.Category;
import java.util.List;

public class CategoryDAO extends DAO {

    public List<Category> get() {
        return session.createCriteria(Category.class).list();
    }

    public CategoryDTO getCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.id = category.getIdCategory();
        categoryDTO.name = category.getNameCategory();
        categoryDTO.description = category.getDescriptionCategory();
        return categoryDTO;
    }

}
