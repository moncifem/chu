package com.chu.chu.hopital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopitalRepository extends JpaRepository<Hopital,Long> {
// une interface qui étend JpaRepository pour donner acces au fonctionaliter
    //sur la table Hopital qui a un Id de type Long
}
// On ne peut pas utiliser le repository directement, on doit le lier avec la class qui va l'utiliser
// voir le service
// Le repository c'est celui qui va faire la liasion entre le code java et le sql avec la BD
// plus de sql juste du java avec la JPA(vous en apprendrez au fur et à mesure)
// ici on peut même creer des requetes specialiser, avec du java ;) exemple:
//    Hopital getHopitalByNom(String Nom);
//    List<Hopital> getHopitalByCapacite(Long cap);
// des requetes pour selectionner les hopitaux par capacite et nom, on peut selectionner par
// tous les attributs qu'on a dans l'entité
