package fr.afcepf.al33.projet1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.Categorie;
import fr.afcepf.al33.projet1.entity.Stock;
import fr.afcepf.al33.projet1.idao.StockIdao;

@Remote(StockIdao.class)
@Stateless
public class StockDao extends GenericDao<Stock> implements StockIdao {
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAll() {
		List<Stock>stocks = new ArrayList<Stock>();
		String REQ_GETALL = "SELECT stock from Stock stock";
		Query queryJPQL = em.createQuery(REQ_GETALL);
		stocks = queryJPQL.getResultList();
		return stocks;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getByIdCategorie(Categorie c) {
		List<Stock> stocksParCategorie=null;
		String REQ= "SELECT s from Stock s JOIN s.article a WHERE a.categorie= :idCat ";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("idCat", c);
		stocksParCategorie = queryJPQL.getResultList();
		
		return stocksParCategorie ;
		
	}

}
