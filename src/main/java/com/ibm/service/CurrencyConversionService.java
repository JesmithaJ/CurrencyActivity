package com.ibm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exception.CurrencyConversionNotFoundException;
//import com.ibm.exception.TodoNotFoundException;
import com.ibm.model.CurrencyConversion;
import com.ibm.repo.CurrencyConversionRepo;

@Service
public class CurrencyConversionService {
	

		@Autowired
		CurrencyConversionRepo todorepo;
		
		public List<CurrencyConversion> getTodos()
		{
			return todorepo.findAll();
		}
		
			public CurrencyConversion getTodo(int id)
			{
				return todorepo.findById(id).orElseThrow(CurrencyConversionNotFoundException::new);
			}
		
		public CurrencyConversion addTodo(CurrencyConversion todo)
		{
			return todorepo.save(todo);
		}
		
		public CurrencyConversion updateTodo(int id, CurrencyConversion todo)
		{
			if(getTodo(id)!=null)
			{
				return todorepo.saveAndFlush(todo);
			}
			return null;
		}
		public boolean deleteTodo(int id)
		{
			if(getTodo(id)!=null)
			{
				 todorepo.deleteById(id);
				 return true;
			}
			return false;
		}
	}
