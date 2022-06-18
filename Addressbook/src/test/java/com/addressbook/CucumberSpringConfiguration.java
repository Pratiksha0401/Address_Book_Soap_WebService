package com.addressbook;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = AddressbookApplication.class)
public class CucumberSpringConfiguration {

}
