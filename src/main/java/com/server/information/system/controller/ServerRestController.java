package com.server.information.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.server.information.system.dto.ServerDTO;
import com.server.information.system.model.Server;
import com.server.information.system.service.ServerService;
import com.server.information.system.util.ObjectMapperUtils;


@RestController
@RequestMapping("/server")
public class ServerRestController {

    @Autowired
    private ServerService serverService;

    @GetMapping(value = "/")
    public List<ServerDTO> getAllServer() {
        return ObjectMapperUtils.mapAll(serverService.findAll(), ServerDTO.class);
    }

 
    @GetMapping(path = { "/byId", "/byId/{id}"})
    public List<ServerDTO> getById(@PathVariable("id") Optional<String> id) {
    	if(id.isPresent()){
         	List<ServerDTO> serverDTO  = new ArrayList<ServerDTO>();
         	if(serverService.findById(id.get()).isPresent()){
         		serverDTO.add(ObjectMapperUtils.map(serverService.findById(id.get()).get(), ServerDTO.class));
         	} else {
         		throw new ResponseStatusException( HttpStatus.NOT_FOUND, "entity not found" );
         	}
            return serverDTO; 
    	} else {
    		return ObjectMapperUtils.mapAll(serverService.findAll(),ServerDTO.class);
    	}
     }

    @GetMapping(value = "/byName/{name}")
    public List<ServerDTO> getServerByName(@PathVariable("name") String name) {
    	  if(serverService.findByNameRegex(name).isEmpty()){
    		  throw new ResponseStatusException( HttpStatus.NOT_FOUND, "entity not found" );
    	  } else {
    		  return ObjectMapperUtils.mapAll(serverService.findByNameRegex(name), ServerDTO.class);
    	  }
    }
 
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateServer(@RequestBody ServerDTO ServerDTO) { 
        serverService.saveOrUpdateServer(ObjectMapperUtils.map(ServerDTO, Server.class));
        return new ResponseEntity("Server added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteServerById(@PathVariable("id") String id) {
        serverService.deleteServerById(id);
        return new ResponseEntity("Server deleted successfully", HttpStatus.OK);
    }

}
