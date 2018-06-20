package com.madonasyombua.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieReview implements Parcelable {
    @JsonProperty("page")
    private final int page;
    @JsonProperty("total_pages")
    private final int totalPages;
    @JsonProperty("results")
    private final List<Review> results;
    @JsonProperty("total_results")
    private final int totalResults;

    public MovieReview() {
        this.page = 0;
        this.totalPages = 0;
        this.results = new ArrayList<>();
        this.totalResults = 0;
    }

    // Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeInt(this.totalPages);
        dest.writeTypedList(this.results);
        dest.writeInt(this.totalResults);
    }

    MovieReview(Parcel in) {
        this.page = in.readInt();
        this.totalPages = in.readInt();
        this.results = in.createTypedArrayList(Review.CREATOR);
        this.totalResults = in.readInt();
    }

    public static final Parcelable.Creator<MovieReview> CREATOR = new Parcelable.Creator<MovieReview>() {
        @Override
        public MovieReview createFromParcel(Parcel source) {
            return new MovieReview(source);
        }

        @Override
        public MovieReview[] newArray(int size) {
            return new MovieReview[size];
        }
    };

    /**
     * get the page
     * @return page
     */
    public int getPage() {
        return page;
    }

    /**
     * all review pages
     * @return total pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * this method is of type list which gets Reviews and returns results
     * @return results
     */
    public List<Review> getResults() {
        return results;
    }


}