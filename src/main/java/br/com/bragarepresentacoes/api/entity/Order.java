package br.com.bragarepresentacoes.api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Entity(name = "ORDERS")
@Data
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AGENT_ID")
    private Agent agent;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", updatable=false)
    private ApiUser user;

    @JsonIgnore
    @Column(name = "CREATE_DATE", updatable=false)
    private LocalDateTime createDate;

    @Column(name = "ORDER_AMOUNT")
    private BigDecimal orderAmount;

    @Column(name = "ORDER_INVOICED")
    private BigDecimal orderInvoiced;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "OBSERVATION")
    private String observation;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "INVOICE_DATE")
    private LocalDate invoiceDate;

    @Column(name = "BONUS_AMOUNT")
    private BigDecimal bonusAmount;

    @Column(name = "BONUS_INVOICED")
    private BigDecimal bonusInvoiced;

    @Column(name = "CANCELLED")
    private Boolean cancelled;
}
