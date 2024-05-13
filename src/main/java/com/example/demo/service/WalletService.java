package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository businessRepository;

    // Get all customers
    public List<Wallet> getAllCustomers() {
        return businessRepository.findAll();
    }

    // Get customer by ID
    public Optional<Wallet> getCustomerById(long id) {
        return businessRepository.findById(id);
    }

    // Create a new customer
    public Wallet createCustomer(Wallet businessEntity) {
        return businessRepository.save(businessEntity);
    }

    public Wallet updateCustomer(long id, Map<String, Object> updates) throws ResourceNotFoundException {
        Optional<Wallet> optionalCustomer = businessRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Wallet customer = optionalCustomer.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "customerId":
                        customer.setCustomer_Id((Long) value);
                        break;
                    case "transactionState":
                        customer.setTransactionState((String) value);
                        break;
                    case "transactionType":
                        customer.setTransactionType((String) value);
                        break;
                    case "customerName":
                        customer.setCustomerName((String) value);
                        break;
                    case "countryCode":
                        customer.setCountryCode((String) value);
                        break;
                    case "balanceAmount":
                        customer.setBalanceAmount((Double) value);
                        break;
                    case "transactionId":
                        customer.setTransactionId((String) value);
                        break;
                    case "createdDate":
                        customer.setCreatedDate((String) value);
                        break;
                    default:
                        // Ignore unknown fields
                }
            });
            return businessRepository.save(customer);
        } else {
            throw new ResourceNotFoundException("Customer_ID not present"); // Customer with the given ID not found
        }
    }

    // Delete a customer
    public void deleteCustomer(long id) {
        businessRepository.deleteById(id);
    }
}
