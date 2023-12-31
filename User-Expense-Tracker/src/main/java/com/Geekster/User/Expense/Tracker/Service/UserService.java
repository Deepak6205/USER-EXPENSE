package com.Geekster.User.Expense.Tracker.Service;

import com.Geekster.User.Expense.Tracker.Entity.*;
import com.Geekster.User.Expense.Tracker.Entity.Dto.PlaceOrder;
import com.Geekster.User.Expense.Tracker.Entity.Dto.SignInInput;
import com.Geekster.User.Expense.Tracker.Entity.Dto.SignUpOutput;
import com.Geekster.User.Expense.Tracker.Repository.IUserRepo;
import com.Geekster.User.Expense.Tracker.Service.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class UserService {
@Autowired
private IUserRepo userRepo;

@Autowired
private AuthenticationService authenticationService;

@Autowired
private OrderService orderService;

@Autowired
private ExpenseService expenseService;

@Autowired
private ProductService productService;

    public SignUpOutput userSignUp(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //saveAppointment the user with the new encrypted password

            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }


    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_



    public String userLogIn(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                // EmailHandler.sendEmail("mainakgh1@gmail.com","email testing",authToken.getTokenValue());
                return "Session Created with the Token "+authToken.getTokenValue();
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public String placeAnOrder(PlaceOrder order,String userEmail) {
        User user = userRepo.findFirstByUserEmail(userEmail);
        return orderService.placeAnOrder(order,user);
    }

    public String checkMonthlyExpense(Month month, Year year ,String userEmail) {

        User user = userRepo.findFirstByUserEmail(userEmail);

        return expenseService.checkMonthlyExpense(month,year,user);
    }

    public String checkYearlyExpense(Year year, String userEmail) {
        User user = userRepo.findFirstByUserEmail(userEmail);

        return expenseService.checkYearlyExpense(year,user);
    }

    public List<Expense> getMonthlyExpenseWithLimit(String userEmail,int limit) {
        User user = userRepo.findFirstByUserEmail(userEmail);

        return expenseService.getMonthlyExpenseWithLimit(user,limit);
    }

    public List<Order> getOrderedProductsWithDate(LocalDate date, String userEmail) {

        User user = userRepo.findFirstByUserEmail(userEmail);

         return orderService.getOrderedProductsWithDate(date,user);
    }

    public Product getProduct(Integer productId) {
        return productService.getproduct(productId);
    }
}
