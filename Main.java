import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			mainMenu();
			int num = s.nextInt();
			s.nextLine();
			if (num == 6) {
				System.out.println("Exiting...");
				break;
			}
			switch (num) {
			case 1 :
				Contact.add(s);
				break;
			case 2 :
				searchMenu();
				break;
			case 3 :
				deleteMenu();
				break;
			case 4 :
				Contact.removeNumber(s);
				break;
			case 5 :
				Contact.display();
				break;
			default :
				System.out.println("-->> Error, please try again");
				break;
			}
		}
		s.close();
	}

	//   Main Menu
	public static void mainMenu() {
		System.out.print(		"——————————————————————————————————————————————————————————————————————————————————————————"
			+
			"\nWelcome to our Address book 😃\n" +
			"1. Add new contact.\n" +
			"2. Search About Contact.\n" +
			"3. Delete contact.\n" +
			"4. Remove Number of Contact.\n" +
			"5. Show all contacts.\n" +
			"6. Exit.\n" +
			"——————————————————————————————————————————————————————————————————————————————————————————"
			+
			"Please to enter your choice: ");
	}

	//   Delete Menu
	public static void deleteMenu() {
		System.out.print(
			"3. Delete contact/\n" +
			"   1. by name.\n" +
			"   2. by number.\n" +
			"   3. back.\n" +
			"   Enter your Choice: ");
		int num = s.nextInt();
		s.nextLine();
		switch (num) {
		case 1:
			Contact.deleteByName(s);
			break;
		case 2:
			Contact.deleteByNumber(s);
			break;
		case 3:
			break;
		default:
			System.out.println("-->> Error, please try again");
			deleteMenu();
			break;
		}
	}

	//   Search Menu
	public static void searchMenu() {
		System.out.print(
			"2. Search About Contact/\n" +
			"   1. by name.\n" +
			"   2. by number.\n" +
			"   3. back.\n" +
			"   Enter your Choice: ");
		int num = s.nextInt();
		s.nextLine();
		switch (num) {
		case 1:
			Contact.searchByName(s);
			break;
		case 2:
			Contact.searchByNumber(s);
			break;
		case 3:
			break;
		default:
			System.out.println("-->> Error, please try again");
			searchMenu();
			break;
		}
	}

}