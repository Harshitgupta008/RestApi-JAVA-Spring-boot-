package com.restApi.restapipractice.Controller;

import com.restApi.restapipractice.Entity.UserEntry;
import com.restApi.restapipractice.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/data")
    public boolean AddUser(@RequestBody UserEntry userEntry){
        userService.SaveUser(userEntry);
        return  true;
    }

    @GetMapping("/data")
    public List<UserEntry> getAllData(){
        return userService.AllUsers();
    }

    @GetMapping("/data/{userid}")
    public UserEntry findUserById(@PathVariable ObjectId userid){
        return userService.FindById(userid).orElse(null);
    }

    @PutMapping("/data/{userid}")
    public UserEntry UpdateById(@PathVariable ObjectId userid, @RequestBody UserEntry newEntry){
        UserEntry oldDetail = userService.FindById(userid).orElse(null);
        if( oldDetail != null){
            oldDetail.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : oldDetail.getName());
            oldDetail.setLocation(newEntry.getLocation() != null && !newEntry.getLocation().equals("") ? newEntry.getLocation() : oldDetail.getLocation());
            oldDetail.setNumber(newEntry.getNumber() != 0 ? newEntry.getNumber() : oldDetail.getNumber());
            userService.SaveUser(oldDetail);
        }
        return oldDetail;
    }

    @DeleteMapping("/data/{userid}")
    public boolean Deleteuser(@PathVariable ObjectId userid){
        userService.DeleteById(userid);
        return  true;
    }
}
