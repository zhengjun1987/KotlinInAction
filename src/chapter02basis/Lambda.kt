package chapter02basis

data class Country(val name: String,
                   val countinent: String,
                   val population: Int) {
    override fun toString(): String {
        return "Country(name='$name', countinent='$countinent', population=$population)"
    }
}

class CountryApp {
    fun filterCountries(countries: List<Country>,
                        filter: (Country) -> Boolean): List<Country> {
        val result = mutableListOf<Country>()
        for (country in countries) {
            if (filter.invoke(country)) {
                result.add(country)
            }
        }
        return result
    }
}

fun main() {
    val getBook = ::Book
    println("getBook.javaClass = ${getBook.javaClass}")
    val book = getBook("Dive into Kotlin", "the Waterdrop")
    println("getBook(\"Dive into Kotlin\",\"the Waterdrop\") = $book")
    book.printName()
    println("book::author = ${book::author}")
    println("book.author = ${book.author}")
    val china = Country("China", "ASIA", 130000)
    val jp = Country("Japan", "ASIA", 30000)
    val australia = Country("Australia", "EURO", 30000)
    val usa = Country("America", "Ameriica", 30000)
    val england = Country("England", "EURO", 7000)
    val countries = arrayListOf<Country>(china, jp, england, australia, usa)
    println("countries = ${countries.javaClass}")
    println("countries = ${countries}")

    println("china::name = ${china::name}")

    val countryApp = CountryApp()
    println("countryApp.filterCountries(countries = countries,filter = CountryFilter::test) = ${countryApp.filterCountries(countries = countries, filter = CountryFilter()::test)}")
    println("countryApp.filterCountries(countries,fun(country:Country):Boolean = country.countinent.equals(\"EURO\")) = ${countryApp.filterCountries(countries, fun(country: Country): Boolean = country.countinent.equals("EURO"))}")
    println("countryApp.filterCountries(countries){ country -> country.name.startsWith(\"A\")}  = ${countryApp.filterCountries(countries) { country -> country.name.startsWith("A") }}")

    fun printEach(int: Int) {
        println("int = ${int}")
    }
    listOf<Int>(1, 3, 5).forEach { printEach(it) };

    { x: Int -> println("x+1 = ${x + 1}") }(1)

    var sum = 0
    countries.forEach {
        sum += it.population
    }
    println("sum = ${sum}")

    fun omitParentheses(block: () -> Unit) {
        block.invoke()
    }

    omitParentheses {
        println("Parentheses is omitted! ")
    }

    fun curryingLike(content: String, block: (String) -> Unit) {
        block(content)
    }

    curryingLike("This looks like currying style.") {
        println(it)
    }

    val a = arrayOf(1, 2, 3)
    val b = arrayOf(2, 3, 4)
    println("a.corresponds(b){i,j -> i==j-1 = ${a.corresponds(b) { i, j -> i == j - 1 }}")
    b[2] = 5
    println("a.corresponds(b){i,j -> i==j-1 = ${a.corresponds(b) { i, j -> i == j - 1 }}")

//    a.corresponds(b,{i,j -> i*j != 0})

}

fun ifExpression(flag:Boolean) {
    val s = if (flag) "Dive into Kotlin" else ""
    println(s.toUpperCase())
}

class CountryFilter {
    fun test(country: Country): Boolean = country.population > 10000
}

fun String?.isEmpty(): Boolean = this == null || length == 0

fun <A, B> Array<A>.corresponds(that: Array<B>, p: (A, B) -> Boolean): Boolean {
    val i = this.iterator()
    val j = that.iterator()
    while (i.hasNext() && j.hasNext()) {
        if (!p(i.next(), j.next())) {
            return false
        }
    }
    return !i.hasNext() && !j.hasNext()
}