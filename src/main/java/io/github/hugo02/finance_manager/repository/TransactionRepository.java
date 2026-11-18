package io.github.hugo02.finance_manager.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import io.github.hugo02.finance_manager.model.Transaction;
import java.time.LocalDate;



public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByDate(LocalDate date); 

    
}
