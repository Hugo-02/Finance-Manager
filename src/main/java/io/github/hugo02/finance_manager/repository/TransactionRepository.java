package io.github.hugo02.finance_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.hugo02.finance_manager.model.Transaction;
import java.time.LocalDate;



public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByDate(LocalDate date); 

    
}
