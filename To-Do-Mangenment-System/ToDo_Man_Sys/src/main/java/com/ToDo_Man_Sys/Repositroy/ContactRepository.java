package com.ToDo_Man_Sys.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDo_Man_Sys.Entities.ContactForm;

@Repository
public interface ContactRepository  extends JpaRepository<ContactForm,Integer>{

}
