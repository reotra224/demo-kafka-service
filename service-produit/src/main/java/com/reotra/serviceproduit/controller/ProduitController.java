package com.reotra.serviceproduit.controller;

import com.reotra.serviceproduit.ProduitTrouveReponseDTO;
import com.reotra.serviceproduit.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping(value = "/")
    public ResponseEntity<List<ProduitTrouveReponseDTO>> recupererListeProduits() {
        return ResponseEntity.ok(produitService.recupererLaListeProduit());
    }

    @GetMapping(value = "/{produitId}")
    public ResponseEntity<ProduitTrouveReponseDTO> trouverUnProduit(@PathVariable UUID produitId) {
        return ResponseEntity.ok(produitService.trouverUnProduitAvecSonID(produitId));
    }
}
