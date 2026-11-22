package io.github.hugo02.finance_manager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.hugo02.finance_manager.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

}
