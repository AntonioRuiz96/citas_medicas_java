package metaenlace.citas_medicas.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICO")
@PrimaryKeyJoinColumn(referencedColumnName = "USER_ID")
public class Medico extends Usuario {

	@Column(name = "NUM_COLEGIADO")
	private String numColegiado;
	@ManyToMany(mappedBy = "medicos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Paciente> pacientes;
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Cita> citas;

	public Medico() {}
	
	/**
	 * @param userID
	 * @param usuario
	 * @param nombre
	 * @param apellidos
	 * @param clave
	 * @param numColegiado
	 * @param pacientes
	 * @param cita
	 */
	public Medico(Integer userID, String usuario, String nombre, String apellidos, String clave, String numColegiado,
			List<Paciente> pacientes, List<Cita> citas) {
		super(userID, usuario, nombre, apellidos, clave);
		this.numColegiado = numColegiado;
		this.pacientes = pacientes;
		this.citas = citas;
	}

	/**
	 * @return the numColegiado
	 */
	public String getNumColegiado() {
		return numColegiado;
	}

	/**
	 * @param numColegiado the numColegiado to set
	 */
	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	/**
	 * @return the pacientes
	 */
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	/**
	 * @param pacientes the pacientes to set
	 */
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

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
