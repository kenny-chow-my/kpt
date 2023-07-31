package com.kenny.llmdemo.kpt.repo;

import com.kenny.llmdemo.kpt.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserDetailRepo extends CrudRepository<UserDetails, Long> {

    Optional<UserDetails> findByEmail(String email);

}
