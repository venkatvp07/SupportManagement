package com.repo.supportmanagement.repository;

import com.repo.supportmanagement.model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SignUpRepo extends JpaRepository<SignUp,Long> {

    @Query("SELECT u FROM SignUp u WHERE u.emailId = :email")
    Optional<SignUp> findUserByEmail(@Param("email") String email);
}
