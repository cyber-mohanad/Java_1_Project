import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
	// Fields
	String name;
	String type;
	ArrayList<String> numbers = new ArrayList<>();
	static ArrayList<Contact> contacts = new ArrayList<>();

	//   Constructor
	Contact(String name, String type) {
		this.name = name;
		this.type = type;
	}

	//  Add Contact Info
	public static void add(Scanner in) {
		System.out.print("Enter contact info: \nName: ");
		String name = in.nextLine();

		System.out.print("Type (Family, Personal, Work, Other): ");
		String type = in.nextLine();
		if (!type.equalsIgnoreCase("Family") &&
				!type.equalsIgnoreCase("Personal") &&
				!type.equalsIgnoreCase("Work") &&
				!type.equalsIgnoreCase("Other")) {
			type = "Other";
			System.out.println("-->> Invalid type, set to Other.");
		}
		Contact contact = new Contact(name, type);

		// Add multiple numbers
		while (true) {
			System.out.print("Number (0 to stop): ");
			String num = in.nextLine();
			if (num.equals("0")) break;
			if (numberExists(num) || contact.numbers.contains(num)) {
				System.out.println("-->> This number already exists!");
			} else {
				contact.numbers.add(num);
				System.out.println("-->> Number added.");
			}
		}
		if (!contact.numbers.isEmpty()) {
			contacts.add(contact);
			System.out.println("\n––>> Contact added successfully.");
		} else {
			System.out.println("-->> No numbers entered, contact not saved.");
		}
	}

	//   Check Constraint (Number Exists ?)
	static boolean numberExists(String num) {
		for (Contact c : contacts) {
			if (c.numbers.contains(num)) return true;
		}
		return false;
	}

	//  Search by name
	public static void searchByName(Scanner in) {
		System.out.print("    enter name to search: ");
		String text = delete_aioeu(in.nextLine());
		boolean found = false;
		for (Contact c : contacts) {
			String name1 = delete_aioeu(c.name);
			if (name1.contains(text)) {
				System.out.println("\n " + c.name + " | " + c.type + " | " + c.numbers);
				found = true;
			}
		}
		if (!found) System.out.println("\n-->> Not found");
	}

	// Search by number
	public static void searchByNumber(Scanner in) {
		System.out.print("    enter number to search: ");
		String num = in.nextLine();
		boolean found = false;

		for (Contact c : contacts) {
			if (c.numbers.contains(num)) {
				System.out.println(c.name + " | " + c.type + " | " + c.numbers);
				found = true;
			}
		}
		if (!found) System.out.println("-->> Not found");
	}

	// Delete Contact by Name
	public static void deleteByName(Scanner in) {
		System.out.print("      enter name to delete: ");
		String text = in.nextLine();
		int count = 0;
		for (int i = contacts.size() - 1; i >= 0; i--) {
			if (contacts.get(i).name.equalsIgnoreCase(text)) {
				contacts.remove(i);
				count++;
			}
		}
		if (count == 0) System.out.println("-->> Not found");
		else System.out.println("-->> " + count + " contact(s) deleted successfully.");
	}

	// Delete Contact by Number
	public static void deleteByNumber(Scanner in) {
		System.out.print("      enter number to delete: ");
		String num = in.nextLine();
		boolean deleted = false;

		for (int i = contacts.size() - 1; i >= 0; i--) {
			Contact c = contacts.get(i);
			if (c.numbers.contains(num)) {
				deleted = true;
				contacts.remove(i);
			}
		}

		if (deleted) System.out.println("-->> contact deleted successfully.");
		else System.out.println("-->> Not found");
	}

	// Remove Number of Contact
	public static void removeNumber(Scanner in) {
		System.out.print("      enter number to remove: ");
		String num = in.nextLine();
		boolean deleted = false;

		for (int i = contacts.size() - 1; i >= 0; i--) {
			Contact c = contacts.get(i);
			if (c.numbers.remove(num)) {
				deleted = true;
				if (c.numbers.isEmpty()) contacts.remove(i);
			}
		}

		if (deleted) System.out.println("-->> Number deleted successfully.");
		else System.out.println("-->> Not found");
	}

	// Display Contacts
	public static void display() {
		if (contacts.isEmpty()) {
			System.out.println("-->> No contacts stored.");
			return;
		}

		System.out.println("Name  | Type  | Number\n");
		for (Contact c : contacts) {
			System.out.println(c.name + " | " + c.type + " | " + c.numbers);
		}
	}

// Advanced Search (mohamed Like mohamad)
	public static String delete_aioeu(String text) {
		String delete_aioeu = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'a' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'e' || text.charAt(i) == 'u') {
				delete_aioeu += "";
			} else {
				delete_aioeu += text.charAt(i);
			}
		}
		return delete_aioeu;
	}

}