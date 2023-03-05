package com.chu.chu.hopital;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
* Squellete CHU
* @Author Moncif
* @todo lire les commentaires de entite=>repository=>servive=>controller
 */
@Entity
//L'annotation @Entity=>Spring va considerer que cette class va devenir une entite en BD
//Comme toute table a besoin d'un id, on doit l'ajouter
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//toutes ces 5 annotations sont de la dependance Lombok qui permet de simplifier le code
//@Getter creer les getteurs, @Setter pour les setteurs, @ToString pour toString()
//@NoArgsConstructor pour un constructeur sont parametres
// @AllArgsConstructor pour constructeur avec tous les parametres, facile non?
public class Hopital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Comme nous l'avons dit, une table a besoin d'un Id, on l'indique avec @Id avant l'attribut
    //Cependant si on laisse seulement @Id, on creer un hopital, il aura id=1,
    // le prochain hopital aura aussi id=1, il faut donc une strategie pour changer le id
    // la plus simple et l'identite qui va incrementer l'Id par 1 chaque fois
    // En monde d'entreprise on cree des strategies plus complexe pour empecher les pirates de
    // lister toutes la table
    private String nom;
    // puis un autre attribut === une autre colone creer auto par spring
    private Long capacite;
    public Hopital(String nom, Long capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }
    // Generalement on a besoin de 3 constructeurs en Spring,
    // un sans argument pour faire des liaisons entre classes,
    // un avec tous les arguments pour faire des modifs sur l'objets
    // un constructeur avec tous les attributs sauf le Id, comme ça en fait des enregistrements de
    // l'objet hopital et Spring va s'occuper d'attribuer un Id avec la strategie definit

    //L'entité et donc analyser par spring et transformer en une requete sql, voir la console lors
    // de l'execution
}
