Laboration 1
============

Syftet med denna laboration är att ni ska lära er att använda koncept som arv, gränssnitt, overriding (överskuggning), overloading (överlagring) och dynamisk bindning, samt att komma igång med Javadoc och JUnit.

Se till att noga läsa igenom instruktionerna och att följa de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt med att ladda ner de filer som behövs.

I första uppgiften bekantar vi oss med den givna Java-koden, samt skapar ny kod. Därefter bygger varje uppgift på den tidigare lösningen. Koden som skrivs och godkänns i denna labb kommer senare att användas i laboration 2.

##Uppgift A - Arv och gränssnitt

Börja med att ladda ner följande Java-filerna och kika lite i det: Volvo240.java och Saab95.java. Just nu verkar klasserna ha ganska mycket gemensamt, eftersom båda representerar bilar.

Skapa en arvshierarki där Volvo240 och Saab95 ingår som eliminerar all kod-duplicering och i görligaste mån följer open-closed-principen. Gör dessa ändringar utan att ändra på klassernas funktionalitet.
I originalfilerna är alla metoder och variabler public, vilket exponerar allt till användaren. Ändra synligheten på de metoder och variabler som användaren inte behöver se eller känna till.
Se till att alla filer kompilerar och fortsätt till nästa uppgift.

##Uppgift B

I denna uppgift fortsätter vi bygga på föregående genom att vi nu också implementerar ett interface kallat Movable.

Skapa en fil Movable.java och ge interfacet följande metoder:
void move();
void turnLeft();
void turnRight();
Se till att era bilar implementerar interfacet Movable, med någon lämplig intern representation av deras riktning och position. Metoden move ska fungera så att beroende på riktning ökas (eller minskas) bilens x- eller y-koordinat med dess currentSpeed.

##Uppgift C

Dokumentation och testning är viktigt när man designar program.

Använd Javadoc för att kommentera samtliga klasser och interfaces. Ni bör ha Javadoc för alla filer; det ska finnas Javadoc för själva klassen och alla des publika metoder. Vid behov ska man dokumentera instansvariabler och hjälp metoder. Det finns funktionalitet i IntelliJ fär att generera (tom) Javadoc
kommentar.
Det finns mycket information om Javadoc på nätet om ni behöver ta fram det. När ni är klara bör ni kunna få ut lämpliga API-dokument för ert program som HTML-filer.

##Uppgift D

Använda JUnit för att skriva tester med 100% coverage för era bilklasser.
Även JUnit har mycket information på nätet som ni kan leta upp. Tänk på att era tester inte behöver testa “allt”; det viktiga är att ni bekantar er med JUnit och förstår hur det fungerar.

Därför behöver ni INTE skriva kodkontrakt för era metoder. Det räcker med att ni skriver testmetoder som testar metodernas funktionalitet med hjälp av assert/equals osv. Därefter testar ni så att alla JUnit-tester går igenom med “Run with coverage”.

##Uppgift E

Bilklassernas metoder har för närvarande inget sätt att kontrollera hur mycket farten kan öka eller sänkas. Skriv om metoder (och dokumentation) så att:

gas() och break() bara accepterar värden i intervallet [0, 1],
currentSpeed alltid ligger i intervallet [0, enginePower],
Anrop till gas() inte kan resultera i att farten sänks, och
Anrop till break() inte kan resultera i att farten höjs.
Extra uppgifter för mer utmaning

Lägg till ytterligare bilar till er arvs-hierarki.
Lägg till en enkel command line controller genom vilken ni kan skapa bilar; gasa och bromsa bilar; avgöra var bilarna befinner sig; etc.
