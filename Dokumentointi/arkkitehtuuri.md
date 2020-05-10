## Arkkitehtuuri

Sovellus noudattaa kolmeosaista kerroarkkitehtuuria

![Pakettirakenne](https://i.imgur.com/Vu07AzD.png)

Main sisältää vain ui:n suorittavan komennon. Ui suorittaa logic -paketin ominaisuuksia ja näyttää ne käyttäjälle

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erillaista näkymää, *login* ja *generaattori*

* Login -näkymässä syötetään käyttäjätunnus, jonka tietoja halutaan seurata
* Generaattori -näkymä sisältää kaiken muun toiminnallisuuden näyttämisen; tehtävien tekemisen, laskimen käytön, vaikeusasteen muutoksen, tilastojen tarkastelun

Jokainen ominaisuus on oma Scene -olionsa, joka asetetaan näkyville napinpainalluksella window -Stagelle

Käyttöliittymä on rakennettu generatorapp.ui -pakettiin, GeneratorUI -luokkaan. Käyttöliittymä ja sovelluslogiikka on erotettu toisistaan, käyttöliittymä kutsuu sovelluslogiikan metodeja ja asettaa tuloksia esille.

## Sovelluslogiikka

Sovelluksien osien suhteita kuvaava kaavio

![Imgur](https://i.imgur.com/avh4R5D.png)

Main kutsuu UI:ta aloittamaan ohjelman näytön, UI käyttää sovelluslogiikalta toimintoja joita se näyttää

* Calculator hoitaa oikean syntaksin omaavien lausekkeiden laskemisen ja vastauksen antamisen
* Assignment luo tehtäviä UI:n antamalla merkillä ja hakee vastauksen tehtävään Calculator:ilta ja antaa lausekkeen UI:lle
* Statistics hoitaa tietojen keräämisen ja päivityksen, kun UI niin sille kertoo

## Tietojen tallennus

Tiedot tallennetaan Statistics -luokan luomaan "UsersAndStatistics.txt" tiedostoon salaamatta mitään. Tiedot löytyvät tiedostosta muodossa 
```
user/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/
```
jossa user on tallennettu käyttäjä ja jokainen nolla kuvaa jotakin seurattavaa toimintaa, joita Statistics -luokka sitten päivittää, kun sovellusta käytetään

## Päätoiminnot

Käydään läpi jokainen sovelluslogiikan toiminto sekvenssikaavioilla

**Kirjautuminen**

Sovellusta avatessa ensimmäisenä tulee automaattisesti login -näkymä johon käyttäjä syöttää halutun tunnuksen

![Imgur](https://i.imgur.com/j7BlK5D.png)

**Tehtävän tekeminen**

Vasemmalta olevasta menusta voidaan valita muutamasta laskutyypistä

![Imgur](https://i.imgur.com/A2Q4KRa.png)

-lasku voi merkitä mitä tahansa menusta valittua laskua. Symbol vastaa valitun laskun symbolia (jakomerkki, kertomerkki yms). Jos käyttäjä tarkistaessaan vastasi oikein luo sovellus automaattisesti uuden tehtävän ja ilmoittaa että edelliseen tehtävään vastattiin oikein.

**Laskimen käyttö**

Käyttäjä syöttää hyväksyttävän lausekkeen tekstikenttään ja painaa Laske. Tarvittaessa lausekkeen muodostamiseen saa apua Ohje -napista

![Imgur](https://i.imgur.com/Pp8PRxG.png)

**Vaikeusasteen muutos**

Käyttäjä voi asettaa parametrejä joilla tehtäviä luodaan

![Imgur](https://i.imgur.com/OTpsKs5.png)

**Tilastojen päivitys ja näyttö**

Kun käyttäjä valitsee Tilastot -näkymän, niin se automaattisesti hakee ja esittää nykyisen käyttäjätunnuksen tiedot

![Imgur](https://i.imgur.com/BQdKkLg.png)




