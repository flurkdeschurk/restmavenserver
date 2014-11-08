package broodjes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * Created by Dieter on 15/01/14.
 */
public class Broodje {
	public enum Field {
		NAAM("naam"), PRIJS("prijs"), BROOD("brood"), BASISBELEG("basisBeleg");

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
	private BigDecimal prijs;
	private Brood brood;
	private List<Ingredient> basisBeleg = new ArrayList<Ingredient>();

	public Broodje(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public Brood getBrood() {
		return brood;
	}

	public void setBrood(Brood brood) {
		this.brood = brood;
	}

	public List<Ingredient> getBasisBeleg() {
		return basisBeleg;
	}
}
