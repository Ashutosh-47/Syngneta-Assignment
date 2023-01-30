package com.example.Syngneta.controller;

import com.example.Syngneta.field.Field;
import com.example.Syngneta.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @GetMapping("/getUsers")
    public List<Field> getMatchedUsers(@RequestParam(name="fname",required=false) String fname,
                                          @RequestParam(name="lname",required=false) String lname,
                                          @RequestParam(name="addr",required=false) String addr,
                                          @RequestParam(name="state",required=false) String state,
                                          @RequestParam(name="city",required=false) String city,
                                          @RequestParam(name="code",required=false) String code) {
        addressBookService = new AddressBookService();
        List<Field> results;
        if (fname == null && lname == null && addr == null && state == null && city == null && code == null) {
            try {
                results = addressBookService.getAll();
            } catch (Exception e) {
                results = new ArrayList<>();
            }
        }
        else {
            try {
                results = addressBookService.match(fname, lname, addr,city, state, code);
            } catch (Exception e) {
                results = new ArrayList<>();
            }
        }
        return results;
    }


}
