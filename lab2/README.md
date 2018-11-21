
# Laboration 2 #

Syftet med denna laboration är att öva på olika verktyg för polymorfism och återanvändning av kod: arv vs delegering, superklasser vs interfaces, och principer för subklasser. Tanken är att ni ska fortsätta på den lösning ni gjort i laboration 1. Ni ska lära er jobba med extensibilitet och polymorfism.

Se till att noga läsa igenom instruktionerna och att följa de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt med att ladda ner de filer som behövs.

Koden ni skriver i denna labb kommer senare att användas i laboration 3.

Ta fram er lösning från laboration 1 och fortsätta därifrån. Notera att om ni inte är klara eller fått godkänt på laboration 1 bör ni göra detta först.
## Uppgift A

Skapa en representation av en Scania-lastbil med modellnamn Scania. Ge den rimliga startvärden för relevanta fält. Lägg den i filen Scania.java i samma mapp.

Scania ska införlivas i er arvs-hierarki från tidigare, men ha ytterligare funktionalitet: den har ett flak som kan höjas (tippas) och sänkas. Införliva detta i er design så att vi kan hålla reda på vilken vinkel flaket har för närvarande, samt funktioner för att höja och sänka det.

Följande förhållanden ska gälla:

* Vinkeln på flaket kan inte vara lägre än 0 eller högre än 70.
* Flaket kan enbart ha en annan vinkel än 0 om lastbilen står stilla.

Lägg allt i Scania.java och skriv Javadoc för klassen och fälten. Gör minst ett JUnit-test i er testklass.
## Uppgift B

Skapa en representation av en biltransport - dvs en långtradare som kan transportera bilar på flaket. Ge den ett valfritt modellnamn och filnamn.

Biltransporten ska på lämpligt sätt införlivas i er arvshierarki från tidigare. Likt Scania-lastbilen har den ett “flak” i form av en ramp som går att höja och sänka. Införliva detta i er design på lämpligt sätt.

Bilar ska kunna lastas på och av biltransporten. Biltransporten har ett maximalt antal bilar som den kan lasta. Bilar som ska lastas på biltransporten får inte vara för stora (gör ett eget antagande).

Följande förhållanden ska gälla:

* Biltransportens ramp har endast två lägen, uppe eller nere.
* Rampen kan endast vara nere om biltransporten står stilla.
* Bilar kan endast lastas om rampen är nere, och de befinner sig rimligt nära biltransporten (gör ett eget antagande, de exakta detaljerna är inte viktiga).
* Bilar kan endast lossas om rampen är nere. De bör då hamna rimligt nära biltransporten.
* Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades måste vara först att lossas (first-in-last-out).
* Biltransporten ska inte kunna lasta på sig själv.
* Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara densamma som biltransportens position.

Viktiga saker att ha i åtanke under den här uppgiften:

* Undvik kodduplicering för funktionalitet som är gemensam för flera olika klasser, e.g. lastbil och biltransport.
* Fundera över behovet av polymorfism för olika ändamål.
* Fundera över hur ni bäst håller reda på de bilar som lastats - vilken sorts datastruktur är bäst för ändamålet?

Kom ihåg att skriva Javadoc-dokumentation, och JUnit-tester för relevanta aspekter av er kod.
## Uppgift C

Skapa en representation av en bilfärja - dvs en färja på vilken det går att lasta bilar. Notera att bilfärjan inte är en bil (doh), men att många av de metoder vi hittills använt för olika sorters bilar bör gå att applicera även på färjan. Hur åstadkommer ni bäst detta?

På bilfärjan gäller samma regler som för biltransporten, med undantaget att bilar lossas i samma ordning som de lastades, dvs den första bilen som lastades måste vara först att lossas (first-in-first-out).

Viktiga saker att ha i åtanke under den här uppgiften:

* Undvik kodduplicering för funktionalitet som är gemensam för e.g. bilfärjan och biltransporten.
* Fundera över behovet av polymorfism

Extra uppgifter för mer utmaning

* Låt bilfärjan ha ett antal olika filer i vilka bilarna kan befinna sig. För varje fil gäller att bilarna i den filen enbart kan lastas av i samma ordning som de lastades på (first-in-first-out), men bilar från olika filer kan lastas av i olika ordning (även omväxlande mellan filerna).
* Utöka er command line controller till att hantera alla nya element.
* Använd Javas Reflection API för att skriva ut klassnamn, metodnamn och namn på fält för objekten i er modell.