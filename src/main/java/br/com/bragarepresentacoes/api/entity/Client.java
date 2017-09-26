package br.com.bragarepresentacoes.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.Data;

@Entity(name="CLIENT")
@Data
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "STATE_REGISTRATION")
    private String stateRegistration;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "CONTACT")
    private String contact;
    
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DISCOUNT_PERCENT")
    private BigDecimal discountPercent;

    @Column(name = "VISIT_INTERVAL")
    private Integer vistiInterval;
}
