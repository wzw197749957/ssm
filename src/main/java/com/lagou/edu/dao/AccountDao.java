package com.lagou.edu.dao;

import com.lagou.edu.domain.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> getAll();

    public Account queryByCardNo(String cardNo);

    public Boolean queryPasswordByUsername(String userName, String passWord);

    public void save(Object entity);

    public void update(Object entity);

    public void delete(String cardNo);
}
