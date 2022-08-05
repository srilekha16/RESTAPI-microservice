package com.retailer2customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.retailer2customer.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
