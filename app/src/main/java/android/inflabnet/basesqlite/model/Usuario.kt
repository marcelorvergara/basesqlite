package android.inflabnet.basesqlite.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Usuarios")
class Usuario(
    @ColumnInfo(name="Nome")
    var nome: String,
    @ColumnInfo(name="Sobrnome")
    var sobrenome: String,
    @ColumnInfo(name="Matricula")
    var matricula: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null)