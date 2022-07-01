package jana60.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	
		//ATTRIBUTI
	     private String titolo;
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
	
		public void validaPosti() throws Exception {
			if (numPostiTot < 0) {
				throw new Exception ("nserire un numero valido maggiore di 0");
				
			}
		}
		public int prenota() throws Exception {
			if (numPostiPrenotati < 0) {
				throw new Exception ("Inserire un numero valido magiore di 0");
			}
	     return numPostiPrenotati += 1;
		}
		public int disdici() throws Exception {
			if (oggi.isAfter(data) || numPostiPrenotati <=0) {
				throw new Exception ("La data è non è successiva al giorno odierna o posti non pervnuti");
			}
	     return numPostiPrenotati -=1;
		}
		
		@Override
		public String toString() {
			return "Titolo evento:" + titolo + "\n Data evento:" + formatter.format(data);
		

	}

}
