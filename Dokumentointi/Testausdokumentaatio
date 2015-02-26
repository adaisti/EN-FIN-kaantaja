# Testausdokumentaatio

Testien tekeminen tällaiseen projektiin on ollut kokonaisuudessaan varsin haastavaa. Olen testannut vain tiettyjä "tärppejä", 
eli vain tiettyjä sanoja, joten esimerkiksi oikean sijamuodon tuottaminen niille on ollut varsin helppoa, vaikka jäsentimeni
tunteekin vain harvoja taivutusmuotoja. Jos siis suomen kielen jäsennystä haluaisi kehittää edelleen, olisi testaus ehdottomasti
toteutettava jollakin toisella tavalla. Olisi esimerkiksi haettava paljon erilaisia poikkeustapaussanoja ja tutkittava,
taivutetaanko nekin oikein. Koodikatsemuksessa minulle ehdotettiin myös satunnaisesti arvotun sanan testaamista yhtenä keinoista,
ja se vaikuttaa mielestäni oikein hyvältä idealta. Pitäisi vain opetella tekemään sellaisia testejä sekä löytää jostakin lista
oikein taivutettuja satunnaisia suomen kielen sanoja.

Englannin kielen jäsentämisen kunnollinen, kattava testaus, olisi, jos mahdollista, vieläkin haastavampaa. Olisi tietysti
vastaavasti kuin suomessa mahdollista tutkia esimerkiksi lekseemin löytämistä vertailemalla sananmuotoja, niiden käsittelyä
ja olemassa olevia englannin sanoja keskenään. Sen sijaan sanojen syntaktisten funktioiden etsimiseksi testausta varten täytyisi
minun nähdäkseni käyttää valmiiksi olemassa olevaa ja toimivaa ohjelmaa, joka tekee ihan samaa kuin minun ohjelmani, jotta
"oikeita vastauksia" saataisiin tarpeeksi kattavasti. Olen siis jälleen tehnyt testejä vain tietyillä esimerkkisanoilla, ja
on vaikea sanoa, miten ohjelma reagoisi täysin satunnaiseen syötteeseen. Toisaalta täyttä satunnaisuutta en ehkä siltä edes
lähtisi vaatimaan. Ohjelma on kuitenkin kehitetty neuleohjeiden kääntämiseen, pitäen mielessä sen, että neuleohjeissa käytetty
typistekieli poikkeaa satunnaisesta englannin tai suomen kielen käytöstä merkittävästi esimerkiksi sanajärjestyksen ja
lauserakenteiden osalta. Ohjelma myös hyödyntää tätä ominaisuutta varsin paljon, koska sen ei oikeastaan tarvitse puuttua 
sanajärjestykseen, ne kun ovat neuleohjeissa varsin samanlaiset suomessa ja englannissa.

Isompia kokonaisuuksia, kuten Teksti-luokan kaanna()-metodin palauttamaa syötettä, on vaikea testata, koska ohjelma ei vielä
tässä vaiheessa ole niin laaja kuin haluaisin. Aikarajan puitteissa olisi varmaankin ollut mahdotonta tehdä tätä kovin paljon
laajempi ohjelma, mutta tuntuu silti kummalta kirjoittaa testejä, joissa pyydetään syötettä, jollaista en haluaisi lopullisen
ohjelmaversioni tuottavan. Olen testannut koko käännöksen tuottoa varsin paljon käsin ja fiksannut joitakin ongelmia sen pohjalta.
Käyttöliittymälle itselleen en ole kirjoittanut testejä lainkaan, sillä olen käsin havainnut sen toimivaksi eivätkä muut ohjelman
osat koske sen toimintaan, joten ohjelmaa kehittäessä mikään siitä ei voi mennä rikki. Lisäksi se on hyvin yksinkertainen.

Joitakin puutteita testauksessa on tällä hetkellä myös siksi, että osa luokista ei vielä toteuta suurinta osaa niistä
toiminnallisuuksista, joita haluan niiden toteuttavan. Olen kuitenkin nähnyt tarpeelliseksi lisätä " lähes turhat" luokat jo 
tässä vaiheessa ohjelmaan, koska haluan kehittää ohjelmaa myöhemmin eteenpäin, ja tällä tavoin sen rakenne on pysynyt
selkeämpänä, ja jatkokehitys tulee olemaan helpompaa. Tällaisia luokkia ovat esimerkiksi englanti-paketin eri syntaksinhakuun
tarkoitetut luokat, tai suomi-paketin Substantiivi ja Numeraali.

Haastavaa testauksesta on tehnyt myös sen, että valtaosa ohjelmani metodeista on void-tyyppisiä, ja monet niistä luovat
toisia oliota tai muuttavat niiden olotilaa. Siksi testatessa voi olla vaikea ottaa selvää siitä, onko mahdollinen vika juuri
testattavassa metodissa, vai jossakin sen käsittelemän olion metodissa. Toki kattavat testit auttavat tässäkin. Monet ohjelman
luokista ovat varsin riippuvaisia toisista luokista, ja siksi esimerkiksi englanti-paketin luokkien testauksessa on nähtävissä
se, että joitakin luokkia on testattu vain testejä varten luodun hyvin pienen sanakirjan avulla, koska testejä tehdessä
ohjelman käyttämä Sanakirja ei ollut vielä toiminnassa.

Tähän mennessä suurimmat löytämäni bugit liittyivät Sanat.txt-tiedoston lukemiseen muilla koneilla kuin omallani. Palautettavaan
versioon olen kovakoodannut sanat, jotta ohjelmaa voisi käyttää tarkastuksessa, mutta pidemmän päälle ongelma on ratkaistava
muilla tavoin. Tällä hetkellä ohjelma osaa vain alle 100 sanaa, mutta lopullisessa versiossa haluaisin sen osaavan ainakin
kymmenkertaisesti enemmän sanoja.
