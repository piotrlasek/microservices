package com.example.transfersrealizationservice.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TransferRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public void insertTransfer(Transfer transfer) {
        /*entityManager.createNativeQuery("insert into transfer (id, nrb_from, nrb_to, amount)" +
                " values (?, ?, ?, ?)")
                .setParameter(1, transfer.getId())
                .setParameter(2, transfer.getNrbFrom())
                .setParameter(3, transfer.getAmount())
                .executeUpdate();*/
        entityManager.persist(transfer);
    }

}
