package com.chu.chu.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
// Le Restful, ici on creer une API qui va etre utiliser par le front
/* Generalement on fait 4 choses:
un Get: pour recevoir des choses de l'API
un DELETE: pour supprimer quelque chose
un POST: pour poster quelque chose, envoyer des données vers l'API
un PUT: faire une modif sur quelque chose
Spring boot permet de gerer ça avec le @RestController class
@RequestMapping("/api") permet de dire que tous c'est lien qui suivent, viendront après:
http://la_racine:port/api/
*/
 public class hopitalController {
    private HopitalService hopitalService;
    @Autowired
    public hopitalController(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }
    //même principe que repo avec service, on lie le service avec le controller pour l'utiliser
    @PostMapping("/hopital/new")
    // requete de type POST sur l'adress /hopital/new
    public Hopital addHopital(@RequestBody Hopital hopital){
        // @RequestBody permet de faire une serialisation auto
        // on va recevoir du JSON qui va être tranformer auto en objet Hopital
        // sinon en java normal vous devrier recuper le json, creer un objet hopital
        // avec les attributs..... avec spring c'est facile non?
        return hopitalService.addHopital(hopital);
    }
    @GetMapping("/hopital/all")
    public List<Hopital> getAll(){
        return hopitalService.getAllHopital();
    }
    @GetMapping("/hopital/{id}")
    public Hopital getById(@PathVariable("id") Long id){
        //pour definir une variable en url en utiliser {}
        // on la recuperer avec le @PathVariable("id") et on specifie le type qu'on veut avoir
        // de cette attribut
        return hopitalService.getHopitalById(id);
    }
    @DeleteMapping("/hopital/delete/{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id){
        return hopitalService.removeHopital(id);
    }
    @PutMapping("/hopital/modify")
    public Hopital modify(@RequestBody Hopital hopital){
        return hopitalService.updateHopital(hopital);
    }
}
