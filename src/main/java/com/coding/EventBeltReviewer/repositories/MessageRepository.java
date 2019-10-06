package com.coding.EventBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.EventBeltReviewer.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}