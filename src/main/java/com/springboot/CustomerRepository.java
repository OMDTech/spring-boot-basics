package com.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//DAO Layer (Databases layer)

//  used to preform crud operations and any extra queries that we want against customer table
// JpaRepository take two generics Entity and Entity Id Type
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
