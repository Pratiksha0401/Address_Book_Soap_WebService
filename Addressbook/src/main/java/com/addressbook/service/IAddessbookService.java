package com.addressbook.service;

import com.addressbook.wsdlClasses.AddContactRequest;
import com.addressbook.wsdlClasses.AddContactResponse;
import com.addressbook.wsdlClasses.DeleteContactRequest;
import com.addressbook.wsdlClasses.DeleteContactResponse;
import com.addressbook.wsdlClasses.GetAllContactRequest;
import com.addressbook.wsdlClasses.GetAllContactResponse;
import com.addressbook.wsdlClasses.GetContactByIdRequest;
import com.addressbook.wsdlClasses.GetContactByIdResponse;
import com.addressbook.wsdlClasses.UpdateContactRequest;
import com.addressbook.wsdlClasses.UpdateContactResponse;

public interface IAddessbookService {
	
	AddContactResponse addContact(AddContactRequest request);

	GetContactByIdResponse getContactById(GetContactByIdRequest request);

	GetAllContactResponse getAllContact(GetAllContactRequest request);

	DeleteContactResponse deleteContact(DeleteContactRequest request);

	//boolean updateContact(AddressbookDTO bookdto);

	UpdateContactResponse updateContact(UpdateContactRequest request);

}
