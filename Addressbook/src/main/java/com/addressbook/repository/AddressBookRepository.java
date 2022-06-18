package com.addressbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addressbook.entity.AddressbookData;

public interface AddressBookRepository extends JpaRepository<AddressbookData, Integer> {

	Optional<AddressbookData> findByName(String name);

	AddressbookData save(Optional<AddressbookData> contactDataById);

}
