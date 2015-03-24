
package Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * @author SamiKhan
 * 
 */
public class ManagementSystem {

	Scanner sc = new Scanner(System.in);

	private static ManagementSystem ManagementSystem;

	private final BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	private static final int EXIT = 0;
	private static final int LOGIN_AS_LIBRARIAN = 1;
	private static final int LOGIN_AS_ADMINISTRATOR = 2;
	private static final int LOGIN_AS_BORROWER = 3;
	private static final int ENTER_A_LIBRARY = 4;
	private static final int CARD_NUMBER = 5;
	private static final int LIB_BOSTON_UNIV_LIBRARY = 6;
	private static final int LIB_NYSTATE_UNIV_LIBRARY = 7;
	private static final int LIB_DC_FEDERAL_LIBRARY = 8;
	private static final int LIB_MCLEAN_COUNTY_LIBRARY = 9;
	private static final int UPDATE_LIBRARY_DETAILS = 10;
	private static final int ADD_COPY_OF_ABOOK = 11;
	private static final int CHECK_OUT_ABOOK = 12;
	private static final int RETURN_ABOOK = 13;
	private static final int ADD_UPDATE_DELETE_ABOOK = 14;
	private static final int ADD_UPDATE_DELETE_ANAUTHOR = 15;
	private static final int ADD_UPDATE_DELETE_APUBLISHER = 16;
	private static final int ADD_UPDATE_DELETE_ABRANCH = 17;
	private static final int ADD_UPDATE_DELETE_ABORROWER = 18;
	private static final int OVERRIDE_DUE_DATE = 19;
	private static final int LIBRARIAN_MENU = 20;
	private static final int ADMINISTRATOR_MENU = 21;
	private static final int BORROWER_MENU = 22;
	private static final int BOR_BOSTON_UNIV_LIBRARY = 23;
	private static final int BOR_NYSTATE_UNIV_LIBRARY = 24;
	private static final int BOR_DC_FEDERAL_LIBRARY = 25;
	private static final int BOR_MCLEAN_COUNTY_LIBRARY = 26;

	private static final int HELP = 27;

	private ManagementSystem() {
		// mLibrary = (Library) Library.instance();
	}

	public static ManagementSystem instance() {

		if (ManagementSystem == null) {
			return ManagementSystem = new ManagementSystem();
		} else {
			return ManagementSystem;
		}
	}

	public String getToken(final String prompt) {
		do {
			try {

				System.out.println(prompt);
				final String line = reader.readLine();
				final StringTokenizer tokenizer = new StringTokenizer(line,
						"\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (final IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	private boolean yesOrNo(final String prompt) {

		final String more = getToken(prompt
				+ "\n (Y or anything else for no.)");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	public int getNumber(final String prompt) {
		do {
			try {
				final String item = getToken(prompt);
				final Integer num = Integer.valueOf(item);
				return num.intValue();
			} catch (final NumberFormatException nfe) {
				System.out.println("\n Please input a number.");
			}
		} while (true);
	}

	public int getNumericalCmd() {
		do {
			try {
				final int value = Integer
						.parseInt(getToken("\n Enter command: " + HELP
								+ " for help."));
				if (value >= EXIT && value <= HELP) {
					return value;
				}
			} catch (final NumberFormatException nfe) {
				System.out.println("\n Enter a number.");
			}
		} while (true);
	}

	
	//Check out book, enter id
	public void processCheckOut() {
		try {

			do {
				final BookLoaned mBookLoaned = new BookLoaned();

				final String cardNumber = getToken(" Enter card number: ");
				mBookLoaned.setbCardNo(Integer.valueOf(cardNumber));

				if (cardNumber != null) {

					final String bkId = getToken(" Enter bookId: ");
					mBookLoaned.setBookId(Integer.valueOf(bkId));

					final String brId = getToken(" Enter branchId: ");
					mBookLoaned.setBranchId(Integer.valueOf(brId));

				} else {

					System.out.println("Unidentified card number!");
				}

				System.out.println("Successfull check out!");
				if (!yesOrNo("\n Check out more books?")) {
					break;
				}

			} while (true);

		} catch (final Exception e) {
			System.out.println("\n Check input for keys constraint! ");
		}

	}

	
	//Return book 
	public void processReturn() {
		try {

			do {
				final String cardNumber = getToken(" Enter card number: ");
				if (cardNumber != null) {

					final BookLoaned mBookLoaned = new BookLoaned();
					mBookLoaned.setbCardNo(Integer.valueOf(cardNumber));

					final String bkId = getToken(" Enter bookId: ");
					mBookLoaned.setBookId(Integer.valueOf(bkId));

				} else {
					System.out.println("\n Could not process card number.");
				}
				System.out.println("\n Successfull return!");
				if (!yesOrNo("\n Return more books?")) {
					break;
				}

			} while (true);

		} catch (final Exception e) {
			System.out.println("\n Check input!!!");
		}
	}

	
	//Enter 
	public void enterALibrary() {
		int userCmd;
		try {
			do {
				librarianOptionsMenuOne();

				while ((userCmd = getNumericalCmd()) != EXIT) {

					switch (userCmd) {

					case LIB_BOSTON_UNIV_LIBRARY:
						manageBostonUnivLibrary();
						break;
					case LIB_NYSTATE_UNIV_LIBRARY:
						librarianOptionsMenuTwo();
						break;
					case LIB_DC_FEDERAL_LIBRARY:
						librarianOptionsMenuTwo();
						break;
					case LIB_MCLEAN_COUNTY_LIBRARY:
						librarianOptionsMenuTwo();
						break;

					}

				}

			} while (true);

		} catch (final Exception e) {
			System.out.println("\n Check input!!!");
		}

	}

	public void manageBostonUnivLibrary() {
		int userCmd;
		try {

			do {
				librarianOptionsMenuTwo();

				while ((userCmd = getNumericalCmd()) != EXIT) {
					switch (userCmd) {

					case UPDATE_LIBRARY_DETAILS:

						final LibraryBranch updateResult = new LibraryBranch();

						final String newName = getToken(" Enter new name: ");
						updateResult.setBranchName(newName);
						final String Id = getToken(" Enter the library Id to update: ");
						updateResult.setBranchId(Integer.valueOf(Id));

						final String name = updateResult.getBranchName();
						if (name != null) {
							System.out.println(name);
							updateResult.setBranchName(newName);

						} else {
							System.out.println("\n Input is null.");
						}

						System.out.println("Succesfull update!");

						break;

					case ADD_COPY_OF_ABOOK:

						final BookCopies mBkCopies = new BookCopies();
						final String mCopiesBkId = getToken(" Enter book Id to add copy: ");
						mBkCopies.setBookId(Integer.valueOf(mCopiesBkId));

						final String branchId = getToken(" Enter branch Id: ");
						mBkCopies.setBranchId(Integer.valueOf(branchId));

						System.out
								.println("You want to add copies of book id # "
										+ mCopiesBkId
										+ " to the branch with id # "
										+ branchId);

						final String noOfCopies = getToken(" Enter the number of copies: ");

						mBkCopies.setNoOfCopies(Integer.valueOf(noOfCopies));

						System.out.println("Successfull copies update!");

						if (!yesOrNo("\n Update more ?")) {
							break;
						}

						break;

					}

				}

			} while (true);

		} catch (final Exception e) {
			System.out.println("\n Could not update!!!");
		}
	}

	public void help() {

		System.out.println(" Enter a number shown below: \n");

		
		System.out.println(" " + LOGIN_AS_LIBRARIAN + " Login as a librarian.");
		System.out.println(" " + LOGIN_AS_ADMINISTRATOR
				+ " Login as an administrator.");
		System.out.println(" " + LOGIN_AS_BORROWER + " Login as a borrower.");
		System.out.println(" " + EXIT + " Exit.");
		System.out.println(" " + HELP + " Help.");

	}

	public void librarianMenu() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + ENTER_A_LIBRARY + " Enter a number: ");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void librarianOptionsMenuOne() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + LIB_BOSTON_UNIV_LIBRARY
				+ " University Library, Boston");
		System.out.println(" " + LIB_NYSTATE_UNIV_LIBRARY
				+ " State Library, New York");
		System.out.println(" " + LIB_DC_FEDERAL_LIBRARY
				+ " Federal Library, Washington DC");
		System.out.println(" " + LIB_MCLEAN_COUNTY_LIBRARY
				+ " County Library, McLean VA");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void librarianOptionsMenuTwo() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + UPDATE_LIBRARY_DETAILS
				+ " Update the details of the Library ");
		System.out.println(" " + ADD_COPY_OF_ABOOK
				+ " Add copies of Book to the Branch");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void administratorMenu() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + ADD_UPDATE_DELETE_ABOOK
				+ " Add/Update/Delete a book.");
		System.out.println(" " + ADD_UPDATE_DELETE_ANAUTHOR
				+ " Add/Update/Delete an author.");
		System.out.println(" " + ADD_UPDATE_DELETE_APUBLISHER
				+ " Add/Update/Delete a publisher.");
		System.out.println(" " + ADD_UPDATE_DELETE_ABRANCH
				+ " Add/Update/Delete a branch.");
		System.out.println(" " + ADD_UPDATE_DELETE_ABORROWER
				+ " Add/Update/Delete a borrower.");
		System.out.println(" " + OVERRIDE_DUE_DATE
				+ " Override Due Date for a Book Loan.");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void administratorOptionsMenu() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + CARD_NUMBER + " Enter your card number: ");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void borrowerMenu() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + CARD_NUMBER
				+ " Enter 5 to provide your card number: ");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void borrowerOptionsMenuOne() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + CHECK_OUT_ABOOK + " Check out a book.");
		System.out.println(" " + RETURN_ABOOK + " Return a Book.");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void borrowerOptionsMenuTwo() {

		System.out.println(" Enter a number shown below: \n");
		System.out.println(" " + BOR_BOSTON_UNIV_LIBRARY
				+ " University Library, Boston");
		System.out.println(" " + BOR_NYSTATE_UNIV_LIBRARY
				+ " State Library, New York");
		System.out.println(" " + BOR_DC_FEDERAL_LIBRARY
				+ " Federal Library, Washington DC");
		System.out.println(" " + BOR_MCLEAN_COUNTY_LIBRARY
				+ " County Library, McLean VA");
		System.out.println(" " + EXIT + " Exit.");

	}

	public void process() {
		int integerCmd;
		help();
		while ((integerCmd = getNumericalCmd()) != EXIT) {

			switch (integerCmd) {

			case LOGIN_AS_BORROWER:
				borrowerOptionsMenuOne();
				break;
			case BOR_BOSTON_UNIV_LIBRARY:
				processCheckOut();
				break;
			case CHECK_OUT_ABOOK:
				borrowerOptionsMenuTwo();
				break;
			case RETURN_ABOOK:
				processReturn();
				break;
			case LOGIN_AS_LIBRARIAN:
				librarianOptionsMenuOne();
				break;
			case ENTER_A_LIBRARY:
				enterALibrary();
				break;
			case LIB_BOSTON_UNIV_LIBRARY:
				manageBostonUnivLibrary();
				break;
			case LIB_NYSTATE_UNIV_LIBRARY:
				// nyStateUnivLibrary();
				break;
			case LIB_DC_FEDERAL_LIBRARY:
				// pickDcFederalLibrary();
				break;
			case LIB_MCLEAN_COUNTY_LIBRARY:
				// pickMcLeanLibrary();
				break;
			case LOGIN_AS_ADMINISTRATOR:
				administratorMenu();
				break;
			case ADD_UPDATE_DELETE_ABOOK:
				// addUpdateDeleteABook();
				break;
			case ADD_UPDATE_DELETE_ANAUTHOR:
				// addUpdateDeleteAnAuthor();
				break;
			case ADD_UPDATE_DELETE_APUBLISHER:
				// addUpdateDeleteAPublisher();
				break;
			case ADD_UPDATE_DELETE_ABRANCH:
				// addUpdateDeleteABranchr();
				break;
			case ADD_UPDATE_DELETE_ABORROWER:
				// addUpdateDeleteABorrower();
				break;
			case OVERRIDE_DUE_DATE:
				// overrideDueDate();
				break;

			case BORROWER_MENU:
				// borrowerMenu();
				break;
			case LIBRARIAN_MENU:
				librarianOptionsMenuOne();
				break;
			case ADMINISTRATOR_MENU:
				administratorMenu();
				break;
			case HELP:
				help();
				break;
			}

		}
	}

	public static void main(final String[] args) {

		ManagementSystem.instance().process();

	}

}
