
package Library;

import java.sql.Date;

/**
 * @author SamiKhan
 * 
 */
public class BookLoaned {
	private Book mBook;
	private LibraryBranch mLibraryBranch;
	private Borrower mBorrower;
	private Date dateOut;
	private Date dueDate;

	private int bookId;
	private int branchId;
	private int bCardNo;

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
	 * @return the bCardNo
	 */
	public int getbCardNo() {
		return bCardNo;
	}

	/**
	 * @param bCardNo
	 *            the bCardNo to set
	 */
	public void setbCardNo(int bCardNo) {
		this.bCardNo = bCardNo;
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
	 * @return the mBorrower
	 */
	public Borrower getmBorrower() {
		return mBorrower;
	}

	/**
	 * @param mBorrower
	 *            the mBorrower to set
	 */
	public void setmBorrower(Borrower mBorrower) {
		this.mBorrower = mBorrower;
	}

	/**
	 * @return the dateOut
	 */
	public Date getDateOut() {
		return dateOut;
	}

	/**
	 * @param dateOut
	 *            the dateOut to set
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bCardNo;
		result = prime * result + bookId;
		result = prime * result + branchId;
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((mBook == null) ? 0 : mBook.hashCode());
		result = prime * result
				+ ((mBorrower == null) ? 0 : mBorrower.hashCode());
		result = prime * result
				+ ((mLibraryBranch == null) ? 0 : mLibraryBranch.hashCode());
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
		BookLoaned other = (BookLoaned) obj;
		if (bCardNo != other.bCardNo)
			return false;
		if (bookId != other.bookId)
			return false;
		if (branchId != other.branchId)
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (mBook == null) {
			if (other.mBook != null)
				return false;
		} else if (!mBook.equals(other.mBook))
			return false;
		if (mBorrower == null) {
			if (other.mBorrower != null)
				return false;
		} else if (!mBorrower.equals(other.mBorrower))
			return false;
		if (mLibraryBranch == null) {
			if (other.mLibraryBranch != null)
				return false;
		} else if (!mLibraryBranch.equals(other.mLibraryBranch))
			return false;
		return true;
	}

}
