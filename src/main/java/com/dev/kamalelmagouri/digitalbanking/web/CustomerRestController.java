package com.dev.kamalelmagouri.digitalbanking.web;

import com.dev.kamalelmagouri.digitalbanking.entities.Customer;
import com.dev.kamalelmagouri.digitalbanking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class CustomerRestController {

    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable(name = "id") int id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null){
            return  ResponseEntity.ok().body(customer);
        }else{
            return ResponseEntity.internalServerError().body(Map.of("errorMessage","Customer Not Found!"));
        }
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return  customerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(name="id") int id, @RequestBody Customer customer){
        customer.setId(id);
        return  customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable(name="id") int id){
         customerRepository.deleteById(id);
    }


}
