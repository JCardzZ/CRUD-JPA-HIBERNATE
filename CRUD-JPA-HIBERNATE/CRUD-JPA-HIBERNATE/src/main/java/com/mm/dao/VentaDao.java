package com.mm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mm.model.TblProducto;
import com.mm.model.Venta;

public class VentaDao {
	

	public void agregarDatosVenta(Venta venta) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(venta);
		em.flush();
		em.getTransaction().commit();
	}

}
