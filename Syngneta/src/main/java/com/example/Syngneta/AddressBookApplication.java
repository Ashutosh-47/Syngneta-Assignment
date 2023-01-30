package com.example.Syngneta;

import com.example.Syngneta.service.AddressBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApplication {
//	static AddressBookService addressBookService=new AddressBookService();
	public static void main(String[] args) throws Exception{
		SpringApplication.run(AddressBookApplication.class, args);

//		System.out.println(addressBookService.getAll());
	}

}
