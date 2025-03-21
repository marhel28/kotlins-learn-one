import kotlinx.coroutines.*

fun calculateGrade(score: Int): String = when (score) {
    in 81..100 -> "A"
    in 51..80 -> "B"
    in 0..50 -> "C"
    else -> "Invalid score"
}

fun hitungNilaiAkhir(studentName: String, score: Int): String =
    "Nama Mahasiswa: $studentName, Nilai: $score, Grade: ${calculateGrade(score)}"

suspend fun fetchData(): String {
    delay(2000L)
    return "Data fetched"
}

fun main() = runBlocking {
    listOf(
        "Andi" to 85,
        "Budi" to 75,
        "Citra" to 45
    ).forEach { (name, score) ->
        println("Nama Mahasiswa: $name")
        println("Nilai Mata Kuliah: $score")
        println("Grade: ${calculateGrade(score)}")
    }

    launch {
        delay(1000L)
        println("Coroutine finished!")
    }
    println("Coroutine started")

    val result = async { fetchData() }
    println("Loading...")
    println(result.await())

    val startTime = System.nanoTime()
    println("Hasil Pengukuran: ${hitungNilaiAkhir("Andi", 85)}")
    println("Waktu eksekusi: ${System.nanoTime() - startTime}ns")
}
