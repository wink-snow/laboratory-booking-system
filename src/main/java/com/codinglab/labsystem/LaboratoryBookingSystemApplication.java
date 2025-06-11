package com.codinglab.labsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.laboratory_sys.app.GreetingController;

@SpringBootApplication
public class LaboratoryBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryBookingSystemApplication.class, args);
		// GreetingController greetingController = new GreetingController();
		System.out.println("Laboratory Booking System Application has started successfully.");
	}

}
