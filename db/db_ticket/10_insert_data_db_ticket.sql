BEGIN TRANSACTION;


--- ================================================================================
--- statut
--- ================================================================================
	INSERT INTO public.statut (id, libelle) VALUES (	1,	'Ouvert'	);
	INSERT INTO public.statut (id, libelle) VALUES (	2,	'En cours de traitement'	);
	INSERT INTO public.statut (id, libelle) VALUES (	3,	'Fermé'	);

	SELECT setval('public.statut_id_seq', 3, true);



--- ================================================================================
--- niveau_bug
--- ================================================================================
	INSERT INTO public.niveau_bug (id, ordre, libelle) VALUES (	1,	1,	'Critique'	);
	INSERT INTO public.niveau_bug (id, ordre, libelle) VALUES (	2,	2,	'Majeur'	);
	INSERT INTO public.niveau_bug (id, ordre, libelle) VALUES (	3,	3,	'Mineur'	);

	SELECT setval('public.niveau_bug_id_seq', 3, true);



--- ================================================================================
--- utilisateur
--- ================================================================================
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	1,	'Noether',	'Emmy'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	2,	'Einstein',	'Albert'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	3,	'Bracame',	'Édouard'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	4,	'Dalton',	'Joe'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	5,	'Dalton',	'William'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	6,	'Dalton',	'Jack'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	7,	'Dalton',	'Averell'	);
	INSERT INTO public.utilisateur (id, nom, prenom) VALUES (	8,	'Dent',	'Arthur'	);

	SELECT setval('public.utilisateur_id_seq', 8, true);



--- ================================================================================
--- projet
--- ================================================================================
	INSERT INTO public.projet (id, nom, date_creation, cloture, responsable_id) VALUES (	1,	'Anneau',	'1920-01-31 12:34:00',	FALSE,	1	);
	INSERT INTO public.projet (id, nom, date_creation, cloture, responsable_id) VALUES (	2,	'Fort Knox',	'1971-02-20 06:21:00',	TRUE,	4	);
	INSERT INTO public.projet (id, nom, date_creation, cloture, responsable_id) VALUES (	3,	'CB 750',	'1975-03-15 18:45:00',	FALSE,	3	);
	INSERT INTO public.projet (id, nom, date_creation, cloture, responsable_id) VALUES (	4,	'Relative R',	'1905-06-30 18:00:00',	FALSE,	2	);
	INSERT INTO public.projet (id, nom, date_creation, cloture, responsable_id) VALUES (	5,	'System 42',	'1978-12-31 23:59:59',	TRUE,	8	);

	SELECT setval('public.projet_id_seq', 5, true);



--- ================================================================================
--- version
--- ================================================================================
	INSERT INTO public.version (projet_id, numero) VALUES (	1,	'1.1'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	2,	'2.1'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	3,	'3.1'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	4,	'4.1'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	5,	'5.1'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	1,	'1.2'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	2,	'2.2'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	3,	'3.2'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	4,	'4.2'	);
	INSERT INTO public.version (projet_id, numero) VALUES (	5,	'5.2'	);




--- ================================================================================
--- ticket
--- ================================================================================
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	1,	'Un anneau pour les gouverner tous',	'2017-01-01 12:34:00',	'Lorem ipsum dolor sit amet',	1,	4,	1	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	2,	'Le calcul de TVA est faux',	'2017-01-02 12:34:00',	'Lorem ipsum dolor sit amet',	2,	1,	2	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	3,	'Ajouter la traduction en Japonnais',	'2017-01-03 12:34:00',	'Lorem ipsum dolor sit amet',	3,	8,	3	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	4,	'Généraliser le concept relatif',	'2017-01-04 12:34:00',	'Lorem ipsum dolor sit amet',	1,	1,	4	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	5,	'Vous pouvez répéter la question',	'2017-01-05 12:34:00',	'Lorem ipsum dolor sit amet',	3,	7,	5	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	6,	'Ajouter le moyen de paiement CB',	'2017-01-06 12:34:00',	'Lorem ipsum dolor sit amet',	1,	5,	2	);
	INSERT INTO public.ticket (numero, titre, date, description, statut_actuel_id, auteur_id, projet_id) VALUES (	7,	'Modifier le format de facture',	'2017-01-07 12:34:00',	'Lorem ipsum dolor sit amet',	1,	6,	2	);

	SELECT setval('public.ticket_numero_seq', 7, true);



--- ================================================================================
--- ticket_associe
--- ================================================================================
	INSERT INTO public.ticket_associe (ticket_numero, ticket_associe_numero) VALUES (	7,	2	);
	INSERT INTO public.ticket_associe (ticket_numero, ticket_associe_numero) VALUES (	7,	6	);




--- ================================================================================
--- evolution
--- ================================================================================
	INSERT INTO public.evolution (ticket_numero, priorite) VALUES (	1,	1	);
	INSERT INTO public.evolution (ticket_numero, priorite) VALUES (	3,	3	);
	INSERT INTO public.evolution (ticket_numero, priorite) VALUES (	4,	2	);
	INSERT INTO public.evolution (ticket_numero, priorite) VALUES (	6,	2	);
	INSERT INTO public.evolution (ticket_numero, priorite) VALUES (	7,	1	);




--- ================================================================================
--- bug
--- ================================================================================
	INSERT INTO public.bug (ticket_numero, niveau_bug_id) VALUES (	2,	1	);
	INSERT INTO public.bug (ticket_numero, niveau_bug_id) VALUES (	5,	2	);




--- ================================================================================
--- bug_version_affectee
--- ================================================================================
	INSERT INTO public.bug_version_affectee (bug_ticket_numero, version_affectee_projet_id, version_affectee_numero) VALUES (	2,	2,	'2.1'	);
	INSERT INTO public.bug_version_affectee (bug_ticket_numero, version_affectee_projet_id, version_affectee_numero) VALUES (	2,	2,	2.2	);
	INSERT INTO public.bug_version_affectee (bug_ticket_numero, version_affectee_projet_id, version_affectee_numero) VALUES (	5,	5,	5.2	);




--- ================================================================================
--- commentaire
--- ================================================================================
	INSERT INTO public.commentaire (id, description, utilisateur_id, ticket_numero) VALUES (	1,	'Quelle question ?',	8,	5	);
	INSERT INTO public.commentaire (id, description, utilisateur_id, ticket_numero) VALUES (	2,	'Celle avec la réponse 42',	7,	5	);
	INSERT INTO public.commentaire (id, description, utilisateur_id, ticket_numero) VALUES (	3,	'Quel est le produit de 6 par 9 ?',	8,	5	);

	SELECT setval('public.commentaire_id_seq', 3, true);





--- ================================================================================
--- historique_statut
--- ================================================================================
	INSERT INTO public.historique_statut (ticket_numero, statut_id, date, commentaire_id, utilisateur_id) VALUES (	5,	3,	'2017-01-06 00:34:00',	3,	8	);




COMMIT;
