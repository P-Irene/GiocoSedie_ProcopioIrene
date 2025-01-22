# GiocoSedie
## Descrizione
Questa applicazione simula il famoso gioco delle sedie. Ci sono, quindi, diversi partecipanti che si contendono i posti sulle sedie. Potranno tutti ottenere un posto tranne uno, che perderà. I risultati del gioco vengono visualizzati in un file di testo. 
## Realizzazione
I partecipanti sono dei thread che tentano l'accesso alla risorsa comune, che è il posto su una sedia, perciò, chi prima arriva riesce ad accapararsi un posto. <br>
La risorsa comune è gestita attraverso dei metodi sincronizzati che permettono, quindi, l'accesso di un thread alla volta, bloccando gli altri finché la risorsa non viene liberata.
```java
public synchronized boolean libero() {
	return (!occupato);
}

public synchronized boolean occupa() {
	if (occupato)
            return false;
        else
            return occupato = true;
}
```
Ogniqualvolta un posto viene occupato da un partecipante, verrà scritto nel file di testo il numero del posto occupato e il suo identificativo (ovvero l'id del thread). <br>
Esempio:
```
Gioco Sedie 2025-01-22
Posto n° 0 - ID Partecipante: 24
Posto n° 1 - ID Partecipante: 26
Posto n° 2 - ID Partecipante: 23
Posto n° 3 - ID Partecipante: 27
```
## Utilizzo
Una volta avviata l'applicazione verrà chiesto all'utente di inserire il numero di partecipanti che intende far giocare. Da qui verrano generati i posti che i giocatori dovranno contendersi. Come risultato verrà mostrato quali partecipanti sono riusciti a sederersi e quale, invece, ha perso il gioco. <br>
Esempio con 6 partecipanti:
```
00000
Sono il Thread Thread-6. Sono riuscito a sedermi sul posto 0
*0000
*0000
Sono il Thread Thread-2. Sono riuscito a sedermi sul posto 1
Sono il Thread Thread-3. Sono riuscito a sedermi sul posto 2
***00
***00
Sono il Thread Thread-1. Sono riuscito a sedermi sul posto 3
Sono il Thread Thread-4. Sono riuscito a sedermi sul posto 4
*****
Sono il Thread Thread-5. Ho perso :((((
```
Dove troviamo lo 0, significa che il posto è libero, dove troviamo l'asterisco (*) significa che il posto è occupato. <br>
Esiste, infatti, una classe Display che durante tutta la durata del gioco controlla quanti posti sono liberi e quanti occupati e lo stampa a video.
## Crediti
+ [Metodo per la scrittura del file di testo - Autrice mciuchetti](https://github.com/mciuchetti/GestioneFile.git)
