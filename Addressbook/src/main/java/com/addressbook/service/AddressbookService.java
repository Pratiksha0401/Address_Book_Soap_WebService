package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.dto.AddressbookDTO;
import com.addressbook.entity.AddressbookData;
import com.addressbook.exception.SoapException;
import com.addressbook.repository.AddressBookRepository;
import com.addressbook.wsdlClasses.AddContactRequest;
import com.addressbook.wsdlClasses.AddContactResponse;
import com.addressbook.wsdlClasses.ContactInfo;
import com.addressbook.wsdlClasses.DeleteContactRequest;
import com.addressbook.wsdlClasses.DeleteContactResponse;
import com.addressbook.wsdlClasses.GetAllContactRequest;
import com.addressbook.wsdlClasses.GetAllContactResponse;
import com.addressbook.wsdlClasses.GetContactByIdRequest;
import com.addressbook.wsdlClasses.GetContactByIdResponse;
import com.addressbook.wsdlClasses.ServiceStatus;
import com.addressbook.wsdlClasses.UpdateContactRequest;
import com.addressbook.wsdlClasses.UpdateContactResponse;

@Service
public class AddressbookService implements IAddessbookService {

	@Autowired
	AddressBookRepository bookRepository;

	@Override
	public AddContactResponse addContact(AddContactRequest request) {

		Optional<AddressbookData> contactName = bookRepository.findByName(request.getContactInfoWithoutId().getName());

		if (contactName.isPresent()) {
			throw new SoapException("Contact with " + contactName.get().getName() + " name already exist");
		}
		if (request.getContactInfoWithoutId().getName().stripLeading().equals("")) {
			throw new SoapException("Name cannot null");
		}
		AddContactResponse response = new AddContactResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		AddressbookDTO bookDto = new AddressbookDTO();
		BeanUtils.copyProperties(request.getContactInfoWithoutId(), bookDto);

		AddressbookData bookData = new AddressbookData(bookDto);
		bookRepository.save(bookData);
		ContactInfo info = new ContactInfo();
		BeanUtils.copyProperties(bookData, info);
		serviceStatus.setMessage("Employee Added Successfully");

		response.setContactInfo(info);
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@Override
	public GetContactByIdResponse getContactById(GetContactByIdRequest request) {
		GetContactByIdResponse response = new GetContactByIdResponse();
		AddressbookData bookData = bookRepository.findById(request.getId()).orElse(null);

		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setMessage("Contact Found");

		ContactInfo info = new ContactInfo();
		BeanUtils.copyProperties(bookData, info);

		response.setContactInfo(info);
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@Override
	public GetAllContactResponse getAllContact(GetAllContactRequest request) {
		GetAllContactResponse response = new GetAllContactResponse();
		List<AddressbookData> contactDataList = bookRepository.findAll();
		List<ContactInfo> contactInfoList = new ArrayList<>();

		for (AddressbookData contactData : contactDataList) {
			ContactInfo info = new ContactInfo();
			BeanUtils.copyProperties(contactData, info);
			contactInfoList.add(info);
		}
		response.getContactInfo().addAll(contactInfoList);

		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setMessage("All Contacts");

		response.setServiceStatus(serviceStatus);

		return response;
	}

	@Override
	public DeleteContactResponse deleteContact(DeleteContactRequest request) {
		DeleteContactResponse response = new DeleteContactResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Optional<AddressbookData> contactData = bookRepository.findById(request.getId());
		if (contactData.isPresent()) {
			bookRepository.deleteById(request.getId());
			serviceStatus.setMessage("Contact with id " + request.getId() + " deleted successfully");
			response.setServiceStatus(serviceStatus);
		} else
			throw new SoapException("Exception while deleting the Contact id=" + request.getId());

		return response;
	}

	@Override
	public UpdateContactResponse updateContact(UpdateContactRequest request) {
		UpdateContactResponse response = new UpdateContactResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Optional<AddressbookData> contactDataById = bookRepository.findById(request.getContactInfo().getId());
		AddressbookData contactData = new AddressbookData();

		BeanUtils.copyProperties(request.getContactInfo(),contactData);
		bookRepository.save(contactData);

		serviceStatus.setMessage("Contact Updated successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}

}
