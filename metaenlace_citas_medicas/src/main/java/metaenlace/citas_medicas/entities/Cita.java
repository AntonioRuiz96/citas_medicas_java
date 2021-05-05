package metaenlace.citas_medicas.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITA")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITA_ID")
	private Integer citaID;
	@Column(name = "FECHA_HORA")
	private Date fechaHora;
	@Column(name = "MOTIVO_CITA")
	private String motivoCita;
	@ManyToOne
	@JoinColumn(name = "PACIENTE")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name = "MEDICO")
	private Medico medico;
	@OneToOne(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
	private Diagnostico diagnostico;

	public Cita() {}
	
	/**
	 * @param citaID
	 * @param fechaHora
	 * @param motivoCita
	 * @param paciente
	 * @param medico
	 */
	public Cita(Integer citaID, Date fechaHora, String motivoCita, Paciente paciente, Medico medico, Diagnostico diagnostico) {
		this.citaID = citaID;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the citaID
	 */
	public Integer getCitaID() {
		return citaID;
	}

	/**
	 * @param citaID the citaID to set
	 */
	public void setCitaID(Integer citaID) {
		this.citaID = citaID;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the motivoCita
	 */
	public String getMotivoCita() {
		return motivoCita;
	}

	/**
	 * @param motivoCita the motivoCita to set
	 */
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the medico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * @return the diagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	
}
