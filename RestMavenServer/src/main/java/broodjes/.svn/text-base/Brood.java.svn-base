package broodjes;

import org.springframework.data.annotation.Id;

/**
 * Created by Dieter on 25/01/14.
 */
public class Brood {
	public enum Field {
		NAAM("naam"), PRIJS("prijs");

		private String naam;

		private Field(String naam) {
			this.naam = naam;
		}

		public String getNaam() {
			return naam;
		}
	}

	@Id
	private String id;
	private String naam;
	private double prijs;

	public Brood(String id, String naam, double prijs) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
	}

	public String getNaam() {
		return naam;
	}

	public double getPrijs() {
		return prijs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Brood) {
			return this.id.equals(((Brood) obj).id);
		} else {
			return false;
		}
	}

}
