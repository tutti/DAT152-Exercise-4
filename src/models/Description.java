package models;

import model.HardcodedModel;

public class Description extends HardcodedModel {
	public static HardcodedModel[] data;
	static {
		// Java won't accept array literals unless they're in the initialiser. Seriously, Java?
		Description[] _data = {
				new Description(1, 1, "no_NO", "En hvit kaffekopp. Denne koppen holder kaffen din varm. Om du ikke liker kaffe, kan koppen også holde andre væsker, for eksempel melk eller flytende nitrogen."),
				new Description(2, 1, "en_US", "A white coffee cup. This cup will keep your coffee warm. If you don't like coffee, the cup can also hold other liquids, such as milk or liquid nitrogen."),
				new Description(3, 1, "es_ES", "Café blanco. Esto le puede ahorrar una taza de café caliente. El nitrógeno líquido, que puede tener una taza de café, leche u otros líquidos."),
				new Description(4, 2, "no_NO", "En svart kaffekopp. Denne koppen er svart som din sjel, eller som kaffen din hvis du vil. Hvis du ikke liker å kunne se kaffen i koppen, er dette koppen for deg."),
				new Description(5, 2, "en_US", "A black coffee cup. This cup is as black as your blighted soul, or as your coffee if you prefer. If you don't like to see the coffee in your cup, this cup is for you."),
				new Description(6, 2, "es_ES", "Después de una taza de café. Se trata de un montón de café negro y seco. Usted no quiere ver una taza de café.")
		};
		data = _data;
	}
	
	public static Description NONE = new Description(0, 0, "en_US", "This product has no description.");
	
	public int id;
	public int pno;
	public String langCode;
	public String text;
	
	private Description(int index, int pno, String langCode, String text) {
		super();
		id = index;
		this.pno = pno;
		this.langCode = langCode;
		this.text = text;
	}

	public Description(int index) throws Exception {
		super(index);
	}

	@Override
	public void load(int index) throws Exception {
		id = index;
		Description d = (Description) data[index-1];
		this.pno = d.pno;
		this.langCode = d.langCode;
		this.text = d.text;
	}
	
	public int getPno() {
		return pno;
	}
	
	public String getLangCode() {
		return langCode;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((langCode == null) ? 0 : langCode.hashCode());
		result = prime * result + pno;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Description)) return false;
		Description d = (Description) o;
		return id == d.id;
	}
	


}
