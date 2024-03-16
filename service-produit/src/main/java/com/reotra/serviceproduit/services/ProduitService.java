package com.reotra.serviceproduit.services;

import com.reotra.serviceproduit.ProduitTrouveReponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProduitService {
    ProduitTrouveReponseDTO trouverUnProduitAvecSonID(UUID uuid);

    List<ProduitTrouveReponseDTO> recupererLaListeProduit();
}
