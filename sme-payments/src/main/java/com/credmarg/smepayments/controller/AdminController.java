package com.credmarg.smepayments.controller;

import com.credmarg.smepayments.model.EmailLog;
import com.credmarg.smepayments.model.Employee;
import com.credmarg.smepayments.model.Vendor;
import com.credmarg.smepayments.service.EmailLogService;
import com.credmarg.smepayments.service.EmployeeService;
import com.credmarg.smepayments.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EmailLogService emailLogService;

    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/addVendor")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/vendors/send-email")
    public String sendEmail(@RequestBody List<Vendor> vendors) {
        StringBuilder emailsSent = new StringBuilder();
        for (Vendor vendor : vendors) {
            String emailContent = "Sending payments to vendor: " + vendor.getName()+ "\n" + " at UPI: " + vendor.getUpi();
            emailLogService.addEmailLog(emailContent);
            emailsSent.append(emailContent).append("\n");
            System.out.println(emailContent);
        }
        return emailsSent.toString();
    }

    @GetMapping("/emails")
    public List<EmailLog> getAllEmails() {
        return emailLogService.getAllEmailLogs();
    }
}
