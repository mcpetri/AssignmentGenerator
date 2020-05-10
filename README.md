 ## AssignmentGenerator

Sovelluksen tarkoitus on luoda käyttäjälle matematiikan perustehtäviä merkeillä + , - , * , /. Sovellus myös pitää kirjaa kaikista toiminnoista, joita käyttäjä voi tehdä ja käyttäjä voi tarkkailla näitä tilastoja.

Sovellus on Helsingin yliopiston kevään 2020 ohjelmistotekniikan kurssin harjoitustyö.

## Dokumentaatio

[Käyttöohje](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/kayttoohje.md)

[Määrittelydokumentti](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/Maarittelydokumentti.md)

[Tuntikirjanpito](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/mcpetri/ot-harjoitustyo/blob/master/Dokumentointi/arkkitehtuuri.md)

[Testaus]()


## Releaset

[Viikko 5](https://github.com/mcpetri/ot-harjoitustyo/releases/tag/viikko5)

[Loppupalautus]()

## Komentorivitoiminnot

Ohjelman voi suorittaa komennolla
```
mvn compile exec:java -Dexec.mainClass=generatorapp.main.Main
```

**Testien suoritus**

Testit suoritetaan komennolla 
```
*mvn test*
```

Testikattavuusraportti suoritetaan komennolla 
```
*mvn jacoco:report* 
```
ja avautuu selaimeen tiedostosta target/site/jacoco/index.html

Checkstyleraportti suoritetaan komennolla 
```
*mvn jxr:jxr checkstyle:checkstyle* 
```
ja avautuu selaimeen tiedostosta target/site/checkstyle.html

**Suoritettava jar**

Suoritettavan jarin generointi komennolla 
```
*mvn package*
```
ja löytyy hakemistosta target nimellä AssignmentGenerator-1.0-SNAPSHOT, jonka voi suorittaa komennolla
```
java -jar AssignmentGenerator-1.0-SNAPSHOT.jar
```

**JavaDoc**

Javadocin generointi komennolla 
```
*mvn javadoc:javadoc*
```
ja avautuu selaimeen tiedostosta target/site/apidocs/index.html






