package tech.arnav.pcbuilder.core.systems

import tech.arnav.pcbuilder.core.components.CPU
import tech.arnav.pcbuilder.core.components.Cabinet
import tech.arnav.pcbuilder.core.components.GPU
import tech.arnav.pcbuilder.core.components.Motherboard
import tech.arnav.pcbuilder.core.components.PSU
import tech.arnav.pcbuilder.core.components.RAM
import tech.arnav.pcbuilder.core.components.Storage

class Tower private constructor(
    val cabinet: Cabinet,
    val motherboard: Motherboard,
    val cpu: CPU,
    val rams: List<RAM>,
    val gpus: List<GPU>,
    val storages: List<Storage>,
    val psu: PSU
){
}