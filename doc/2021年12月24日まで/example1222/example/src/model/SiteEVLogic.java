package model;

public class SiteEVLogic {
	// likeの数を1増やす
	public void like(SiteEV site) {
		int count = site.getLike();
		site.setLike(count + 1);
	}
	// dislikeの数を1増やす
	public void dislike(SiteEV site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
}
