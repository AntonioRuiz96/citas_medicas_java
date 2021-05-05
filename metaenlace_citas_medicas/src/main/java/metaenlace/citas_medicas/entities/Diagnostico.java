package metaenlace.citas_medicas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIAGNOSTICO")
public class Diagnostico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DIAGNOSTICO_ID")
	private Integer diagnosticoID;
	@Column(name = "VALORACION_ESPECIALISTA")
	private String valoracionEspecialista;
	@Column(name = "ENFERMEDAD")
	private String enfermedad;
	@OneToOne
	@JoinColumn(name = "CITA")
	private Cita cita;

	public Diagnostico() {}
	
	/**
	 * @param diagnosticoID
	 * @param valoracionEspecialista
	 * @param enfermedad
	 * @param cita
	 */
	public Diagnostico(Integer diagnosticoID, String valoracionEspecialista, String enfermedad, Cita cita) {
		this.diagnosticoID = diagnosticoID;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.cita = cita;
	}

	/**
	 * @return the diagnosticoID
	 */
	public int getDiagnosticoID() {
		return diagnosticoID;
	}

	/**
	 * @param diagnosticoID the diagnosticoID to set
	 */
	public void setDiagnosticoID(Integer diagnosticoID) {
		this.diagnosticoID = diagnosticoID;
	}

	/**
	 * @return the valoracionEspecialista
	 */
	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	/**
	 * @param valoracionEspecialista the valoracionEspecialista to set
	 */
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	/**
	 * @return the enfermedad
	 */
	public String getEnfermedad() {
		return enfermedad;
	}

	/**
	 * @param enfermedad the enfermedad to set
	 */
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}

}
