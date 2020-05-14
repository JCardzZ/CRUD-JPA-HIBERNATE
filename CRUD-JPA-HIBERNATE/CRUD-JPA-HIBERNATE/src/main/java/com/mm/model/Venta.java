package com.mm.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to TblProducto
	@ManyToOne
	@JoinColumn(name="id_venta_productos")
	private TblProducto tblProducto;

	public Venta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TblProducto getTblProducto() {
		return this.tblProducto;
	}

	public void setTblProducto(TblProducto tblProducto) {
		this.tblProducto = tblProducto;
	}

}