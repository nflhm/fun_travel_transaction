package id.co.travel.fun.transaction.service;

import id.co.travel.fun.transaction.model.Transaction;
import id.co.travel.fun.transaction.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    ITransactionRepository transactionRepository;

    public void insert(Transaction transaction) { transactionRepository.save(transaction); }

    public void update(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void delete(Transaction transaction) {
        transactionRepository.deleteById(transaction.getId());
    }

    public Transaction findTheTransaction(Transaction transaction) {
        return transactionRepository.findTransactionById(transaction.getId());
    }

    public List<Transaction> allTransactions() {
        return transactionRepository.findAllByOrderById();
    }
}
