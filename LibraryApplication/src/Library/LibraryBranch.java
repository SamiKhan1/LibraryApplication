
package Library;

/**
 * @author SamiKhan
 *
 */
public class LibraryBranch
{
	private int cardNo;
	private int branchId;
	private String branchName;
	private String branchAddress;


	
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	
	/**
	 * @return the branchId
	 */
	public int getBranchId()
	{
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId)
	{
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName()
	{
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}

	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress()
	{
		return branchAddress;
	}

	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress)
	{
		this.branchAddress = branchAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchAddress == null) ? 0 : branchAddress.hashCode());
		result = prime * result + branchId;
		result = prime * result
				+ ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + cardNo;
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
		LibraryBranch other = (LibraryBranch) obj;
		if (branchAddress == null) {
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (branchId != other.branchId)
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (cardNo != other.cardNo)
			return false;
		return true;
	}

}
