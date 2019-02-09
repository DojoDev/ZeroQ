package com.movile.zeroQ.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.financial.domain.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{
}
