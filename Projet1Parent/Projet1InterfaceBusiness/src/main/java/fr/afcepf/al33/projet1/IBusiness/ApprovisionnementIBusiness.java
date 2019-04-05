package fr.afcepf.al33.projet1.IBusiness;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.entity.Stock;

public interface ApprovisionnementIBusiness {
	
	public Approvisionnement addApprovisionnement(Approvisionnement a);				
	public Boolean delete(Approvisionnement approvisionnement);
	public Commande update(Approvisionnement approvisionnement);
	public Approvisionnement searchById(Integer id);
	List<Approvisionnement> getAllApproByStock (Stock stock);

}
