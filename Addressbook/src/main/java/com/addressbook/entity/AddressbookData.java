package com.addressbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.addressbook.dto.AddressbookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="addressbook_data")
@Data
@NoArgsConstructor
public class AddressbookData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	public String city;	
	public String state;		
	public int zipcode;		
	public String phonenumber;
	
	public AddressbookData(AddressbookDTO addressbookDTO) {
		this.name = addressbookDTO.name;
		this.address = addressbookDTO.address;
		this.city = addressbookDTO.city;
		this.state = addressbookDTO.state;
		this.zipcode = addressbookDTO.zipcode;
		this.phonenumber = addressbookDTO.phonenumber;
	}
	
	public AddressbookData(int id, AddressbookDTO addressbookDTO) {
		this.id = id;
		this.name = addressbookDTO.name;
		this.address = addressbookDTO.address;
		this.city = addressbookDTO.city;
		this.state = addressbookDTO.state;
		this.zipcode = addressbookDTO.zipcode;
		this.phonenumber = addressbookDTO.phonenumber;
	}
	
}
