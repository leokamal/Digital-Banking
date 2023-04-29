package com.dev.kamalelmagouri.digitalbanking.repository;

import com.dev.kamalelmagouri.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
