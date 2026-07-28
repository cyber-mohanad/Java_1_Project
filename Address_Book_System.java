import java.util.*;

public class Mohanad_120251012 {

	//  Contact class
	static class Contact {
		String name;
		String type;
		ArrayList<String> numbers = new ArrayList<>();

		Contact(String name, String type) {
			this.name = name;
			this.type = type;
		}
	}
	static ArrayList<Contact> contacts = new ArrayList<>();

	//  Add Contact Info
	public static void AddContactInfo(Scanner in) {
		System.out.print("Enter contact info: \nName: ");
		String name = in.nextLine();

		System.out.print("Type (Family, Personal, Work, Other): ");
		String type = in.nextLine();
		if (!type.equalsIgnoreCase("Family") &&
				!type.equalsIgnoreCase("Personal") &&
				!type.equalsIgnoreCase("Work") &&
				!type.equalsIgnoreCase("Other")) {
			type = "Other";
			System.out.println("Invalid type, set to Other.");
		}
		Contact contact = new Contact(name, type);

		// Add multiple numbers (Bouns)
		while (true) {
			System.out.print("Number (0 to stop): ");
			String num = in.nextLine();
			if (num.equals("0")) break;

			// Check if number exists
			if (numberExists(num)) {
				System.out.println("This number already exists!");
			} else {
				contact.numbers.add(num);
				System.out.println("Number added.");
			}
		}
		if (!contact.numbers.isEmpty()) {
			contacts.add(contact);
			System.out.println("Contact added successfully.");
		} else {
			System.out.println("No numbers entered, contact not saved.");
		}
	}
	static boolean numberExists(String num) {
		for (Contact c : contacts) {
			if (c.numbers.contains(num)) return true;
		}
		return false;
	}

	//  Search by name
	public static void SearchByName(Scanner in) {
		System.out.print("Enter contact name to search: ");
		String text = in.nextLine().toLowerCase();
		boolean found = false;
		text1(text);
		for (Contact c : contacts) {
			String name1 = "";
			// store c.name to name and make all leters to lower case
			String name = c.name.toLowerCase();
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) == 'a' || name.charAt(i) == 'i' || name.charAt(i) == 'o' ||   name.charAt(i) == 'e' || name.charAt(i) == 'u') {
					name1 += "";
				} else {
					name1 += name.charAt(i);
				}
			}
			if (name1.contains(text1)) {
				System.out.println(c.name + " | " + c.type + " | " + c.numbers);
				found = true;
			}
		}
		if (!found) System.out.println("Not found");
	}
// Search by number
	public static void SearchByNumber(Scanner in) {
		System.out.print("Enter contact number to search: ");
		String text = in.nextLine();
		boolean found = false;

		for (Contact c : contacts) {
			if (c.numbers.contains(text)) {
				System.out.println(c.name + " | " + c.type + " | " + text);
				found = true;
			}
		}
		if (!found) System.out.println("Not found");
	}

	// Delete by Name
	public static void DeleteContactByName(Scanner in) {
		System.out.print("Enter contact name to delete: ");
		String text = in.nextLine();
		int count = 0;
		for (int i = contacts.size() - 1; i >= 0; i--) {
			if (contacts.get(i).name.equalsIgnoreCase(text)) {
				contacts.remove(i);
				count++;
			}
		}
		if (count == 0) System.out.println("Not found");
		else System.out.println(count + " contact(s) deleted successfully.");
	}
	// Delete by Number
	public static void DeleteContactByNumber(Scanner in) {
		System.out.print("Enter contact number to delete: ");
		String text = in.nextLine();
		boolean deleted = false;

		for (int i = contacts.size() - 1; i >= 0; i--) {
			Contact c = contacts.get(i);
			if (c.numbers.remove(text)) {
				deleted = true;
				if (c.numbers.isEmpty()) contacts.remove(i);
			}
		}

		if (deleted) System.out.println("Number deleted successfully.");
		else System.out.println("Not found");
	}

	// Show all contacts
	public static void ShowAllContact() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts stored.");
			return;
		}

		System.out.println("Name | Type | Number");
		for (Contact c : contacts) {
			System.out.println(c.name + " | " + c.type + " | " + c.numbers);
		}
	}
// Bouns → mohamed = mohamad when you search
	static String text1 = "";
	public static String text1(String text) {

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'a' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'e' || text.charAt(i) == 'u') {
				text1 += "";
			} else {
				text1 += text.charAt(i);
			}
		}
		return text1;
	}
	//  Main
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print(
				"Welcome to our Address book, please to find what you want\n" + "1. Add new contact.\n" + "2. Search by name.\n" + "3. Search by number.\n" + "4. Delete contact by name.\n" +
				"5. Delete contact by number.\n" + "6. Show all contacts.\n" + "7. Exit\n" + "Please to enter your choice: ");

			int num = s.nextInt();
			s.nextLine();
			text1 = "";
			if (num == 7) {
				System.out.println("Exiting...");
				break;
			}
			switch (num) {
			case 1 :
				AddContactInfo(s);
				break;
			case 2 :
				SearchByName(s);
				break;
			case 3 :
				SearchByNumber(s);
				break;
			case 4 :
				DeleteContactByName(s);
				break;
			case 5 :
				DeleteContactByNumber(s);
				break;
			case 6 :
				ShowAllContact();
				break;
			default :
				System.out.println("Error, please try again");
				break;
			}
		}
		s.close();
	}
}