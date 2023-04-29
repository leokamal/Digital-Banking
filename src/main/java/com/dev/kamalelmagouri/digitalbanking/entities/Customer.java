package com.dev.kamalelmagouri.digitalbanking.entities;



import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMERS")
@Data @NoArgsConstructor @Builder @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(name = "EMAIL", length = 50, unique = true)
    private String email;

}
