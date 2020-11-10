package es.vrivas.ejemplos_apartado_9_listas.data


import es.vrivas.ejemplos_apartado_9_listas.R
import java.util.ArrayList

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
object VehiculoContent {

    /**
     * An array of sample (Vehiculo) items.
     */
    val ITEMS: MutableList<VehiculoItem> = ArrayList()

    /**
     * A map of sample (Vehiculo) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, VehiculoItem> = HashMap()


    init {
        // Add some sample items.
        addItem(createVehiculoItem("0","Seat", "00000SST", R.mipmap.ic_seat))
        addItem(createVehiculoItem("1", "Volkswagen", "1111WLG", R.mipmap.ic_vw))
        addItem(createVehiculoItem("2", "Mercedes", "22222MBZ", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("3","Seat", "3333STT", R.mipmap.ic_seat))
        addItem(createVehiculoItem("4", "Volkswagen", "4444VLS", R.mipmap.ic_vw))
        addItem(createVehiculoItem("5", "Mercedes", "5555MRC", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("6","Seat", "6666STT", R.mipmap.ic_seat))
        addItem(createVehiculoItem("7", "Volkswagen", "7777WGN", R.mipmap.ic_vw))
        addItem(createVehiculoItem("8", "Mercedes", "8888MBZ", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("9","Seat", "9999STT", R.mipmap.ic_seat))
        addItem(createVehiculoItem("10", "Volkswagen", "1010VLS", R.mipmap.ic_vw))
        addItem(createVehiculoItem("11", "Mercedes", "11111MRC", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("12","Seat", "1212SST", R.mipmap.ic_seat))
        addItem(createVehiculoItem("13", "Volkswagen", "1313WGN", R.mipmap.ic_vw))
        addItem(createVehiculoItem("14", "Mercedes", "11414MBZ", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("15","Seat", "1515STT", R.mipmap.ic_seat))
        addItem(createVehiculoItem("16", "Volkswagen", "1616VLS", R.mipmap.ic_vw))
        addItem(createVehiculoItem("17", "Mercedes", "1717MRC", R.mipmap.ic_mercedes))
        addItem(createVehiculoItem("18","Seat", "1818SST", R.mipmap.ic_seat))
        addItem(createVehiculoItem("19", "Volkswagen", "1919WKG", R.mipmap.ic_vw))
    }

    private fun addItem(item: VehiculoItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createVehiculoItem(id: String, marca: String, matricula: String, icono: Int): VehiculoItem {
        return VehiculoItem(id, marca, matricula, icono)
    }

    /**
     * A Vehiculo item representing a piece of content.
     */
    data class VehiculoItem(val id: String, val marca: String, val matricula: String, val icono: Int) {
        override fun toString(): String = "$id: $matricula ($marca)"
    }
}