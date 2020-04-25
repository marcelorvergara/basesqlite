package android.inflabnet.basesqlite.dao

import android.inflabnet.basesqlite.model.Usuario
import androidx.room.*

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

    @Update
    fun updateMany (vararg usuario: Usuario)

    @Delete
    fun delete (usuario:Usuario)

    @Query("Select * from Usuarios")
    fun all(): Array<Usuario>

    @Query("Select * from Usuarios where id = :identificador")
    fun show(identificador: Int): Array<Usuario>

}