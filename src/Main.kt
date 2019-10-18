import java.io.File
import java.io.InputStreamReader
import java.nio.ByteBuffer

fun main(){
    val filePath = "./res/tears_of_steel_1080p.mp4"

    val mpeg4Container = Mpeg4Container(filePath)
    mpeg4Container.parse()

//    var offset = 0


    // Pull size of ftyp box
//    val size = getBoxSize(inputStreamBytes, offset)
//    offset += 4
//    println("Size including 4 bytes for size value: $size")
//
//    val typeString = inputStreamBytes.copyOfRange(offset,offset+4).toString(Charsets.US_ASCII)
//    offset += 4
//    println("ascii type: $typeString")
//
//    val majorBrandString = inputStreamBytes.copyOfRange(offset,offset+4).toString(Charsets.US_ASCII)
//    offset += 4
//    println("major brand: $majorBrandString")
//
//    val minorVersion = ByteBuffer.wrap(inputStreamBytes, offset, 4).int
//    offset += 4
//    println("minor version: $minorVersion")
//
//    val bytesRemaining = size - offset
//    println("bytes remaining: $bytesRemaining")
//
//    val compatibleBrandsCount = bytesRemaining / 4
//    var compatibleBrands = arrayOfNulls<String>(compatibleBrandsCount)
//    println("compatible brands")
//    for(i in 0 until compatibleBrandsCount){
//        val brand = inputStreamBytes.copyOfRange(offset,offset+4).toString(Charsets.US_ASCII)
//        offset += 4
//        compatibleBrands[i] = brand
//        println("   $brand")
//    }
//
//    // Pull size of next box
//    val boxSize = getBoxSize(inputStreamBytes, offset)
//    offset += 4
//    println("Next box size: $boxSize")
//
//    val boxType = inputStreamBytes.copyOfRange(offset,offset+4).toString(Charsets.US_ASCII)
//    offset += 4
//    println("ascii type: $boxType")
}



// Returns new offset
//fun parseBox(inputStreamBytes: ByteArray, offset: Int): Int{
//    var offset = offset
//
//    val size = getBoxSize(inputStreamBytes, offset)
//    offset += 4
//    println("Size including 4 bytes for size value: $size")
//
//    val typeString = inputStreamBytes.copyOfRange(offset,offset+4).toString(Charsets.US_ASCII)
//    offset += 4
//    println("ascii type: $typeString")
//
//
//
//    return offset
//}

fun parseFTYPBox(){

}