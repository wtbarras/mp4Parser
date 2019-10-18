import java.io.File
import java.nio.ByteBuffer

class Mpeg4Container(filePath : String) {
    private val filePath = filePath
    private val inputStreamBytes : ByteArray
    private val boxMap = mutableMapOf<Int, Mpeg4Box>()
    private var offset = 0
    init {
        // Open mpeg4 file
        this.inputStreamBytes = File(this.filePath).inputStream().readBytes()
    }

    fun parse() {
        while(this.offset < this.inputStreamBytes.size){
            parseBox()
        }
    }

    private fun parseBox() {
        var box = Mpeg4Box()

        this.offset = box.parseBox(this.inputStreamBytes, this.offset)
        println(box)
    }

    private fun getBoxSize(inputStreamBytes: ByteArray, offset: Int) : Int {
        var buffer = ByteBuffer.wrap(
            inputStreamBytes,
            offset,
            4
        )
        return buffer.int
    }

    private fun parseFtyp(size : Int) : Int {
        var remainingBytes = size
        // We've already read two ints, size and type
        remainingBytes -= 8

        println("ParseFtyp")

        // Major brand (32)
        val brand = inputStreamBytes.copyOfRange(
            this.offset,
            this.offset + 4
        ).toString(Charsets.US_ASCII)
        this.offset += 4
        remainingBytes -= 4
        println("   Brand: $brand")

        // Minor version (32)
        val version = ByteBuffer.wrap(
            inputStreamBytes,
            this.offset,
            4
        ).int
        this.offset += 4
        remainingBytes -= 4
        println("   Version: $version")

        // Compatible brands (to end of box)
        println("Compatible Brands:")
        while (remainingBytes > 0) {
            val compatibleBrand = inputStreamBytes.copyOfRange(
                this.offset,
                this.offset + 4
            ).toString(Charsets.US_ASCII)
            this.offset += 4
            remainingBytes -= 4
            println("   $compatibleBrand")
        }

        return remainingBytes
    }

    private fun parseMdat(size : Int) : Int {
        var remainingBytes = size
        // We've already read two ints, size and type
        remainingBytes -= 8
        println("ParseMdat")



        return remainingBytes
    }

    private fun parseMoov(size : Int) : Int {
        println("ParseMoov")
        var remainingBytes = size
        remainingBytes -= 8

        // Parse next box within the moov box
        var boxSize = getBoxSize(
            this.inputStreamBytes,
            this.offset
        )
        this.offset += 4
        remainingBytes -= 4

        val typeString = inputStreamBytes.copyOfRange(
            this.offset,
            this.offset+4
        ).toString(Charsets.US_ASCII)
        this.offset += 4
        remainingBytes -= 4

        System.out.println("$boxSize/$typeString")
        return remainingBytes
    }

    private fun parseMvhd(inputStreamBytes: ByteArray, offset: Int) {
        println("ParseMvhd")

    }
}