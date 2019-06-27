package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.CapteurMesure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface CapteurMesureRepository extends JpaRepository<CapteurMesure,Long>, Serializable {

    @Query(value="SELECT cm.valeur,cm.date,m.mesure from capteur c ,mesure m, capteurs_mesures cm  where cm.capteur_id = c.idcapt and cm.mesure_id = m.id  and c.region_id =?1 group by cm.mesure_id,cm.date,cm.valeur order by cm.date ",nativeQuery = true)
    List getDataParregion(long id);

    @Query(value="select region.name,count( DISTINCT capteurs_mesures.mesure_id) as \"nbrmesure\"\n" +
            "from region ,capteur ,capteurs_mesures ,mesure \n" +
            "WHERE capteur.region_id=region.id and capteurs_mesures.capteur_id=capteur.idcapt and mesure.id=capteurs_mesures.mesure_id\n" +
            "GROUP BY region.name ;",nativeQuery = true)
    List getAllData();

    @Query(value="select COUNT(capteur.idcapt) as 'nbr' from region,capteur where region.id=capteur.region_id and region.id=?1 UNION select count(*) from capteur",nativeQuery = true)
    List getcapteurRegion(long id);
}
