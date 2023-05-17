package com.dev.kamalelmagouri.digitalbanking.entities;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CUSTOMERS")
@Data @NoArgsConstructor @Builder @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(name = "EMAIL", length = 50, unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @OneToMany(mappedBy="Customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccounts;

}
