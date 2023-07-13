package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@EntityListeners( value = MyEntityListener.class)
public class Address implements Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipcode;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
