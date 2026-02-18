package v.company.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
    ],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {

}

private const val DATABASE_VERSION = 1