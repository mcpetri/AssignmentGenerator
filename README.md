 ## AssignmentGenerator

Sovelluksen tarkoitus on luoda käyttäjälle matematiikan perustehtäviä merkeillä + , - , * , /. Sovellus myös pitää kirjaa kaikista toiminnoista, joita käyttäjä voi tehdä ja käyttäjä voi tarkkailla näitä tilastoja.

Sovellus on Helsingin yliopiston kevään 2020 ohjelmistotekniikan kurssin harjoitustyö.

## Dokumentaatio

[Käyttöohje](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/kayttoohje.md)

[Määrittelydokumentti](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/Maarittelydokumentti.md)

[Tuntikirjanpito](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/arkkitehtuuri.md)


## Releaset

[Viikko 5](https://github.com/mcpetri/ot-harjoitustyo/releases/tag/viikko5)

[Loppupalautus]()

## Komentorivitoiminnot

Suoritettavan jarin generointi *mvn package*

Checkstyle tarkistus *mvn jxr:jxr checkstyle:checkstyle*

Testikattavuuden generointi *mvn jacoco:report*

Javadocin generointi *mvn javadoc:javadoc*

mvn compile exec:java -Dexec.mainClass=generaattoriapp.main.Main



