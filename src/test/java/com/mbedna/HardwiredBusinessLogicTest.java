package com.mbedna;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class HardwiredBusinessLogicTest {
	
	@Test
	public void mockingWithoutInterfaces() {
		HardwiredBusinessLogic mock = mock(HardwiredBusinessLogic.class);	
		final String expected = "Java Rocks";
		when(mock.getGreeting()).thenReturn(expected);
		String actual = mock.getGreeting();
		assertThat(actual, is(expected));
		System.out.println("dupsko"); 
	} 
}
