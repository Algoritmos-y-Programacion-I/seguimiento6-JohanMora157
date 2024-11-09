package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();

	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. Show Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerSpecies() {
		boolean isMigratory, hasFlowers, hasFruits;

		System.out.println("What is the type of the new Species? 0 = Fauna 1 = Flora");
		int option = reader.nextInt();

		if (option == 1) {
			System.out.println("Type the new Species' name: ");
			String name = reader.next();

			System.out.println("Type the new Species' scientific name: ");
			String scientificName = reader.next();

			System.out.println("Does the new Species have flowers? 0 = No 1 = Yes");
			int optionFlowers = reader.nextInt();
			if (optionFlowers == 0) {
				hasFlowers = false;
			} else {
				hasFlowers = true;
			}
			System.out.println("Does the new Species have fruits? 0 = No 1 = Yes");
			int optionFruits = reader.nextInt();
			if (optionFruits == 0) {
				hasFruits = false;
			} else {
				hasFruits = true;
			}
			System.out.println("Type the new Species' max height: ");
			int maxHeith = reader.nextInt();

			if (speciesController.registerSpecies(name, scientificName, hasFlowers, hasFruits, maxHeith)) {

				System.out.println("Species registered successfully. Type = Flora");

			} else {

				System.out.println("Error, Species couldn't be registered");
			}

		} else {
			System.out.println("Type the new Species' name: ");
			String name = reader.next();

			System.out.println("Type the new Species' scientific name: ");
			String scientificName = reader.next();

			System.out.println("Is migratory? 0 = No 1 = Yes");
			int optionMigratory = reader.nextInt();
			if (optionMigratory == 0) {
				isMigratory = false;
			} else {
				isMigratory = true;
			}

			System.out.println("Type the new Species' max weight: ");
			int maxWeith = reader.nextInt();

			if (speciesController.registerSpecies(name, scientificName, isMigratory, maxWeith)) {

				System.out.println("Species registered successfully. Type = Fauna");

			} else {

				System.out.println("Error, Species couldn't be registered");
			}
		}

	}

	public void editSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();
		if (query.equals("")) {
			System.out.println("There aren't any species registered yet");
			return;
		}
		System.out.println(query);
		System.out.print("Type the name... ");
		String name = reader.next();
		String aux = "";

		if (speciesController.getTypeOfSpecies(name)) {

			System.out.println(
					"What do you want to edit?\n1. Name\n2. Scientific Name\n3. Flowers\n4. Fruits\n5. Max Height");
			int option = reader.nextInt();

			switch (option) {
				case 1 -> {
					reader.nextLine();
					System.out.println("Type the new name... ");
					aux = reader.next();
				}

				case 3 -> {
					reader.nextLine();
					System.out.println("Has flowers? 0 = No 1 = Yes... ");
					int optionFlowers = reader.nextInt();
					if (optionFlowers == 0) {
						aux = "false";
					} else {
						aux = "true";
					}
				}

				case 4 -> {
					reader.nextLine();
					System.out.println("Has fruits? 0 = No 1 = Yes... ");
					int optionFruits = reader.nextInt();
					if (optionFruits == 0) {
						aux = "false";
					} else {
						aux = "true";
					}
				}

				case 5 -> {
					reader.nextLine();

					System.out.println("Type the new height... ");
					aux = reader.nextLine();
				}
				case 2 -> {
					reader.nextLine();
					System.out.println("Type the new Scientificname... ");
					aux = reader.next();
				}
				default -> System.out.println("Invalid option");

			}
			if (speciesController.editSpecies(name, aux, option)) {
				System.out.println("Species edited successfully");
			} else {
				System.out.println("Error, Species couldn't be edited");
			}
		} else {
			System.out.println(
					"What do you want to edit?\n1. Name\n2. Scientific Name\n3. Weight\n4. Migratory ");
			int option = reader.nextInt();
			switch (option) {
				case 1 -> {
					reader.nextLine();
					System.out.println("Type the new name... ");
					aux = reader.next();
				}
				case 4 -> {
					reader.nextLine();
					System.out.println("Is migratory? 0 = No 1 = Yes... ");
					int optionMigratory = reader.nextInt();
					if (optionMigratory == 0) {
						aux = "false";
					} else {
						aux = "true";
					}

				}

				case 3 -> {
					reader.nextLine();
					System.out.println("Type the new weight... ");
					aux = reader.nextLine();
				}
				case 2 -> {
					reader.nextLine();
					System.out.println("Type the new Scientificname... ");
					aux = reader.nextLine();
				}
				default -> System.out.println("Invalid option");
			}
			if (speciesController.editSpecies(name, aux, option)) {
				System.out.println("Species edited successfully");
			} else {
				System.out.println("Error, Species couldn't be edited");
			}
		}

	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.print("Type the name... ");
			String name = reader.next();

			if (speciesController.deleteSpecies(name)) {
				System.out.println("Species deleted successfully");
			} else {
				System.out.println("Error, Species couldn't be deleted");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println("Species registered :");
			System.out.println(query);

			// ...

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
