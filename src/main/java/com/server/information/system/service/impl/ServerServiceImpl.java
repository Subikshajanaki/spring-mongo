package com.server.information.system.service.impl;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.information.system.model.Server;
import com.server.information.system.repository.ServerRepository;
import com.server.information.system.service.ServerService;

import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

	@Override
	public List<Server> findAll() {
 		return serverRepository.findAll();
	}

	@Override
	public Optional<Server> findById(String id) {
		return serverRepository.findById(id);
	}

	@Override
	public Server findByName(String name) {
		return serverRepository.findByName(name);
	}

	@Override
	public Server saveOrUpdateServer(Server server) {
		return serverRepository.save(server);
	}

	@Override
	public void deleteServerById(String id) {
		serverRepository.deleteById(id);		
	}

	@Override
	public List<Server> findByNameRegex(String regexString) {
		return serverRepository.findByNameRegex(regexString);
	}
 
}
