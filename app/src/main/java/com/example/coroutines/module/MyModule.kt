package com.example.coroutines.module

import android.content.Context
import androidx.room.Room
import com.example.coroutines.Constant
import com.example.coroutines.data.local.MyDao
import com.example.coroutines.data.local.MyDataBase
import com.example.coroutines.data.network.CallApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MyModule {

    //to get request from server
    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
       return  OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val requestWithHeader = original.newBuilder()
                    .header(
                        "Authorization",
                        Constant.BEARER_TOKEN
                    )
                    .build()


                chain.proceed(requestWithHeader)
            })
            .build()
    }
    @Named("one")
    @Singleton
    @Provides
    fun getRetrofit ( okhttp : OkHttpClient) : Retrofit {

        return Retrofit.Builder()
            .client(okhttp)
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    //how to create two objects of two api

//    @Named("two")
//    @Singleton
//    @Provides
//    fun getRetrofit2 ( okhttp : OkHttpClient) : Retrofit {
//
//        return Retrofit.Builder()
//            .client(okhttp)
//            .baseUrl("https://api.sdfdsfdsf.org/3/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    }

    @Singleton
    @Provides
    fun getApi (@Named("one") retrofit: Retrofit) : CallApi {
        return retrofit.create(CallApi::class.java)
    }


//    @Singleton
//    @Provides
//    fun getApi2 (@Named("two")retrofit: Retrofit) : CallApi {
//        return retrofit.create(CallApi::class.java)
//    }
    @Singleton
    @Provides
    fun getMyDataBase(@ApplicationContext context: Context) : MyDataBase {

        return Room.databaseBuilder(context, MyDataBase::class.java, "MyDataBase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun getDao(myDataBase: MyDataBase) : MyDao {
        return myDataBase.myDao()

    }

}