package com.restApi.restapipractice.Service;

import com.restApi.restapipractice.Entity.UserEntry;
import com.restApi.restapipractice.UserInterfaceRepo.UserRepoInterface;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepoInterface userRepoInterface;

    public void SaveUser(UserEntry userEntry){
        userRepoInterface.save(userEntry);
    }

    public List<UserEntry> AllUsers(){
        return userRepoInterface.findAll();
    }

    public Optional<UserEntry> FindById(ObjectId id){
        return userRepoInterface.findById(id);
    }

    public void DeleteById(ObjectId id){
        userRepoInterface.deleteById(id);
    }
}
