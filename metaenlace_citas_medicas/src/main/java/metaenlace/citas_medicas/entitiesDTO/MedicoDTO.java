package metaenlace.citas_medicas.entitiesDTO;
import java.util.List;

public class MedicoDTO{
	
	private Integer medicoUserID;
	private String medicoUsuario;
	private String medicoNombre;
	private String medicoApellidos;
	private String medicoClave;
	private String medicoNumColegiado;
	private List<Integer> medicoPacientesUserID;//Necesita ser llamado asi para que por lo menos se mapeen
	private List<Integer> medicoCitasCitaID;//como atributos de tipo list<integer>
	/**
	 * @return the medicoUserID
	 */
	public Integer getMedicoUserID() {
		return medicoUserID;
	}
	/**
	 * @param medicoUserID the medicoUserID to set
	 */
	public void setMedicoUserID(Integer medicoUserID) {
		this.medicoUserID = medicoUserID;
	}
	/**
	 * @return the medicoUsuario
	 */
	public String getMedicoUsuario() {
		return medicoUsuario;
	}
	/**
	 * @param medicoUsuario the medicoUsuario to set
	 */
	public void setMedicoUsuario(String medicoUsuario) {
		this.medicoUsuario = medicoUsuario;
	}
	/**
	 * @return the medicoNombre
	 */
	public String getMedicoNombre() {
		return medicoNombre;
	}
	/**
	 * @param medicoNombre the medicoNombre to set
	 */
	public void setMedicoNombre(String medicoNombre) {
		this.medicoNombre = medicoNombre;
	}
	/**
	 * @return the medicoApellidos
	 */
	public String getMedicoApellidos() {
		return medicoApellidos;
	}
	/**
	 * @param medicoApellidos the medicoApellidos to set
	 */
	public void setMedicoApellidos(String medicoApellidos) {
		this.medicoApellidos = medicoApellidos;
	}
	/**
	 * @return the medicoClave
	 */
	public String getMedicoClave() {
		return medicoClave;
	}
	/**
	 * @param medicoClave the medicoClave to set
	 */
	public void setMedicoClave(String medicoClave) {
		this.medicoClave = medicoClave;
	}
	/**
	 * @return the medicoNumColegiado
	 */
	public String getMedicoNumColegiado() {
		return medicoNumColegiado;
	}
	/**
	 * @param medicoNumColegiado the medicoNumColegiado to set
	 */
	public void setMedicoNumColegiado(String medicoNumColegiado) {
		this.medicoNumColegiado = medicoNumColegiado;
	}
	/**
	 * @return the medicoPacientesUserID
	 */
	public List<Integer> getMedicoPacientesUserID() {
		return medicoPacientesUserID;
	}
	/**
	 * @param medicoPacientesUserID the medicoPacientesUserID to set
	 */
	public void setMedicoPacientesUserID(List<Integer> medicoPacientesUserID) {
		this.medicoPacientesUserID = medicoPacientesUserID;
	}
	/**
	 * @return the medicoCitasCitaID
	 */
	public List<Integer> getMedicoCitasCitaID() {
		return medicoCitasCitaID;
	}
	/**
	 * @param medicoCitasCitaID the medicoCitasCitaID to set
	 */
	public void setMedicoCitasCitaID(List<Integer> medicoCitasCitaID) {
		this.medicoCitasCitaID = medicoCitasCitaID;
	}
	
	
}
