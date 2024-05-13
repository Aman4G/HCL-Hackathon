package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customerTable")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_Id;

    @Column(name = "transactionState", nullable = false)
    private String transactionState;

    @Column(name = "transactionType", nullable = false)
    private String transactionType;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Column(name = "countryCode", nullable = false)
    private String countryCode;

    @Column(name = "balanceAmount", nullable = false)
    private double balanceAmount;

    @Column(name = "transactionId", nullable = false)
    private String transactionId;

    @Column(name = "createdDate", nullable = false)
    private String createdDate;

    @Override
    public String toString() {
        return "Wallet{" +
                "customer_Id=" + customer_Id +
                ", transactionState='" + transactionState + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", countryCode=" + countryCode +
                ", balanceAmount=" + balanceAmount +
                ", transactionId='" + transactionId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
