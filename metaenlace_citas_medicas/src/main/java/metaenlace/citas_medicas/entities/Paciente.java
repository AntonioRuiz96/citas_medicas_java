package metaenlace.citas_medicas.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE")
@PrimaryKeyJoinColumn(referencedColumnName = "USER_ID")
public class Paciente extends Usuario {

	@Column(name = "NSS")
	private String NSS;
	@Column(name = "NUM_TARJETA")
	private String numTarjeta;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "DIRECCION")
	private String direccion;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PACIENTE_MEDICO", joinColumns = { @JoinColumn(name = "ID_PACIENTE") }, inverseJoinColumns = {
	@JoinColumn(name = "ID_MEDICO") })
	private List<Medico> medicos;
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Cita> citas;
	
	public Paciente() {}

	/**
	 * @param userID
	 * @param usuario
	 * @param nombre
	 * @param apellidos
	 * @param clave
	 * @param nSS
	 * @param numTarjeta
	 * @param telefono
	 * @param direccion
	 * @param medicos
	 * @param cita
	 */
	public Paciente(Integer userID, String usuario, String nombre, String apellidos, String clave, String nSS,
			String numTarjeta, String telefono, String direccion, List<Medico> medicos, List<Cita> citas) {
		super(userID, usuario, nombre, apellidos, clave);
		NSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		this.medicos = medicos;
		this.citas = citas;
	}

	/**
	 * @return the nSS
	 */
	public String getNSS() {
		return NSS;
	}

	/**
	 * @param nSS the nSS to set
	 */
	public void setNSS(String nSS) {
		NSS = nSS;
	}

	/**
	 * @return the numTarjeta
	 */
	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * @param numTarjeta the numTarjeta to set
	 */
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the medicos
	 */
	public List<Medico> getMedicos() {
		return medicos;
	}

	/**
	 * @param medicos the medicos to set
	 */
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	/**
	 * @return the cita
	 */
	/**
	 * @return the citas
	 */
	public List<Cita> getCitas() {
		return citas;
	}

	/**
	 * @param citas the citas to set
	 */
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
