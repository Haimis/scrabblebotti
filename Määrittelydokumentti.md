# Määrittelydokumentti
Scrabble on sanapeli, jossa kerätään pisteitä laatimalla pelilaudalle sanoja. Pelaajilla on käytössään seitsemän umpimähkään valittua kirjainlaattaa, joista sanat laaditaan yhdistämällä ne laudalla oleviin kirjainlaattoihin. Kirjainlaatat on pisteytetty siten, että harvinaisemmista kirjaimista saa enemmän pisteitä. Projektin tavoitteena on toteuttaa scrabblebotti, joka muodostaa parhaat pisteet antavat suomen kielen sanat pelaajan käytössä olevista kirjainlaatoista.

## Projektin tietorakenteet ja algoritmit
Mitä algoritmeja ja tietorakenteita toteutat työssäsi

## Ratkaistava ongelma

Tarkoituksena on siis muodostaa suomenkielisiä sanoja annetuista kirjaimista mahdollisimman tehokkaasti. Ratkaistava ongelma on kaksivaiheinen. 

### 1) Sanojen järjestäminen

Kotimaisten kielten keskuksen nykysuomen sanalista käsittää noin 94 110 sanatietuetta. Tarkoituksena on pilkkoa sanat kirjaimiksi ja muodostaa kirjaimista deterministinen äärellinen automaatti. Tietorakenne on suunnattu verkko, jossa solmut ovat joko hyväksyviä tai hylkääviä tiloja (merkkijono kuuluu suomen kieleen tai ei kuulu) ja kaaret puolestaan kirjaimia. Kaaret ovat painotettuja, sillä myös sanalaatoilla on eri pistemäärät. Verkko on tallennettu kaarilistana, jossa kukin kaari käsittää kyseessä olevan kirjaimen, kirjainpisteet, viittauksen seuraavaan tilaan ja tiedon siitä onko seuraava tila hyväksyvä vai ei. Valitsin kyseisen toteutustavan, sillä se tuli vastaan scrabble-algoritmeja käsittelevässä artikkelissa ja vaikutti tehokkaalta.

### 2) Sallittujen sanojen haku

Varsinainen sanojen haku toteutetaan leveyshaulla. Jos tiloja merkitään n ja kaaria m on algoritmin aikavaativuus O(n + m), joten sen pitäisi olla riittävän nopea ongelman ratkaisemiseen.

## Ohjelman saamat syötteet ja niiden käyttö

Ohjelmalle annetaan syötteeksi käytössä olevat kirjainlaatat, eli käytännössä seitsemän kirjaimen merkkijono. Syöte määrittää ne kirjaimet, joita haussa voidaan käyttää.

## Aika- ja tilavaativuustavoitteet

Algoritmi on tarkoitus saada toimimaan ajassa O(n + m). Tilavaativuus on  sama O(n + m).

## Lähteet
[Scrabble, Wikipedia](https://fi.wikipedia.org/wiki/Scrabble)

[Kotimaisten kielten keskuksen nykysuomen sanalista](http://kaino.kotus.fi/sanat/nykysuomi/)

[Andrew W. Appel, Guy J. Jacobson: The World’s Fastest Scrabble Program](http://www.cs.cmu.edu/afs/cs/academic/class/15451-s06/www/lectures/scrabble.pdf)

Antti Laaksonen: Tirakirja
