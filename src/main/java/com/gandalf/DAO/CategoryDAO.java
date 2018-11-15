package com.gandalf.DAO;

import com.gandalf.DTO.CategoryDTO;
import com.gandalf.models.Categoria;
import java.util.List;

public class CategoryDAO extends DAO {

    public List<Categoria> get() {
        return session.createCriteria(Categoria.class).list();
    }

    public CategoryDTO getCategoryDTO(Categoria category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.id = category.getIdCategoria();
        categoryDTO.name = category.getNomeCategoria();
        categoryDTO.description = category.getDescCategoria();
        return categoryDTO;
    }

}
