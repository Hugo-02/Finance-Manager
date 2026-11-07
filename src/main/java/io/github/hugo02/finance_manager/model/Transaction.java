package io.github.hugo02.finance_manager.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "transactions")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date ;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    private Category category;

    protected Transaction() {}

    public Transaction(String description, BigDecimal amount,  
        LocalDate date, TransactionType type, Category category) {

        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Transaction[id=%d, amount='%s', date='%s', type='%s', description='%s', category='%s']",
         id, amount, date, type, description, category);
    }

    public Long getId(){
        return id;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Category getCategory(){
        return category;
    }

    public TransactionType getType(){
        return type;
    }

    public String getDescription(){
        return description;
    }


}
