package android.inflabnet.basesqlite

import android.inflabnet.basesqlite.dao.UsuarioDao
import android.inflabnet.basesqlite.model.Usuario
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(
        Usuario::class
    ),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao() : UsuarioDao

}