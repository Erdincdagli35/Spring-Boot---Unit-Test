package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DemoApplicationTests {

	Calculator test = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {
		//given
		int numberOne = 20,numberTwo=20;

		//when
		int result = test.add(numberOne,numberTwo);

		//then
		assertThat(result).isEqualTo(40);
	}

	class Calculator{
		int add (int n1,int n2){return n1+n2;}
	}
}
