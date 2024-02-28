package com.ToDo_Man_Sys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo_Man_Sys.Entities.ContactForm;
import com.ToDo_Man_Sys.Repositroy.ContactRepository;
@Service
public class ContactService {
	
	@Autowired
	private ContactRepository CRepo;
	
	public void save(ContactForm cf) {
		// TODO Auto-generated method stub
		CRepo.save(cf);
}
}