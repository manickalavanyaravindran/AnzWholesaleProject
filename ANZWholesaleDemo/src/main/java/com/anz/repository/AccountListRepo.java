package com.anz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.entity.AccountListEntity;

@Repository
public interface AccountListRepo extends JpaRepository<AccountListEntity, Long> {
	List<AccountListEntity> findByLoginId(String loginId);
	AccountListEntity findByAccountNumber(long accountNumber);

}
