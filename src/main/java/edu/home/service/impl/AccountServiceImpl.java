package edu.home.service.impl;

import edu.home.model.Account;
import edu.home.repository.AccountRepository;
import edu.home.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository dao;

    @Override
    public Account findById(String id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Account> getAdministrators() {
        return dao.getAdministrators();
    }

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }
}
