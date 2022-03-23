package com.server.information.system.service;

 
import java.util.List;
import java.util.Optional;

 
import com.server.information.system.model.Server;

public interface ServerService {

    List<Server> findAll();

    Optional<Server> findById(String id);

    Server findByName(String name);

    Server saveOrUpdateServer(Server server);

    void deleteServerById(String id);
    
    List<Server> findByNameRegex(String regexString);

}
