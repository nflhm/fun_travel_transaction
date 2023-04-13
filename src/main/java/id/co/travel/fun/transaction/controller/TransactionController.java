package id.co.travel.fun.transaction.controller;

import id.co.travel.fun.transaction.model.Transaction;
import id.co.travel.fun.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/")
    public @ResponseBody List<Transaction> selectAllTransaction() {
        return transactionService.allTransactions();
    }
    @GetMapping("/id")
    public @ResponseBody Transaction selectUnique(@RequestParam("id") int id) {
        Transaction model = new Transaction();
        model.setId(id);
        return transactionService.findTheTransaction(model);
    }
    @GetMapping("/add")
    public String addTransaction(@RequestParam("customer_id") int customerId,
                             @RequestParam("package_id") int packageId) {
        Transaction model = new Transaction(0, 0, 0, customerId, packageId);
        transactionService.insert(model);
        return "redirect:/transaction/";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") int id,
                                 @RequestParam("tran_status") int tranStatus,
                                 @RequestParam("delete_status") int deleteStatus,
                                 @RequestParam("customer_id") int customerId,
                                 @RequestParam("package_id") int packageId) {
        Transaction model = new Transaction(id, tranStatus, deleteStatus, customerId, packageId);
        transactionService.update(model);
        return "redirect:/transaction/";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        Transaction model = new Transaction();
        model.setId(id);
        transactionService.delete(model);
        return "redirect:/transaction/";
    }
}
