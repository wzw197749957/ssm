package com.lagou.edu.dao.impl;

import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Service("AccountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Account> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Account a");
        try {
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Account queryByCardNo(String cardNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Account a where a.cardNo=?1");
        query.setParameter(1, cardNo);
        try {
            return (Account) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Boolean queryPasswordByUsername(String userName, String passWord) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Account a where a.userName=?1");
        query.setParameter(1, userName);
        try {
            Account account = (Account) query.getSingleResult();
            return account.getPassWord().equals(passWord);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void save(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
        entityManager.close();
    }
}
