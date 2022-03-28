package com.ibm.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.CurrencyConversion;

@Repository
public interface CurrencyConversionRepo extends JpaRepository<CurrencyConversion, Integer>{

}

