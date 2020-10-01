package rest.api.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.api.dto.PacienteDTO;
import rest.api.entity.Paciente;
import rest.api.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;

	public List<PacienteDTO> getPacientesQuantity() {

		List<Paciente> pacientes = repository.findAll();

		int acre = pacientes.stream().filter(x -> x.getEstado().equals("AC")).collect(Collectors.toList()).size();
		int alagoas = pacientes.stream().filter(x -> x.getEstado().equals("AL")).collect(Collectors.toList()).size();
		int amapa = pacientes.stream().filter(x -> x.getEstado().equals("AP")).collect(Collectors.toList()).size();
		int amazonas = pacientes.stream().filter(x -> x.getEstado().equals("AM")).collect(Collectors.toList()).size();
		int bahia = pacientes.stream().filter(x -> x.getEstado().equals("BA")).collect(Collectors.toList()).size();
		int ceara = pacientes.stream().filter(x -> x.getEstado().equals("CE")).collect(Collectors.toList()).size();
		int es = pacientes.stream().filter(x -> x.getEstado().equals("ES")).collect(Collectors.toList()).size();
		int goias = pacientes.stream().filter(x -> x.getEstado().equals("GO")).collect(Collectors.toList()).size();
		int maranhao = pacientes.stream().filter(x -> x.getEstado().equals("MA")).collect(Collectors.toList()).size();
		int mt = pacientes.stream().filter(x -> x.getEstado().equals("MT")).collect(Collectors.toList()).size();
		int ms = pacientes.stream().filter(x -> x.getEstado().equals("MS")).collect(Collectors.toList()).size();
		int mg = pacientes.stream().filter(x -> x.getEstado().equals("MG")).collect(Collectors.toList()).size();
		int para = pacientes.stream().filter(x -> x.getEstado().equals("PA")).collect(Collectors.toList()).size();
		int paraiba = pacientes.stream().filter(x -> x.getEstado().equals("PB")).collect(Collectors.toList()).size();
		int parana = pacientes.stream().filter(x -> x.getEstado().equals("PR")).collect(Collectors.toList()).size();
		int pernambuco = pacientes.stream().filter(x -> x.getEstado().equals("PE")).collect(Collectors.toList()).size();
		int piaui = pacientes.stream().filter(x -> x.getEstado().equals("PI")).collect(Collectors.toList()).size();
		int rj = pacientes.stream().filter(x -> x.getEstado().equals("RJ")).collect(Collectors.toList()).size();
		int rn = pacientes.stream().filter(x -> x.getEstado().equals("RN")).collect(Collectors.toList()).size();
		int rs = pacientes.stream().filter(x -> x.getEstado().equals("RS")).collect(Collectors.toList()).size();
		int rondonia = pacientes.stream().filter(x -> x.getEstado().equals("RO")).collect(Collectors.toList()).size();
		int roraima = pacientes.stream().filter(x -> x.getEstado().equals("RR")).collect(Collectors.toList()).size();
		int sc  = pacientes.stream().filter(x -> x.getEstado().equals("SC")).collect(Collectors.toList()).size();
		int sp = pacientes.stream().filter(x -> x.getEstado().equals("SP")).collect(Collectors.toList()).size();
		int sergipe = pacientes.stream().filter(x -> x.getEstado().equals("SE")).collect(Collectors.toList()).size();
		int tocantins = pacientes.stream().filter(x -> x.getEstado().equals("TO")).collect(Collectors.toList()).size();
		int df = pacientes.stream().filter(x -> x.getEstado().equals("DF")).collect(Collectors.toList()).size();

		List<PacienteDTO> qnttEstado = Arrays.asList(new PacienteDTO("Acre", acre), 
				new PacienteDTO("Alagoas", alagoas), new PacienteDTO("Amapa", amapa), 
				new PacienteDTO("Amazonas", amazonas), new PacienteDTO("Bahia", bahia), 
				new PacienteDTO("Ceara", ceara), new PacienteDTO("Espirírito Santo", es), 
				new PacienteDTO("Goias", goias), new PacienteDTO("Maranhão", maranhao),
				new PacienteDTO("Mato Grosso", mt), new PacienteDTO("Mato Grosso do Sul", ms), 
				new PacienteDTO("Minas Gerais", mg), new PacienteDTO("Para", para), 
				new PacienteDTO("Paraiba", paraiba), new PacienteDTO("Paraná", parana), 
				new PacienteDTO("Pernambuco", pernambuco), new PacienteDTO("Piaui", piaui), 
				new PacienteDTO("Rio de Janeiro", rj), new PacienteDTO("Rio grande do Norte", rn), 
				new PacienteDTO("Rio Grande do Sul", rs), new PacienteDTO("rondonia", rondonia), 
				new PacienteDTO("Roraima", roraima), new PacienteDTO("Santa Catarina", sc), 
				new PacienteDTO("São Paulo", sp), new PacienteDTO("Sergipe", sergipe), 
				new PacienteDTO("Tocantins", tocantins), new PacienteDTO("Distrito Federal", df));

		return qnttEstado;
	}



	public List<PacienteDTO> getIMCFaixaEtaria() {

		List<Paciente> pacientes = repository.findAll();

		int hoje = LocalDate.now().getYear();

		List<Paciente> zeroDez = pacientes.stream()
				.filter(x -> hoje - x.getData_nasc().toInstant().atZone(
						ZoneId.systemDefault()).toLocalDate().getYear() <= 10)
				.collect(Collectors.toList());


		List<Paciente> onzeVinte = pacientes.stream()
				.filter(x -> hoje - x.getData_nasc().toInstant().atZone(
						ZoneId.systemDefault()).toLocalDate().getYear() <= 20 && hoje - x.getData_nasc().toInstant().atZone(
								ZoneId.systemDefault()).toLocalDate().getYear() >= 11)
				.collect(Collectors.toList());



		List<Paciente> vinteUmTrinta = pacientes.stream()
				.filter(x -> hoje - x.getData_nasc().toInstant().atZone(
						ZoneId.systemDefault()).toLocalDate().getYear() <= 30 && hoje - x.getData_nasc().toInstant().atZone(
								ZoneId.systemDefault()).toLocalDate().getYear() >= 21)
				.collect(Collectors.toList());



		double countZero = 0;
		double countOnze = 0;
		double countVinte = 0;

		for (Paciente p : zeroDez) {
			countZero += p.getPeso() / (p.getAltura() * p.getAltura());
		}

		for (Paciente p : onzeVinte) {
			countOnze += p.getPeso() / (p.getAltura() * p.getAltura());
		}

		for (Paciente p : vinteUmTrinta) {
			countVinte += p.getPeso() / (p.getAltura() * p.getAltura());
		}

		PacienteDTO zeroDezMedia = new PacienteDTO("0 a 10", zeroDez.size() == 0 ? 0.0 : countZero / zeroDez.size());
		PacienteDTO onzeVinteMedia = new PacienteDTO("11 a 20", onzeVinte.size() == 0 ? 0.0 : countOnze / onzeVinte.size());
		PacienteDTO vinteTrintaMedia = new PacienteDTO("21 a 30", vinteUmTrinta.size() == 0 ? 0.0 : countVinte / vinteUmTrinta.size());

		List<PacienteDTO> lista = Arrays.asList(zeroDezMedia, onzeVinteMedia, vinteTrintaMedia);

		return lista;
	}


	public List<PacienteDTO> getPercentualObesos() {

		List<Paciente> pacientes = repository.findAll();

		List<PacienteDTO> obesos = new ArrayList<>();


		List<Paciente> mulheres = pacientes.stream()
				.filter(x -> x.getSexo().equals("Feminino"))
				.collect(Collectors.toList());

		List<Paciente> homens = pacientes.stream()
				.filter(x -> x.getSexo().equals("Masculino"))
				.collect(Collectors.toList());

		List<Paciente> mulheresObesas = mulheres.stream().filter(x -> x.getPeso() / (x.getAltura() * x.getAltura()) > 30).collect(Collectors.toList());
		List<Paciente> homensObesos = homens.stream().filter(x -> x.getPeso() / (x.getAltura() * x.getAltura()) > 30).collect(Collectors.toList());

		obesos.add(new PacienteDTO((double)(100*mulheresObesas.size()) / mulheres.size(), "Mulher"));
		obesos.add(new PacienteDTO((double)(100*homensObesos.size()) / homens.size(), "Homem"));

		return obesos;
	}


	public List<PacienteDTO> getMediaIdadeTipoSanguineo() {

		List<Paciente> pacientes = repository.findAll();
		List<PacienteDTO> pacientesDTO = new ArrayList<>();

		List<Paciente> APositivo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("A+"))
				.collect(Collectors.toList());


		List<Paciente> ANegativo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("A-"))
				.collect(Collectors.toList());


		List<Paciente> BPositivo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("B+"))
				.collect(Collectors.toList());


		List<Paciente> BNegativo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("B-"))
				.collect(Collectors.toList());


		List<Paciente> ABPositivo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("AB+"))
				.collect(Collectors.toList());


		List<Paciente> ABNegativo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("AB-"))
				.collect(Collectors.toList());


		List<Paciente> OPositivo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("O+"))
				.collect(Collectors.toList());


		List<Paciente> ONegativo = pacientes.stream()
				.filter(x -> x.getTipo_sanguineo().equals("O-"))
				.collect(Collectors.toList());


		int APositivoMedia = 0;
		int ANegativoMedia = 0;
		int BPositivoMedia = 0;
		int BNegativoMedia = 0;
		int ABPositivoMedia = 0;
		int ABNegativoMedia = 0;
		int OPositivoMedia = 0;
		int ONegativoMedia = 0;


		int APositivoTotal = 0;
		int ANegativoTotal = 0;
		int BPositivoTotal = 0;
		int BNegativoTotal = 0;
		int ABPositivoTotal  = 0;
		int ABNegativoTotal = 0;
		int OPositivoTotal = 0;
		int ONegativoTotal = 0;

		for (Paciente p : APositivo) {
			APositivoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (APositivo.size() == 0) 
			APositivoMedia = 0;
		else
			APositivoMedia = APositivoTotal / APositivo.size();


		PacienteDTO APositivoDTO = new PacienteDTO(APositivoMedia, "A+");

		for (Paciente p : ANegativo) {
			ANegativoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (ANegativo.size() == 0)
			ANegativoMedia = 0;
		else
			ANegativoMedia = ANegativoTotal / ANegativo.size();

		PacienteDTO ANegativoDTO = new PacienteDTO(ANegativoMedia, "A-");


		for (Paciente p : BPositivo) {
			BPositivoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (BPositivo.size() == 0) 
			BPositivoMedia = 0;
		else
			BPositivoMedia = BPositivoTotal / BPositivo.size();


		PacienteDTO BPositivoDTO = new PacienteDTO(BPositivoMedia, "B+");

		for (Paciente p : BNegativo) {
			BNegativoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (BNegativo.size() == 0)
			BNegativoMedia = 0;
		else
			BNegativoMedia = BNegativoTotal / BNegativo.size();


		PacienteDTO BNegativoDTO = new PacienteDTO(BNegativoMedia, "B-");

		for (Paciente p : ABPositivo) {
			ABPositivoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (ABPositivo.size() == 0)
			ABPositivoMedia = 0;
		else
			ABPositivoMedia = ABPositivoTotal / ABPositivo.size();		


		PacienteDTO ABPositivoDTO = new PacienteDTO(ABPositivoMedia, "AB+");

		for (Paciente p : ABNegativo) {
			ABNegativoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (ABNegativo.size() == 0)
			ABNegativoMedia = 0; 

		else
			ABNegativoMedia = ABNegativoTotal / ABNegativo.size();	

		PacienteDTO ABNegativoDTO = new PacienteDTO(ABNegativoMedia, "AB-");

		for (Paciente p : OPositivo) {
			OPositivoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (OPositivo.size() == 0)
			OPositivoMedia = 0;
		else
			OPositivoMedia = OPositivoTotal / OPositivo.size();		

		PacienteDTO OPositivoDTO = new PacienteDTO(OPositivoMedia, "O+");

		for (Paciente p : ONegativo) {
			ONegativoTotal += p.getData_nasc().toInstant().atZone(
					ZoneId.systemDefault()).toLocalDate().getYear();
		}

		if (ONegativo.size() == 0)
			ONegativoMedia = 0;
		else
			ONegativoMedia = ONegativoTotal / ONegativo.size();

		PacienteDTO ONegativoDTO = new PacienteDTO(ONegativoMedia, "O-");


		pacientesDTO = Arrays.asList(APositivoDTO, ANegativoDTO, BPositivoDTO, BNegativoDTO, ABPositivoDTO, ABNegativoDTO, OPositivoDTO, ONegativoDTO);

		return pacientesDTO;
	}

}
