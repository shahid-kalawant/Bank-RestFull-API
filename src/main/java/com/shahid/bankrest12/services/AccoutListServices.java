package com.shahid.bankrest12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.shahid.bankrest12.entities.Account;
import com.shahid.bankrest12.repository.Accountrepo;

@Service
public class AccoutListServices {
	
	@Autowired
	private Accountrepo at;
	
	public List<Account> getAllList()
	{
		return at.findAll();
	}
	
	
	public Account getoneAccount(int accno)
	{
		return at.findById(accno).get();
	}
	
	public List<Account> getAccounttype(String acctype)
	{
		return at.findByAcctype(acctype);
	}
	
	
	public Account addNewAccount(Account obj)
	{
		return at.save(obj);
	}
	
	public String deposite(int accno,float balance)
	{
		String status="";
		
		
		Account obj=at.findById(accno).get();
		
		if(obj!=null)
		{
			
		obj.setBalance(obj.getBalance()+balance);
		at.save(obj);
		status="successs Deposite";
		
		}
		else
			status="Failed";
		
		return status;
	}
	
	
	
	public String deleteAccount(int accno)
	{
		String status="";
		Account obj=at.findById(accno).get();
		if(obj!=null)
		{
			at.delete(obj);
			status="delete account";
		}
		else
			status="Failed";
		
		return status;
			
			
	}
	
	public String tansger(int fromacc,int toacc,float balance)
	{
		String status="";
		Account obj1=at.findById(fromacc).get();
		Account obj2=at.findById(toacc).get();
		if(obj1!=null && obj2!=null)
		{
			obj1.setBalance(obj1.getBalance()-balance);
			obj2.setBalance(obj2.getBalance()+balance);
			at.save(obj1);
			at.save(obj2);
			
			status ="success transfer";
		}
		else
		{
			status="Failed";
		}
		
		return status;
		
	}
}
