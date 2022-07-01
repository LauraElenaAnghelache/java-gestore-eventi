package jana60.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	/* La consegna è di creare una classe  Evento  che abbia  le seguenti proprietà: 
    titolo 
    data 
    numero di posti totali (cioè la capienza della location) 
    numero di posti prenotati 
 Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel 
 costruttore  , tranne posti prenotati   che va inizializzato a 0. 
 Inserire il controllo che la data non sia già passata e che il numero di posti totali sia un 
 numero positivo. In caso contrario sollevare opportune eccezioni. 
 Aggiungere metodi  getter  e  setter  in modo che: 
   titolo sia in lettura e in scrittura 
   data sia in lettura e scrittura 
   numero di posti totali sia solo in lettura 
    numero di posti prenotati sia solo in lettura 
 Vanno inoltre implementati dei  metodi public  che svolgono  le seguenti funzioni: 
 1.   prenota  : aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha più 
 posti disponibili deve sollevare un’eccezione. 
 2.   disdici  : riduce di uno i posti prenotati. Se l’evento  è già passato o non ci sono 
 prenotazioni deve sollevare un’eccezione. 
 3.   l’override  del metodo  toString()  in modo che venga  restituita una stringa 
 contenente: data formattata - titolo */

	
		//ATTRIBUTI
	     private String titolo = null;
	     private LocalDate data;
	     private int numPostiTot;
	     private int numPostiPrenotati;
	     private LocalDate oggi = LocalDate.now();
		 private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	     //COSTRUTTORE
	     public Evento(String titolo,LocalDate data, int numPostiTot) throws Exception{
	    	 super();
	    	 this.titolo = titolo;
	    	 this.data = data;
	    	 this.numPostiTot = numPostiTot;
	    	 this.numPostiPrenotati = 0;
	    	 validaData();
	    	 validaPosti();
	    	 prenota();
	    	 disdici();
	     }

		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}

		public int getNumPostiTot() {
			return numPostiTot;
		}

		public int getNumPostiPrenotati() {
			return numPostiPrenotati;
		}

		public LocalDate getOggi() {
			return oggi;
		}

		public void setOggi(LocalDate oggi) {
			this.oggi = oggi;
		}

		public DateTimeFormatter getFormatter() {
			return formatter;
		}

		public void setFormatter(DateTimeFormatter formatter) {
			this.formatter = formatter;
		}
		
		public int postiDisponibili() {
				return numPostiTot - numPostiPrenotati;
		}
		public void validaData() throws Exception {
			if (oggi.isAfter(data)) {
				throw new Exception ("Non è possibile prenotare con data passata");
			}
		}
			public int prenota() throws Exception {
				if (numPostiPrenotati < 0) {
					throw new Exception ("Inserire un numero valido magiore di 0");
				}
		     return numPostiPrenotati += 1;
		}
	
		public void validaPosti() throws Exception {
			if (numPostiTot <= 0) {
				throw new Exception ("nserire un numero valido maggiore di 0");
				
			}
		}
		 public void prenota(int numeroprenotazioni)throws Exception {
	    	 if (numPostiPrenotati > numPostiTot ) {
				throw new Exception("Non puoi prenotare posti non disponibili");
			}
	 
		}
		public int disdici() throws Exception {
			if (oggi.isAfter(data) || numPostiPrenotati <=0) {
				throw new Exception ("La data è non è successiva al giorno odierna o posti non pervnuti");
			}
	     return numPostiPrenotati -=1;
		}
		
		@Override
		public String toString() {
				return "Posti disponibili: " + postiDisponibili() + " Evento: " + titolo +" "+ "in data:" +formatter.format(data);
			}
	}


