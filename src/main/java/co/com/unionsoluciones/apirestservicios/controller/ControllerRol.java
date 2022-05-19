package co.com.unionsoluciones.apirestservicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.unionsoluciones.apirestservicios.models.RolModel;
import co.com.unionsoluciones.apirestservicios.services.ServiceRol;

@RestController
@CrossOrigin(value = {"http://localhost:4200"})
@RequestMapping("/rol")
public class ControllerRol {
	
	@Autowired
	private ServiceRol serviceRol;
	
	@GetMapping
	public List<RolModel> getRoles(){
		return serviceRol.getRoles();
	}

}
