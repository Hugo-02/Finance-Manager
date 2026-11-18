package io.github.hugo02.finance_manager.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import io.github.hugo02.finance_manager.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

}
