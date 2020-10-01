package rest.api.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class PacienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nomeEstado;
	private int quantidadeEstado;
	private double imc;
	private String faixaEtaria;
	private String sexo;
	private double percentualObeso;
	private Date idade;
	private int mediaIdade;
	private String tipoSanguineo;  
	
	public PacienteDTO() {
		
	}

	public PacienteDTO(int mediaIdade, String tipoSanguineo) {
		super();
		int hoje = LocalDate.now().getYear();
		this.mediaIdade = hoje - mediaIdade;
		this.tipoSanguineo = tipoSanguineo;
	}
	
	public PacienteDTO(double percentualObeso, String sexo) {
		super();
		this.percentualObeso = percentualObeso;
		this.sexo = sexo;
	}
	
	public PacienteDTO(String nomeEstado, int quantidadeEstado) {
		super();
		this.nomeEstado = nomeEstado;
		this.quantidadeEstado = quantidadeEstado;
	}


	public PacienteDTO(String faixaEtaria, double imc) {
		super();
		this.faixaEtaria = faixaEtaria;
		this.imc = imc;
	}

	public PacienteDTO(int id, Date idade) {
		super();
		this.id = id;
		this.idade = idade;
	}


	public String getNomeEstado() {
		return nomeEstado;
	}


	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}


	public int getQuantidadeEstado() {
		return quantidadeEstado;
	}


	public void setQuantidadeEstado(int quantidadeEstado) {
		this.quantidadeEstado = quantidadeEstado;
	}


	public double getImc() {
		return imc;
	}


	public void setImc(double imc) {
		this.imc = imc;
	}


	public String getFaixaEtaria() {
		return faixaEtaria;
	}


	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public double getPercentualObeso() {
		return percentualObeso;
	}


	public void setPercentualObeso(double percentualObeso) {
		this.percentualObeso = percentualObeso;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getIdade() {
		return idade;
	}


	public void setIdade(Date idade) {
		this.idade = idade;
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public int getMediaIdade() {
		return mediaIdade;
	}

	public void setMediaIdade(int mediaIdade) {
		this.mediaIdade = mediaIdade;
	}


	
}
