# MovieApp


# OverView



  ![Webp net-gifmaker (1)](https://user-images.githubusercontent.com/6108274/60019813-6a59aa00-9697-11e9-8ebb-65c7fdbaf290.gif)
  

 # Uses the following technologies
 
 A simple movie app with Clean Architecture .
 
 Android Architecture Components (MVVM, LiveData)
 
 RxJava 2
 
 Glide 4
 
 Retrofit 2
 
 Dagger 2
 
 ButterKnife
 
 
# How did I use rxjava2 and retrofit2?

RxJava zip
Returns an Observable that emits the results of a specified combiner function applied to combinations of three items emitted, in sequence, by tree other ObservableSources.

Last Release Movies,Popular Movies and Top Rates Movies fetched same  time call api and same time return response.

![image](https://user-images.githubusercontent.com/6108274/60024735-020fc600-96a1-11e9-9fdf-16e36910d29f.png)



        Observable<List<Object>> result =
                Observable.zip(UtilApi.getAPIService().getPlayingMovies().subscribeOn(Schedulers.io()), UtilApi.getAPIService().getPopularMovies().subscribeOn(Schedulers
                        .io()), UtilApi.getAPIService().getRatedMovie().subscribeOn(Schedulers.io()), new Function3<MovieResult, MovieResult, MovieResult, List<Object>>() {
                    @Override
                    public List<Object> apply(MovieResult type1, MovieResult type2, MovieResult type3) {
                        setIsLoading(false);
                        type1.setTypeValue(2);
                        type1.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_lATEST_MOVİE);
                        movieListObjects.add(type1);
                        type2.setTypeValue(3);
                        type2.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_POPULAR_MOVİE);
                        movieListObjects.add(type2);
                        type3.setTypeValue(4);
                        type3.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_RATED_MOVİE);
                        movieListObjects.add(type3);
                        return movieListObjects;
                    }
                });

        result.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Object>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Object> objects) {


                  setMovieList(objects);

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, R.string.network_connection, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
        
        
        
  # License
   Copyright 2019 nalanulusoy

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
        
        
        
        
        
        
     
        
        
        
      

 
 

  
  
  
  


