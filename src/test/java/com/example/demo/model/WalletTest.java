package com.example.demo.model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WalletTest {

    @InjectMocks
    private Wallet wallet;

    @Test
    void testWalletConstructor() {
        wallet = new Wallet(1L, "Active", "Deposit", "Aman Gautam", "UK", 1000.0, "123456", "2022-05-11");

        // Verify the fields
        assertEquals(1L, wallet.getCustomer_Id());
        assertEquals("Active", wallet.getTransactionState());
        assertEquals("Deposit", wallet.getTransactionType());
        assertEquals("Aman Gautam", wallet.getCustomerName());
        assertEquals("UK", wallet.getCountryCode());
        assertEquals(1000.0, wallet.getBalanceAmount());
        assertEquals("123456", wallet.getTransactionId());
        assertEquals("2022-05-11", wallet.getCreatedDate());
    }

    @Test
    void testWalletNoArgsConstructor() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
    }
}

