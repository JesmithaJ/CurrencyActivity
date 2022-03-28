package com.ibm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.CurrencyConversion;
import com.ibm.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionService todoService;
	
	@GetMapping("cc")
	public ResponseEntity<List<CurrencyConversion>> getTodos(){
		return ResponseEntity.ok(todoService.getTodos());
	}
	
	@GetMapping("cc/{id}")
	public ResponseEntity<CurrencyConversion> getTodoById(@PathVariable int id){
		return ResponseEntity.ok(todoService.getTodo(id));
	}
	
	@PostMapping("cc")
	public ResponseEntity<CurrencyConversion>  addTodo(@Valid @RequestBody CurrencyConversion todo){
		CurrencyConversion result = todoService.addTodo(todo);
		URI link = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(link).body(result);
	}
	
	@PutMapping("cc/{id}")
	public ResponseEntity<CurrencyConversion> updateTodo(@PathVariable int id, @Valid @RequestBody CurrencyConversion todo){
		return ResponseEntity.ok(todoService.updateTodo(id, todo));
	}
	
	@DeleteMapping("cc/{id}")
	public  ResponseEntity<?> deleteTodo(@PathVariable int id)
	{
		if(todoService.deleteTodo(id))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}

}