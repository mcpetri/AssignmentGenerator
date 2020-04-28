**OHJELMISTOTEKNIIKKA, harjoitustyö**



**Tehtavageneraattori matematiikan tehtäville**

Sovelluksen tekstikäyttöliittymä sallii neljän erimerkkisen laskun, yhteen-, vähennys-, kerto-, ja jakolaskujen tekemisen. Generaattori tuottaa tällä hetkellä alkeellisia "ratkaise x" kysymyksiä joissa tekijöinä 2 eri lukua väleiltä 1-200 sekä sisältää alkeellisen laskimen käyttäjälle.



**Dokumentaatio**

[Käyttöohje](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/kayttoohje.md)

[Määrittelydokumentti](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/Maarittelydokumentti.md)

[Tuntikirjanpito](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/arkkitehtuuri.md)


**Releaset**

[Viikko 5](https://github.com/mcpetri/ot-harjoitustyo/releases/tag/viikko5)

**Komentorivitoiminnot**


Testikattavuuden generointi *mvn jacoco:report*

Suoritettavan jarin generointi *mvn package*

Checkstyle tarkistus *mvn jxr:jxr checkstyle:checkstyle*



mvn compile exec:java -Dexec.mainClass=generaattoriapp.main.Main



