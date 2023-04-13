package id.co.travel.fun.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "tran_status")
    private int tranStatus;
    @Column(name = "delete_status")
    private int deleteStatus;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "package_id")
    private int packageId;

    public Transaction() {
    }

    public Transaction(int id, int tranStatus, int deleteStatus, int customerId, int packageId) {
        this.id = id;
        this.tranStatus = tranStatus;
        this.deleteStatus = deleteStatus;
        this.customerId = customerId;
        this.packageId = packageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(int tranStatus) {
        this.tranStatus = tranStatus;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }
}
