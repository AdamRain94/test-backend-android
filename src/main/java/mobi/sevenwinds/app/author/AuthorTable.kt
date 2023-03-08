package mobi.sevenwinds.app.author


import com.google.gson.annotations.SerializedName
import mobi.sevenwinds.app.budget.BudgetEntity
import mobi.sevenwinds.app.budget.BudgetTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable


object AuthorTable : IntIdTable("author") {

    val fio = varchar("fio", 50)
    val date = datetime("date")
}


class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)

    var fio by AuthorTable.fio
    var date by AuthorTable.date
    val budgets by BudgetEntity optionalReferrersOn  BudgetTable.author

    fun toResponse(): AuthorRecord  {
        return AuthorRecord (fio)
    }
}