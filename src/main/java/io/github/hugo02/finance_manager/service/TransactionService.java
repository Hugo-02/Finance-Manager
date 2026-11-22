package io.github.hugo02.finance_manager.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.hugo02.finance_manager.repository.TransactionRepository;
import io.github.hugo02.finance_manager.model.Transaction;

@Service 
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction){
        return  transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();

    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Transação " + id + " não encontrada"));

    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}