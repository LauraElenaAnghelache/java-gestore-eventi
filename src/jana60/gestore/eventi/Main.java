package jana60.gestore.eventi;


	import java.time.DateTimeException;
    import java.time.LocalDate;
	import java.util.Scanner;

	public class Main {
/*1.   Creare una classe  Main  di test, in cui si chiede all’utente  di inserire un nuovo evento 
 con tutti i parametri. 
 2.   Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni 
 vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo 
 eventuali eccezioni. 
 3.   Stampare a video il numero di posti prenotati e quelli disponibili 
 4.   Chiedere all’utente se e quanti posti vuole disdire 
 5.   Provare ad effettuare le disdette, implementando opportuni controlli e gestendo 
 eventuali eccezioni 
 6.   Stampare a video il numero di posti prenotati e quelli disponibili */
		public static void main(String[] args) throws Exception {

			Scanner scan = new Scanner(System.in);
			boolean flag = false;
			String prenotazione;
			String disdetta;
			Evento e = null;
			
		
			do {
				try {
					System.out.println("Benvenuto in Java Eventi!");
					System.out.println("Inserisci il nome dell'evento ");
					String titolo = scan.nextLine();
					System.out.println("Inserisci il giorno della prenotazione");
					int giorno = Integer.parseInt(scan.nextLine());
					System.out.println("Inserisci il mese della prenotazione");
					int mese = Integer.parseInt(scan.nextLine());
					System.out.println("Inserisci l'anno della prenotazione");
					int anno = Integer.parseInt(scan.nextLine());
					
					LocalDate data = LocalDate.of(anno, mese, giorno);
					System.out.println("Inserisci la capienza dell'evento ");
					int capienza = Integer.parseInt(scan.nextLine());
					e = new Evento(titolo, data, capienza);
					System.out.println(e);
					
					flag = false;
					
				}catch (DateTimeException ex) {
					System.out.println("I valori devono essere numeri superiori a 0");
				} catch (NumberFormatException ex ) {
					System.out.println("I valori devono essere numeri superiori a 0 ");
				} catch (Exception ex) {
					System.out.println("E' stato riscontrato un errore, riprova.");
					System.out.println(ex.getMessage());
				} 
			} while (flag);
			      
			        System.out.println("Inserisci 1 per prenotare o  2 per terminare ");
			        prenotazione = scan.nextLine();
			        switch (prenotazione) {
			        case "1": {
				System.out.println("Inserisci il numero di prenotazioni da effettuare ");
				int prenot = Integer.parseInt(scan.nextLine());
				for (int i = 0; i < prenot; i++)
	

					e.prenota();
				System.out.println("I posti prenotati sono : " + e.getNumPostiPrenotati()
						+ " ne restano disponibili : " + e.postiDisponibili());
				break;
			}
			case "2": {
				System.out.println("Grazie e arrivederci");
				flag = true;
			}
	
           }
	        System.out.println("Inserisci 1 se vuoi annullare delle prenotazioni /2 per terminare ");
			disdetta = scan.nextLine();
			switch (disdetta) {
			case "1": {
				System.out.println("Inserisci quanti posti vuoi togliere ");
				int disdetto = Integer.parseInt(scan.nextLine());
				for (int i = 0; i < disdetto; i++)
	

					e.disdici();
				System.out.println("I posti da te eliminati sono :" + disdetto + " I posti che hai prenotato sono "+e.getNumPostiPrenotati()+" e la disponibilità rimasta è : "
						+ e.postiDisponibili());
				System.out.println("Grazie e arrivederci");
				break;
			}
			case "2": {
				System.out.println("Grazie e arrivederci");
			}
			}
		
		scan.close();
			}
		}
	
