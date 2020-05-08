# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelma palauttaa käyttäjän antamista kirjaimista muodostettavissa olevat sanat. Oletuksena käytetään nykysuomen sanakirjaa ja suomenkielisen Scrabblen pisteytystä, mutta myös omia listoja ja pistetiedostoja on mahdollista käyttää. Käyttö tapahtuu komentorivin kautta.

Ohjelma koostuu kahdesta toiminnallisuudesta. Ensimmäinen näistä on niin sanottu build-vaihe, jossa käyttäjä voi konfiguroida haluamansa sanalistan ja pistetaulukon. Samalla sanalista ja pistetaulukko alustetaan muistiin tehokkaiksi tietorakenteiksi.

Varsinainen päätoiminnallisuus on sanojen hakeminen. Käyttäjä syöttää komentoriville käytössään olevat kirjaimet ja saa tulosteen, josta näkyvät muodostettavissa olevat sanat, sekä sanapisteet. Käyttäjän on mahdollista tehdä lukematon määrä hakuja.

Ohjelman yleisrakenne noudattaa MVC-arkkitehtuuria. Kunkin osan luokkien toiminta on avattu alla.

### Model
**DataStructure** Abstrakti yläluokka Letter ja PointTable tietorakenteiden alustamiseen. Sisältää metodit, joilla saadaan sopiva syöte tiedostonimeksi, sekä alustettua tietorakenteet luettavista tiedostoista. Tietorakenteet alustetaan tehokkaasti kirjainten hashCodeja hyödyntäen.

**Letter** Ohjelman keskeinen tietorakenne, johon sanalista alustetaan. Tietorakenne koostuu Letter-olioiden muodostamasta puusta. Puun juuren arvo on null, mutta se sisältää taulukon, jossa on viittaukset sanojen alkukirjaimiin. Näistä on puolestaan viittaukset niihin kirjaimiin, jotka esiintyvät alkukirjaimen jälkeen jossain sanassa. (Katso kuva).

**PointTable** Yksinkertainen taulukko, johon alustetaan kunkin kirjaimen tuottama pistemäärä pelissä. Pisteet alustetaan ja niihin viitataan kirjaimen hashcodella.

### View
**CLI** Yksinkertainen tekstikäyttöliittymä, joka tarjoaa sovelluslogiikalle metodit
- tervehdysviestiin
- Luettavien tiedostopolkujen vastaanottamiseen.
- Käyttäjän kirjainten vastaanottaminen.
- Virheiden raportointi
- Hakutulosten tulostaminen

### Controller
**Logic** Sisältää varsinaisen sovelluslogiikan. Metodi build hyödyntää aiemmin esiteltyjä build metodeja ja alustaa tietorakenteet.

Metodi run kysyy käyttöliittymän kautta käyttäjän syötteitä kunnes tämä antaa tyhjän syötteen.

Metodi form tiles käy läpi käyttäjän antamat kirjaimet ja käynnistää rekusiivisen haun kullakin alkukirjaimella.

Rekursio käy rekursiivisesti läpi viittaukset kustakin kirjaimesta seuraaviin kirjaimiin ja palauttaa onnistuneet sanat.

**WordLoader** Luokka lukee käytettävät sanalistat ja pistetaulukot ohjelman muistiin ja käyttöön. Sisältää metodit tiedostojen avaamiseen ja sulkemiseen, sekä metodit niiden käsittelyyn.

Metodi readWordList lukee apumetodin splitWord avulla halutun sanalistan ohjelman muistiin. splitWord vastaa sanojen pilkkomisesta puurakenteeseen.

Metodi readPointList lukee halutun pistetaulun muistiin.

## Saavutetut aikavaativuudet

Sanojen latoja käy lineaarisesti sanakirjan sanat läpi ja kutsuu sopivien sanojen kohdalla rekursiivista apumetodia:

``` 
for sana in sanat:
  rekursio(sana)
  
rekursio(sana):
    ...
    rekursio(subString(sana))
```

Latominen toimii siis ajassa `O(n)`. Kokska sanakirjasta luetaan vain alle 9 merkkiä pitkät sanat, kutsutaan rekrsiivista apumetodia korkeintaan kahdeksan kertaa. Latojan aikavaativuus on siis `O(n*8) = O(n)`.

Varsinainen hakumetodi saa syötteekseen `n` kirjainta. Tämän jälkeen käydään läpi kaikki ne kirjaimet, joilla jokin haettavista sanoista alkaa. Näitä kirjaimia on korkeintaan 25. Mikäli alkukirjain löytyy kädestä, käynnistetään rekursiivinen apumetodi. Päämetodi kutsuu apumetodia siis korkeintaan 25 kertaa, eli sen aikavaativuus on `O(1)`. 

```
for kirjain in sanojenEnsiKirjaimet:
  if kirjain in syotetytKirjaimet:
    rekursio("", kirjain, muutKirjaimet)
```
Apumetodi saa parametreikseen käytetyistä kirjaimista muodostuvan sanan alun, käsiteltävän kirjaimen, sekä käyttämättömät kirjaimet. Mikäli uusi sana on muodosteltu se käsitellään metodin alussa. Tämän jälkeen sanan alusta ja käsiteltävästä kirjaimesta luodaan uusi sanan alku, minkä jälkeen metodi kutsuu itseään niissä tapauksissa, joissa jokin sanan alulle seuraava kirjain löytyy muista kirjaimista.

```
rekursio(sananAlku, kirjain, muutKirjaimet)
  ...
  sananAlku += kirjain
  for seuraavaKirjain in sanojenEnsiKirjaimet:
    if seuraavaKirjain in muutKirjaimet:
      muutKirjaimet -= seuraavaKirjain
      rekursio(sananAlku, seuraavaKirjain, muutKirjaimet)
```


Apumetodin aikavaativuus on `O(1)`. Sanojen maksimipituus on kahdeksan kirjainta, joten teoriassa metodi kutsuu itseään korkeintaan `Min(n, 25)^8` kertaa. Sanoja on kuitenkin käytössä vain 500 000. Lisäksi samanalkuiset sanat kuten "aamu", "aamen" ja "aate" käsitellään erikseen vain niiltä osin, kuin sanat eroavat toisistaan.  Käsittely etenee siis seuraavasti:
```
   a     ---- 1. kierros
   |
   a     ---- 2. kierros
   | \
   m  t  ---- 3. kierros
 / |  |
e  u  e  ---- 4. kierros
|
n        ---- 5. kierros
```
Sanat tuottavat siis yhteensä vain kahdeksan metodikutsua, vaikka ne käsittävät yhteen laskettuna 13 kirjainta. Täten algoritmin toiminta-aika ei ole riippuvainen käyttäjän syötteen `n` koosta. Kun `n` on pieni toimii algoritmi erittäin nopeasti, mutta `n`:n kasvaessa suureksi ei algoritmin toiminta-aika kasva kuin korkeintaan niin suureksi, että kaikki sanat on käyty kertaalleen läpi. Voidaan siis todeta, että algoritmi toimii ajassa `O(1)`.



## Työn mahdolliset puutteet ja parannusehdotukset
- wild cardien käyttö
- hakutulosten suorattaminen pisteiden mukaan
- laudalla olevien kirjainten huomioiminen
- tekoälysovellus

## Lähteet

http://kaino.kotus.fi/sanat/nykysuomi/
