package in.co.rays.association;

import java.util.Set;

public class Auction {
	private long id;
	private Set<Bid> bids;
	private String description;
	private Bid successfulBid = null;

	public Auction() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bid getSuccessfulBid() {
		return successfulBid;
	}

	public void setSuccessfulBid(Bid successfulBid) {
		this.successfulBid = successfulBid;
	}

}
