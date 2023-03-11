package com.projetotareja1.projetotareja1.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotareja1.projetotareja1.dto.ClientsDTO;
import com.projetotareja1.projetotareja1.entities.Clients;
import com.projetotareja1.projetotareja1.repository.ClientsRepository;

@Service
public class ClientsService {

	@Autowired
	private ClientsRepository clienteRepository;

	@Transactional(readOnly = true)
	public Page<ClientsDTO> page(PageRequest pageRequest) {

		Page<Clients> pageListClients = clienteRepository.findAll(pageRequest);

		Page<ClientsDTO> listDTO = pageListClients.map(cat -> new ClientsDTO(cat));

		return listDTO;
	}

	@Transactional(readOnly = true)
	public ClientsDTO findId(Long id) {

		Optional<Clients> obj = clienteRepository.findById(id);

		Clients entity = obj.orElseThrow();

		return new ClientsDTO(entity);

	}

	
	@Transactional
	public ClientsDTO updateEntity(ClientsDTO obj, Long id) {

		
		Clients entity = clienteRepository.getOne(id);
		preencherEntity(obj, entity);

		clienteRepository.save(entity);

		return new ClientsDTO(entity);
	}

	@Transactional
	public ClientsDTO insertEntity(ClientsDTO obj) {

		Clients entity = new Clients();

		preencherEntity(obj, entity);

		entity = clienteRepository.save(entity);

		return new ClientsDTO(entity);
	}
	

	public void deleteEntity(Long id) {

		clienteRepository.deleteById(id);

	}

	private void preencherEntity(ClientsDTO objDTO, Clients entity) {

		entity.setName(objDTO.getName());
		entity.setBirthDate(objDTO.getBirthDate());
		entity.setChildren(objDTO.getChildren());
		entity.setCpfe(objDTO.getCpf());
		entity.setIncome(objDTO.getIncome());

	}

}
