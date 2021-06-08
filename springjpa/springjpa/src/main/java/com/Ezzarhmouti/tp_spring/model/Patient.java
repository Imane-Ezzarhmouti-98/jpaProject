package com.Ezzarhmouti.tp_spring.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "PATIENTS")
@Data
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "Nom",length = 25)
    @NotEmpty
    @Size(min = 4 ,max = 25)
    private  String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date")
    private Date dateNaissance;
    @DecimalMin("4")
    @Column(name="score")
    private int score;
    @Column(name="malade")
    private boolean malade;
}
