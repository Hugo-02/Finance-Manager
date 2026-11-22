package io.github.hugo02.finance_manager.controller;

import io.github.hugo02.finance_manager.repository.TransactionRepository;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.github.hugo02.finance_manager.model.Transaction;
import io.github.hugo02.finance_manager.service.TransactionService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController 
class TransactionController {

    private final TransactionService service;

    TransactionController(TransactionService service){
        this.service = service;
    }


    @GetMapping("/transactions")
    List<Transaction> all(){
        return service.findAll();
    }

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    Transaction newTransaction(@RequestBody Transaction newTransaction){
        return service.save(newTransaction);
    }

    @GetMapping("/transactions/{id}")
    Transaction one(@PathVariable Long id) {
        return service.findById(id);
    }

    /* @PutMapping("/transactions/{id}")
    Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {
        return service.findById(id)
        .map(transaction -> {
            transaction.setType(newTransaction.getType());
            transaction.setCategory(newTransaction.getCategory());
            return service.save(transaction);
        })
            .orElseGet(() -> {
            return service.save(newTransaction);
            });
    } */
    

    @DeleteMapping("/transactions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTransaction(@PathVariable Long id) {
        service.deleteById(id);
    }


}