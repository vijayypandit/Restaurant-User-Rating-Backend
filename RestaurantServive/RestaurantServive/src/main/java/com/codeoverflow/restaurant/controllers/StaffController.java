package com.codeoverflow.restaurant.controllers;

@RestController
@RequestMapping("/staff")
public class StaffController {

    // create api here

    @GetMapping
    public ResponseEntity<List<String>> getStaffs(){

        List<String> list = Arrays.asList("Ram","Shyam","Sita","Geeta");
        return ResponseEntity<>(list,HttpStatus.OK);
    }
}
