package com.codeoverflow.user.service.repositories;

import com.codeoverflow.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


//you can implement here your custom design methods

}
