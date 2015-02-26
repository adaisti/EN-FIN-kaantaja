# Rakennekuvaus

Käyttäjä syöttää tekstiä käyttöliittymään, mistä tapahtumankuuntelija noukkii sen talteen ja luo sen pohjalta uuden teksti-olion,
joka käännetään. Teksti (esimerkiksi "Move 24 sts on two needles, turn work, knit 20 sts") jaetaan lauseiksi 
("Move 24 sts on two needles", "turn work", "knit 20 sts") ja siitä edelleen lausekkeiksi ("Move", "24 sts", "on two needles", 
jne). Jako-operaatioissa käytetään apuna sanakirjaa ja syntaksisanakirjaa, joita hakemistonhallinta hallitsee.

Jokainen lauseke-olio käsitellään lausekkeen lekseemin ja syntaktisten ominaisuuksien löytämiseksi. Nämä ominaisuudet eivät
ole tässä ohjelman versiossa vielä kovin pitkälle kehitettyjä. Syntaksihauista vastaavat luokat NomininSyntaksiHaku,
VerbinSyntaksiHaku ja VertailuMuodoissaTaipuvanSyntaksiHaku.

Lausekkeen palauttamien syntaksien ja lekseemien perusteella lause-olio luo uuden SuomiLausekkeen, joka jäsennetään oikeaan
muotoon. Taivutuksista vastaavat luokat Substantiivi, Adjektiivi, Numeraali, Pronomini, Partikkeli ja Verbi. Neljä ensin mainittua
perivät luokan Nomini, joka Verbin kanssa perii luokan Taipuva. Lisäksi Adjektiivilla ja Partikkelilla on lisäksi yhteinen 
rajapinta VertailumuodoissaTaipuva.

Kun kaikki lausekkeet on käännetty, palautetaan lause tekstille, joka on säilyttänyt välimerkit, ja muodostaa käännetyistä
lauseista niiden perusteella uuden tekstin. Käännösteksti palautetaan tapahtumankuuntelijalle, joka taas antaa sen
käyttöliittymälle, joka tulostaa sen käyttäjälle.
