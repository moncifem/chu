package com.chu.chu.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HopitalService {
    //le service, c'est la quand utilise le repository pour faire la logique si on veut
    //ou simplement executer des requetes avec du java
    private HopitalRepository hopitalRepository;
    // on fait appel au repository, mais il faut le lier avec le service pour l'utiliser
    @Autowired
    public HopitalService(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }
    // Autowired est un design pattern qui permet de lier plusieurs objets sans les insctancier
    // c'est un avantage de spring, maintenant que le repo et lier au service, on peut l'utiliser
    public Hopital addHopital(Hopital hopital){
        return hopitalRepository.save(hopital);
    }
    // save, findAll(),deleteById().. se sont des methodes de la JpaRepository..
    public Hopital getHopitalById(Long id){
        return hopitalRepository.findById(id).get();
    }
    public List<Hopital> getAllHopital(){
        return hopitalRepository.findAll();
    }
    public String removeHopital(Long id){
        hopitalRepository.deleteById(id);
        return "hopital de id:"+id+" supprimer";
    }
    @Transactional
    public Hopital updateHopital(Hopital hopital){
       Hopital h=getHopitalById(hopital.getId());
       h.setNom(hopital.getNom());
       h.setCapacite(hopital.getCapacite());
       return addHopital(h);
    }
    // @Transational annotation optionnel pour dire que c'est une transaction
    // avantage si l'operation echoue..
    // Commencer toujours par le fonctionnel, l'entite, le repo, le service
    // la gestion des erreurs se fait vers la fin qu'on maitrise les choses
}
