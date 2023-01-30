package com.example.Syngneta;

import com.example.Syngneta.field.Field;
import com.example.Syngneta.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AddressBookApplicationTests {

	@Autowired
	AddressBookService addressBookService;

	@Test
	void commasCountTest() {
		int c=addressBookService.countOfCommas("\"abc\"d\"");
		Assert.isTrue(c==3,"should display count in the string");
	}

	@Test
	void fileExist() throws Exception{
		String filePath="C:/Users/91817/Desktop/Syngneta/src/main/java/com/example/Syngneta/service/data.csv";
		List<Field> lines= addressBookService.readFile(filePath);
		Assert.isTrue(lines.size()>0,"Either csv doesn't have any lines or file path is wrong");
	}


	@Test
	void checkUsers() throws Exception{
		String fname="dave";
		String lname="smith";
		String addr=null;
		String city=null;
		String state="wa";
		String code=null;
		List<Field> lines= addressBookService.match(fname,lname,addr,city,state,code);
		Assert.isTrue(lines.size()>2,"refined search based on different parameters should give all the values matched");
	}

	@Test
	void fileShouldNotExist() throws Exception{
		String filePath="data.csv";
		Exception exception = assertThrows(Exception.class, () -> addressBookService.readFile(filePath));
		assertEquals("data.csv (The system cannot find the file specified)", exception.getMessage());
	}
}
