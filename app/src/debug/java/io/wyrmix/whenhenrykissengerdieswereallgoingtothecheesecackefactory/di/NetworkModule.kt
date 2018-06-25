package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.bridge.okhttp.NetworkOnly
import okhttp3.Interceptor
import javax.inject.Singleton

@Module class NetworkModule {
    @Provides @IntoSet @NetworkOnly fun customInterceptor(context: Context): Interceptor = ChuckInterceptor(context)
}