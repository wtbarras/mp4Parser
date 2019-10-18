class boxFactory {

    public fun createBoxFromGeneric(box: Mpeg4Box): Mpeg4Box {
        val boxType: BoxType = box.getType()
        var box: Mpeg4Box = box

        when (boxType) {
            BoxType.FTYP -> box = FtypBox()
        }

        return box
    }
}