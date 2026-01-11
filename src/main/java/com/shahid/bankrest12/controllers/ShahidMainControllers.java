package com.shahid.bankrest12.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shahid.bankrest12.entities.Account;
import com.shahid.bankrest12.services.AccoutListServices;

@RestController
@RequestMapping("/bank/api")
public class ShahidMainControllers {
	
	@Autowired
	private AccoutListServices as;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Account> getall()
	{
		return as.getAllList();
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/search/{accno}")
	public Account searchAccount(@PathVariable int accno)
	{
		return as.getoneAccount(accno);
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/type/{acctype}")
	public List<Account> getType(@PathVariable String acctype)
	{
		return as.getAccounttype(acctype);
	}

	
	@CrossOrigin(origins = "*")
	@PostMapping("/add")
	public Account addAccount(@RequestBody Account account)
	{
		return as.addNewAccount(account);
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping("/deposite")
	public String depositebalance(int accno,float balance)
	{
		return as.deposite(accno, balance);
	}
	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete")
	public String deleteacc( int accno)
	{
		return as.deleteAccount(accno);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/transfer")
	public String transferAccount( int fromacc, int toacc,  float balance)
	{
		return as.tansger(fromacc, toacc, balance);
	}
}
