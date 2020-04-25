package android.inflabnet.basesqlite

import android.inflabnet.basesqlite.dao.UsuarioDao
import android.inflabnet.basesqlite.model.Usuario
import androidx.room.Database
import androidx.room.RoomDatabase


//anotação com relação de entidades(tabelas) que compõe a base
@Database(
    entities = arrayOf(
        Usuario::class
    ),
    //para notificar mudanças da base de dados do dispositivo
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    //métodos sem entrada com retorno as interfaces - junção
    abstract fun usuarioDao() : UsuarioDao
}