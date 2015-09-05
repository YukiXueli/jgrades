package org.jgrades.data.api.entities;

import lombok.Data;
import org.jgrades.data.api.model.roles.ManagerDetails;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "JG_DATA_MANAGER")
@PrimaryKeyJoinColumn(name = "USER_ID")
@Data
public class Manager extends User implements ManagerDetails, Serializable {
}
