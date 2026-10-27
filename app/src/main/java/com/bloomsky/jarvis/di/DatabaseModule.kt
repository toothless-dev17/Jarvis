package com.bloomsky.jarvis.di

import android.content.Context
import androidx.room.Room
import com.bloomsky.jarvis.data.JarvisDatabase
import com.bloomsky.jarvis.data.RoutineDao
import com.bloomsky.jarvis.data.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): JarvisDatabase {
        return Room.databaseBuilder(
            context,
            JarvisDatabase::class.java,
            ""jarvis_db""
        ).build()
    }

    @Provides
    fun provideRoutineDao(database: JarvisDatabase): RoutineDao = database.routineDao()

    @Provides
    fun provideHistoryDao(database: JarvisDatabase): HistoryDao = database.historyDao()
}
