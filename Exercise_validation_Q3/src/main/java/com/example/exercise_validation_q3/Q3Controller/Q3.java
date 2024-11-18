package com.example.exercise_validation_q3.Q3Controller;

import com.example.exercise_validation_q3.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Q3")
public class Q3 {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/display")
    public ResponseEntity getQ3(){
        return ResponseEntity.ok(events);
    }
@PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody @Valid Event event , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        return ResponseEntity.status(200).body(event);
}

    @PutMapping("/update/{index}")
    public ResponseEntity update( @PathVariable int index, @RequestBody @Valid Event event, Errors errors){
        if(errors.hasErrors()){
            String mesage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(mesage);}

        events.set(index, event);
        return ResponseEntity.ok("updated");
    }


    @DeleteMapping("/delete")
    public ResponseEntity delete(@PathVariable int index){
        events.remove(index);
        return ResponseEntity.ok("deleted");
    }

    @PutMapping("/change/{index}/{capacity}")
    public ResponseEntity changeCapacity(@PathVariable @Valid int index ,@PathVariable int capacity , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.get(index).setCapacity(capacity);
        return ResponseEntity.status(200).body("Updated capacity is successful");
    }

    @GetMapping("search/{id}")
    public ResponseEntity searchEvent(@PathVariable int id) {
        ArrayList<Event> events1 = new ArrayList<>();
        for (Event event : events) {
            if (event.getId() == id) {
                events1.add(event);
            }
        }
        return ResponseEntity.status(200).body(events1);
    }





}
