INSERT INTO public.izdelek(naziv, kategorija, cena)
values ('Coca-Cola', 'Pijača', 2.41);

INSERT INTO public.izdelek(naziv, kategorija, cena)
values ('Fanta', 'Pijača', 1.22);

INSERT INTO public.izdelek(naziv, kategorija, cena)
values ('Nestea', 'Pijača', 0.98);

INSERT INTO public.izdelek(naziv, kategorija, cena)
values ('Chio chips', 'Prigrizki', 2.77);

INSERT INTO public.izdelek(naziv, kategorija, cena)
values ('Smoki', 'Prigrizki', 1.64);

INSERT INTO public.lokacija(postna_stevilka, naziv)
values (2380, 'Slovenj Gradec');

INSERT INTO public.lokacija(postna_stevilka, naziv)
values (1000, 'Ljubljana');

INSERT INTO public.lokacija(postna_stevilka, naziv)
values (2000, 'Maribor');

INSERT INTO public.lokacija(postna_stevilka, naziv)
values (2250, 'Ptuj');

INSERT INTO public.lokacija(postna_stevilka, naziv)
values (3301, 'Petrovce');

INSERT INTO public.uporabnik(ime, priimek, uporabnisko_ime, email, postna_stevilka)
values ('Mitja', 'Kotnik', 'mj0073', 'mj0073@student.uni-lj.si', 2380);

INSERT INTO public.uporabnik(ime, priimek, uporabnisko_ime, email, postna_stevilka)
values ('Klemen', 'Lovenjak', 'kl7021', 'kl7021@student.uni-lj.si', 2250);

INSERT INTO public.uporabnik(ime, priimek, uporabnisko_ime, email, postna_stevilka)
values ('Spela', 'Jurak', 'sj0511', 'sj0511@student.uni-lj.si', 3301);

INSERT INTO public.trgovina(naziv, postna_stevilka)
values ('Mercator LJ', 1000);

INSERT INTO public.trgovina(naziv, postna_stevilka)
values ('Mercator MB', 2000);

INSERT INTO public.trgovina(naziv, postna_stevilka)
values ('Lidl SG', 2380);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (1, 1);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (1, 2);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (1, 4);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (2, 1);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (2, 4);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (2, 5);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (3, 2);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (3, 3);

INSERT INTO public.seznam(id_trgovina, id_izdelek)
values (3, 5);

INSERT INTO public.listek(id_listek, id_uporabnik)
values (1, 3);

INSERT INTO public.listek(id_listek, id_uporabnik)
values (2, 1);

INSERT INTO public.listek(id_listek, id_uporabnik)
values (3, 2);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (1, 1);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (1, 3);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (2, 2);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (2, 5);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (3, 1);

INSERT INTO public.listek_izdelek(id_listek, id_izdelek)
values (3, 4);