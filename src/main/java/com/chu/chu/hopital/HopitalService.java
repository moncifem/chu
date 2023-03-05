package com.chu.chu.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HopitalService {
    private HopitalRepository hopitalRepository;
    @Autowired
    public HopitalService(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }
    public Hopital addHopital(Hopital hopital){
        return hopitalRepository.save(hopital);
    }
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
}
