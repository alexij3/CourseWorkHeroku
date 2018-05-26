  /* 1) Одержати перелік культурних споруд вказаного типу загалом
            та тих, які задовольняють вказані хар-ки (місткість залу тощо)*/
/* SELECT * FROM cinema; */ 
/* SELECT * FROM cinema WHERE screen_size > 130; */


/* 2) Одержати список артистів, які виступають у вказаному жанрі */
/*
SELECT id, name
FROM artist
INNER JOIN artist_and_genre
ON artist.id = artist_and_genre.id_artist
WHERE artist_and_genre.id_genre = (SELECT id FROM genre WHERE name = 'Пародія');
*/


/* 3) Одержати список артистів, які працюють із вказаним імпресаріо */
/*
SELECT id, name
FROM artist
INNER JOIN artist_and_impresario
ON artist.id = artist_and_impresario.id_artist
WHERE artist_and_impresario.id_impresario = (SELECT id FROM impresario WHERE name LIKE '%Столяр%');
*/


/* 4) Одержати список артистів, які працюють більш ніж у одному жанрі (вказати жанри) */
/*
SELECT artist.id, artist.name, genre.name as genre FROM
((artist JOIN artist_and_genre ON artist.id = artist_and_genre.id_artist)
JOIN genre ON genre.id = artist_and_genre.id_genre)
WHERE artist.id IN (SELECT id_artist FROM artist_and_genre JOIN artist
ON artist.id = artist_and_genre.id_artist GROUP BY artist.id HAVING COUNT(artist.id) > 1)
ORDER BY artist.id;
*/


/* 5) Одержати список імпресаріо вказаного артиста */
/*
SELECT id, name
FROM impresario
INNER JOIN artist_and_impresario
ON impresario.id = artist_and_impresario.id_impresario
WHERE artist_and_impresario.id_artist = (SELECT id FROM artist WHERE name LIKE '%Шнур%');
*/


/* 6) Одержати список концертних заходів, проведених протягом 
      вказаного періоду загалом або вказаним організатором */
/*
SELECT name
FROM concert_in_hall
WHERE date BETWEEN '2018-02-04' AND '2018-02-17';
*/

/*
SELECT name
FROM contest_in_palace
WHERE date BETWEEN '2018-02-01' AND '2018-02-15';
*/

/*
SELECT name
FROM theatre_performance
WHERE date BETWEEN '2018-01-02' AND '2018-02-10';
*/

/*
SELECT name
FROM concert_in_hall
WHERE concert_in_hall.id_organizer = (SELECT id FROM organizer WHERE name LIKE '%Нестійко%');
*/

/* 7) Одержати список лауреатів та призерів вказаного конкурсу */
/*
SELECT name, place, winner
FROM contest_results
INNER JOIN artist
ON id_artist = artist.id
WHERE id_contest = (SELECT id_contest FROM contest_in_palace WHERE name LIKE '%Пейзаж%');
*/

/* 8) Одержати список концертних заходів, проведених у вказаній культурній споруді */
/*SELECT id_contest as id, contest_in_palace.name
FROM contest_in_palace
WHERE contest_in_palace.id_palace = (SELECT id FROM culture_palace
									 WHERE name LIKE '%Диво%');*/

/* 9) Одержати список імпресаріо вказаного жанру */
/*
SELECT id, name
FROM impresario
INNER JOIN impresario_and_genre
ON impresario.id = impresario_and_genre.id_impresario
WHERE impresario_and_genre.id_genre = (SELECT id FROM genre WHERE name = 'Драма');
*/

/* 10) Вивести список артистів, які не брали участь в жодному конкурсі протягом
       вказаного періоду */
/*
SELECT id, name
FROM artist
WHERE id NOT IN
(SELECT id_artist FROM contest_results JOIN contest_in_palace
ON contest_results.id_contest = contest_in_palace.id_contest
WHERE contest_in_palace.date BETWEEN '2018-01-20' AND '2018-02-05');
*/

/* 11) Одержати список організаторів культурних заходів
   та кількість проведених ними концертів протягом вказаного періоду часу */
/*
SELECT organizer.name, COUNT(concert_in_hall.id) as number
FROM concert_in_hall
INNER JOIN organizer
ON organizer.id = concert_in_hall.id_organizer
WHERE date BETWEEN '2018-01-24' AND '2018-02-15'
GROUP BY id_organizer;
*/

/* 12) Одержати перелік культурних споруд та дати проведення
       в них культурних заходів протягом вказаного періоду */

/*
SELECT theatre.name, date
FROM theatre
INNER JOIN theatre_performance
ON theatre.id = theatre_performance.id_theatre
WHERE date BETWEEN '2018-02-02' AND '2018-02-20'
ORDER BY theatre.name;
*/

/*
SELECT culture_palace.id, culture_palace.name, date
FROM culture_palace
INNER JOIN contest_in_palace
ON culture_palace.id = contest_in_palace.id_palace
WHERE date BETWEEN '2018-01-18' AND '2018-02-20'
ORDER BY culture_palace.name;
*/