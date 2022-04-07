package com.altiusdigital.roster.roster.controller;

import com.altiusdigital.roster.roster.entity.BookingRequest;
import com.altiusdigital.roster.roster.entity.Roster;
import com.altiusdigital.roster.roster.model.Acceptance;
import com.altiusdigital.roster.roster.repository.IRosterRepo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/")
@ComponentScan("com.altiusdigital.roster")
@CrossOrigin
public class RosterController {

    Acceptance acceptance;
    BookingRequest bookingRequest;
    @Autowired(required = true)
    RestTemplate restTemplate;
    //Roster roster=new Roster();
    @Autowired(required = true)
    IRosterRepo repo;
    //ResponseEntity<Acceptance> acceptanceResponse = new ResponseEntity<Acceptance>();
    private Object ResponseEntity;
    @Autowired(required =true)
    EurekaClient client;
   /* @Value("${concierge.serviceId}")
    private String conciergeId;*/

    @PostMapping(path="/roster",consumes="application/json")
    public String createRosterEntry(@RequestBody Roster roster){
        try{
            repo.save(roster);
        }catch(JpaSystemException jpse){
          jpse.getMessage();
        }
        return "roster created successfully";
    }

    @GetMapping(path="/roster", produces="application/json")
    public Roster viewRoster(@RequestParam(value="firstName",required = true) String firstName,@RequestParam(value="date") String date){
    Roster roster = repo.fetchRosterByFirstNameAndDate (firstName,date);
        if(roster!=null){
            System.out.println(roster.getLastName ());
        }else{
            System.out.println("roster is null");
        }
        return roster;
       }
       @PostMapping(path="/accept",consumes="application/json")
       public ResponseEntity<BookingRequest> acceptRoster(@RequestBody BookingRequest request){
          bookingRequest = request;
           ResponseEntity<BookingRequest> booked=null;
          Application app = client.getApplication ("concierge");
          if(app==null){
              System.out.println("App object is null");
          }
          InstanceInfo instanceInfo = app.getInstances ().get(0);
          System.out.println("HostName:  "+instanceInfo.getHostName ());
          //String url= "http://"+instanceInfo.getHostName ()+":"+instanceInfo.getAppName ()+":"+instanceInfo.getPort ()+"/"+"booking";
           String url= "http://"+instanceInfo.getHostName ()+":"+instanceInfo.getPort ()+"/booking";
           System.out.println("VIP Address"+instanceInfo.getVIPAddress ());
           System.out.println(instanceInfo.getId ());
          System.out.println("URL "+url);
          try {
              System.out.println("TRYYYY");

           booked = restTemplate.postForEntity (new URL (url).toString(), bookingRequest, BookingRequest.class);
              System.out.println ("Rest Template ");
          }catch(Exception e){
              System.out.println("Inside Exception ");
              e.printStackTrace ();
          }
          return booked;
          //return new ResponseEntity<BookingRequest>(bookingRequest, HttpStatus.CREATED);
       }

}