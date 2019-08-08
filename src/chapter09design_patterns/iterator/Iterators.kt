package chapter09design_patterns.iterator

data class Book(val name:String)

class BookShelf(val books:List<Book>):Iterator<Book>{
    private val iterable:Iterator<Book> = books.iterator()
    override fun hasNext(): Boolean {
        return iterable.hasNext()
    }

    override fun next(): Book {
        return iterable.next()
    }
}

class BookCase(val list:List<Book>){
    operator fun iterator():Iterator<Book> = list.iterator()
}

class BookBox(val list: List<Book>)

operator fun BookBox.iterator():Iterator<Book> = list.iterator()

fun main(args: Array<String>) {
    val list = listOf(Book("Dive into Kotlin"), Book("Thinking in Java"))
    val bookShelf = BookShelf(list)
    while (bookShelf.hasNext()) {
        println("The book name is ${bookShelf.next().name}")
    }

    val bookCase = BookCase(list)
    val iterator = bookCase.iterator()
    while (iterator.hasNext()) {
        println("The book name is ${iterator.next().name}")
    }

    val bookBoxIterator = BookBox(list).iterator()
    while (bookBoxIterator.hasNext()) {
        println("The book name is ${bookBoxIterator.next().name}")
    }
}