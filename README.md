TDA552
======

Laborations for TDA552 (Objektorienterad Programmering och Design).

## Laboration 1

Syftet med denna laboration är att ni ska lära er att använda koncept som arv, gränssnitt, overriding (överskuggning), overloading (överlagring) och dynamisk bindning, samt att komma igång med Javadoc och JUnit.

Se till att noga läsa igenom instruktionerna och att följa de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt med att ladda ner de filer som behövs.

I första uppgiften bekantar vi oss med den givna Java-koden, samt skapar ny kod. Därefter bygger varje uppgift på den tidigare lösningen. Koden som skrivs och godkänns i denna labb kommer senare att användas i laboration 2.

### Uppgift A - Arv och gränssnitt

Börja med att ladda ner följande Java-filerna och kika lite i det: `Volvo240.java` och `Saab95.java`. Just nu verkar klasserna ha ganska mycket gemensamt, eftersom båda representerar bilar.

Skapa en arvshierarki där Volvo240 och Saab95 ingår som eliminerar all kod-duplicering och i görligaste mån följer open-closed-principen. Gör dessa ändringar utan att ändra på klassernas funktionalitet.
I originalfilerna är alla metoder och variabler public, vilket exponerar allt till användaren. Ändra synligheten på de metoder och variabler som användaren inte behöver se eller känna till.
Se till att alla filer kompilerar och fortsätt till nästa uppgift.

### Uppgift B

I denna uppgift fortsätter vi bygga på föregående genom att vi nu också implementerar ett interface kallat Movable.

Skapa en fil `Movable.java` och ge interfacet följande metoder:
`void move();`
`void turnLeft();`
`void turnRight();`

Se till att era bilar implementerar interfacet Movable, med någon lämplig intern representation av deras riktning och position. Metoden move ska fungera så att beroende på riktning ökas (eller minskas) bilens x- eller y-koordinat med dess `currentSpeed`.

### Uppgift C

Dokumentation och testning är viktigt när man designar program.

Använd Javadoc för att kommentera samtliga klasser och interfaces. Ni bör ha Javadoc för alla filer; det ska finnas Javadoc för själva klassen och alla des publika metoder. Vid behov ska man dokumentera instansvariabler och hjälp metoder. Det finns funktionalitet i IntelliJ fär att generera (tom) Javadoc
kommentar.
Det finns mycket information om Javadoc på nätet om ni behöver ta fram det. När ni är klara bör ni kunna få ut lämpliga API-dokument för ert program som HTML-filer.

### Uppgift D

Använda JUnit för att skriva tester med 100% coverage för era bilklasser.
Även JUnit har mycket information på nätet som ni kan leta upp. Tänk på att era tester inte behöver testa “allt”; det viktiga är att ni bekantar er med JUnit och förstår hur det fungerar.

Därför behöver ni INTE skriva kodkontrakt för era metoder. Det räcker med att ni skriver testmetoder som testar metodernas funktionalitet med hjälp av assert/equals osv. Därefter testar ni så att alla JUnit-tester går igenom med “Run with coverage”.

### Uppgift E

Bilklassernas metoder har för närvarande inget sätt att kontrollera hur mycket farten kan öka eller sänkas. Skriv om metoder (och dokumentation) så att:

`gas()` och `break()` bara accepterar värden i intervallet `[0, 1]`,
`currentSpeed` alltid ligger i intervallet `[0, enginePower]`,
Anrop till `gas()` inte kan resultera i att farten sänks, och
Anrop till `break()` inte kan resultera i att farten höjs.

### Extra uppgifter för mer utmaning

Lägg till ytterligare bilar till er arvs-hierarki.
Lägg till en enkel command line controller genom vilken ni kan skapa bilar; gasa och bromsa bilar; avgöra var bilarna befinner sig; etc.

## Laboration 2

Syftet med denna laboration är att öva på olika verktyg för polymorfism och återanvändning av kod: arv vs delegering, superklasser vs interfaces, och principer för subklasser. Tanken är att ni ska fortsätta på den lösning ni gjort i laboration 1. Ni ska lära er jobba med extensibilitet och polymorfism.

Se till att noga läsa igenom instruktionerna och att följa de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt med att ladda ner de filer som behövs.

Koden ni skriver i denna labb kommer senare att användas i laboration 3.

Ta fram er lösning från laboration 1 och fortsätta därifrån. Notera att om ni inte är klara eller fått godkänt på laboration 1 bör ni göra detta först.

### Uppgift A

Skapa en representation av en Scania-lastbil med modellnamn Scania. Ge den rimliga startvärden för relevanta fält. Lägg den i filen Scania.java i samma mapp.

Scania ska införlivas i er arvs-hierarki från tidigare, men ha ytterligare funktionalitet: den har ett flak som kan höjas (tippas) och sänkas. Införliva detta i er design så att vi kan hålla reda på vilken vinkel flaket har för närvarande, samt funktioner för att höja och sänka det.

Följande förhållanden ska gälla:

* Vinkeln på flaket kan inte vara lägre än 0 eller högre än 70.
* Flaket kan enbart ha en annan vinkel än 0 om lastbilen står stilla.

Lägg allt i `Scania.java` och skriv Javadoc för klassen och fälten. Gör minst ett JUnit-test i er testklass.

### Uppgift B

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

### Uppgift C

Skapa en representation av en bilfärja - dvs en färja på vilken det går att lasta bilar. Notera att bilfärjan inte är en bil (doh), men att många av de metoder vi hittills använt för olika sorters bilar bör gå att applicera även på färjan. Hur åstadkommer ni bäst detta?

På bilfärjan gäller samma regler som för biltransporten, med undantaget att bilar lossas i samma ordning som de lastades, dvs den första bilen som lastades måste vara först att lossas (first-in-first-out).

Viktiga saker att ha i åtanke under den här uppgiften:

* Undvik kodduplicering för funktionalitet som är gemensam för e.g. bilfärjan och biltransporten.
* Fundera över behovet av polymorfism

Extra uppgifter för mer utmaning

* Låt bilfärjan ha ett antal olika filer i vilka bilarna kan befinna sig. För varje fil gäller att bilarna i den filen enbart kan lastas av i samma ordning som de lastades på (first-in-first-out), men bilar från olika filer kan lastas av i olika ordning (även omväxlande mellan filerna).
* Utöka er command line controller till att hantera alla nya element.
* Använd Javas Reflection API för att skriva ut klassnamn, metodnamn och namn på fält för objekten i er modell.

## Laboration 3

I denna laborationsuppgift är tanken att ni ska fortsätta på den lösning ni gjort i laboration 2.

Se till att noga läsa igenom instruktionerna och att ni följer de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt att ni laddar ner de filer som krävs. Koden som skrivs och godkänns i denna lab kommer att användas till de senare laborationerna.

Börja med ladda ner nya klassfiler: CarController.java, CarView.java, DrawPanel.java samt en zip-fil med bilder. Notera att de nya klasserna har allvarliga brister vad gäller design och implementation. Notera att ni kommer behöva er färdiga lösning från Lab 2.

### Uppgift A

`CarController`, `CarView` och `DrawPanel` utgör tillsammans ett grafiskt användargränssnitt till era fordonsklasser från lab 1. Gränssnittet är skrivet av en tredje part som inte haft tillgång till vare sig kod, dokumentation eller designdokument för er lösning.

Gör de eventuella ändringar i `CarController`, `CarView` och `DrawPanel` som behövs för att det ska gå att använda tillsammans med er lösning från lab 2.

När ni är färdiga ska ni kunna köra `CarController` och se Volvo-bilen röra sig (genom att öka värdet på gasen och gasa). Notera att vi förutsätter att ni använder IntelliJ; se kommentarer i koden ifall ni vill använda något annat. Detta påverkar mest bilderna, eftersom ni måste skapa ett nytt package pics i src-mappen och lägga alla bilder där. För er inte använder IntelliJ kan ni lägga bilderna i samma mapp som klass-filerna och ändra koden enligt instruktionerna.

### Uppgift B

Se till att även bromsknappen är kopplad till bilen, så att den får effekt på er simulation (bromsvärdet får ni från samma snurra som gasen hämtar sitt värde ifrån). Ni måste se till att modellens tillstånd uppdateras, och sen anropar tillbaka till View via Controllern.

Volvon åker just nu ut ur rutan. Se till att när bilen nuddar en vägg så stoppar den helt, inverterar sin riktning och startar igen.

Sätt in Saab95, Scania och deras respektive bilder med 100 pixlars avstånd i Y-led från varandra (alla avbildas ursprungligen med X=0).

Koppla turbo-knapparna till Saaben och flakknapparna till Scania. Koppla “starta och stoppa alla bilar”-knapparna till bägge.

Även dessa bilar ska förhindras att åka utanför rutan.

### Uppgift C

Rita upp ett UML-diagram över systemet i dess nuvarande skick.

Analysera de beroenden som finns med avseende på cohesion, coupling och dependency inversion principle.

Vilka beroenden är nödvändiga? Vilka klasser är beroende av varandra som inte bör vara det? Finns det starkare beroenden än nödvändigt? Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?

Ni behöver inte göra någon ny design eller implementation; det återkommer vi till i senare labbar.

### Frivillig BONUS-uppgift

Utöka era fordonsmodell (men inte användargränssnittet) med stöd för kollisionshantering. Implementera metoder för att avgöra om två fordon kommer krocka vid nästa move(). Implementera något sätt att undvika sådana kollisioner — till exempel kan ni låta bilarna studsa ifrån varandra eller väja åt sidan. Hur kan man se till att kollisionshanteringen inte ger falskt alarm när man testar för kollision mellan en biltransport och en på biltransporten pålastad bil? För två bilar lastade på samma biltransport? För För två bilar lastade på olika biltransporter, men som i sin tur är lastade på samma bilfärja? För ännu oimplementerade typer av biltransport?


## Laboration 4

I denna laborationsuppgift ska ni fortsätta på den lösning ni gjort i laboration 3. Målet är att göra ert program mer modulärt. Koden som skrivs och godkänns i denna lab kommer att användas till nästa laboration.

### Uppgift A

Utgå från ert UML-diagram från laboration 3 uppgift C.

Analysera era klasser med avseende på separation of concern (SoC) och single responsibility-principle (SRP). Vad har era klasser för ansvarsområde(n)? Vad har de för anledningar att ändras? På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?


### Uppgift B

Rita ett UML-diagram över en ny design som åtgärdar de brister ni identifierat med avseende både på beroenden och ansvarsfördelning, dvs. både från uppgift A och från laboration 3 uppgift C.

Motivera, i termer av de principer vi gått igenom, varför era förbättringar verkligen är förbättringar.

### Uppgift C

Skriv en refaktoriseringsplan. Planen bör bestå av en sekvens refaktoriseringssteg som tar er från det nuvarande programmet till ett som implementerar er nya design. Planen behöver inte vara enormt detaljerad.

Finns det några delar av planen som går att utföra parallellt, av olika utvecklare som arbetar oberoende av varandra? Om inte, finns det något sätt att omformulera planen så att en sådan arbetsdelning är möjlig?

### Uppgift D

Byt kod samt refaktoriseringsplan med en annan grupp. Verkställ den andra gruppens refaktoriseringsplan; förvissa er om att programmets funktionalitet förblir oförändrad. Inspektera resultatet av den andra gruppens verkställande av er refaktoriseringsplan. Blev det som ni tänkt er?
Frivillig BONUS-uppgift

    Ordna en dialogruta som startar i början av programmet, som frågar vilka av de 3 bilarna ni vill inkludera i simulationen. Fråga även användaren om simulationens hastighet: Snabb (20 ms delay), Normal (50 ms), Långsam (100 ms).
    Skriv ut “: ” i något lämpligt hörn av panelen, eller kanske på en helt ny JLabel ni kan lägga under alla knappar.
    Kan du få piltangenterna på tangentbordet att ändra bilarnas riktning, och se till att kollisioner hanteras med kollisionshanteringen från bonusuppgiften i laboration 3? (Very Hard mode)

