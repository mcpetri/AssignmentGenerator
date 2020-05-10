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

**Tehtävän tekeminen**

**Laskimen käyttö**

**Vaikeusasteen muutos**

**Tilastojen päivitys ja näyttö**



![Uuden tehtävän luonti](https://i.imgur.com/D3bZMdL.png)
