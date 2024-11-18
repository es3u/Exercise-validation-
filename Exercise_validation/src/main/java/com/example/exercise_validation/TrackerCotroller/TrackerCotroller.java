package com.example.exercise_validation.TrackerCotroller;

import com.example.exercise_validation.TrackerCotroller.Model.Tracker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
////Srevr 1222
@RestController
@RequestMapping("/api/v1/Q2")
public class TrackerCotroller {

    ArrayList<Tracker> trackers = new ArrayList<>();

    @GetMapping("/display")
    public ArrayList<Tracker> Display(){

        return trackers;
    }


    @PostMapping("/add")
    public ResponseEntity addTask(@RequestBody @Valid Tracker tracker , Errors errors){

        if(errors.hasErrors()){
            String messae = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(messae);
        }

        trackers.add(tracker);
        return ResponseEntity.status(200).body("Added successfully");
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateTask(@PathVariable @Valid int index,@RequestBody @Valid Tracker tracker){

        trackers.set(index, tracker);
        return ResponseEntity.status(200).body("Updated Task is successfully");
    }
    @DeleteMapping(("/delete/{id}"))
    public ResponseEntity DeleteTask(@PathVariable int id){
        trackers.remove(id);
        return ResponseEntity.status(200).body("Deleted  is successfully");
    }


    @PutMapping("/change/{index}/")
    public ResponseEntity changeStatus(@PathVariable  int index , Errors errors){

        if(trackers.get(index).getStatus().contains("Not Started")){
            trackers.get(index).setStatus("Progress");
          return ResponseEntity.status(200).body("is Progress");
        }else if(trackers.get(index).getStatus().contains("Progress")) {
            trackers.get(index).setStatus("Complete");
            return ResponseEntity.status(200).body("is Complete");
        }else{
           return ResponseEntity.status(200).body("is already Complete");
        }

    }

    @GetMapping("/search/{title}")
    public ResponseEntity search(@PathVariable String title) {
        ArrayList<Tracker> t1 = new ArrayList<>();
        for (Tracker t : trackers) {
            if (t.getTitle().contains(title)) {
                t1.add(t);

            }

        }
        return ResponseEntity.status(200).body(t1);
    }




}
