package android.inflabnet.basesqlite.dao

import android.inflabnet.basesqlite.model.Usuario
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun store(usuario: Usuario)

    @Insert
    fun storeBothUsers(usuario1: Usuario, usuario2: Usuario)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun storeMany(vararg usuario: Usuario)

    @Update
    fun update (usuario: Usuario)
}