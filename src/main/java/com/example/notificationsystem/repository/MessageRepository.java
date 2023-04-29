package com.example.notificationsystem.repository;

import com.example.notificationsystem.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("MessageRepository")
public interface MessageRepository extends JpaRepository<Message, Integer> {
    Optional<Message> findById(int id);

    List<Message> findByUserid_to(int userid);
}
