create schema if not exists service_produit;

create table produits (
    id  uuid DEFAULT gen_random_uuid(),
    nom varchar(255) not null,
    prix    double precision null,
    date_creation timestamp not null,
    constraint pk_produits primary key (id)
)

