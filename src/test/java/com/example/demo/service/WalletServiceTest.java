package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletService walletService;

    @Test
    void testUpdateCustomer() throws ResourceNotFoundException {
        Wallet sampleWallet = new Wallet();
        sampleWallet.setCustomer_Id(1L);
        sampleWallet.setTransactionState("Active");
        sampleWallet.setTransactionType("Deposit");
        sampleWallet.setCustomerName("Aman Gautam");
        sampleWallet.setCountryCode("UK");
        sampleWallet.setBalanceAmount(1000.0);
        sampleWallet.setTransactionId("123456");
        sampleWallet.setCreatedDate("2022-05-11");

        // Create a sample map with field updates
        Map<String, Object> updates = new HashMap<>();
        updates.put("customerName", "Aman Gupta");
        updates.put("balanceAmount", 1500.0);

        when(walletRepository.findById(1L)).thenReturn(Optional.of(sampleWallet));
        when(walletRepository.save(any(Wallet.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Wallet updatedWallet = walletService.updateCustomer(1L, updates);

        // Verify the repository interaction
        verify(walletRepository).findById(1L);
        verify(walletRepository).save(any(Wallet.class));

        assertEquals("Aman Gupta", updatedWallet.getCustomerName());
        assertEquals(1500.0, updatedWallet.getBalanceAmount());
    }
}
