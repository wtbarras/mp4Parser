import java.nio.ByteBuffer

open class Mpeg4Box(){

    private var size : Int = -1
    private var type : BoxType = BoxType.NONE
    private var index: Int = 0

    // Parses generic box info and returns a new offset for the buffer
    public fun parseBox(inputStreamBytes: ByteArray, indexInput: Int) : Int{
        this.index = indexInput

        this.setSize(
            inputStreamBytes,
            this.index
        )

        this.setType(
            inputStreamBytes,
            this.index
        )

        var indexOfNextBox = indexInput
        indexOfNextBox += this.size
        return indexOfNextBox
    }

    private fun setSize(inputStreamBytes: ByteArray, offset: Int) {
        var buffer = ByteBuffer.wrap(
            inputStreamBytes,
            offset,
            4
        )

        this.size = buffer.int
        this.index += 4
    }

    private fun setType(inputStreamBytes: ByteArray, offset: Int) {
        val typeString = inputStreamBytes.copyOfRange(
            this.index,
            this.index+4
        ).toString(Charsets.US_ASCII)

        this.index += 4

        when (typeString) {
            "ftyp" -> this.type = BoxType.FTYP
            "mdat" -> this.type = BoxType.MDAT
            "moov" -> this.type = BoxType.MOOV
            "free" -> this.type = BoxType.FREE
        }
    }

    public fun getType() : BoxType {
        return this.type
    }

    // Return string in the form:   <type>/<size>
    public override fun toString() : String {
        var stringBuilder = StringBuilder()

        stringBuilder.append(this.type)
        stringBuilder.append("/")
        stringBuilder.append(this.size)

        return stringBuilder.toString()
    }
}