die klasse f�hrt einen post request durch, um den Spieler:

{
	"mail":"testmail.de",
	"nickname":"test",
	"password":"testpw"
}

einzuloggen. das json wird dabei in den httpbody gesetzt.


Das ganze habe ich hier fix mit maven gemacht, 
einfach die .jar importieren, dann solltet ihr die klasse sehen k�nnen, alternativ ist sie nochmal blank drinne.

falls ihr das mal ausf�hren wollt geht das mit:

mvn exec:java 
oder aus der IDE heraus: bei maven das goal exec:java setzen und ausf�hren


Die Ausgabe ist: Sie haben sich erfolgreich angemeldet.
funktioniert also :D


das ganze k�nnt ihr dann so anpassen, dass es die richtigen daten schickt, nicht immer nur den test (logischerweise^^).


link zum einbinden:
https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/dependency-info.html (bei mir das erste, bei euch dann das mit Gradle)