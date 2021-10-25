package com.godink.demo01.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestObjectInputStream {

	@Test
	void testObjectToFile() {
		Person person = new Person("ch", 18);
		try {
			FileOutputStream fos = new FileOutputStream(new File("D:\\tmp\\testiostream\\person.obj"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
			oos.flush();
			oos.close();
			
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFileToObject() {
		try {
			FileInputStream fis = new FileInputStream(new File("D:\\tmp\\testiostream\\person.obj"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person person = (Person)ois.readObject();
			log.info("person: {}", person.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Data
	@AllArgsConstructor
	static class Person implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String name;
		private int age;
	}

}
