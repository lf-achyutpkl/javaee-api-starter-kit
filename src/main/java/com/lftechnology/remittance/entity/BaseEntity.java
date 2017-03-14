package com.lftechnology.remittance.entity;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;

import com.lftechnology.remittance.util.GuidUtil;

/**
 * Base abstract class for holding common properties of each entity.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Type(type = "pg-uuid")
	protected UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@PrePersist
	public void perPersist() {
		this.setId(GuidUtil.generate());
	}
}
