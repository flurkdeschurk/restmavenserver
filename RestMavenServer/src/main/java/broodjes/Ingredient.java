package broodjes;

import org.springframework.data.annotation.Id;

/**
 * Created by Dieter on 25/01/14.
 */
public class Ingredient {
	public enum Field {
		NAAM("naam"), PRIJS("prijs"), IMAGE_URL("imageUrl");

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
	private String imageUrl;

	public Ingredient(String id, String naam, double prijs, String imageUrl) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
		this.imageUrl = imageUrl;
	}

	public String getNaam() {
		return naam;
	}

	public double getPrijs() {
		return prijs;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
