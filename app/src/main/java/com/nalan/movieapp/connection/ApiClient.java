package com.nalan.movieapp.connection;

import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.model.MovieResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiClient {

    @GET(AppConstants.API_CLIENT.TOP_RATED_MOVİE)
    Observable<MovieResult> getRatedMovie();

    @GET(AppConstants.API_CLIENT.TOP_POPULAR_MOVİE)
    Observable<MovieResult> getPopularMovies();

    @GET(AppConstants.API_CLIENT.TOP_lATEST_MOVİE)
    Observable<MovieResult> getPlayingMovies();

    @GET(AppConstants.API_CLIENT.GET_MOVİE )
    Observable<Movie> getMovieById(@Path("movie_id") int movieId);

}
