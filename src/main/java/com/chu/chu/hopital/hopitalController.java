package com.chu.chu.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class hopitalController {
    private HopitalService hopitalService;
    @Autowired
    public hopitalController(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }
    @PostMapping("/hopital/new")
    public Hopital addHopital(@RequestBody Hopital hopital){
        return hopitalService.addHopital(hopital);
    }
    @GetMapping("/hopital/all")
    public List<Hopital> getAll(){
        return hopitalService.getAllHopital();
    }
    @GetMapping("/hopital/{id}")
    public Hopital getById(@PathVariable("id") Long id){
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
