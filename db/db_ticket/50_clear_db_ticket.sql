BEGIN TRANSACTION;

--- ===== Purge des tables
DELETE FROM public.historique_statut;
DELETE FROM public.commentaire;
DELETE FROM public.bug_version_affectee;
DELETE FROM public.bug;
DELETE FROM public.evolution;
DELETE FROM public.ticket_associe;
DELETE FROM public.ticket;
DELETE FROM public.version;
DELETE FROM public.projet;
DELETE FROM public.utilisateur;
DELETE FROM public.niveau_bug;
DELETE FROM public.statut;


--- ===== Réinitialisation des séquences
SELECT setval('public.commentaire_id_seq', 1, false);
SELECT setval('public.niveau_bug_id_seq', 1, false);
SELECT setval('public.projet_id_seq', 1, false);
SELECT setval('public.statut_id_seq', 1, false);
SELECT setval('public.ticket_numero_seq', 1, false);
SELECT setval('public.utilisateur_id_seq', 1, false);


COMMIT;