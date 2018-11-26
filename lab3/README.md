
# Laboration 3

I denna laborationsuppgift är tanken att ni ska fortsätta på den lösning ni gjort i laboration 2.

Se till att noga läsa igenom instruktionerna och att ni följer de regler och krav som uppgifterna föreskriver. Börja med att kolla igenom hela beskrivningen och se vad som krävs för att få godkänt, samt att ni laddar ner de filer som krävs. Koden som skrivs och godkänns i denna lab kommer att användas till de senare laborationerna.

Börja med ladda ner nya klassfiler: CarController.java, CarView.java, DrawPanel.java samt en zip-fil med bilder. Notera att de nya klasserna har allvarliga brister vad gäller design och implementation. Notera att ni kommer behöva er färdiga lösning från Lab 2.
## Uppgift A

CarController, CarView och DrawPanel utgör tillsammans ett grafiskt användargränssnitt till era fordonsklasser från lab 1. Gränssnittet är skrivet av en tredje part som inte haft tillgång till vare sig kod, dokumentation eller designdokument för er lösning.

Gör de eventuella ändringar i CarController, CarView och DrawPanel som behövs för att det ska gå att använda tillsammans med er lösning från lab 2.

När ni är färdiga ska ni kunna köra CarController och se Volvo-bilen röra sig (genom att öka värdet på gasen och gasa). Notera att vi förutsätter att ni använder IntelliJ; se kommentarer i koden ifall ni vill använda något annat. Detta påverkar mest bilderna, eftersom ni måste skapa ett nytt package pics i src-mappen och lägga alla bilder där. För er inte använder IntelliJ kan ni lägga bilderna i samma mapp som klass-filerna och ändra koden enligt instruktionerna.
## Uppgift B

Se till att även bromsknappen är kopplad till bilen, så att den får effekt på er simulation (bromsvärdet får ni från samma snurra som gasen hämtar sitt värde ifrån). Ni måste se till att modellens tillstånd uppdateras, och sen anropar tillbaka till View via Controllern.

Volvon åker just nu ut ur rutan. Se till att när bilen nuddar en vägg så stoppar den helt, inverterar sin riktning och startar igen.

Sätt in Saab95, Scania och deras respektive bilder med 100 pixlars avstånd i Y-led från varandra (alla avbildas ursprungligen med X=0).

Koppla turbo-knapparna till Saaben och flakknapparna till Scania. Koppla “starta och stoppa alla bilar”-knapparna till bägge.

Även dessa bilar ska förhindras att åka utanför rutan.
## Uppgift C

Rita upp ett UML-diagram över systemet i dess nuvarande skick.

Analysera de beroenden som finns med avseende på cohesion, coupling och dependency inversion principle.

Vilka beroenden är nödvändiga? Vilka klasser är beroende av varandra som inte bör vara det? Finns det starkare beroenden än nödvändigt? Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?

Ni behöver inte göra någon ny design eller implementation; det återkommer vi till i senare labbar.
## Frivillig BONUS-uppgift

Utöka era fordonsmodell (men inte användargränssnittet) med stöd för kollisionshantering. Implementera metoder för att avgöra om två fordon kommer krocka vid nästa move(). Implementera något sätt att undvika sådana kollisioner — till exempel kan ni låta bilarna studsa ifrån varandra eller väja åt sidan. Hur kan man se till att kollisionshanteringen inte ger falskt alarm när man testar för kollision mellan en biltransport och en på biltransporten pålastad bil? För två bilar lastade på samma biltransport? För För två bilar lastade på olika biltransporter, men som i sin tur är lastade på samma bilfärja? För ännu oimplementerade typer av biltransport?
