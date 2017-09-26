package br.com.bragarepresentacoes.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="COMPANY")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CHARGE_PERCENT")
    private BigDecimal chargePercent;
}
