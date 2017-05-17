package com.neuqer.voter.dto.response;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.RecordDetail;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteRecord;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordsResponse {

	private VoteShow voteShow;
	private List<Option> options;

	public RecordsResponse(Vote vote , List<Option> options) {
		this.voteShow = new VoteShow();
		voteShow.setId(vote.getId());
		voteShow.setTitle(vote.getTitle());
		voteShow.setType(vote.getType());
		this.options = options;
	}

	public VoteShow getVote() {
		return voteShow;
	}

	public void setVote(VoteShow vote) {
		this.voteShow = vote;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public class VoteShow
	{
		private long id;
		private String title;
		private int type;

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
