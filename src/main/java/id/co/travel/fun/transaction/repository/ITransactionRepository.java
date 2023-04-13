package id.co.travel.fun.transaction.repository;

import id.co.travel.fun.transaction.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTransactionById(Integer integer);
    List<Transaction> findAllByOrderById();
    @Modifying(clearAutomatically = true)
    @Query("update Transaction t set t.deleteStatus=1 where t.id=:id")
    void deleteById(Integer id);
}
