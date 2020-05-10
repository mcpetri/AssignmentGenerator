## Testausdokumentti

**Sovelluslogiikka**

Sovellus koostuu logic-, UI- ja main-paketista joista logic -paketti sisältää kaiken testattavan materiaalin. Mainista löytyy vain UI:n suorittava mainClass ja UI:ta ei testata.

* AssignmentTest testaa generoituvien tehtävien tyyppejä ja että Assignment -luokka tuottaa oikeanpituisia lausekkeita, kun parametrejä muutetaan
* CalculatorTest testaa laskimelle mahdollisesti syötettäviä rajatapauksia
* StatisticsTest testaa uuden tiedoston luomista, sen päivittämistä, siitä lukemista ja käyttäjän hakemista

**Testikattavuusraportti**

Raportti koostuu logic -paketista, eikä huomio main- tai UI-pakettia

![Imgur](https://i.imgur.com/Wy9WqHC.png)

Rivikattavuus on 95% sekä haarautumiskattavuus 85% (Saattaa vaihdella lievästi, muutamassa testissä luodaan 100 esimerkkitapausta jotka tarkistetaan)

![Imgur](https://i.imgur.com/E4Dhhh5.png)

Testaamatta jäi tilanteet, joissa ulkopuolinen sekaantuu tiedostoon kesken suorituksen tai tiedoston lukemisessa on ongelmia.

**Järjestelmätestaus**

Suoritettiin manuaalisesta lataamalla tiedosto ja suorittamalla [määrittelydokumentin](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/Maarittelydokumentti.md) ominaisuudet [käyttöohjeen](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/kayttoohje.md) avulla


