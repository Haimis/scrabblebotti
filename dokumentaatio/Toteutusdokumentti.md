# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelma palauttaa käyttäjän antamista kirjaimista muodostettavissa olevat sanat. Oletuksena käytetään nykysuomen sanakirjaa ja suomenkielisen Scrabblen pisteytystä, mutta myös omia listoja ja pistetiedostoja on mahdollista käyttää. Käyttö tapahtuu komentorivin kautta.

Ohjelma koostuu kahdesta toiminnallisuudesta. Ensimmäinen näistä on niin sanottu build-vaihe, jossa käyttäjä voi konfiguroida haluamansa sanalistan ja pistetaulukon. Samalla sanalista ja pistetaulukko alustetaan muistiin tehokkaiksi tietorakenteiksi.

Varsinainen päätoiminnallisuus on sanojen hakeminen. Käyttäjä syöttää komentoriville käytössään olevat kirjaimet ja saa tulosteen, josta näkyvät muodostettavissa olevat sanat, sekä sanapisteet. Käyttäjän on mahdollista tehdä lukematon määrä hakuja.

Ohjelman yleisrakenne noudattaa MVC-arkkitehtuuria. Kunkin osan luokkien toiminta on avattu alla.

`**LISÄÄ KUVA!**`

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

**WordLoader** `**PÄIVITÄ**`

## Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista)

## Työn mahdolliset puutteet ja parannusehdotukset
- wild cardien käyttö
- hakutulosten suorattaminen pisteiden mukaan
- laudalla olevien kirjainten huomioiminen
- tekoälysovellus

## Lähteet

http://kaino.kotus.fi/sanat/nykysuomi/
