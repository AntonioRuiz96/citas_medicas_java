package metaenlace.citas_medicas.entitiesDTO;

import java.util.Date;

public class CitaDTO {
	private Integer citaCitaID;
	private Date citaFechaHora;
	private String citaMotivoCita;
	private Integer citaPacienteUserID;
	private Integer citaMedicoUserID;
	private Integer diagnosticoDiagnosticoID;
	/**
	 * @return the citaCitaID
	 */
	public Integer getCitaCitaID() {
		return citaCitaID;
	}
	/**
	 * @param citaCitaID the citaCitaID to set
	 */
	public void setCitaCitaID(Integer citaCitaID) {
		this.citaCitaID = citaCitaID;
	}
	/**
	 * @return the citaFechaHora
	 */
	public Date getCitaFechaHora() {
		return citaFechaHora;
	}
	/**
	 * @param citaFechaHora the citaFechaHora to set
	 */
	public void setCitaFechaHora(Date citaFechaHora) {
		this.citaFechaHora = citaFechaHora;
	}
	/**
	 * @return the citaMotivoCita
	 */
	public String getCitaMotivoCita() {
		return citaMotivoCita;
	}
	/**
	 * @param citaMotivoCita the citaMotivoCita to set
	 */
	public void setCitaMotivoCita(String citaMotivoCita) {
		this.citaMotivoCita = citaMotivoCita;
	}
	/**
	 * @return the citaPacienteUserID
	 */
	public Integer getCitaPacienteUserID() {
		return citaPacienteUserID;
	}
	/**
	 * @param citaPacienteUserID the citaPacienteUserID to set
	 */
	public void setCitaPacienteUserID(Integer citaPacienteUserID) {
		this.citaPacienteUserID = citaPacienteUserID;
	}
	/**
	 * @return the citaMedicoUserID
	 */
	public Integer getCitaMedicoUserID() {
		return citaMedicoUserID;
	}
	/**
	 * @param citaMedicoUserID the citaMedicoUserID to set
	 */
	public void setCitaMedicoUserID(Integer citaMedicoUserID) {
		this.citaMedicoUserID = citaMedicoUserID;
	}
	/**
	 * @return the diagnosticoDiagnosticoID
	 */
	public Integer getDiagnosticoDiagnosticoID() {
		return diagnosticoDiagnosticoID;
	}
	/**
	 * @param diagnosticoDiagnosticoID the diagnosticoDiagnosticoID to set
	 */
	public void setDiagnosticoDiagnosticoID(Integer diagnosticoDiagnosticoID) {
		this.diagnosticoDiagnosticoID = diagnosticoDiagnosticoID;
	}
	
	
}
