package com.mm.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import com.mm.model.TblProducto;
import com.mysql.fabric.Response;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String action = request.getParameter("btn");
		EntityManager em;
		EntityManagerFactory emf;

		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();

		TblProducto pr = new TblProducto();

		try {

			String id = request.getParameter("Id");
			String nombreProducto = request.getParameter("Nproductos");
			String precioProducto = request.getParameter("Pproductos");
			String cantidadProducto = request.getParameter("Cproductos");
			String totalProducto = request.getParameter("Tproductos");

			pr.setId(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));

		} catch (Exception e) {

		}

		if (action.equals("agregar")) {

			em.getTransaction().begin();
			em.persist(pr);
			em.flush();
			em.getTransaction().commit();

		} else if (action.equals("eliminar")) {

			pr = em.getReference(TblProducto.class, pr.getId());
			em.getTransaction().begin();
			em.remove(pr);
			em.getTransaction().commit();

		} else if (action.equals("modificar")) {

			em.getTransaction().begin();
			em.merge(pr);
			em.flush();
			em.getTransaction().commit();
			
		}
		response.sendRedirect("index.jsp");
	}

}
