package samples.tempdir

import com.sushistack.ListWriter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path


class TempDirectoryDemo {
    companion object {
        @TempDir
        var sharedTempDir: Path? = null
    }

    @Test
    @Throws(IOException::class)
    fun writeItemsToFile() {
        val file = sharedTempDir!!.resolve("test.txt")
        ListWriter(file).write("a", "b", "c")
        assertEquals(listOf("a,b,c"), Files.readAllLines(file))
    }

    @Test
    fun anotherTestThatUsesTheSameTempDir() {
        // use sharedTempDir
    }
}