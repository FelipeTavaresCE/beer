package br.com.beer.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractModel<ID> implements AbstractModelInterface<ID>, Serializable {

	private static final long serialVersionUID = -3102918297801568195L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GENERATOR")
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		return (obj instanceof AbstractModel) ? (this.getId() == null ? this == obj
				: this.getId().equals(((AbstractModel<?>) obj).getId()))
				: false;
	}

}
