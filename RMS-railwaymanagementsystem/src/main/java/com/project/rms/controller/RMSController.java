package com.project.rms.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.rms.model.Card;
import com.project.rms.model.Query;
import com.project.rms.model.Ticket;
import com.project.rms.model.Trains;
import com.project.rms.model.User;
import com.project.rms.repository.userRepository;

import com.project.rms.repository.ticketRepository;
import com.project.rms.repository.trainsRepository;
import com.project.rms.repository.cardRepository;
import com.project.rms.repository.queryRepository;

@Controller
@RequestMapping("/rms")
public class RMSController {
	
	@Autowired
	userRepository userRepository;
	
	@Autowired
	ticketRepository ticketRepository;
	
	@Autowired
	trainsRepository trainsRepository;
	
	@Autowired
	queryRepository queryRepository;
	
	@Autowired
	cardRepository cardRepository;
	
	String loggedUserId = null;
	String bookedTrainId = null;
	String requiredDateOfJourney = null;
	String coachType = null;
	
	public String changeFormat(String dateOfJourney) {
		try {
			SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = currentFormat.parse(dateOfJourney);
			SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM yyyy");
			return newFormat.format(date);
		}catch(Exception e) {
			return null;
		}
	}
	
	public String generatePNR() {
	    long leftLimit = 1234567890L;
	    long rightLimit = 9876543210L;
	    long generatedPNR = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return String.valueOf(generatedPNR);
	}
	
	public String generateCoachNumber() {
		int leftLimit = 1;
		int rightLimit = 9;
		int generatedCoachNumber = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
		return coachType+"-"+generatedCoachNumber;
	}
	
	public String generateSeatNumber() {
		int leftLimit = 2;
		int rightLimit = 48;
		int generatedSeatNumber =  leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
		return String.valueOf(generatedSeatNumber);
	}
	
	public String bookedDate() {
		SimpleDateFormat bookedDateFormat = new SimpleDateFormat("dd MMM yyyy");
		Date date = new Date();
		return bookedDateFormat.format(date);
	}
	
	public String userAge(String dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = formatter.parse(dob);
			Instant instant = date.toInstant();
		    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		    LocalDate givenDate = zone.toLocalDate();
		    Period period = Period.between(givenDate, LocalDate.now());
		    return ""+period.getYears()+" Y";
		}catch(Exception e) {
			return null;
		}
	}
	
	@GetMapping("/home")
	public String home() {
		
		return "home.html";
	}
	
	@GetMapping("/error")
	public String error() {
		
		return "error.html";
	}
	
	@GetMapping("/invalid")
	public String invalid() {
		
		return "invalid.html";
	}
	
	@GetMapping("/signUpPage")
	public String signUpPage() {
		
		return "userSignUp.html";
	}
	
	@GetMapping("/loginPage") 
	public String loginPage() {
	  
	  return "userLogin.html"; 
	}
	
	@GetMapping("/logOut") 
	public String logout() {
		return "index.html";
	}
	
	@GetMapping("/trainDetailsPage")
	public String trainDetailsPage() {
		
		return "trains.html";
	}
	
	@GetMapping("/clickRegisterUser")
	public String clickRegisterUser() {
		
		return "registerUser.html";
	}
	
	@GetMapping("/paymentDetails/{id}")
	public String paymentDetails(@PathVariable("id") String trainId) {
		bookedTrainId = trainId;
		return "paymentDetails.html";
	}
	
	@PostMapping("/userSignUp")
	public String registerUser(@RequestParam String userName, @RequestParam String userEmail, @RequestParam String userMobileNo, @RequestParam String userPassword, @RequestParam String userDateOfBirth,
			@RequestParam String userGender, @RequestParam String userAddress){
		try {
			userRepository.save(new User(userName, userEmail, userMobileNo, userPassword, userDateOfBirth, userGender, userAddress));
			return "redirect:loginPage";
		}catch (Exception e) {
			return "redirect:error";
		}
	}
	
	@GetMapping("/userLogin") 
	public String login(@RequestParam String userEmail, @RequestParam String userPassword){
	  User user = userRepository.findByUserEmail(userEmail);
	  loggedUserId = user.getUserId();
	  if(userPassword.equals(user.getUserPassword())) { 
		  try { 
			  return "redirect:home"; 
		  }catch (Exception e) { 
			  return "redirect:error"; } 
	  }else	{ 
		  return "redirect:invalid"; 
	  }
	}
	
	@GetMapping("/checkAvailableTrains")
	public String checkAvailableTrains(@RequestParam String trainBoardingStation, @RequestParam String trainDeboardingStation, @RequestParam String dateOfJourney, @RequestParam String berthType, Model model) {
		try {
			System.out.println(trainBoardingStation+"	"+ trainDeboardingStation);
			
			requiredDateOfJourney = changeFormat(dateOfJourney);
			coachType = berthType;
			
			List<Trains> availableTrains = trainsRepository.findByTrainRunningDate(requiredDateOfJourney).stream().filter(train -> train.getTrainBoardingStation().equalsIgnoreCase(trainBoardingStation) && train.getTrainDeboardingStation().equalsIgnoreCase(trainDeboardingStation)).collect(Collectors.toList());
			System.out.println(dateOfJourney);
			
			model.addAttribute("listTrains", availableTrains);
			
			return "availableTrains.html";
		}catch(Exception e) {
			return "redirect:error";
		}
	}
	
	@PostMapping("/trainDetails")
	public String trainDetails(@RequestParam String trainNumber, @RequestParam String trainName, @RequestParam String trainBoardingStation, @RequestParam String trainDeboardingStation, @RequestParam String trainRunningDate,
			@RequestParam String trainArrivalTime, @RequestParam String trainDepartureTime, @RequestParam String numberOfSeats, @RequestParam String trainFare){
		try {
			trainsRepository.save(new Trains(trainNumber, trainName, trainBoardingStation, trainDeboardingStation, trainRunningDate, trainArrivalTime, trainDepartureTime, numberOfSeats, trainFare));
			return "redirect:loginPage";
		}catch (Exception e) {
			return "redirect:error"; }
	}
	
	@GetMapping("/listAllTrains")
	public String listTrains(Model model) {
		try {
			model.addAttribute("listTrains", trainsRepository.findAll());
			return "listAllTrains.html";
		}catch(Exception e) {
			return "error.html"; 
		}
	}
	
	@PostMapping("/saveQuery")
	public String saveQuery(@RequestParam String userEmail, @RequestParam String userQuery) {
		try {
			queryRepository.save(new Query(userEmail, userQuery));
			return "redirect:home";
		} catch (Exception e) {
			return "redirect:home";
		}
	}
	
	@GetMapping("/bookedTicket")
	public String bookTicket(Model trainModel, Model userModel, Model ticketModel, Model model) {
		try {
			
			User user = userRepository.findById(loggedUserId).orElse(null);
			Trains train = trainsRepository.findById(bookedTrainId).orElse(null);
			
			user.setUserDateOfBirth(userAge(user.getUserDateOfBirth()));
			
			ticketRepository.save(new Ticket(generatePNR(), bookedDate(), requiredDateOfJourney, user, train, generateCoachNumber(), generateSeatNumber(), train.getTrainFare()));
			
			Ticket ticket = new Ticket(generatePNR(), bookedDate(), requiredDateOfJourney, user, train, generateCoachNumber(), generateSeatNumber(), train.getTrainFare());
			
			List<Ticket> ticketList = new ArrayList<>();
			ticketList.add(ticket);
			
			ticketModel.addAttribute("bookedTicket", ticketList);
			return "booked.html";
		} catch (Exception e) {
			return "error.html";
		}
		
	}
	
	@PostMapping("/confirmPayment")
	public String  confirmPayment(@RequestParam String nameOnCard, @RequestParam String cardNo, @RequestParam String expiryDate, @RequestParam String cardCVV) {
		
		try {
			cardRepository.save(new Card(nameOnCard, cardNo, expiryDate, cardCVV));
			return "redirect:bookedTicket";
		} catch (Exception e) {
			return "error.html";
		}
	}
	 
}
