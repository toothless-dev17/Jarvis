package com.bloomsky.jarvis.data

import androidx.room.*
import java.time.Instant

@Entity(tableName = ""routines"")
data class RoutineEntity(
    @PrimaryKey val id: String,
    val name: String,
    val enabled: Boolean = true,
    val triggersJson: String = ""[]"",
    val actionsJson: String = ""[]"",
    val createdAt: Long = Instant.now().toEpochMilli(),
    val lastRunAt: Long? = null
)

@Entity(tableName = ""execution_history"")
data class ExecutionHistoryEntity(
    @PrimaryKey val id: String,
    val routineId: String,
    val triggerType: String,
    val actionResults: String,
    val executedAt: Long = Instant.now().toEpochMilli(),
    val success: Boolean
)

@Dao
interface RoutineDao {
    @Query(""SELECT * FROM routines WHERE enabled = 1"")
    fun getEnabledRoutines(): kotlinx.coroutines.flow.Flow<List<RoutineEntity>>
    
    @Query(""SELECT * FROM routines"")
    fun getAllRoutines(): kotlinx.coroutines.flow.Flow<List<RoutineEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutine(routine: RoutineEntity)
    
    @Update
    suspend fun updateRoutine(routine: RoutineEntity)
    
    @Delete
    suspend fun deleteRoutine(routine: RoutineEntity)
}

@Dao
interface HistoryDao {
    @Query(""SELECT * FROM execution_history ORDER BY executedAt DESC LIMIT 100"")
    fun getRecentHistory(): kotlinx.coroutines.flow.Flow<List<ExecutionHistoryEntity>>
    
    @Insert
    suspend fun insertHistory(history: ExecutionHistoryEntity)
}

@Database(entities = [RoutineEntity::class, ExecutionHistoryEntity::class], version = 1)
abstract class JarvisDatabase : RoomDatabase() {
    abstract fun routineDao(): RoutineDao
    abstract fun historyDao(): HistoryDao
}
