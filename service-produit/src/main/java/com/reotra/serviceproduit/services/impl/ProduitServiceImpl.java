package com.reotra.serviceproduit.services.impl;

import com.reotra.serviceproduit.ProduitTrouveReponseDTO;
import com.reotra.serviceproduit.domain.Produit;
import com.reotra.serviceproduit.repositories.ProduitRepository;
import com.reotra.serviceproduit.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public ProduitTrouveReponseDTO trouverUnProduitAvecSonID(UUID uuid) {
        Produit produitTrouve = produitRepository.findById(uuid)
                .orElseThrow(() -> HttpClientErrorException.create("Le produit avec ID #" + uuid + " n'existe pas", HttpStatus.NOT_FOUND, "Produit non trouvé", null, null, null));
        return ProduitTrouveReponseDTO.creerDepuisUnProduit(produitTrouve);
    }

    @Override
    public List<ProduitTrouveReponseDTO> recupererLaListeProduit() {
        return ProduitTrouveReponseDTO.creerDepuisUneListeProduit(produitRepository.findAll());
    }

}
