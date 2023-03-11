package com.projetotareja1.projetotareja1.Resouce;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.projetotareja1.projetotareja1.dto.ClientsDTO;
import com.projetotareja1.projetotareja1.services.ClientsService;

@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {

	@Autowired
	private ClientsService service;

	@GetMapping
	public ResponseEntity<Page<ClientsDTO>> findpag(

			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<ClientsDTO> list = service.page(pageRequest);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> findId(@PathVariable Long id) {

		ClientsDTO obj =  service.findId(id);	
		

		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping
	public ResponseEntity<ClientsDTO> insert( @RequestBody ClientsDTO dto){
		
		dto = service.insertEntity(dto);
		
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> update(@PathVariable Long id, @RequestBody ClientsDTO dto){
		
		dto = service.updateEntity(dto,id);
		
		 
		return ResponseEntity.ok().body(dto);
		
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteEntity(id);

		// retorno 204 noContent
		return ResponseEntity.noContent().build();

	}

}
