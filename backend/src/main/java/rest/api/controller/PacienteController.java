package rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.api.dto.PacienteDTO;
import rest.api.service.PacienteService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping("/quantity")
	public List<PacienteDTO> getPacientesQuantity() {
		return service.getPacientesQuantity();
	}



	@GetMapping("/imc")
	public List<PacienteDTO> getIMCFaixaEtaria() {
		return service.getIMCFaixaEtaria();
	}



	@GetMapping("/obesos")
	public List<PacienteDTO> getPercentualObesos() {
		return service.getPercentualObesos();
	}

	@GetMapping("/mediaIdadeSanguineo")
	public List<PacienteDTO> getMediaIdadeTipoSanguineo() {
		return service.getMediaIdadeTipoSanguineo();
	}
}
