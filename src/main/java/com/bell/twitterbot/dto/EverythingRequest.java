package com.bell.twitterbot.dto;

public class EverythingRequest {
	private String q, language, sortBy;

	private EverythingRequest(Builder builder) {
		this.q = builder.q;
		this.language = builder.language;
		this.sortBy = builder.sortBy;
	}

	public String getQ() {
		return q;
	}
	
	public String getLanguage() {
		return language;
	}

	public String getSortBy() {
		return sortBy;
	}

	public static class Builder {
		private String q, language, sortBy;

		public Builder q(String q) {
			this.q = q;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public Builder sortBy(String sortBy) {
			this.sortBy = sortBy;
			return this;
		}

		public EverythingRequest build() {
			return new EverythingRequest(this);
		}
	}

}
