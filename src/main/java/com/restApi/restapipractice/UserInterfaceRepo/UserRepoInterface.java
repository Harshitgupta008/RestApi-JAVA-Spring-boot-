package com.restApi.restapipractice.UserInterfaceRepo;

import com.restApi.restapipractice.Entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepoInterface extends MongoRepository<UserEntry, ObjectId> {
}
