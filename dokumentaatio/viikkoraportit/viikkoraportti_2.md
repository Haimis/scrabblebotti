# Viikkoraportti 2

## Mitä olen tehnyt?

Viikon aikana toteutin seuraavat toimenpiteet:
- loin projektin
- circle ci, codecov ja code climate käyttöön
- testasin pipelinen toimivuuden
- kirjoitin pythonscriptin, jolla saan tarvittavan sanakirjan helposti ladattua ja siistittyä
- toteutin alustavan latojan, jolla voin lukea sanakirjan sanoja tiedostosta
- viikkoraportti

## Miten ohjelma on edistynyt?

Itse projekti on luotu ja koodin laaduntarkkailuun liittyvät rakenteet pystyssä. Saan tarvittavan sanakirjan helposti ladattua ja voin käsitellä sitä varsinaisella ohjelmalla.

## Mitä opin?

Eri mikropalveluiden konfiguraation kanssa tuli taas näperreltyä jokunen tovi. Rutiinia laadunhallinnasta ja työkalujen integroinnista kertyi mojovasti.

## Mikä jäi epäselväksi?

Tuo latoja lukee nyt projektin juuressa olevaa sanalistatiedostoa ja toimi myös jar:lla. Haluaisin kuitenkin, että sanalista kulkisi aina jar paketin mukana, koska muuten ohjelma on täysin hyödytön. Tuohon pitää löytää jokin toimiva ratkaisu. Yllättävän huonosti löytyi tietoa googlaillessa.

## Mitä teen seuraavaksi?

- toteutan tämän viikon "mitä jäi tavoitteista tekemättä" -kohdat
- heitän tuon konffausta varten luodun Dictionary-luokan testeineen mäkeen
- varmistan, että circle ci:ssä tapahtuu kaikki tarvittava, myös jar:n generointi, checkstyle
- järkevöitän latojan rakennetta siten, että voin testata myös epäonnistuvat caset
- aloitan toteuttamaan tietorakennetta sanakirjalle
- aloitan toteuttamaan algoritmia sanakirjan lateluun tietorakenteeseen

## Mitä jäi tavoitteista tekemättä?
- Javadoc dokumentaatiota ei ole aloitettu
- alustavia tietorakenteita ei ole aloitettu

## Paljonko käytin aikaa?

9h
