package com.example.oop.polymorphism;

import java.io.IOException;

import com.example.oop.accesscheck.HubCap;

public class Parent {

	
	HubCap attach() throws IOException {
		return new HubCap();
	}
}