package model;

public class SpeciesController {

	private final Species[] species;

	public SpeciesController() {

		this.species = new Species[80];
		precarga();

	}

	public boolean registerSpecies(String name, String scientificName, boolean hasFlowers, boolean hasFruits,
			int maxHeith) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeith);
				return true;
			}

		}

		return false;

	}

	public boolean registerSpecies(String name, String scientificName, boolean isMigratory, int maxWeigth) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Fauna(name, scientificName, isMigratory, maxWeigth);
				return true;
			}

		}

		return false;

	}

	public Species searchSpecies(String name) {

		for (Species specie : species) {
			if (specie != null) {
				if (specie.getName().toLowerCase().equals(name.toLowerCase())) {
					return specie;
				}
			}
		}

		return null;

	}

	public boolean getTypeOfSpecies(String name) {
		Species aux = searchSpecies(name);
		if (aux instanceof Flora) {
			return true;
		} else {
			return false;
		}

	}

	public boolean editSpecies(String name, String aux, int option) {
		boolean auxBool;
		Species auxSpecies = searchSpecies(name);

		// Verificar que se encontró la especie
		if (auxSpecies == null) {
			return false;
		}

		if (auxSpecies instanceof Flora) {
			Flora flora = (Flora) auxSpecies; // Hacemos un casting solo una vez
			switch (option) {
				case 1:
					flora.setName(aux);
					return true;

				case 2:
					flora.setScientificName(aux);
					return true;

				case 3:
					auxBool = aux.equals("true"); // Convertir el String en boolean
					flora.setHasFlowers(auxBool);
					return true;

				case 4:
					auxBool = aux.equals("true"); // Convertir el String en boolean
					flora.setHasFruits(auxBool);
					return true;

				case 5:
					flora.setMaxHeight(Integer.parseInt(aux)); // Convertir el String en entero
					return true;

				default:
					return false; // Opción no válida
			}

		} else if (auxSpecies instanceof Fauna) {
			Fauna fauna = (Fauna) auxSpecies; // Hacemos un casting solo una vez
			switch (option) {
				case 1:
					fauna.setName(aux);
					return true;

				case 2:
					fauna.setScientificName(aux);
					return true;

				case 4:
					auxBool = aux.equals("true"); // Convertir el String en boolean
					fauna.setIsMigratory(auxBool);
					return true;

				case 3:
					fauna.setMaxWeight(Integer.parseInt(aux)); // Convertir el String en entero
					return true;

				default:
					return false; // Opción no válida
			}
		}

		return false; // Retornar false si no es ni Flora ni Fauna
	}

	public boolean deleteSpecies(String name) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if (species[i].getName().equals(name)) {
					species[i] = null;
					return true;
				}
			}
		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". Name= " + species[i].getName() + ", Scientific name= "
						+ species[i].getScientificName() + ", "
						+ species[i].toString();
			}
		}

		return msg;

	}

	public void precarga() {
		species[0] = new Flora("Rosa", "Rosa sp", true, true, 100);
		species[1] = new Fauna("Caballo", "Ornito", true, 20);

	}

}
