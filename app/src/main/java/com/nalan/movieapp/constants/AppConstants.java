package com.nalan.movieapp.constants;

public class AppConstants {
    public static final String API_KEY = "api_key=dfaf7f88c02c3c7389f148cf09f4a5d7&language=en-US";


    public static final String IMAGE_PATH="http://image.tmdb.org/t/p/w185";
    public static final String IMAGE_PATH_ORİGİNAL="http://image.tmdb.org/t/p/original";

    public static class API_CLIENT{

        public static final   String TOP_RATED_MOVİE ="movie/top_rated?"+API_KEY;
        public static final   String TOP_POPULAR_MOVİE ="movie/popular?"+API_KEY;
        public static final   String TOP_lATEST_MOVİE ="movie/now_playing?"+API_KEY;
        public static final   String GET_MOVİE ="movie/{movie_id}?"+API_KEY;


    }


    public static class VİEW_TYPE_NAME{

        public static final   String TOP_RATED_MOVİE ="Rated Movies";
        public static final   String TOP_POPULAR_MOVİE ="Popular Movies";
        public static final   String TOP_lATEST_MOVİE ="Now Playing Movies";
        public static final   String GET_MOVİE ="Movie Header";

    }


    public static class VİEW_TYPE{

        public static final  int HORİZONTAL_LİST =1;
        public static final   int VERTİCAL_LİST=2;
        public static final   int  GRİD_LİST =3;
        public static final   int GET_MOVİE =4;

    }
    public static class FRAGMENT_TAG{

        public static  String HOME_MOVİE_FRAGMENT="HOME_MOVİE_FRAGMENT";
        public static  String HOME_DETAİL_FRAGMENT="HOME_MOVİE_DETAİL_FRAGMENT";

    }

}
