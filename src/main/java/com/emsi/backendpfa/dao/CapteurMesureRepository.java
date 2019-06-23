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
}
