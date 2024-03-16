package com.reotra.serviceproduit;

import com.reotra.serviceproduit.domain.Produit;
import lombok.Builder;

import java.util.List;

@Builder
public record ProduitTrouveReponseDTO(String id, String nom, Double prix) {

    public static ProduitTrouveReponseDTO creerDepuisUnProduit(Produit produit) {
        return ProduitTrouveReponseDTO.builder()
                .id(produit.getId().toString())
                .nom(produit.getNom())
                .prix(produit.getPrix())
                .build();
    }

    public static List<ProduitTrouveReponseDTO> creerDepuisUneListeProduit(List<Produit> produits) {
        return produits.stream().map(ProduitTrouveReponseDTO::creerDepuisUnProduit).toList();
    }
}
