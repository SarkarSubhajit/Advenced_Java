package wbjp.spring.firstboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wbjp.spring.firstboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
