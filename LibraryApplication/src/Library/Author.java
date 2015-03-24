
package Library;

/**
 * @author SamiKhan
 *
 */
public class Author extends AbstractDomain
{
	private int authorId;
	private String authorName;

	/**
	 * @return the authorId
	 */
	public int getAuthorId()
	{
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(final int authorId)
	{
		this.authorId = authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName()
	{
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(final String authorName)
	{
		this.authorName = authorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result
				+ ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorId != other.authorId)
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}

}
