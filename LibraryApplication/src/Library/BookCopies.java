
package Library;

/**
 * @author SamiKhan
 * 
 */
public class BookCopies {
	private int noOfCopies;
	private LibraryBranch mLibraryBranch;
	private Book mBook;
	private int branchId;
	private int bookId;

	/**
	 * @return the noOfCopies
	 */
	public int getNoOfCopies() {
		return noOfCopies;
	}

	/**
	 * @param noOfCopies
	 *            the noOfCopies to set
	 */
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	/**
	 * @return the mLibraryBranch
	 */
	public LibraryBranch getmLibraryBranch() {
		return mLibraryBranch;
	}

	/**
	 * @param mLibraryBranch
	 *            the mLibraryBranch to set
	 */
	public void setmLibraryBranch(LibraryBranch mLibraryBranch) {
		this.mLibraryBranch = mLibraryBranch;
	}

	/**
	 * @return the mBook
	 */
	public Book getmBook() {
		return mBook;
	}

	/**
	 * @param mBook
	 *            the mBook to set
	 */
	public void setmBook(Book mBook) {
		this.mBook = mBook;
	}

	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId
	 *            the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + branchId;
		result = prime * result + ((mBook == null) ? 0 : mBook.hashCode());
		result = prime * result
				+ ((mLibraryBranch == null) ? 0 : mLibraryBranch.hashCode());
		result = prime * result + noOfCopies;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		if (bookId != other.bookId)
			return false;
		if (branchId != other.branchId)
			return false;
		if (mBook == null) {
			if (other.mBook != null)
				return false;
		} else if (!mBook.equals(other.mBook))
			return false;
		if (mLibraryBranch == null) {
			if (other.mLibraryBranch != null)
				return false;
		} else if (!mLibraryBranch.equals(other.mLibraryBranch))
			return false;
		if (noOfCopies != other.noOfCopies)
			return false;
		return true;
	}

}
