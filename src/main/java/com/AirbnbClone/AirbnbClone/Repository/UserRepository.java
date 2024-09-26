package com.AirbnbClone.AirbnbClone.Repository;

import com.AirbnbClone.AirbnbClone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
